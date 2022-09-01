package com.itf201.mitarbeiteransicht.frontend;

import com.itf201.mitarbeiteransicht.backend.MitarbeiterDto;

import javax.swing.*;
import java.awt.*;

public class MitarbeiterEditModal extends JFrame {

    private static final Dimension WINDOW_SIZE = new Dimension(500, 600);
    private static final Dimension HEADER_SIZE = new Dimension(500, 100);
    private static final Dimension BODY_SIZE = new Dimension(250, 350);
    private static final Dimension BUTTONROW_SIZE = new Dimension(500, 50);
    private static final Dimension BODY_OBJECT_SIZE = new Dimension(250, 50);
    private static final Color BACKGROUND_COLOR = Color.GRAY;
    private final JPanel header = new JPanel();
    private final JPanel body = new JPanel(new BorderLayout());
    private final JPanel bodyInternalLeft = new JPanel();
    private final JPanel bodyInternalRight = new JPanel();
    private final JPanel buttonrow = new JPanel();

    private final JButton updateButton = new JButton();
    private final JButton exitButton = new JButton();

    private final JLabel headerText = new JLabel();
    private final JLabel textId = new JLabel();
    private final JLabel textName = new JLabel();
    private final JLabel textCustom1 = new JLabel();
    private final JLabel textCustom2 = new JLabel();

    private final JTextField textFieldId = new JTextField();
    private final JTextField textFieldName = new JTextField();
    private final JTextField buttonCustom1 = new JTextField();
    private final JTextField buttonCustom2 = new JTextField();

    public MitarbeiterEditModal(MitarbeiterDto dude) {
        createHeader();
        createDefaultBody();
        createButtonRow();
        switch (dude.typ()) {
            case SCHICHTARBEITER -> createSchichtarbeiterBody(dude);
            case BUEROARBEITER -> createBueroarbeiterBody(dude);
            case MANAGER -> createManagerBody(dude);
        }
        this.setSize(WINDOW_SIZE);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }

    private void createManagerBody(MitarbeiterDto dto) {
        textCustom1.setText("Festgehalt");
        textCustom2.setText("Bonussatz");
        textFieldId.setText(String.valueOf(dto.id()));
        textFieldName.setText(dto.name());
        buttonCustom1.setText(String.valueOf(dto.festgehalt()));
        buttonCustom2.setText(String.valueOf(dto.bonussatz()));
    }

    private void createBueroarbeiterBody(MitarbeiterDto dto) {}

    private void createSchichtarbeiterBody(MitarbeiterDto dto) {}

    private void createHeader() {
        headerText.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        headerText.setText("Mitarbeiter bearbeiten");
        headerText.setVisible(true);
        header.add(headerText);
        header.setBackground(BACKGROUND_COLOR);
        header.setSize(HEADER_SIZE);
        this.getContentPane().add(header, BorderLayout.NORTH);
    }

    private void createDefaultBody() {
        //left side objects
        textName.setText("Name");
        textName.setVisible(true);
        textName.setSize(BODY_OBJECT_SIZE);
        textId.setText("ID");
        textId.setVisible(true);
        textId.setSize(BODY_OBJECT_SIZE);

        //right side objects
        textFieldId.setSize(BODY_OBJECT_SIZE);
        textFieldName.setSize(BODY_OBJECT_SIZE);
        //buttonCustom1.setSize(BODY_OBJECT_SIZE);
        //buttonCustom2.setSize(BODY_OBJECT_SIZE);

        body.setLayout(new BoxLayout(body, BoxLayout.X_AXIS));
        body.add(bodyInternalLeft);
        body.add(bodyInternalRight);

        bodyInternalLeft.setLayout(new GridLayout(4,1));
        bodyInternalLeft.setSize(BODY_SIZE);
        bodyInternalLeft.add(textName);
        bodyInternalLeft.add(textId);
        bodyInternalLeft.add(textCustom1);
        bodyInternalLeft.add(textCustom2);
        bodyInternalLeft.setBackground(BACKGROUND_COLOR);

        bodyInternalRight.setLayout(new GridLayout(4,1));
        bodyInternalRight.setSize(BODY_SIZE);
        bodyInternalRight.add(textFieldName);
        bodyInternalRight.add(textFieldId);
        bodyInternalRight.add(buttonCustom1);
        bodyInternalRight.add(buttonCustom2);
        bodyInternalRight.setBackground(BACKGROUND_COLOR);

        body.setBackground(BACKGROUND_COLOR);
        body.setSize(BODY_SIZE);

        this.getContentPane().add(body, BorderLayout.CENTER);
    }

    private void createButtonRow() {
        buttonrow.setBackground(BACKGROUND_COLOR);
        buttonrow.setSize(BUTTONROW_SIZE);

        exitButton.setText("Schließen");
        exitButton.setVisible(true);

        updateButton.setText("Speichern");
        updateButton.setVisible(true);

        buttonrow.add(exitButton);
        buttonrow.add(updateButton);

        this.getContentPane().add(buttonrow, BorderLayout.SOUTH);
    }

}

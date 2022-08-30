package com.itf201.mitarbeiteransicht.frontend;

import com.itf201.mitarbeiteransicht.backend.person.MitarbeiterTyp;

import javax.swing.*;
import java.awt.*;

public class MitarbeiterEditModal extends JFrame {

    private static final Dimension WINDOW_SIZE = new Dimension(500, 600);
    private static final Dimension HEADER_SIZE = new Dimension(500, 100);
    private static final Dimension BODY_SIZE = new Dimension(500, 350);
    private static final Dimension BUTTONROW_SIZE = new Dimension(500, 50);
    private static final Color BACKGROUND_COLOR = Color.GRAY;
    private final JPanel header = new JPanel();
    private final JPanel body = new JPanel();
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

    public MitarbeiterEditModal(MitarbeiterTyp typ) {
        createDefaultBody();
        createHeader();
        createButtonRow();
        switch (typ) {
            case SCHICHTARBEITER -> createSchichtarbeiterBody();
            case BUEROARBEITER -> createBueroarbeiterBody();
            case MANAGER -> createManagerBody();
        }
        this.setSize(WINDOW_SIZE);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }

    private void createManagerBody() {}

    private void createBueroarbeiterBody() {}

    private void createSchichtarbeiterBody() {}

    private void createHeader() {
        headerText.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        headerText.setText("Mitarbeiter bearbeiten");
        headerText.setVisible(true);
        header.add(headerText);

        header.setBackground(BACKGROUND_COLOR);
        header.setSize(HEADER_SIZE);

        this.add(header);
    }

    private void createDefaultBody() {
        textName.setText("Name");
        textName.setVisible(true);

        textId.setText("ID");
        textId.setVisible(true);

        body.add(bodyInternalLeft);
        body.add(bodyInternalRight);

        bodyInternalLeft.add(textName);
        bodyInternalLeft.add(textId);
        bodyInternalLeft.add(textCustom1);
        bodyInternalLeft.add(textCustom2);
        body.setBackground(BACKGROUND_COLOR.darker());
        body.setSize(BODY_SIZE);

        this.add(body);
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

        this.add(buttonrow);
    }

}

package com.itf201.mitarbeiteransicht.frontend;

import com.itf201.mitarbeiteransicht.backend.MitarbeiterDto;
import com.itf201.mitarbeiteransicht.backend.ReaderWriter;

import javax.swing.*;
import java.awt.*;

public class MitarbeiterEditModal extends JFrame {

    private static final Dimension WINDOW_SIZE = new Dimension(500, 600);
    private static final Dimension HEADER_SIZE = new Dimension(500, 100);
    private static final Dimension BODY_SIZE = new Dimension(250, 350);
    private static final Dimension BUTTONROW_SIZE = new Dimension(500, 50);
    private static final Dimension BODY_OBJECT_SIZE = new Dimension(250, 50);
    private static final Color BACKGROUND_COLOR = Color.WHITE;
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
    private final JLabel textCustomUpper = new JLabel();
    private final JLabel textCustomLower = new JLabel();
    private final JLabel textFieldId = new JLabel();
    private final JLabel textFieldName = new JLabel();
    private final JTextField inputCustomUpper = new JTextField();
    private final JTextField inputCustomLower = new JTextField();

    public MitarbeiterEditModal(MitarbeiterDto dude) {
        createHeader();
        createDefaultBody();
        createButtonRow();
        switch (dude.typ()) {
            case SCHICHTARBEITER -> createSchichtarbeiterBody(dude);
            case BUEROARBEITER -> createBueroarbeiterBody(dude);
            case MANAGER -> createManagerBody(dude);
        }
        textFieldId.setText(String.valueOf(dude.id()));
        textFieldName.setText(dude.name());
        this.setSize(WINDOW_SIZE);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        updateButton.addActionListener(e -> saveToDb(dude));
    }

    private void createManagerBody(MitarbeiterDto dto) {
        textCustomUpper.setText("Festgehalt");
        textCustomLower.setText("Bonussatz");
        inputCustomUpper.setText(String.valueOf(dto.festgehalt()));
        inputCustomLower.setText(String.valueOf(dto.bonussatz()));
    }

    private void createBueroarbeiterBody(MitarbeiterDto dto) {
        textCustomUpper.setText("Festgehalt");
        inputCustomUpper.setText(String.valueOf(dto.festgehalt()));
        inputCustomLower.setVisible(false);
        textCustomLower.setVisible(false);
        //TODO leerzeile entfernen
        this.remove(inputCustomLower);
        this.remove(textCustomLower);
    }

    private void createSchichtarbeiterBody(MitarbeiterDto dto) {
        textCustomUpper.setText("Stundenlohn");
        inputCustomUpper.setText(String.valueOf(dto.stundenlohn()));
        textCustomLower.setText("Stundenzahl");
        inputCustomLower.setText(String.valueOf(dto.stundenzahl()));
    }

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
        textName.setFocusable(false);
        textId.setText("ID");
        textId.setVisible(true);
        textId.setSize(BODY_OBJECT_SIZE);

        //right side objects
        textFieldId.setSize(BODY_OBJECT_SIZE);
        textFieldName.setSize(BODY_OBJECT_SIZE);
        inputCustomUpper.setSize(BODY_OBJECT_SIZE);
        inputCustomLower.setSize(BODY_OBJECT_SIZE);

        body.setLayout(new BoxLayout(body, BoxLayout.X_AXIS));
        body.add(bodyInternalLeft);
        body.add(bodyInternalRight);

        bodyInternalLeft.setLayout(new GridLayout(4, 1));
        bodyInternalLeft.setSize(BODY_SIZE);
        bodyInternalLeft.add(textName);
        bodyInternalLeft.add(textId);
        bodyInternalLeft.add(textCustomUpper);
        bodyInternalLeft.add(textCustomLower);
        bodyInternalLeft.setBackground(BACKGROUND_COLOR);

        bodyInternalRight.setLayout(new GridLayout(4, 1));
        bodyInternalRight.setSize(BODY_SIZE);
        bodyInternalRight.add(textFieldName);
        bodyInternalRight.add(textFieldId);
        bodyInternalRight.add(inputCustomUpper);
        bodyInternalRight.add(inputCustomLower);
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
        exitButton.addActionListener(e -> this.dispose());

        updateButton.setText("Speichern");
        updateButton.setVisible(true);

        buttonrow.add(exitButton);
        buttonrow.add(updateButton);

        this.getContentPane().add(buttonrow, BorderLayout.SOUTH);
    }

    //if all values are validated, user is able to save to """database"""
    private void saveToDb(MitarbeiterDto dtoToSave) {
        MitarbeiterDto result = switch (dtoToSave.typ()) {
            case MANAGER -> new MitarbeiterDto(
                    dtoToSave.id(),
                    dtoToSave.name(),
                    dtoToSave.typ(),
                    Double.valueOf(inputCustomUpper.getText()),
                    0.0,
                    Double.valueOf(inputCustomLower.getText()),
                    0
            );
            case BUEROARBEITER -> new MitarbeiterDto(
                    dtoToSave.id(),
                    dtoToSave.name(),
                    dtoToSave.typ(),
                    Double.valueOf(inputCustomUpper.getText()),
                    0.0,
                    0.0,
                    0
            );
            case SCHICHTARBEITER -> new MitarbeiterDto(
                    dtoToSave.id(),
                    dtoToSave.name(),
                    dtoToSave.typ(),
                   0.0,
                    Double.valueOf(inputCustomUpper.getText()),
                    0.0,
                    Integer.parseInt(inputCustomLower.getText())
            );
        };
        ReaderWriter.editMitarbeiter(result);
        System.out.println(ReaderWriter.getAllMitarbeiter());
    }


}

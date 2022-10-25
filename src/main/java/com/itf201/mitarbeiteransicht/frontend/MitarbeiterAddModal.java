package com.itf201.mitarbeiteransicht.frontend;

import com.itf201.mitarbeiteransicht.backend.MitarbeiterDto;
import com.itf201.mitarbeiteransicht.backend.ReaderWriter;
import com.itf201.mitarbeiteransicht.backend.person.MitarbeiterTyp;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MitarbeiterAddModal extends JFrame {

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
    private final JButton addButton = new JButton();
    private final JButton exitButton = new JButton();
    private final JLabel headerText = new JLabel();

    private final JLabel textLabelID = new JLabel();
    private final JLabel textLabelName = new JLabel();
    private final JLabel textLabelStundenZahl = new JLabel();
    private final JLabel textLabelStundenLohn = new JLabel();
    private final JLabel textLabelBonussatz = new JLabel();
    private final JLabel textLabelFestGehalt = new JLabel();

    private final JTextField inputID = new JTextField();
    private final JTextField inputName = new JTextField();
    private final JTextField inputStundenZahl = new JTextField();
    private final JTextField inputStundenLohn = new JTextField();
    private final JTextField inputBonussatz = new JTextField();
    private final JTextField inputFestGehalt = new JTextField();

    private final JComboBox<String> typeSelector = new JComboBox<>(new String[]{
            MitarbeiterTyp.BUEROARBEITER.name(),
            MitarbeiterTyp.MANAGER.name(),
            MitarbeiterTyp.SCHICHTARBEITER.name()
    });

    public MitarbeiterAddModal() {
        createHeader();
        createDefaultBody();
        createButtonRow();
        setSize(WINDOW_SIZE);
        setResizable(false);
        setAlwaysOnTop(true);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();

        addButton.addActionListener(e -> saveToDb(createMitarbeiterFromInput()));
    }

    private MitarbeiterDto createMitarbeiterFromInput() {
        return new MitarbeiterDto(
                Integer.parseInt(inputID.getText()),
                inputName.getText(),
                MitarbeiterTyp.valueOf(Objects.requireNonNull(typeSelector.getSelectedItem()).toString()),
                Double.valueOf(inputFestGehalt.getText()),
                Double.valueOf(inputStundenLohn.getText()),
                Double.valueOf(inputBonussatz.getText()),
                Integer.parseInt(inputStundenZahl.getText()));
    }

    private void createHeader() {
        headerText.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        headerText.setText("Mitarbeiter bearbeiten");
        headerText.setVisible(true);
        header.add(headerText);
        header.setBackground(BACKGROUND_COLOR);
        header.setSize(HEADER_SIZE);
        getContentPane().add(header, BorderLayout.NORTH);

        header.add(typeSelector);
        typeSelector.addActionListener(e -> enableCorrectInputColumns(MitarbeiterTyp.valueOf(
                Objects.requireNonNull(typeSelector.getSelectedItem()).toString())));
        typeSelector.setSelectedIndex(0);
    }

    private void setAllLabelsAndInputsInvisible() {
        textLabelStundenZahl.setEnabled(false);
        inputStundenZahl.setEnabled(false);

        textLabelStundenLohn.setEnabled(false);
        inputStundenLohn.setEnabled(false);

        textLabelBonussatz.setEnabled(false);
        inputBonussatz.setEnabled(false);

        textLabelFestGehalt.setEnabled(false);
        inputFestGehalt.setEnabled(false);
    }

    private void enableCorrectInputColumns(MitarbeiterTyp type) {
        setAllLabelsAndInputsInvisible();
        switch (type) {
            case MANAGER -> {
                textLabelBonussatz.setEnabled(true);
                inputBonussatz.setEnabled(true);
                textLabelFestGehalt.setEnabled(true);
                inputFestGehalt.setEnabled(true);
            }
            case BUEROARBEITER -> {
                textLabelFestGehalt.setEnabled(true);
                inputFestGehalt.setEnabled(true);
            }
            case SCHICHTARBEITER -> {
                textLabelStundenZahl.setEnabled(true);
                inputStundenZahl.setEnabled(true);
                textLabelStundenLohn.setEnabled(true);
                inputStundenLohn.setEnabled(true);
            }
        }
        pack();
    }

    private void setUpLabel(JLabel label, String name) {
        label.setText(name);
        label.setVisible(true);
        label.setSize(BODY_OBJECT_SIZE);
        label.setFocusable(false);
    }

    private void createDefaultBody() {
        //left side objects
        setUpLabel(textLabelID, "ID");
        setUpLabel(textLabelName, "Name");
        setUpLabel(textLabelStundenZahl, "Stundenzahl");
        setUpLabel(textLabelStundenLohn, "Stundenlohn");
        setUpLabel(textLabelBonussatz, "Bonussatz");
        setUpLabel(textLabelFestGehalt, "Festgehalt");

        //right side objects
        body.setLayout(new BoxLayout(body, BoxLayout.X_AXIS));
        body.add(bodyInternalLeft);
        body.add(bodyInternalRight);

        bodyInternalLeft.setLayout(new GridLayout(7, 1));
        bodyInternalLeft.setSize(BODY_SIZE);
        bodyInternalLeft.add(textLabelID);
        bodyInternalLeft.add(textLabelName);
        bodyInternalLeft.add(textLabelStundenZahl);
        bodyInternalLeft.add(textLabelStundenLohn);
        bodyInternalLeft.add(textLabelBonussatz);
        bodyInternalLeft.add(textLabelFestGehalt);
        bodyInternalLeft.setBackground(BACKGROUND_COLOR);

        bodyInternalRight.setLayout(new GridLayout(7, 1));
        bodyInternalRight.setSize(BODY_SIZE);
        bodyInternalRight.add(inputID);
        bodyInternalRight.add(inputName);
        bodyInternalRight.add(inputStundenZahl);
        bodyInternalRight.add(inputStundenLohn);
        bodyInternalRight.add(inputBonussatz);
        bodyInternalRight.add(inputFestGehalt);
        bodyInternalRight.setBackground(BACKGROUND_COLOR);

        body.setBackground(BACKGROUND_COLOR);
        body.setSize(BODY_SIZE);

        getContentPane().add(body, BorderLayout.CENTER);
    }

    private void createButtonRow() {
        buttonrow.setBackground(BACKGROUND_COLOR);
        buttonrow.setSize(BUTTONROW_SIZE);

        exitButton.setText("Schließen");
        exitButton.setVisible(true);
        exitButton.addActionListener(e -> dispose());

        addButton.setText("Speichern");
        addButton.setVisible(true);

        buttonrow.add(exitButton);
        buttonrow.add(addButton);

        getContentPane().add(buttonrow, BorderLayout.SOUTH);
    }

    //if all values are validated, user is able to save to """database"""
    private void saveToDb(MitarbeiterDto dtoToSave) {
        MitarbeiterDto result = switch (dtoToSave.typ()) {
            case MANAGER -> new MitarbeiterDto(
                    dtoToSave.id(),
                    dtoToSave.name(),
                    dtoToSave.typ(),
                    Double.valueOf(inputFestGehalt.getText()),
                    0.0,
                    Double.valueOf(inputBonussatz.getText()),
                    0
            );
            case BUEROARBEITER -> new MitarbeiterDto(
                    dtoToSave.id(),
                    dtoToSave.name(),
                    dtoToSave.typ(),
                    Double.valueOf(inputFestGehalt.getText()),
                    0.0,
                    0.0,
                    0
            );
            case SCHICHTARBEITER -> new MitarbeiterDto(
                    dtoToSave.id(),
                    dtoToSave.name(),
                    dtoToSave.typ(),
                    0.0,
                    Double.valueOf(inputStundenLohn.getText()),
                    0.0,
                    Integer.parseInt(inputStundenZahl.getText())
            );
        };
        ReaderWriter.createMitarbeiter(result);
    }
}

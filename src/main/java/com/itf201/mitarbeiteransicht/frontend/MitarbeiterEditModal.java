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

    private final FlowLayout layout = new FlowLayout();
    private final FlowLayout layoutHeader = new FlowLayout();
    private final FlowLayout layoutBody = new FlowLayout();
    private final FlowLayout layoutBodyLeft = new FlowLayout();
    private final FlowLayout layoutBodyRight = new FlowLayout();
    private final FlowLayout layoutButtonRow = new FlowLayout();

    private final JPanel header = new JPanel();
    private final JPanel body = new JPanel();
    private final JPanel bodyInternalLeft = new JPanel();
    private final JPanel bodyInternalRight = new JPanel();
    private final JPanel buttonrow = new JPanel();

    private final JButton updateButton = new JButton();
    private final JButton exitButton = new JButton();

    private final JTextArea headerText = new JTextArea();
    private final JTextArea textId = new JTextArea();
    private final JTextArea textName = new JTextArea();
    private final JTextArea textCustom1 = new JTextArea();
    private final JTextArea textCustom2 = new JTextArea();

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
        this.setVisible(true);
        this.setLayout(layout);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createManagerBody() {}

    private void createBueroarbeiterBody() {}

    private void createSchichtarbeiterBody() {}

    private void createHeader() {
        header.setLayout(layout);
        header.setBackground(BACKGROUND_COLOR);
        header.setSize(HEADER_SIZE);

        headerText.setText("Mitarbeiter bearbeiten");
        headerText.setBackground(BACKGROUND_COLOR);
        headerText.setSize(header.getSize());

        header.add(headerText);

        this.add(header);
    }

    private void createDefaultBody() {
        body.setLayout(layout);
        body.setBackground(BACKGROUND_COLOR.darker());
        body.setSize(BODY_SIZE);

        textName.setText("Name");
        textName.setVisible(true);
        textName.setLayout(layout);

        textId.setText("ID");
        textId.setVisible(true);
        textId.setLayout(layout);

        body.add(textName);
        body.add(textId);
        body.add(textCustom1);
        body.add(textCustom2);

        this.add(body);
    }

    private void createButtonRow() {
        buttonrow.setLayout(layout);
        buttonrow.setBackground(BACKGROUND_COLOR);
        buttonrow.setSize(BUTTONROW_SIZE);

        exitButton.setText("Schließen");

        updateButton.setText("Speichern");

        buttonrow.add(exitButton);
        buttonrow.add(updateButton);

        this.add(buttonrow);
    }

}

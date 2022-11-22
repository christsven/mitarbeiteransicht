package com.itf201.mitarbeiteransicht.frontend;

import com.itf201.mitarbeiteransicht.backend.MitarbeiterDto;
import com.itf201.mitarbeiteransicht.backend.ReaderWriter;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;

public class MitarbeiterWindow extends JFrame {
    private final JButton addButton = new JButton();
    private final JPanel middlePanel = new JPanel();
    private final JToolBar toolBar = new JToolBar("Tools");
    private JTable table;

    private final String[] headerRow = new String[]{
            "ID", "NAME", "POSITION", "FESTGEHALT", "STUNDENLOHN", "BONUSSATZ", "STUNDENZAHL"
    };

    public MitarbeiterWindow(Runnable runnable) {
        createTable();
        createToolBar();

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        //TODO onClose ->
    }

    private void createTable() {
        table = new JTable();
        table.setModel(new DefaultTableModel(getVisibleTableData(), headerRow));
        table.setRowHeight(20);
        table.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);
        table.doLayout();

        JScrollPane scrollPane = new JScrollPane(table);
        middlePanel.add(scrollPane);
        middlePanel.setVisible(true);
        add(middlePanel);
    }

    private void createToolBar() {
        addButton.setText("Hinzufügen");
        addButton.setVisible(true);
        addButton.addActionListener(e -> openAddModal());

        toolBar.add(addButton);
        add(toolBar, BorderLayout.PAGE_START);
    }

    private Object[][] getVisibleTableData() {

        if (ReaderWriter.getAllMitarbeiter() == null || ReaderWriter.getAllMitarbeiter().isEmpty())
            return new MitarbeiterDto[6][0];

        ArrayList<MitarbeiterDto> dtos = new ArrayList<>(ReaderWriter.getAllMitarbeiter());

        String[][] tableValues = new String[dtos.size()][7];
        for (int current = 0; current < dtos.size(); current++) {
            MitarbeiterDto dto = dtos.get(current);
            tableValues[current][0] = String.valueOf(dto.id());
            tableValues[current][1] = dto.name();
            tableValues[current][2] = dto.typ().name();
            tableValues[current][3] = String.valueOf(dto.festgehalt());
            tableValues[current][4] = String.valueOf(dto.stundenlohn());
            tableValues[current][5] = String.valueOf(dto.bonussatz());
            tableValues[current][6] = String.valueOf(dto.stundenzahl());
        }

        return tableValues;
    }

    private int getSelectedID() {
        return (Integer) table.getValueAt(0, table.getSelectedColumn());
    }

    private void openAddModal() {
        new MitarbeiterAddModal(() -> table.setModel(new DefaultTableModel(getVisibleTableData(), headerRow)));
        AbstractTableModel tableModel = (AbstractTableModel) table.getModel();
        tableModel.fireTableDataChanged();
    }
}

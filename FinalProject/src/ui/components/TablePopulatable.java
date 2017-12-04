/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hezj
 */
public interface TablePopulatable<Element> extends ChildComponent {
    JTable getTable();

    default DefaultTableModel clearTable() {
        JTable table = getTable();
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        return dtm;
    }
    
    default void populateTable(Iterable<Element> elements) {
        DefaultTableModel dtm = clearTable();
        elements.forEach(e -> dtm.addRow(populateRow(e)));
    }
    
    default void populateTable(Stream<Element> elementStream) {
        DefaultTableModel dtm = clearTable();
        elementStream.forEach(e -> dtm.addRow(populateRow(e)));
    }

    Object[] populateRow(Element element);

    default Element getSelected() {
        JTable table = getTable();
        int selectedCount = table.getSelectedRowCount();
        if (selectedCount > 1) {
            JOptionPane.showMessageDialog((Component) this, "Please select no more than 1 row.");
            return null;
        }
        if (selectedCount < 1) {
            JOptionPane.showMessageDialog((Component) this, "Please select 1 row.");
            return null;
        }

        return (Element)table.getValueAt(table.getSelectedRow(), 0);
    }

    void populateTable();

    @Override
    default void exposed() {
        populateTable();
    }

    //    default boolean removeSelected(AbstractCatalog<Element> catalog) {
//        Element selected = getSelected();
//        if (selected == null) {
//            return false;
//        }
//        
//        int result = JOptionPane.showConfirmDialog((Component) this, "Confirm delete?", "Warning", JOptionPane.YES_NO_OPTION);
//        if (result == JOptionPane.NO_OPTION) {
//            return false;
//        }
//        
//        boolean res = catalog.removeElement(selected);
//
//        populateTable();
//        
//        return res;
//    }
    
    default StringBuilder getTableSB() {
        StringBuilder sb = new StringBuilder();
        JTable table = getTable();
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        
        ArrayList<String> strArr = new ArrayList<>();
        for (int j = 0; j < dtm.getColumnCount(); j++) {
            strArr.add(dtm.getColumnName(j));
        }
        sb.append(String.join(",", strArr) + "\n");

        for (int i = 0; i < dtm.getRowCount(); i++) {
            strArr = new ArrayList<>();
            for (int j = 0; j < dtm.getColumnCount(); j++) {
                strArr.add(String.valueOf(dtm.getValueAt(i, j)));
            }
            sb.append(String.join(",", strArr) + "\n");
        }
        return sb;
    }
    
    default void toCSV() {
        toCSV("Output.csv");
    }
    
    default void toCSV(String fileName) {
        JFileChooser chooser = new JFileChooser(); 
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose csv path");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog((Component) this) == JFileChooser.APPROVE_OPTION) { 
            try {
                File file = new File(chooser.getSelectedFile().toString() + "/" + fileName);
                BufferedWriter writer = null;
                writer = new BufferedWriter(new FileWriter(file));
                writer.write(getTableSB().toString());
                writer.close();
                JOptionPane.showMessageDialog((Component) this, "Exported");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog((Component) this, "Export failed.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}

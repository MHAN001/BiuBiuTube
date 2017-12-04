package ui.components;

import javax.swing.table.DefaultTableModel;

public class UnEditableTableModel extends DefaultTableModel {
    public UnEditableTableModel(String[] colNames) {
        super(new Object[0][colNames.length], colNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

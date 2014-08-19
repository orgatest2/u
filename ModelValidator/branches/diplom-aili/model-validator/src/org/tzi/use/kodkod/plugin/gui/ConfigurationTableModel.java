package org.tzi.use.kodkod.plugin.gui;

import javax.swing.table.AbstractTableModel;

public class ConfigurationTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	private String[] columnNames;
	private Object[][] data;

	public ConfigurationTableModel(String[] columnNames,
			Object[][] data) {
		super();
		this.columnNames = columnNames;
		this.data = data;
	}
	
	@Override
	public int getColumnCount() {
        return columnNames.length;
    }

	@Override
    public int getRowCount() {
        return data.length;
    }

	@Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

	@Override
    public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	public boolean isCellEditable(int row, int col) {
        if (col < 1) {
            return false;
        } else {
            return true;
        }
	}
	
	public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

}
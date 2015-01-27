package org.tzi.use.kodkod.plugin.gui.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import org.tzi.use.kodkod.plugin.gui.ConfigurationTerms;

public class RendererReal extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;

	public RendererReal() {
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object color,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		if (isSelected) {
			if (table.getColumnModel().getColumn(0).getHeaderValue().equals(ConfigurationTerms.BASIC_TYPE)) {
				setBackground(Color.white);
			} else {
				setBackground(new Color(204,204,255));
			}
		} else {
			setBackground(table.getBackground());
		}
		
		Double value = (Double) table.getValueAt(row, column);
		this.setText(""+value);
		this.setHorizontalAlignment(RIGHT);
		
		return this;
	}
}
package org.tzi.use.kodkod.plugin.gui.model.data;

import java.util.ArrayList;
import java.util.List;

import org.tzi.kodkod.model.config.impl.DefaultConfigurationValues;
import org.tzi.kodkod.model.type.TypeConstants;
import org.tzi.use.kodkod.plugin.gui.util.ChangeString;

public class IntegerSettings {
	
	private String name = TypeConstants.INTEGER;
	private boolean enabled;
	private Integer minimum;
	private Integer maximum;
	private List<String> values = new ArrayList<>();
	private SettingsConfiguration configurationSettings;
	
	public IntegerSettings(SettingsConfiguration configurationSettings) {
		this.configurationSettings = configurationSettings;
	}
	
	public String name() {
		return this.name;
	}
	
	public SettingsConfiguration getConfigurationSettings() {
		return configurationSettings;
	}
	
	public Integer getMinimum() {
		return this.minimum;
	}
	
	public void setMinimum(Object minimum) {
		if (minimum == null) {
			this.minimum = null;
		} else {
			if (minimum.equals("")) {
				this.minimum = null;
			} else {
				this.minimum = (Integer) minimum;
			}
		}
		this.configurationSettings.setChanged(true);
	}
	
	public Integer getMaximum() {
		return this.maximum;
	}
	
	public void setMaximum(Object maximum) {
		if (maximum == null) {
			this.maximum = null;
		} else {
			if (maximum.equals("")) {
				this.maximum = null;
			} else {
				this.maximum = (Integer) maximum;
			}
		}
		this.configurationSettings.setChanged(true);
	}
		
	public List<String> getValues() {
		return values;
	}
	
	public void setValues(String values) {
		this.values = ChangeString.toArrayList(values);
		this.configurationSettings.setChanged(true);
	}
	
	public void setValues(List<String> values) {
		this.values = values;
		this.configurationSettings.setChanged(true);
	}
	
	public void deleteValues() {
		values.clear();
	}

	/**
	 * Resets these Settings to default values.
	 */
	public void reset() {
		minimum = DefaultConfigurationValues.integerMin;
		maximum = DefaultConfigurationValues.integerMax;
		deleteValues();
	}
	
}
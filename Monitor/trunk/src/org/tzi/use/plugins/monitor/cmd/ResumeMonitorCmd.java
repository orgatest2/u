package org.tzi.use.plugins.monitor.cmd;

import org.tzi.use.main.shell.runtime.IPluginShellCmd;
import org.tzi.use.plugins.monitor.MonitorPlugin;

public class ResumeMonitorCmd extends AbstractMonitorCmd {

	@Override
	public void doPerformCommand(IPluginShellCmd pluginCommand) {
		if (!MonitorPlugin.getInstance().getMonitor().isPaused()) return;
		MonitorPlugin.getInstance().getMonitor().resume();
	}

}

package com.opera.core.systems.scope.services.ums;

import java.awt.Point;

import org.openqa.selenium.RenderedWebElement;

import com.opera.core.systems.QuickWidget;
import com.opera.core.systems.ScopeServices;
import com.opera.core.systems.scope.AbstractService;
import com.opera.core.systems.scope.ExecCommand;
import com.opera.core.systems.scope.SystemInputCommand;
import com.opera.core.systems.scope.internal.OperaMouseKeys;
import com.opera.core.systems.scope.protos.ExecProtos.MouseAction;
import com.opera.core.systems.scope.protos.SystemInputProtos.MouseInfo;
import com.opera.core.systems.scope.services.SystemInput;

public class SystemInputManager extends AbstractService implements SystemInput {

	 SystemInputManager(ScopeServices services, String version) {
			super(services, version);
			
			String serviceName = "system-input";
			
			if(!isVersionInRange(version, "5.0", serviceName))
				throw new UnsupportedOperationException(serviceName + " version " + version + " is not supported");
			
			services.setSystemInputManager(this);
		}
	
	public void click(Point location) {
		System.out.println("SystemInputManager::click( " + location.x + ", " + location.y + ")");
		//services.getExec().mouseAction(point.x, point.y, OperaMouseKeys.LEFT);
		MouseInfo.Builder actionBuilder = MouseInfo.newBuilder();
		actionBuilder.setX(location.x);
		actionBuilder.setY(location.y);
		actionBuilder.setButton(0);
		actionBuilder.setNumClicks(1);
		executeCommand(SystemInputCommand.CLICK, actionBuilder.clone());
		
	}

	public void keyPress() {
		// TODO Auto-generated method stub

	}

}
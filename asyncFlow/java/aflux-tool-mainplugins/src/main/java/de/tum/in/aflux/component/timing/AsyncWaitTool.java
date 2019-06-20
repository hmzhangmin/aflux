/*
 *
 *  *
 *  * aFlux: JVM based IoT Mashup Tool
 *  * Copyright (C) 2018  Tanmaya Mahapatra
 *  *
 *  * This file is part of aFlux.
 *  *
 *  * aFlux is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU General Public License as published by
 *  * the Free Software Foundation, version 3 of the License.
 *  *
 *  * aFlux is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU General Public License
 *  * along with aFlux.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 */

package de.tum.in.aflux.component.timing;

import de.tum.in.aflux.tools.core.AbstractMainExecutor;
import de.tum.in.aflux.tools.core.NodeLaunchType;
import de.tum.in.aflux.tools.core.PropertyInputType;
import de.tum.in.aflux.component.timing.actor.AsyncWaitToolActor;
import de.tum.in.aflux.tools.core.ToolProperty;

public class AsyncWaitTool extends AbstractMainExecutor {
	
	

	static public final String NAME="async wait";
	static public final ToolProperty[] configurationProperties={
			new ToolProperty("value","1000",PropertyInputType.TEXT,null,"Time to wait in milliseconds","",false)
			};

	public AsyncWaitTool() {
		super(NAME, AsyncWaitToolActor.class.getCanonicalName(), AsyncWaitTool.class.getName(),1 , 1, NodeLaunchType.LAUNCHED_BY_SIGNAL,true,configurationProperties);
		this.setColor("#A5D6A7");
	}


}

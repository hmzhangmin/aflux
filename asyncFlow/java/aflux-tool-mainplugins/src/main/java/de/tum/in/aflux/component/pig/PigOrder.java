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

package de.tum.in.aflux.component.pig;

import de.tum.in.aflux.component.pig.actor.PigOrderActor;
import de.tum.in.aflux.tools.core.AbstractMainExecutor;
import de.tum.in.aflux.tools.core.NodeLaunchType;
import de.tum.in.aflux.tools.core.PropertyInputType;
import de.tum.in.aflux.tools.core.ToolProperty;
import de.tum.in.aflux.tools.core.ToolPropertyOption;

public class PigOrder extends AbstractMainExecutor  {
	public static final String NAME="Pig ORDER";
	static ToolPropertyOption[] orderType={
			new ToolPropertyOption("ASC|ASC"),
			new ToolPropertyOption("DESC|DESC")};
	
	static public ToolProperty[] connectionProperties={
			new ToolProperty(PigConstants.SOURCE_ALIAS,"",PropertyInputType.TEXT,null,"The name of a relation.","",false),

			new ToolProperty(PigConstants.FIELD,"",PropertyInputType.TEXT,null,"Name of the order field or *","",false),
			new ToolProperty(PigConstants.MODE,"ASC",PropertyInputType.SELECT,orderType,"Mode ASC/DESC","",false),

			new ToolProperty(PigConstants.PARALLEL,"1",PropertyInputType.TEXT,null,"Increase the parallelism of a job by specifying the number of reduce tasks, n","",false),
			new ToolProperty(PigConstants.TARGET_ALIAS,"",PropertyInputType.TEXT,null,"Variable name to get the grouped data and be used in subsequent sentences","",false)
	};

	public PigOrder() {
		super(NAME,
				PigOrderActor.class.getCanonicalName(),
				PigOrder.class.getName(),
				1, 
				1,
				NodeLaunchType.LAUNCHED_BY_DATA,
				false,
				connectionProperties);
		this.setColor(PigConstants.COLOR);

	}

}

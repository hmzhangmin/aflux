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

import de.tum.in.aflux.component.pig.actor.PigDescribeActor;
import de.tum.in.aflux.component.pig.actor.PigExplainActor;
import de.tum.in.aflux.tools.core.AbstractMainExecutor;
import de.tum.in.aflux.tools.core.NodeLaunchType;
import de.tum.in.aflux.tools.core.PropertyInputType;
import de.tum.in.aflux.tools.core.ToolProperty;

public class PigExplain extends AbstractMainExecutor  {
	public static final String NAME="Pig EXPLAIN";
	static public ToolProperty[] connectionProperties={
			new ToolProperty(PigConstants.ALIAS,"",PropertyInputType.TEXT,null,"Alias name associated to the collection to be describede","",false),
			
	};

	public PigExplain() {
		super(NAME,
				PigExplainActor.class.getCanonicalName(),
				PigExplain.class.getName(),
				1, 
				1,
				NodeLaunchType.LAUNCHED_BY_DATA,
				false,
				connectionProperties);
		this.setColor(PigConstants.COLOR);

	}

}

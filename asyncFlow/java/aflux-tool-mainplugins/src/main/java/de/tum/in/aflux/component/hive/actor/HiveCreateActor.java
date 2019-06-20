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

package de.tum.in.aflux.component.hive.actor;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.tum.in.aflux.component.hive.HiveConstants;
import de.tum.in.aflux.bigdata.hive.model.HiveBuilder;
import de.tum.in.aflux.bigdata.hive.model.HiveExecutionPlan;
import de.tum.in.aflux.flux_engine.FluxEnvironment;
import de.tum.in.aflux.flux_engine.FluxRunner;
import de.tum.in.aflux.tools.core.AbstractAFluxActor;

public class HiveCreateActor extends AbstractAFluxActor{
	private final Logger log = LoggerFactory.getLogger(this.getClass());	
	
	public HiveCreateActor(String fluxId, FluxEnvironment fluxEnvironment, FluxRunner fluxRunner,Map<String,String> properties) {
		super(fluxId, fluxEnvironment, fluxRunner,properties,-1);
	}

	@Override
	protected void runCore(Object message) throws Exception {
		// get previous script
		HiveExecutionPlan executionPlan=HiveBuilder.buildExecutionPlan(message);
		String name = 		HiveBuilder.buildTableName(this.getProperty(HiveConstants.NAME), this.getProperty(HiveConstants.ADD_TIMESTAMP));
		// build sentence
		String sentence = "CREATE";
		sentence+=HiveBuilder.buildTemporaryClause(this.getProperty(HiveConstants.TEMPORARY));
		sentence+=HiveBuilder.buildExternalClause(this.getProperty(HiveConstants.EXTERNAL));
		sentence+=" TABLE";
		sentence+=" IF NOT EXISTS";
		
		sentence+=" "+name;
		sentence+=" ("+this.getProperty(HiveConstants.COLUMNS)+")";
		sentence+=HiveBuilder.buildCommentClause(this.getProperty(HiveConstants.COMMENT));
		sentence+=HiveBuilder.buildPartitionedClause(this.getProperty(HiveConstants.PARTITIONED));
		sentence+=HiveBuilder.buildRowFormatClause(this.getProperty(HiveConstants.ROW_FORMAT));
		sentence+=HiveBuilder.buildStoredAsClause(this.getProperty(HiveConstants.FILE_FORMAT));
		sentence+=HiveBuilder.buildLocationClause(this.getProperty(HiveConstants.LOCATION));
		
		HiveBuilder.deliverPlan("create-table",sentence,name,log,executionPlan,this,null);

	}

}

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

package de.tum.in.aflux.component.hdfs.actor;

import java.util.Map;

import de.tum.in.aflux.component.hdfs.HDFSConstants;
import de.tum.in.aflux.flux_engine.FluxEnvironment;
import de.tum.in.aflux.flux_engine.FluxRunner;
import de.tum.in.aflux.tools.core.AbstractAFluxActor;

public class FsShellHDFSLsActor extends AbstractAFluxActor{
	public FsShellHDFSLsActor(String fluxId, FluxEnvironment fluxEnvironment, FluxRunner fluxRunner,Map<String,String> properties) {
		super(fluxId, fluxEnvironment, fluxRunner,properties,2);
	}

	@Override
	protected void runCore(Object message) throws Exception {
		String sourceFileName = this.getProperty(HDFSConstants.SOURCE_PATH);
		boolean recursive=((String) this.getProperty(HDFSConstants.RECURSIVE)).toLowerCase().equals("true");
		String result=this.getFluxEnvironment().getFsShell().ls(recursive,sourceFileName).toString();
		this.setOutput(1, result);
	}
}

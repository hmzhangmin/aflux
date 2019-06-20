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

package de.tum.in.aflux.dao;
import java.util.List;

/**
 * Tool Mongo Repository interface 
 * @author Tanmaya Mahapatra
 */
import org.springframework.data.mongodb.repository.MongoRepository;

import de.tum.in.aflux.model.FlowElementType;
import de.tum.in.aflux.tools.core.ToolImplementationType;

public interface FlowElementTypeRepository extends MongoRepository<FlowElementType, String>{
	public FlowElementType findByName(String name);

	public FlowElementType findByClassName(String className);
	
	public FlowElementType findByJarLocationAndJarNameAndClassName(String jarLocation,String jarName,String className);
	
	public List<FlowElementType> findByType(ToolImplementationType type);

	public List<FlowElementType> findByJobName(String jobName);
}

/*
 * aFlux: JVM based IoT Mashup Tool
 * Copyright 2019 Tanmaya Mahapatra
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.tum.in.aflux.service;

import java.util.List;

import org.springframework.stereotype.Component;

import de.tum.in.aflux.flux_engine.impl.FluxError;


/**
 * Services related with activities
 * @author Tanmaya Mahapatra
 *
 */
@Component
public class FluxActivityService {
	
	
	/**
	 * Get Flux Activity from Database
	 * 
	 * TODO: Get actually the connectors and elements based on activity name
	 * 
	 * @param name
	 * @return
	 */
	/*
	public FlowActivity load(String name) {
		
		Example<FlowActivity> example = Example.of(new FlowActivity(null,name));
		FlowActivity activity=repository.findOne(example);
		return activity;
	}
	*/
	
	public List<FluxError> validate() {
		return null;
	}
	
	public void compile() {
		
	}

	
	
}

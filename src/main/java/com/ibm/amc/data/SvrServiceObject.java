/**
 * Copyright 2014 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package com.ibm.amc.data;

import com.ibm.amc.Constants;
import com.ibm.amc.ras.Logger47;
import com.ibm.amc.resources.data.HasRest;
import com.ibm.amc.resources.data.ServiceObject;

public abstract class SvrServiceObject implements HasRest
{
	// @CLASS-COPYRIGHT@
	
	static Logger47 logger = Logger47.get(SvrServiceObject.class.getCanonicalName(), Constants.CWZBA_BUNDLE_NAME);
	
	@Override
	public ServiceObject toRest()
	{
		if (logger.isEntryEnabled()) logger.entry("toRest");
		ServiceObject result = new ServiceObject();
	
		result.id = this.getPrimaryKey();
		result.name = this.getName();
		result.type = this.getType();
		
		if (logger.isEntryEnabled()) logger.exit("toRest", result);
		return result;
	}

	public abstract String getPrimaryKey();
	public abstract String getName();
	public abstract String getType();


}

/* Copyright 2016 Sven van der Meer <vdmeer.sven@mykolab.com>
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

package de.vandermeer.skb.interfaces.categories.has;

import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.skb.interfaces.categories.CategoryHas;

/**
 * Interface for objects that have special log methods.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.2 build 170502 (02-May-17) for Java 1.8
 * @since      v0.0.1
 */
public interface HasToLog extends CategoryHas {

	StrBuilder toLog();

	/**
	 * Returns a builder using containment class, contained class, and values.
	 * @param container the contain object class
	 * @param contained contained object class
	 * @param values values, printed comma separated
	 * @return an `StrBuilder` combining the inputs
	 */
	static StrBuilder toLog(Class<?> container, Class<?> contained, Object... values){
		StrBuilder ret = new StrBuilder(50)
				.append(container.getSimpleName())
				.append('(')
				.append(contained.getSimpleName())
				.append(')')
				.append(": ")
				.appendWithSeparators(values, ", ");
			;
		return ret;
	}

	/**
	 * Returns a builder using containment class, default contained class, and values.
	 * @param container the contain object class
	 * @param values values, printed comma separated
	 * @return an `StrBuilder` combining the inputs
	 */
	static StrBuilder toLog(Class<?> container, Object... values){
		StrBuilder ret = new StrBuilder(50)
				.append(container.getSimpleName())
				.append('(')
				.append("DefaultImpl")
				.append(')')
				.append(": ")
				.appendWithSeparators(values, ", ");
			;
		return ret;
	}
}

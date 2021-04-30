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

package de.vandermeer.skb.interfaces.strategies.collections.set;

import java.util.Collection;
import java.util.HashSet;

import de.vandermeer.skb.interfaces.strategies.collections.IsSetStrategy;

/**
 * Strategy for a hash set.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.2 build 170502 (02-May-17) for Java 1.8
 * @since      v0.0.1
 */
public interface HashSetStrategy<T> extends IsSetStrategy<HashSet<T>, T> {

	@Override
	default HashSet<T> get(Collection<T> collection) {
		if(collection==null){
			return new HashSet<T>();
		}
		return new HashSet<T>(collection);
	}

	@Override
	default HashSet<T> get(){
		return new HashSet<T>();
	}

	/**
	 * Creates a new hash set strategy.
	 * @param <T> type for the objects in the set
	 * @return new hash set strategy
	 */
	static <T> HashSetStrategy<T> create(){
		return new HashSetStrategy<T>(){};
	}
}
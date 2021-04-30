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

package de.vandermeer.skb.interfaces.strategies.maps.hashtable;

import de.vandermeer.skb.interfaces.strategies.maps.IsHashtableStrategy;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

/**
 * Strategy for property map.
 *
 * @author Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version v0.0.2 build 170502 (02-May-17) for Java 1.8
 * @since v0.0.1
 */
public interface PropertiesStrategy extends IsHashtableStrategy<Object, Object> {

    /**
     * Creates a property map strategy.
     *
     * @return property map strategy
     */
    static PropertiesStrategy create() {
        return new PropertiesStrategy() {
        };
    }

    @Override
    default Hashtable<Object, Object> get() {
        return new Properties();
    }

    @Override
    default Hashtable<Object, Object> get(Map<Object, Object> map) {
        throw new NotImplementedException("cannot implement get(map) on properties w map as argument, see interface for alternative");
    }

    /**
     * Returns a new property object initialized with default properties.
     *
     * @param prop default properties
     * @return new property object
     */
    default Properties get(Properties prop) {
        return new Properties(prop);
    }
}

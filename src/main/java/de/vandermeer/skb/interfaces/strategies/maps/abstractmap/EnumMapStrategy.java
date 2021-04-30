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

package de.vandermeer.skb.interfaces.strategies.maps.abstractmap;

import de.vandermeer.skb.interfaces.strategies.maps.IsAbstractMapStrategy;
import org.apache.commons.lang3.NotImplementedException;

import java.util.EnumMap;
import java.util.Map;

/**
 * Strategy for an enum map.
 *
 * @author Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version v0.0.2 build 170502 (02-May-17) for Java 1.8
 * @since v0.0.1
 */
public interface EnumMapStrategy<K extends Enum<K>, V> extends IsAbstractMapStrategy<K, V> {

    /**
     * Creates a new hash map strategy.
     *
     * @param <K> type of the keys in the map
     * @param <V> type of the values in the map
     * @return hash map strategy
     */
    static <K extends Enum<K>, V> EnumMapStrategy<K, V> create() {
        return new EnumMapStrategy<K, V>() {
        };
    }

    @Override
    default EnumMap<K, V> get() {
        throw new NotImplementedException("cannot implement get() on enum map w/o enum key, see interface for alternative");
    }

    @Override
    default EnumMap<K, V> get(Map<K, V> map) {
        return new EnumMap<>(map);
    }

    /**
     * Returns a new enum map for given key type.
     *
     * @param keyType key type
     * @return new enum map
     */
    default EnumMap<K, V> get(Class<K> keyType) {
        return new EnumMap<>(keyType);
    }
}

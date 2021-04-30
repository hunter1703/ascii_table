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

package de.vandermeer.skb.interfaces.transformers;

import org.apache.commons.lang3.text.StrBuilder;

/**
 * Converts an {@link StrBuilder} to a string.
 * This transformer is useful to transform a cluster of {@link StrBuilder} to a cluster of strings.
 *
 * @author Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version v0.0.2 build 170502 (02-May-17) for Java 1.8
 * @since v0.0.1
 */
public interface StrBuilder_To_String extends IsTransformer<StrBuilder, String> {

    /**
     * Creates a transformer that takes an {@link StrBuilder} and returns a string.
     *
     * @return new transformer
     */
    static StrBuilder_To_String create() {
        return new StrBuilder_To_String() {
        };
    }

    @Override
    default String transform(StrBuilder sb) {
        if (sb == null) {
            return "";
        }
        return sb.toString();
    }

}

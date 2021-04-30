/* Copyright 2017 Sven van der Meer <vdmeer.sven@mykolab.com>
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

package de.vandermeer.skb.interfaces.transformers.textformat;

/**
 * Options for text alignment.
 *
 * @author Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version v0.0.2 build 170502 (02-May-17) for Java 1.8
 * @since v0.0.1
 */
public enum TextAlignment {

    /**
     * Option for a justified alignment.
     */
    JUSTIFIED(Text_To_FormattedText.ALIGN_JUSTIFIED),

    /**
     * Option for a justified alignment, last line right aligned.
     */
    JUSTIFIED_RIGHT(Text_To_FormattedText.ALIGN_JUSTIFIED_RIGHT),

    /**
     * Option for a justified alignment, last line left left aligned.
     */
    JUSTIFIED_LEFT(Text_To_FormattedText.ALIGN_JUSTIFIED_LEFT),

    /**
     * Option for paragraph alignment left.
     */
    LEFT(Text_To_FormattedText.ALIGN_LEFT),

    /**
     * Option for paragraph alignment center.
     */
    CENTER(Text_To_FormattedText.ALIGN_CENTER),

    /**
     * Option for paragraph alignment right.
     */
    RIGHT(Text_To_FormattedText.ALIGN_RIGHT),
    ;

    /**
     * A mapping to the alignment options in {@link Text_To_FormattedText}.
     */
    protected int mapping;

    /**
     * Creates a new alignment.
     *
     * @param mapping mapping to transformer options
     */
    TextAlignment(int mapping) {
        this.mapping = mapping;
    }

    /**
     * Returns a mapping to the alignment options defined in {@link Text_To_FormattedText}.
     *
     * @return mapping
     */
    public int getMapping() {
        return this.mapping;
    }

}

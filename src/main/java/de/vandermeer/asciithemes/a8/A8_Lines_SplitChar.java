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

package de.vandermeer.asciithemes.a8;

import de.vandermeer.asciithemes.TA_Line_Char;
import de.vandermeer.asciithemes.TA_Line_SplitChar;

/**
 * Collection of {@link TA_Line_Char} for extended ASCII characters.
 *
 * @author Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version v0.0.1 build 170404 (04-Apr-17) for Java 1.8
 * @since v0.0.1
 */
public abstract class A8_Lines_SplitChar {

    /**
     * A split line using left `»` and right '«'.
     * <p>
     * ----
     * »»»»»«««««
     * ----
     *
     * @return the line
     */
    public static TA_Line_SplitChar daq() {
        return TA_Line_SplitChar.create('»', '«', "split line using left `»` and right '«'");
    }

    /**
     * A split line using left `«` and right '»'.
     * <p>
     * ----
     * «««««»»»»»
     * ----
     *
     * @return the line
     */
    public static TA_Line_SplitChar daqRev() {
        return TA_Line_SplitChar.create('«', '»', "split line using left `«` and right '»'");
    }

    /**
     * A split line using left `›` and right '‹'.
     * <p>
     * ----
     * ›››››‹‹‹‹‹
     * ----
     *
     * @return the line
     */
    public static TA_Line_SplitChar paqm() {
        return TA_Line_SplitChar.create('›', '‹', "split line using left `›` and right '‹'");
    }

    /**
     * A split line using left `‹` and right '›'.
     * <p>
     * ----
     * ‹‹‹‹‹›››››
     * ----
     *
     * @return the line
     */
    public static TA_Line_SplitChar paqmRev() {
        return TA_Line_SplitChar.create('‹', '›', "split line using left `‹` and right '›'");
    }

}

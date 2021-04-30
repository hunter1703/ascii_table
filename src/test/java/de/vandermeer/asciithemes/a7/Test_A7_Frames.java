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

package de.vandermeer.asciithemes.a7;

import de.vandermeer.asciithemes.TA_Frame;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Test {@link A7_Frames}.
 *
 * @author Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version v0.0.1 build 170404 (04-Apr-17) for Java 1.8
 * @since v0.0.1
 */
public class Test_A7_Frames {

    @Test
    public void test_Doc() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        for (Method m : A7_Frames.class.getMethods()) {
            if (m.getReturnType() == TA_Frame.class) {
                Object descr = ((TA_Frame) m.invoke("")).getDescription();
                StrBuilder doc = ((TA_Frame) m.invoke("")).toDoc();
                System.out.println(m.getName() + " = " + descr);
                System.out.println();
                System.out.println("----");
                System.out.println(doc);
                System.out.println("----");
                System.out.println();
                System.out.println();
            }
        }
    }
}

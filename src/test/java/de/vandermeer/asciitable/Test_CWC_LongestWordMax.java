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

package de.vandermeer.asciitable;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

/**
 * Tests for {@link CWC_LongestWordMax}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.3.2 build 170502 (02-May-17) for Java 1.8
 * @since      v0.0.3
 */
public class Test_CWC_LongestWordMax {

	@Test
	public void test_CodeForDoc(){
		AsciiTable at;
		int[] cols;
		CWC_LongestWordMax cwc;


		at = new AsciiTable();
		at.addRow("first", "information");
		at.addRow("second", "info");
		at.setPaddingLeftRight(1);
		cwc = new CWC_LongestWordMax(10);
		cols = cwc.calculateColumnWidths(at.getRawContent(), at.getColNumber(), at.getContext());
		assertEquals(2, cols.length);
		assertEquals(8, cols[0]);		// longest word: second (6) plus padding
		assertEquals(10, cols[1]);		// longest word: information (11) plus padding but max col is 10
		System.out.println(ArrayUtils.toString(cols));


		at = new AsciiTable();
		at.addRow("first", "information");
		at.addRow("second", "info");
		at.setPaddingLeftRight(1);
		cwc = new CWC_LongestWordMax(new int[]{5,-1});
		cols = cwc.calculateColumnWidths(at.getRawContent(), at.getColNumber(), at.getContext());
		assertEquals(2, cols.length);
		assertEquals(5, cols[0]);		// longest word: second (6) plus padding but max col is 5
		assertEquals(13, cols[1]);		// longest word: information (11) plus padding
		System.out.println(ArrayUtils.toString(cols));
	}
}

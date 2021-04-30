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

package de.vandermeer.translation.combinations;

import de.vandermeer.skb.interfaces.translators.CombinedTranslator;

/**
 * Combined translator translating from text to LaTeX.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.2 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.1
 */
public class Text2Latex implements CombinedTranslator {

	@Override
	public String translateCharacters(String input) {
		return new de.vandermeer.translation.characters.Text2Latex().translateCharacters(input);
	}

	@Override
	public String text2tmp(String input) {
		return new de.vandermeer.translation.helements.Text2Latex().text2tmp(input);
	}

	@Override
	public String tmp2target(String input) {
		return new de.vandermeer.translation.helements.Text2Latex().tmp2target(input);
	}

	@Override
	public String translate(String input) {
		String ret = this.text2tmp(input);
		ret = this.translateCharacters(ret);
		ret = this.tmp2target(ret);
		return ret;
	}

	@Override
	public String translateHtmlElements(String input) {
		return new de.vandermeer.translation.helements.Text2Latex().translateHtmlElements(input);
	}

}

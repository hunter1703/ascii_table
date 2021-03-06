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

package de.vandermeer.asciilist;

import de.vandermeer.asciithemes.TA_Frame;
import de.vandermeer.skb.interfaces.document.IsListContext;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import de.vandermeer.skb.interfaces.translators.CharacterTranslator;
import de.vandermeer.skb.interfaces.translators.HtmlElementTranslator;
import de.vandermeer.skb.interfaces.translators.TargetTranslator;
import org.apache.commons.lang3.text.StrBuilder;

/**
 * Context for an {@link AsciiList}.
 *
 * @author Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version v0.0.5 build 170502 (02-May-17) for Java 1.8
 * @since v0.1.0
 */
public interface AsciiListContext extends IsListContext {

    /**
     * Copies all settings from the given object.
     *
     * @param ctx the object to copy settings from
     * @return this to allow chaining
     */
    AsciiListContext copySettings(AsciiListContext ctx);

    /**
     * Returns the set alignment.
     *
     * @return paragraph alignment
     */
    TextAlignment getAlignment();

    /**
     * Sets the paragraph alignment.
     *
     * @param alignment set alignment
     * @return this to allow chaining
     * @throws NullPointerException if the argument was null
     */
    AsciiListContext setAlignment(TextAlignment alignment);

    /**
     * Returns a calculated item label string, item label plus all margins and indentations.
     * Calculated means that the returned item string is using default values.
     * The return can be used to calculate nested indentations, but not as an actual item string.
     * To get an actual item string, use {@link #getItemString(AsciiListItem, int)}.
     *
     * @return calculated item label string
     */
    default StrBuilder getCalculatedItemString() {
        return this.getItemString(null, 0);
    }

    /**
     * Returns the character translator
     *
     * @return character translator
     */
    CharacterTranslator getCharTranslator();

    /**
     * Sets the character translator.
     * It will also remove any other translator set.
     * Nothing will happen if the argument is null.
     *
     * @param charTranslator translator
     * @return this to allow chaining
     */
    AsciiListContext setCharTranslator(CharacterTranslator charTranslator);

    /**
     * Returns the paragraph frame.
     *
     * @return frame, null if not set
     */
    TA_Frame getFrame();

    /**
     * Sets the paragraph frame.
     *
     * @param frame new frame, null to reset
     * @return this to allow chaining
     */
    AsciiListContext setFrame(TA_Frame frame);

    /**
     * Returns the set frame mode.
     *
     * @return frame mode
     */
    int getFrameMode();

    /**
     * Sets the frame mode.
     *
     * @param frameMode new frame mode, only used if 0 or positive integer
     * @return this to allow chaining
     */
    AsciiListContext setFrameMode(int frameMode);

    /**
     * Returns the HTML entity translator.
     *
     * @return HTML entity
     */
    HtmlElementTranslator getHtmlElementTranslator();

    /**
     * Sets the HTML entity translator.
     * It will also remove any other translator set.
     * Nothing will happen if the argument is null.
     *
     * @param htmlElementTranslator translator
     * @return this to allow chaining
     */
    AsciiListContext setHtmlElementTranslator(HtmlElementTranslator htmlElementTranslator);

    /**
     * Returns the item margin character.
     *
     * @return item margin character
     */
    Character getItemChar();

    /**
     * Sets the item margin character.
     *
     * @param c new item margin character, ignored if null
     * @return this to allow chaining
     */
    AsciiListContext setItemChar(Character c);

    /**
     * Returns the item margin.
     *
     * @return item margin
     */
    int getItemMargin();

    /**
     * Sets the item margin.
     *
     * @param margin new item margin, ignored if negative
     * @return this to allow chaining
     */
    AsciiListContext setItemMargin(int margin);

    /**
     * Returns the item label string, item label plus all margins and indentations.
     *
     * @param item  the list item for which the string should be returned, can be null to use default settings
     * @param index the index of the label in the item list, can be null to use default settings
     * @param <LI>  list item type
     * @return item label string, default if no item is provided
     */
    <LI extends AsciiListItem> StrBuilder getItemString(LI item, int index);

    /**
     * Returns the left label margin character.
     *
     * @return left label margin character
     */
    Character getLabelLeftChar();

    /**
     * Sets the left label margin character.
     *
     * @param c new left label margin character, ignored if null
     * @return this to allow chaining
     */
    AsciiListContext setLabelLeftChar(Character c);

    /**
     * Returns the left label margin.
     *
     * @return left label margin
     */
    int getLabelLeftMargin();

    /**
     * Sets the left label margin.
     *
     * @param margin new left label margin, ignored if negative
     * @return this to allow chaining
     */
    AsciiListContext setLabelLeftMargin(int margin);

    /**
     * Returns the right label margin character.
     *
     * @return right label margin character
     */
    Character getLabelRightChar();

    /**
     * Sets the right label margin character.
     *
     * @param c new right label margin character, ignored if null
     * @return this to allow chaining
     */
    AsciiListContext setLabelRightChar(Character c);

    /**
     * Returns the right label margin.
     *
     * @return right label margin
     */
    int getLabelRightMargin();

    /**
     * Sets the right label margin.
     *
     * @param margin new right label margin, ignored if negative
     * @return this to allow chaining
     */
    AsciiListContext setLabelRightMargin(int margin);

    /**
     * Returns the left label string.
     *
     * @return left label string, null if not set
     */
    String getLeftLabelString();

    /**
     * Sets the left label string.
     *
     * @param leftLabel left label string, null is ok
     * @return this to allow chaining
     */
    AsciiListContext setLeftLabelString(String leftLabel);

    /**
     * Returns the level of the list.
     *
     * @return list level, one if top list, greater than one if it is a nested list
     */
    int getLevel();

    /**
     * Sets the level of the list.
     *
     * @param level new list level, should only be used if 2 or larger (nested list) using 1 as default
     * @return self to allow chaining
     */
    AsciiListContext setLevel(int level);

    /**
     * Returns the list end string
     *
     * @return list end string
     */
    String getListEnd();

    /**
     * Sets the list end string
     *
     * @param listEnd new list end string, null and blank are ok
     * @return this to allow chaining
     */
    AsciiListContext setListEnd(String listEnd);

    /**
     * Returns the list start string
     *
     * @return list start string
     */
    String getListStart();

    /**
     * Sets the list start string
     *
     * @param listStart new list start string, null and blank are ok
     * @return this to allow chaining
     */
    AsciiListContext setListStart(String listStart);

    /**
     * Returns the parent index array.
     *
     * @return parent index array
     */
    int[] getParentIndex();

    /**
     * Returns the right label string.
     *
     * @return right label string, null if not set
     */
    String getRightLabelString();

    /**
     * Sets the right label string.
     *
     * @param rightLabel right label string, null is ok
     * @return this to allow chaining
     */
    AsciiListContext setRightLabelString(String rightLabel);

    /**
     * Returns the target translator.
     *
     * @return target translator, null if not set
     */
    TargetTranslator getTargetTranslator();

    /**
     * Sets the target translator.
     * It will also remove any other translator set.
     * Nothing will happen if the argument is null.
     *
     * @param targetTranslator translator
     * @return this to allow chaining
     */
    AsciiListContext setTargetTranslator(TargetTranslator targetTranslator);

    /**
     * Returns the left text margin character.
     *
     * @return left text margin character
     */
    Character getTextLeftChar();

    /**
     * Sets the left text margin character.
     *
     * @param c new left text margin character, ignored if null
     * @return this to allow chaining
     */
    AsciiListContext setTextLeftChar(Character c);

    /**
     * Returns the left text margin.
     *
     * @return left text margin
     */
    int getTextLeftMargin();

    /**
     * Sets the left text margin.
     *
     * @param margin new left text margin, ignored if negative
     * @return this to allow chaining
     */
    AsciiListContext setTextLeftMargin(int margin);

    /**
     * Returns the right text margin character.
     *
     * @return right text margin character
     */
    Character getTextRightChar();

    /**
     * Sets the right text margin character.
     *
     * @param c new right text margin character, ignored if null
     * @return this to allow chaining
     */
    AsciiListContext setTextRightChar(Character c);

    /**
     * Returns the right text margin.
     *
     * @return right text margin
     */
    int getTextRightMargin();

    /**
     * Sets the right text margin.
     *
     * @param margin new right text margin, ignored if negative
     * @return this to allow chaining
     */
    AsciiListContext setTextRightMargin(int margin);

    /**
     * Returns the width of item text calculated using the currently set width.
     *
     * @return text width
     */
    default int getTextWidth() {
        return this.getTextWidth(this.getWidth());
    }

    /**
     * Returns the width of item text calculated for the given width.
     *
     * @param width the maximum width for the list
     * @return text width
     */
    default int getTextWidth(int width) {
        return (width - this.getCalculatedItemString().length());
    }

    /**
     * Returns the paragraph width.
     *
     * @return paragraph width
     */
    int getWidth();

    /**
     * Sets the paragraph width.
     *
     * @param width new width
     * @return this to allow chaining
     * @throws IllegalStateException if the resulting text width was smaller than 3
     */
    AsciiListContext setWidth(int width);

    /**
     * Inherit settings from another context.
     *
     * @param ctx the context to inherit settings from
     * @return self to allow chaining
     */
    AsciiListContext inheritSettings(AsciiListContext ctx);

    /**
     * Sets all converters, margins, characters, indentations, and strings to default values.
     */
    void init();

    /**
     * Sets the parent index array
     *
     * @param parentIndex parent index array
     * @return this to allow chaining
     */
    AsciiListContext setParents(int[] parentIndex);

    /**
     * Returns the current set line separator.
     *
     * @return the line separator, null if none set
     */
    String getLineSeparator();

    /**
     * Sets a new line separator for the renderer.
     *
     * @param separator the new separator, ignored if blank
     * @return self to allow chaining
     */
    AsciiListContext setLineSeparator(String separator);
}

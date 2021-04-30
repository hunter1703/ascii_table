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

package de.vandermeer.skb.interfaces;

/**
 * A pair of things, with a left and a right hand side (or left and right).
 *
 * @author Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version v0.0.2 build 170502 (02-May-17) for Java 1.8
 * @since v0.0.1
 */
public interface SimplePair<LHS, RHS> {

    /**
     * Returns a new Pair of given type with default description.
     *
     * @param <LHS> type for left hand site
     * @param <RHS> type for right hand site
     * @param rhs   right hand side of the pair
     * @param lhs   left hand side of the pair
     * @return new pair
     */
    static <LHS, RHS> SimplePair<LHS, RHS> create(LHS lhs, RHS rhs) {
        return SimplePair.create(lhs, rhs, "abstract Skb_Pair implementation");
    }

    /**
     * Creates a new Pair of given type with given description.
     *
     * @param <LHS>       type for left hand site
     * @param <RHS>       type for right hand site
     * @param rhs         right hand side of the pair
     * @param lhs         left hand side of the pair
     * @param description description of the pair
     * @return new pair
     */
    static <LHS, RHS> SimplePair<LHS, RHS> create(final LHS lhs, final RHS rhs, final String description) {
        return new SimplePair<LHS, RHS>() {
            @Override
            public RHS rhs() {
                return rhs;
            }

            @Override
            public RHS right() {
                return rhs;
            }

            @Override
            public LHS lhs() {
                return lhs;
            }

            @Override
            public LHS left() {
                return lhs;
            }

            @Override
            public String getDescription() {
                return description;
            }
        };
    }

    /**
     * Returns the value of the right hand side of the pair.
     *
     * @return right hand side value
     */
    RHS rhs();

    /**
     * Returns the value of the right hand side of the pair.
     *
     * @return right hand side value
     */
    RHS right();

    /**
     * Returns the value of the left hand side of the pair.
     *
     * @return left had side value
     */
    LHS lhs();

    /**
     * Returns the value of the left hand side of the pair.
     *
     * @return left had side value
     */
    LHS left();

    /**
     * Returns the description of an object.
     *
     * @return description
     */
    String getDescription();

}

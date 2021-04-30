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

package de.vandermeer.skb.interfaces.strategies.collections.queue;

import java.util.Collection;
import java.util.concurrent.LinkedTransferQueue;

import de.vandermeer.skb.interfaces.strategies.collections.IsQueueStrategy;

/**
 * Strategy for a linked transfer queue.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.2 build 170502 (02-May-17) for Java 1.8
 * @since      v0.0.1
 */
public interface LinkedTransferQueueStrategy<T> extends IsQueueStrategy<LinkedTransferQueue<T>, T> {

	@Override
	default LinkedTransferQueue<T> get(Collection<T> collection) {
		LinkedTransferQueue<T> ret = new LinkedTransferQueue<T>();
		if(collection!=null){
			ret.addAll(collection);
		}
		return ret;
	}

	@Override
	default LinkedTransferQueue<T> get() {
		return new LinkedTransferQueue<T>();
	}

	/**
	 * Creates a new linked transfer queue strategy.
	 * @param <T> type for the objects in the queue
	 * @return new linked transfer queue strategy
	 */
	static <T> LinkedTransferQueueStrategy<T> create(){
		return new LinkedTransferQueueStrategy<T>(){};
	}
}

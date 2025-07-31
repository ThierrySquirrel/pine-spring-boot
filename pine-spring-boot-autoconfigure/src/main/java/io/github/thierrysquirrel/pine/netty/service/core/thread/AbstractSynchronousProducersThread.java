/**
 * Copyright 2019 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.thierrysquirrel.pine.netty.service.core.thread;

import io.github.thierrysquirrel.pine.common.netty.domain.PineRequestContext;
import lombok.Data;


/**
 * ClassName: SynchronousProducers
 * Description:
 * date: 2019/10/18 19:57
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Data
public abstract class AbstractSynchronousProducersThread implements Runnable {
    private String url;
    private PineRequestContext synchronousProducers;

    protected AbstractSynchronousProducersThread(String url, PineRequestContext synchronousProducers) {
        this.url = url;
        this.synchronousProducers = synchronousProducers;
    }

    /**
     * synchronousProducers
     * @param url url
     * @param synchronousProducers PineRequestContext
     */
    protected abstract void synchronousProducers(String url, PineRequestContext synchronousProducers);

    @Override
    public void run() {
        synchronousProducers (this.url, this.synchronousProducers);
    }
}

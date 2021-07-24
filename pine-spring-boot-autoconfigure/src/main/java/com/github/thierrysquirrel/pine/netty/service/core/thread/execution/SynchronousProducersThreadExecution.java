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

package com.github.thierrysquirrel.pine.netty.service.core.thread.execution;

import com.github.thierrysquirrel.pine.netty.core.client.factory.ClientFactory;
import com.github.thierrysquirrel.pine.netty.domain.PineRequestContext;
import com.github.thierrysquirrel.pine.netty.service.core.thread.AbstractSynchronousProducersThread;
import lombok.extern.slf4j.Slf4j;


/**
 * ClassName: SynchronousProducersThreadExecution
 * Description:
 * date: 2019/10/18 20:03
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Slf4j
public class SynchronousProducersThreadExecution extends AbstractSynchronousProducersThread {
    public SynchronousProducersThreadExecution(String url, PineRequestContext synchronousProducers) {
        super (url, synchronousProducers);
    }

    @Override
    protected void synchronousProducers(String url, PineRequestContext synchronousProducers) {
        try {
            ClientFactory.request (url, synchronousProducers);
        } catch (Exception e) {
            log.error ("SynchronousProducers Error", e);
        }
    }
}

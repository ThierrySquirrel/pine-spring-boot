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

package io.github.thierrysquirrel.pine.common.netty.core.client.factory;

import io.github.thierrysquirrel.pine.common.netty.core.client.ClientInit;
import io.github.thierrysquirrel.pine.common.netty.core.client.factory.constant.ClientConstant;
import io.github.thierrysquirrel.pine.common.netty.domain.PineRequestContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * ClassName: ClientFactory
 * Description:
 * date: 2025/7/31 13:36
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class ClientClusterFactory {

    public static PineRequestContext request(String clusterUrl, String producerName, PineRequestContext pineRequestContext) throws InterruptedException, TimeoutException, ExecutionException {
        ClientInit clientInit = ClientClusterCacheFactory.getClientInit(clusterUrl,producerName);
        clientInit.init ();
        clientInit.getChannel ().writeAndFlush (pineRequestContext);
        return clientInit.getCompletableFuture ().get (ClientConstant.TIMEOUT.getValue (), TimeUnit.MILLISECONDS);
    }
}

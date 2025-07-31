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
import io.github.thierrysquirrel.pine.common.netty.core.constant.MapSizeConstant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: ClientCacheFactory
 * Description:
 * date: 2019/10/17 19:40
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class ClientCacheFactory {
    private static final ThreadLocal<Map<String, ClientInit>> CLIENT_CACHE = new InheritableThreadLocal<> ();

    private ClientCacheFactory() {
    }

    public static ClientInit getClientInit(String url) {
        Map<String, ClientInit> clientInitMap = CLIENT_CACHE.get ();
        if (null == clientInitMap) {
            clientInitMap = new ConcurrentHashMap<> (MapSizeConstant.DEFAULT_SIZE.getValue ());
            CLIENT_CACHE.set (clientInitMap);
        }
        return clientInitMap.computeIfAbsent (url, key -> new ClientInit (url));
    }

    public static void remove() {
        CLIENT_CACHE.remove ();
    }
}

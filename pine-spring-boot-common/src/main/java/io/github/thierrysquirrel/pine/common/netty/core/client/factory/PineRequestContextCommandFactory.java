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

import io.github.thierrysquirrel.pine.common.netty.domain.PineRequestContext;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.Command;

/**
 * ClassName: PineRequestContextFactory
 * Description:
 * date: 2019/10/18 15:01
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class PineRequestContextCommandFactory {
    private PineRequestContextCommandFactory() {
    }

    public static void buildPing(PineRequestContext pineRequestContext) {
        pineRequestContext.setCommand (Command.PING);
    }

    public static void buildPang(PineRequestContext pineRequestContext) {
        pineRequestContext.setCommand (Command.PANG);
    }

    public static void buildSynchronousProducers(PineRequestContext pineRequestContext) {
        pineRequestContext.setCommand (Command.SYNCHRONOUS_PRODUCERS);
    }

    public static void buildByProducersNameGetUrl(PineRequestContext pineRequestContext) {
        pineRequestContext.setCommand (Command.BY_PRODUCERS_NAME_GET_URL);
    }

    public static void buildRpc(PineRequestContext pineRequestContext) {
        pineRequestContext.setCommand (Command.RPC);
    }
}

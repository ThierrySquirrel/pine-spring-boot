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

package io.github.thierrysquirrel.pine.netty.service.event;

import io.github.thierrysquirrel.pine.annotation.PineServiceEvent;
import io.github.thierrysquirrel.pine.annotation.PineServiceHandler;
import io.github.thierrysquirrel.pine.common.netty.core.client.factory.PineRequestContextFactory;
import io.github.thierrysquirrel.pine.common.netty.domain.PineRequestContext;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.Command;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.Modular;
import io.github.thierrysquirrel.pine.netty.service.core.factory.HeartbeatFactory;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * ClassName: ConsumptionHandler
 * Description:
 * date: 2019/10/18 14:52
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Slf4j
@PineServiceHandler
public class ConsumptionHandler {
    @PineServiceEvent(modular = Modular.CONSUMPTION, command = Command.BY_PRODUCERS_NAME_GET_URL)
    public void byProducersNameGetUrls(ChannelHandlerContext ctx, PineRequestContext msg, String producersName) {
        List<String> clientServiceUrlList = HeartbeatFactory.getClientServiceUrlList (producersName);
        PineRequestContext byProducersNameGetUrls = PineRequestContextFactory.createByProducersNameGetUrlsResponse (clientServiceUrlList);
        ctx.channel ().writeAndFlush (byProducersNameGetUrls);
    }
}

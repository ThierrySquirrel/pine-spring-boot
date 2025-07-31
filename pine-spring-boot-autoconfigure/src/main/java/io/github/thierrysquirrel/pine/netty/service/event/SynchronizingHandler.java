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
import io.github.thierrysquirrel.pine.autoconfigure.PineServiceProperties;
import io.github.thierrysquirrel.pine.common.netty.core.client.factory.PineRequestContextFactory;
import io.github.thierrysquirrel.pine.common.netty.domain.PineRequestContext;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.Command;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.Modular;
import io.github.thierrysquirrel.pine.netty.service.core.factory.HeartbeatFactory;
import io.netty.channel.ChannelHandlerContext;

import javax.annotation.Resource;


/**
 * ClassName: SynchronizingHandler
 * Description:
 * date: 2019/10/18 14:51
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@PineServiceHandler
public class SynchronizingHandler {
	@Resource
	private PineServiceProperties pineServiceProperties;

	@PineServiceEvent(modular = Modular.SYNCHRONIZING, command = Command.SYNCHRONOUS_PRODUCERS)
	public void synchronousProducers(ChannelHandlerContext ctx, PineRequestContext msg, String clientServiceName, String clientServiceUrl) {
		HeartbeatFactory.getClientServicePing(clientServiceName, clientServiceUrl, pineServiceProperties.getMaxNumberHeartbeatTimeouts());
		PineRequestContext synchronousResponse = PineRequestContextFactory.createSynchronousResponse(clientServiceUrl);
		ctx.channel().writeAndFlush(synchronousResponse);
	}
}

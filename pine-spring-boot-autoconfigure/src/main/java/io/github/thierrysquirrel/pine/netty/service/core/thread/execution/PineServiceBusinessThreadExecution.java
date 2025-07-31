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

package io.github.thierrysquirrel.pine.netty.service.core.thread.execution;

import io.github.thierrysquirrel.pine.common.netty.core.factory.ArgsConversionFactory;
import io.github.thierrysquirrel.pine.common.netty.core.factory.execution.EventExecutionContainerFactoryExecution;
import io.github.thierrysquirrel.pine.common.netty.domain.PineRequest;
import io.github.thierrysquirrel.pine.common.netty.domain.PineRequestContext;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.Command;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.Modular;
import io.github.thierrysquirrel.pine.netty.service.core.thread.AbstractPineServiceBusinessThread;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;



/**
 * ClassName: PineServiceBusinessThreadExecution
 * Description:
 * date: 2019/10/18 14:15
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Slf4j
public class PineServiceBusinessThreadExecution extends AbstractPineServiceBusinessThread {

    public PineServiceBusinessThreadExecution(ChannelHandlerContext ctx, PineRequestContext msg) {
        super (ctx, msg);
    }

    @Override
    protected void pineServiceBusinessExecution(ChannelHandlerContext ctx, PineRequestContext msg) {
        Modular modular = msg.getModular ();
        Command command = msg.getCommand ();
        PineRequest pineRequest = msg.getPineRequest ();
        Object[] args;
        if (pineRequest != null) {
            args = ArgsConversionFactory.getArgs (ctx, msg, pineRequest.getParameters ());
        } else {
            args = ArgsConversionFactory.getArgs (ctx, msg);
        }

        try {
            EventExecutionContainerFactoryExecution.execution (modular, command, args);
        } catch (Exception e) {
            log.error ("BusinessThreadExecution Error", e);
        }

    }

}

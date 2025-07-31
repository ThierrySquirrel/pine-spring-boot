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

package io.github.thierrysquirrel.pine.common.netty.coder;

import io.github.thierrysquirrel.pine.common.netty.domain.PineRequestContext;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.CoderConstant;
import io.github.thierrysquirrel.pine.common.netty.utils.SerializerUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * ClassName: PineEncode
 * Description:
 * date: 2019/10/17 17:47
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class PineEncode extends MessageToByteEncoder<PineRequestContext> {

    @Override
    protected void encode(ChannelHandlerContext ctx, PineRequestContext msg, ByteBuf out) throws Exception {
        out.writeBytes (CoderConstant.PINE.getValue ());
        byte[] serialize = SerializerUtils.serialize (msg);
        out.writeInt (serialize.length);
        out.writeBytes (serialize);
    }
}

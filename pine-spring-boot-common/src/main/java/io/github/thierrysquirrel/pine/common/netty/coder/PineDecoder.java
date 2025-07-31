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
import io.github.thierrysquirrel.pine.common.netty.domain.constant.DecoderConstant;
import io.github.thierrysquirrel.pine.common.netty.utils.DecoderUtils;
import io.github.thierrysquirrel.pine.common.netty.utils.SerializerUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * ClassName: PineDecoder
 * Description:
 * date: 2019/10/17 17:41
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class PineDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        while (true) {
            if (in.readableBytes () >= DecoderConstant.MINIMUM_DECODING.getValue ()) {
                int readerIndex = in.readerIndex ();

                if (!DecoderUtils.readPine (in)) {
                    in.readerIndex (readerIndex);
                    return;
                }

                int dataLength = in.readInt ();
                if (in.readableBytes () < dataLength) {
                    in.readerIndex (readerIndex);
                    return;
                }

                byte[] data = new byte[dataLength];
                in.readBytes (data);
                PineRequestContext pineRequestContext1 = SerializerUtils.deSerialize (data, PineRequestContext.class);
                out.add (pineRequestContext1);
            } else {
                break;
            }
        }

    }
}

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

package io.github.thierrysquirrel.pine.common.netty.utils;

import io.github.thierrysquirrel.pine.common.netty.domain.constant.CoderConstant;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.DecoderConstant;
import io.netty.buffer.ByteBuf;

import java.util.Arrays;

/**
 * ClassName: DecoderUtils
 * Description:
 * date: 2019/10/17 18:25
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class DecoderUtils {
	private DecoderUtils() {
	}

	public static boolean readPine(ByteBuf in) {
		boolean readPine = false;
		boolean loop = true;
		in.markReaderIndex ();
		while (loop) {

			byte[] bytes = new byte[4];
			in.readBytes(bytes);

			if (Arrays.equals(CoderConstant.PINE.getValue(), bytes)) {
				readPine = true;
				break;
			}

			in.readByte();

			if (in.readableBytes() < DecoderConstant.MINIMUM_DECODING.getValue()) {
				in.resetReaderIndex();
				loop = false;
			}
		}
		return readPine;
	}
}

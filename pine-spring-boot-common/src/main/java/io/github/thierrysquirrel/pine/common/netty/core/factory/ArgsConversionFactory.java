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

package io.github.thierrysquirrel.pine.common.netty.core.factory;

import io.github.thierrysquirrel.pine.common.netty.domain.PineRequestContext;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: ArgsConversionFactory
 * Description:
 * date: 2019/10/18 14:37
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class ArgsConversionFactory {
    private ArgsConversionFactory() {
    }

    public static Object[] getArgs(ChannelHandlerContext ctx, PineRequestContext msg, Object... object) {
        List<Object> argsList = new ArrayList<> ();
        argsList.add (ctx);
        argsList.add (msg);
        argsList.addAll (Arrays.stream (object).collect (Collectors.toList ()));
        return argsList.toArray ();
    }
}

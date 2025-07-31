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

package io.github.thierrysquirrel.pine.common.netty.core.client.utils;

import io.github.thierrysquirrel.pine.common.netty.core.client.factory.constant.RandomConstant;

import java.util.concurrent.ThreadLocalRandom;

/**
 * ClassName: RandomUtils
 * Description:
 * date: 2019/10/17 19:29
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class RandomUtils {
    private RandomUtils() {
    }

    public static int getRandom() {
        return ThreadLocalRandom.current ().nextInt (RandomConstant.RANDOM_MIN.getValue (), RandomConstant.RANDOM_MAX.getValue ());
    }
}

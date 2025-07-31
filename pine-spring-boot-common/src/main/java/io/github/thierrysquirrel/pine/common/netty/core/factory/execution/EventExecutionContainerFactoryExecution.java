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

package io.github.thierrysquirrel.pine.common.netty.core.factory.execution;

import io.github.thierrysquirrel.pine.common.netty.core.domain.MethodContainer;
import io.github.thierrysquirrel.pine.common.netty.core.factory.EventExecutionContainerFactory;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.Command;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.Modular;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: EventExecutionContainerFactoryExecution
 * Description:
 * date: 2019/10/17 21:18
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class EventExecutionContainerFactoryExecution {
    private EventExecutionContainerFactoryExecution() {
    }

    public static void execution(Modular modular, Command command, Object... args) throws InvocationTargetException, IllegalAccessException {
        MethodContainer methodContainer = EventExecutionContainerFactory.getMethodContainer (modular, command);
        Method method = methodContainer.getMethod ();
        Object object = methodContainer.getObject ();
        method.invoke (object, args);
    }
}

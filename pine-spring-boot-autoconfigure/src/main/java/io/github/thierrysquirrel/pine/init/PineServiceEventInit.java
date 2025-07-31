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

package io.github.thierrysquirrel.pine.init;

import io.github.thierrysquirrel.pine.annotation.PineServiceEvent;
import io.github.thierrysquirrel.pine.annotation.PineServiceHandler;
import io.github.thierrysquirrel.pine.core.utils.AnnotatedMethodsUtils;
import io.github.thierrysquirrel.pine.common.netty.core.domain.MethodContainer;
import io.github.thierrysquirrel.pine.common.netty.core.factory.EventExecutionContainerFactory;
import io.github.thierrysquirrel.pine.common.netty.core.factory.MethodContainerFactory;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.Command;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.Modular;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;

import javax.annotation.PostConstruct;

/**
 * ClassName: PineServiceEventInit
 * Description:
 * date: 2019/10/17 20:51
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Data
public class PineServiceEventInit implements ApplicationContextAware {

    private ApplicationContext applicationContext;


    @PostConstruct
    public void init() {
        applicationContext.getBeansWithAnnotation (PineServiceHandler.class).forEach ((beanName, bean) ->
                AnnotatedMethodsUtils.getMethodAndAnnotation (bean, PineServiceEvent.class).
                        forEach ((method, pineServiceEvent) -> {
                            Modular modular = pineServiceEvent.modular ();
                            Command command = pineServiceEvent.command ();
                            MethodContainer methodContainer = MethodContainerFactory.getMethodContainer (method, bean);
                            EventExecutionContainerFactory.setMethodContainer (modular, command, methodContainer);
                        })
        );
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}

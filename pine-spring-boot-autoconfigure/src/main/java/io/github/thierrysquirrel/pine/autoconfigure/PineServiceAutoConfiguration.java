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

package io.github.thierrysquirrel.pine.autoconfigure;

import io.github.thierrysquirrel.pine.core.constant.ComponentScanConstant;
import io.github.thierrysquirrel.pine.init.PineServiceEventInit;
import io.github.thierrysquirrel.pine.netty.service.init.PineServiceHeartbeatInit;
import io.github.thierrysquirrel.pine.netty.service.init.PineServiceInit;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;


/**
 * ClassName: PineServiceAutoConfiguration
 * Description:
 * date: 2019/10/17 20:40
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Configuration
@EnableConfigurationProperties(PineServiceProperties.class)
@ComponentScan(basePackages = {ComponentScanConstant.DEFAULT_SCAN})
public class PineServiceAutoConfiguration {
    @Resource
    private PineServiceProperties pineServiceProperties;

    @Bean
    @ConditionalOnMissingBean(PineServiceEventInit.class)
    public PineServiceEventInit pineServiceEventInit() {
        return new PineServiceEventInit ();
    }

    @Bean
    @ConditionalOnMissingBean(PineServiceHeartbeatInit.class)
    public PineServiceHeartbeatInit pineServiceHeartbeatInit() {
        return new PineServiceHeartbeatInit (pineServiceProperties);
    }

    @Bean
    @ConditionalOnMissingBean(PineServiceInit.class)
    public PineServiceInit pineServiceInit() {
        return new PineServiceInit (pineServiceProperties);
    }

}

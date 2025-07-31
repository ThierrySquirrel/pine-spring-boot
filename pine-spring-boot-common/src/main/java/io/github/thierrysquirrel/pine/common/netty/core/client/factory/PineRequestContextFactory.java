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

package io.github.thierrysquirrel.pine.common.netty.core.client.factory;

import io.github.thierrysquirrel.pine.common.netty.domain.PineRequest;
import io.github.thierrysquirrel.pine.common.netty.domain.PineRequestContext;
import io.github.thierrysquirrel.pine.common.netty.domain.PineResponse;

import java.util.List;

/**
 * ClassName: PineRequestContextFactory
 * Description:
 * date: 2019/10/18 15:05
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class PineRequestContextFactory {
	private PineRequestContextFactory() {
	}

	private static PineRequestContext getPineRequestContext() {
		return new PineRequestContext();
	}

	public static PineRequestContext createPingPineRequestContext(String clientServiceName, String clientServiceUrl) {
		PineRequestContext pineRequestContext = getPineRequestContext();
		PineRequestContextModularFactory.buildHeartbeat(pineRequestContext);
		PineRequestContextCommandFactory.buildPing(pineRequestContext);
		PineRequest pineRequest = PineRequestFactory.buildPinePineRequest(clientServiceName, clientServiceUrl);
		pineRequestContext.setPineRequest(pineRequest);
		return pineRequestContext;
	}

	public static PineRequestContext createPangPineRequestContext() {
		PineRequestContext pineRequestContext = getPineRequestContext();
		PineRequestContextModularFactory.buildHeartbeat(pineRequestContext);
		PineRequestContextCommandFactory.buildPang(pineRequestContext);
		return pineRequestContext;
	}

	public static PineRequestContext createSynchronousProducers(String clientServiceName, String clientServiceUrl) {
		PineRequestContext pineRequestContext = getPineRequestContext();
		PineRequestContextModularFactory.buildSynchronizing(pineRequestContext);
		PineRequestContextCommandFactory.buildSynchronousProducers(pineRequestContext);
		PineRequest pineRequest = PineRequestFactory.buildSynchronousProducersPineRequest(clientServiceName, clientServiceUrl);
		pineRequestContext.setPineRequest(pineRequest);
		return pineRequestContext;
	}

	public static PineRequestContext createByProducersNameGetUrlsResponse(List<String> byProducersNameGetUrls) {
		PineRequestContext pineRequestContext = getPineRequestContext();
		PineResponse pineResponse = PineResponseFactory.buildByProducersNameGetUrls(byProducersNameGetUrls);
		pineRequestContext.setPineResponse(pineResponse);
		return pineRequestContext;
	}

	public static PineRequestContext createByProducersNameGetUrlsRequest(String producersName) {
		PineRequestContext pineRequestContext = getPineRequestContext();
		PineRequestContextModularFactory.buildConsumption(pineRequestContext);
		PineRequestContextCommandFactory.buildByProducersNameGetUrl(pineRequestContext);
		PineRequest pineRequest = PineRequestFactory.buildByProducersNameGetUrls(producersName);
		pineRequestContext.setPineRequest(pineRequest);
		return pineRequestContext;
	}

	public static PineRequestContext createRpcRequest(String coordinate, Object[] args) {
		PineRequestContext pineRequestContext = getPineRequestContext();
		PineRequestContextModularFactory.buildConsumption(pineRequestContext);
		PineRequestContextCommandFactory.buildRpc(pineRequestContext);
		PineRequest pineRequest = PineRequestFactory.buildRpc(coordinate, args);
		pineRequestContext.setPineRequest(pineRequest);
		return pineRequestContext;
	}

	public static PineRequestContext createRpcResponse(Object object) {
		PineRequestContext pineRequestContext = getPineRequestContext();
		PineResponse pineResponse = PineResponseFactory.buildRpc(object);
		pineRequestContext.setPineResponse(pineResponse);
		return pineRequestContext;
	}

	public static PineRequestContext createSynchronousResponse(String clientServiceUrl) {
		PineRequestContext pineRequestContext = getPineRequestContext();
		PineResponse pineResponse = PineResponseFactory.buildSynchronous(clientServiceUrl);
		pineRequestContext.setPineResponse(pineResponse);
		return pineRequestContext;
	}

}

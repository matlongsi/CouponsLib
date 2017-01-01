package com.coupon.security;
/*
import java.util.Collections;
import java.util.List;






import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseFilter;

import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.ContainerResponse;

import com.coupon.security.CacheAnnotations.CacheMaxAge;


public class CacheFilterFactory /*implements ResourceFilterFactory *//*{
/*
	@Override
	public List<ResourceFilter> create(AbstractMethod am) {
		if (am.isAnnotationPresent(CacheMaxAge.class)) {
			CacheMaxAge maxAge = am.getAnnotation(CacheMaxAge.class);
			return newCacheFilter("max-age= " + maxAge.unit().toSeconds(maxAge.time()));
		} else if (am.isAnnotationPresent(NoCache.class)) {
			return newCacheFilter("no-cache");
		} else {
			return Collections.emptyList();
		}
	}

	private List<ResourceFilter> newCacheFilter(String content) {
		return Collections
		        .<ResourceFilter> singletonList(new CacheResponseFilter(content));
	}

	private static class CacheResponseFilter implements ResourceFilter, ContainerResponseFilter {
		private final String headerValue;

		CacheResponseFilter(String headerValue) {
			this.headerValue = headerValue;
		}

		@Override
		public ContainerRequestFilter getRequestFilter() {
			return null;
		}

		@Override
		public ContainerResponseFilter getResponseFilter() {
			return this;
		}

		@Override
		public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
			response.getHttpHeaders().putSingle(HttpHeaders.CACHE_CONTROL, headerValue);
			return response;
		}
	}
*//*
}
*/
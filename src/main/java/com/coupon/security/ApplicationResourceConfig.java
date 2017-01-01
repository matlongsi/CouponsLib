package com.coupon.security;
/*
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.validation.ParameterNameProvider;
import javax.validation.Validation;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.ContextResolver;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.glassfish.jersey.server.validation.ValidationConfig;
import org.glassfish.jersey.server.validation.internal.InjectingConstraintValidatorFactory;

import com.coupon.resource.GlobalLocationNumberResource;
import com.coupon.resource.GlobalServiceRelationNumberResource;


@ApplicationPath("/")
public class ApplicationResourceConfig extends ResourceConfig {

	public ApplicationResourceConfig() {
		
		super();
		register(RolesAllowedDynamicFeature.class);

		this.register(GlobalServiceRelationNumberResource.class);		//TODO currently works without registration, why?
		
/*		//resources
        packages(GlobalLocationNumberResource.class.getPackage().getName());

        //validation
        register(ValidationConfigurationContextResolver.class);
*//*	}


	public static class ValidationConfigurationContextResolver implements ContextResolver<ValidationConfig> {
	
	    @Context
	    private ResourceContext resourceContext;
	
	    @Override
	    public ValidationConfig getContext(final Class<?> type) {
	        return new ValidationConfig()
	                .constraintValidatorFactory(resourceContext.getResource(InjectingConstraintValidatorFactory.class))
	                .parameterNameProvider(new CustomParameterNameProvider());
	    }
	
	    private class CustomParameterNameProvider implements ParameterNameProvider {
	
	        private final ParameterNameProvider nameProvider;
	
	        public CustomParameterNameProvider() {
	            nameProvider = Validation.byDefaultProvider().configure().getDefaultParameterNameProvider();
	        }
	
	        @Override
	        public List<String> getParameterNames(final Constructor<?> constructor) {
	            return nameProvider.getParameterNames(constructor);
	        }
	
	        @Override
	        public List<String> getParameterNames(final Method method) {
	            // See ContactCardTest#testAddInvalidContact.
	            if ("addContact".equals(method.getName())) {
	                return Arrays.asList("contact");
	            }
	            return nameProvider.getParameterNames(method);
	        }
	    }
	}


}
*/
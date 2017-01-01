package com.coupon.security;
/*
import java.security.Principal;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public class CouponSecurityContext implements SecurityContext {

    public CouponSecurityContext() {
    }
 
    @Override
    public String getAuthenticationScheme() {
        return SecurityContext.CLIENT_CERT_AUTH;
    }
 
    @Override
    public Principal getUserPrincipal() {
        return null;//user;
    }
 
    @Override
    public boolean isSecure() {
        return false;
    }
 
    @Override
    public boolean isUserInRole(String role) {
 
/*        if (null == session || !session.isActive()) {
            // Forbidden
            Response denied = Response.status(Response.Status.FORBIDDEN).entity("Permission Denied").build();
            throw new WebApplicationException(denied);
        }
 
        try {
            // this user has this role?
            return user.getRoles().contains(User.Role.valueOf(role));
        } catch (Exception e) {
        }
*//*
    	if (role.equals("user")) {
    		return true;
    	}
    	
    	return false;
    }

}
*/
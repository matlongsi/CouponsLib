package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.ProductCategoryBean;
import com.coupon.common.init.ProductCategoryInit;


/**
 * Bean abstract class for OfferProductCategory
 */
@XmlDiscriminatorNode("@type")
@XmlSeeAlso({ProductCategoryBean.class})
public abstract class ProductCategory implements Serializable, Comparable<ProductCategory>, ProductCategoryInit {

	private static final long serialVersionUID = 4478623508548466100L;

	public static final int MAX_NAME_LENGTH = 80;

	public abstract String getCategoryName();
	public abstract void setCategoryName(String categoryName);

    /**
     * Default constructor. 
     */
    public ProductCategory() {
    }

    @Override public boolean equals(Object obj) {
	
	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !ProductCategory.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	ProductCategory pc = ProductCategory.class.cast(obj);
	    	
	    	return ((getCategoryName() == null) ?
				(pc.getCategoryName() == null) : getCategoryName().equals(pc.getCategoryName()));
    }

    @Override public int compareTo(ProductCategory pc) {

	    	//ascending
	    	return (getCategoryName() != null) ?
	    				getCategoryName().compareTo(pc.getCategoryName()) :
	    			(pc.getCategoryName() == null) ? 0 : -1;
    }

	@Override public ProductCategory doInit(ProductCategory pc) {
	    	
	    	pc.setCategoryName(getCategoryName());
	    	
	    	return pc;    	
    }

}
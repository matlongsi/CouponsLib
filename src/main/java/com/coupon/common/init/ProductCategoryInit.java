package com.coupon.common.init;

import com.coupon.common.ProductCategory;
import com.coupon.common.bean.ProductCategoryBean;
import com.coupon.common.entity.ProductCategoryEntity;


/**
 * Interface to initialize (visitor pattern) AcquisitionPeriod
 */
public interface ProductCategoryInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	ProductCategory init(ProductCategoryInit pci);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default ProductCategory dispatchInit(ProductCategoryBean pcb) {
		
		return doInit(pcb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default ProductCategory dispatchInit(ProductCategoryEntity pce) {
		
		return doInit(pce);
	}

	/**
	 * actual initialization activities
	 */
	ProductCategory doInit(ProductCategory pc);

}
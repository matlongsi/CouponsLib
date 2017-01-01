package com.coupon.common.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.ProductCategory;
import com.coupon.common.init.ProductCategoryInit;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation for class ProductCategory
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("ProductCategoryBean")
public class ProductCategoryBean extends ProductCategory implements Bean, Hierarchy {

	private static final long serialVersionUID = 4478623508548466100L;

	@Null(message="pcId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="pcId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="pcId needs to be unsigned number of 19 digits or less.")
	private Long pcId;
	@Override public Long getId() { return pcId; }
	@Override public void setId(Long pcId) { this.pcId = pcId; }

	@NotNull(message="mmId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="mmId needs to be unsigned number of 19 digits or less.")
	private Long mmId;
	@Override public Long getParentId() { return mmId; }
	@Override public void setParentId(Long mmId) { this.mmId = mmId; }

	@NotNull(message="categoryName is required.")
	@Size(max=MAX_NAME_LENGTH,
			message="categoryName needs to be " + MAX_NAME_LENGTH + " characters or less.")
	private String categoryName;
	@Override public String getCategoryName() { return categoryName; }
	@Override public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

	/**
     * Default constructor. 
     */
    public ProductCategoryBean() {
    }

	@Override public ProductCategoryBean init(ProductCategoryInit pci) {
    	
		pci.dispatchInit(this);

		return this;    	
    }

	@Override public ProductCategoryBean dispatchInit(ProductCategoryBean pcb) {
    	
		super.dispatchInit(pcb);

	    	pcb.setId(getId());
	    	pcb.setParentId(getParentId());
	    	
	    	return pcb;    	
    }

}
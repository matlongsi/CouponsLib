package com.coupon.common.bean;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.validation.groups.ConvertGroup;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.Artwork;
import com.coupon.common.LegalStatement;
import com.coupon.common.LongDescription;
import com.coupon.common.MarketingMaterial;
import com.coupon.common.ProductCategory;
import com.coupon.common.ShortDescription;
import com.coupon.common.init.MarketingMaterialInit;
import com.coupon.common.validator.ChildValidate;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation for class MarketingMaterial
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("MarketingMaterialBean")
public class MarketingMaterialBean extends MarketingMaterial implements Bean, Hierarchy {

	private static final long serialVersionUID = -5499675169318793040L;

	@Null(message="mmId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="mmId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="mmId needs to be unsigned number of 19 digits or less.")
	private Long mmId;
	@Override public Long getId() { return mmId; }
	@Override public void setId(Long mmId) { this.mmId = mmId; }

	@NotNull(message="offerId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="offerId needs to be unsigned number of 19 digits or less.")
	private Long offerId;
	@Override public Long getParentId() { return offerId; }
	@Override public void setParentId(Long offerId) { this.offerId = offerId; }

	@Size(min=1, message="1 or more ShortDescription(s) required.")
	@Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private List<ShortDescriptionBean> shortDescriptions;
	@Override public List<ShortDescriptionBean> getShortDescriptions() { return shortDescriptions; }
	@Override public <T extends ShortDescription> void setShortDescriptions(List<T> shortDescriptions) {
		
		this.shortDescriptions = new ArrayList<ShortDescriptionBean>();
		for (ShortDescription sd : shortDescriptions) {
			this.shortDescriptions.add(new ShortDescriptionBean().init(sd));
		}
	}

	@Size(min=1, message="1 or more LongDescription(s) required.")
	@Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private List<LongDescriptionBean> longDescriptions;
	@Override public List<LongDescriptionBean> getLongDescriptions() { return longDescriptions; }
	@Override public <T extends LongDescription> void setLongDescriptions(List<T> longDescriptions) {
		
		this.longDescriptions = new ArrayList<LongDescriptionBean>();
		for (LongDescription ld : longDescriptions) {
			this.longDescriptions.add(new LongDescriptionBean().init(ld));
		}
	}

	@Size(min=1, message="1 or more LegalStatement(s) required.")
	@Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private List<LegalStatementBean> legalStatements;
	@Override public List<LegalStatementBean> getLegalStatements() { return legalStatements; }
	@Override public <T extends LegalStatement> void setLegalStatements(List<T> legalStatements) {
		
		this.legalStatements = new ArrayList<LegalStatementBean>();
		for (LegalStatement ls : legalStatements) {
			this.legalStatements.add(new LegalStatementBean().init(ls));
    		}
	}

	@Size(min=1, message="1 or more ProductCategory(s) required.")
	@Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private List<ProductCategoryBean> productCategories;
	@Override public List<ProductCategoryBean> getProductCategories() { return productCategories; }
	@Override public <T extends ProductCategory> void setProductCategories(List<T> productCategories) {
		
		this.productCategories = new ArrayList<ProductCategoryBean>();
		for (ProductCategory pc : productCategories) {
			this.productCategories.add(new ProductCategoryBean().init(pc));
		}
	}

	@Size(min=1, message="1 or more Artwork(s) required.")
	@Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private List<ArtworkBean> artworks;
	@Override public List<ArtworkBean> getArtworks() { return artworks; }
	@Override public <T extends Artwork> void setArtworks(List<T> artworks) {
		
		this.artworks = new ArrayList<ArtworkBean>();
		for (Artwork a : artworks) {
			this.artworks.add(new ArtworkBean().init(a));
		}
	}

    @Size(max=MAX_BRAND_NAME_LENGTH, message="brandName needs to be " + MAX_BRAND_NAME_LENGTH + " characters or less.")
	private String brandName;
	@Override public String getBrandName() { return brandName; }
	@Override public void setBrandName(String brandName) { this.brandName = brandName; }

    /**
     * Default constructor. 
     */
    public MarketingMaterialBean() {
    }

	@Override public MarketingMaterialBean init(MarketingMaterialInit mmi) {

		mmi.dispatchInit(this);

		return this;
    }

	@Override public MarketingMaterialBean dispatchInit(MarketingMaterialBean mmb) {

		super.dispatchInit(mmb);

		mmb.setId(getId());
   		mmb.setParentId(getParentId());

   		return mmb;
    }

}
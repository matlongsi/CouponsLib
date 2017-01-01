package com.coupon.common;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.MarketingMaterialBean;
import com.coupon.common.init.MarketingMaterialInit;
import com.coupon.common.utils.ListCompare;


/**
 * Bean abstract class for OfferMarketingMaterial
 */
@XmlDiscriminatorNode("@type")
@XmlSeeAlso({MarketingMaterialBean.class})
public abstract class MarketingMaterial implements Serializable, MarketingMaterialInit {

	private static final long serialVersionUID = -5499675169318793040L;

	public static final int MAX_BRAND_NAME_LENGTH = 100;

	public abstract List<? extends ShortDescription> getShortDescriptions();
	public abstract <T extends ShortDescription> void setShortDescriptions(List<T> shortDescriptions);

	public abstract List<? extends LongDescription> getLongDescriptions();
	public abstract <T extends LongDescription> void setLongDescriptions(List<T> longDescriptions);

	public abstract List<? extends LegalStatement> getLegalStatements();
	public abstract <T extends LegalStatement> void setLegalStatements(List<T> legalStatements);

	public abstract List<? extends ProductCategory> getProductCategories();
	public abstract <T extends ProductCategory> void setProductCategories(List<T> productCategories);

	public abstract List<? extends Artwork> getArtworks();
	public abstract <T extends Artwork> void setArtworks(List<T> artworks);

	public abstract String getBrandName();
	public abstract void setBrandName(String brandName);

	@Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !MarketingMaterial.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	MarketingMaterial mm = MarketingMaterial.class.cast(obj);

	    	return ((getBrandName() == null) ?
				(mm.getBrandName() == null) : getBrandName().equals(mm.getBrandName())) &&
		    	ListCompare.<ShortDescription>equal(getShortDescriptions(), mm.getShortDescriptions()) &&
		    	ListCompare.<LongDescription>equal(getLongDescriptions(), mm.getLongDescriptions()) &&
		    	ListCompare.<LegalStatement>equal(getLegalStatements(), mm.getLegalStatements()) &&
		    	ListCompare.<ProductCategory>equal(getProductCategories(), mm.getProductCategories()) &&
		    	ListCompare.<Artwork>equal(getArtworks(), mm.getArtworks());
	}

	@Override public MarketingMaterial doInit(MarketingMaterial mm) {
    	
	    	mm.setShortDescriptions(getShortDescriptions());
	    	mm.setLongDescriptions(getLongDescriptions());
	    	mm.setLegalStatements(getLegalStatements());
	    	mm.setProductCategories(getProductCategories());
	    	mm.setArtworks(getArtworks());
	    	mm.setBrandName(getBrandName());
	
	    	return mm;
    }

}
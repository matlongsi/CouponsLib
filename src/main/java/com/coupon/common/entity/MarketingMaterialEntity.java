package com.coupon.common.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import com.coupon.common.Artwork;
import com.coupon.common.LegalStatement;
import com.coupon.common.LongDescription;
import com.coupon.common.MarketingMaterial;
import com.coupon.common.ProductCategory;
import com.coupon.common.ShortDescription;
import com.coupon.common.bean.Bean;
import com.coupon.common.bean.MarketingMaterialBean;
import com.coupon.common.init.MarketingMaterialInit;


/**
 * Entity bean implementation for class OfferMarketingMaterial
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="offer_marketing_material_tbl")
public class MarketingMaterialEntity extends MarketingMaterial implements Record {

	private static final long serialVersionUID = 3657911850931550150L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="omm_tbl_id")
	private Long mmId;
	@Override public Long getId() { return mmId; }
	@Override public void setId(Long mmId) { this.mmId = mmId; }

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cpn_tbl_fk", updatable=false, nullable=false)
	private OfferEntity offer;
	public OfferEntity getOffer() { return offer; }
	public void setOffer(OfferEntity offer) { this.offer = offer; }
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="marketingMaterial", cascade=CascadeType.ALL)
	@OrderBy(value="sdId ASC")
	@MapKey(name="sdId")
	private Map<Long, ShortDescriptionEntity> shortDescriptionsMap;
	public Map<Long, ShortDescriptionEntity> getShortDescriptionsMap() { return shortDescriptionsMap; }
	public void setShortDescriptionsMap(Map<Long, ShortDescriptionEntity> shortDescriptionsMap) { this.shortDescriptionsMap = shortDescriptionsMap; }
	
	@Override public List<ShortDescriptionEntity> getShortDescriptions() {
		
		return (getShortDescriptionsMap() == null) ?
				null : new ArrayList<ShortDescriptionEntity>(getShortDescriptionsMap().values());
	}

	@Override public <T extends ShortDescription> void setShortDescriptions(List<T> shortDescriptions) {
    	
		for (T sd : shortDescriptions) {
			if (getShortDescriptionsMap().containsKey(Bean.class.cast(sd).getId())) {
				getShortDescriptionsMap().get(Bean.class.cast(sd).getId()).init(sd);
			}
		}
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="marketingMaterial", cascade=CascadeType.ALL)
	@OrderBy(value="ldId ASC")
	@MapKey(name="ldId")
	private Map<Long, LongDescriptionEntity> longDescriptionsMap;
	public Map<Long, LongDescriptionEntity> getLongDescriptionsMap() { return longDescriptionsMap; }
	public void setLongDescriptionsMap(Map<Long, LongDescriptionEntity> longDescriptionsMap) { this.longDescriptionsMap = longDescriptionsMap; }

	@Override public List<LongDescriptionEntity> getLongDescriptions() {
		
		return (getLongDescriptionsMap() == null) ?
				null : new ArrayList<LongDescriptionEntity>(getLongDescriptionsMap().values());
	}

	@Override public <T extends LongDescription> void setLongDescriptions(List<T> longDescriptions) {
    	
		for (T ld : longDescriptions) {
			if (getLongDescriptionsMap().containsKey(Bean.class.cast(ld).getId())) {
				getLongDescriptionsMap().get(Bean.class.cast(ld).getId()).init(ld);
			}
		}
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="marketingMaterial", cascade=CascadeType.ALL)
	@OrderBy(value="lsId ASC")
	@MapKey(name="lsId")
	private Map<Long, LegalStatementEntity> legalStatementsMap;
	public Map<Long, LegalStatementEntity> getLegalStatementsMap() { return legalStatementsMap; }
	public void setLegalStatementsMap(Map<Long, LegalStatementEntity> legalStatementsMap) { this.legalStatementsMap = legalStatementsMap; }

	@Override public List<LegalStatementEntity> getLegalStatements() {
		
		return (getLegalStatementsMap() == null) ?
				null : new ArrayList<LegalStatementEntity>(getLegalStatementsMap().values());
	}

	@Override public <T extends LegalStatement> void setLegalStatements(List<T> legalStatements) {
    	
		for (T ls : legalStatements) {
			if (getLegalStatementsMap().containsKey(Bean.class.cast(ls).getId())) {
				getLegalStatementsMap().get(Bean.class.cast(ls).getId()).init(ls);
			}
    		}
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="marketingMaterial", cascade=CascadeType.ALL)
	@OrderBy(value="pcId ASC")
	@MapKey(name="pcId")
	private Map<Long, ProductCategoryEntity> productCategoriesMap;
	public Map<Long, ProductCategoryEntity> getProductCategoriesMap() { return productCategoriesMap; }
	public void setProductCategoriesMap(Map<Long, ProductCategoryEntity> productCategoriesMap) { this.productCategoriesMap = productCategoriesMap; }

	@Override public List<ProductCategoryEntity> getProductCategories() {
		
		return (getProductCategoriesMap() == null) ?
				null : new ArrayList<ProductCategoryEntity>(getProductCategoriesMap().values());
	}

	@Override public <T extends ProductCategory> void setProductCategories(List<T> productCategories) {
    	
		for (T pc : productCategories) {
			if (getProductCategoriesMap().containsKey(Bean.class.cast(pc).getId())) {
				getProductCategoriesMap().get(Bean.class.cast(pc).getId()).init(pc);
			}
		}
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="marketingMaterial", cascade=CascadeType.ALL)
	@OrderBy(value="aId ASC")
	@MapKey(name="aId")
	private Map<Long, ArtworkEntity> artworksMap;
	public Map<Long, ArtworkEntity> getArtworksMap() { return artworksMap; }
	public void setArtworksMap(Map<Long, ArtworkEntity> artworksMap) { this.artworksMap = artworksMap; }

	@Override public List<ArtworkEntity> getArtworks() {
		
		return (getArtworksMap() == null) ?
				null : new ArrayList<ArtworkEntity>(getArtworksMap().values());
	}

	@Override public <T extends Artwork> void setArtworks(List<T> artworks) {
    	
		for (T a : artworks) {
			if (getArtworksMap().containsKey(Bean.class.cast(a).getId())) {
				getArtworksMap().get(Bean.class.cast(a).getId()).init(a);
			}
		}
	}

	@Column(name="brand_name", columnDefinition="VARCHAR DEFAULT NULL", length=50)
	private String brandName;
	@Override public String getBrandName() { return brandName; }
	@Override public void setBrandName(String brandName) { this.brandName = brandName; }

    @Version
    @Column(name="optimistic_lock_version", columnDefinition="INT UNSIGNED DEFAULT 0", nullable=false)
    private Integer optimisticLockVersion;
	@Override public Integer getOptimisticLockVersion() { return optimisticLockVersion; }
	@Override public void setOptimisticLockVersion(Integer optimisticLockVersion) { this.optimisticLockVersion = optimisticLockVersion; }

	@Embedded
    private RecordHistoryEmbed recordHistory;
	@Override public RecordHistoryEmbed getRecordHistory() { return recordHistory; }
	@Override public void setRecordHistory(RecordHistoryEmbed recordHistory) { this.recordHistory = recordHistory; }

    /**
     * Default constructor. 
     */
    public MarketingMaterialEntity() {
    }

    @Override public MarketingMaterialEntity init(MarketingMaterialInit mmi) {

	    	mmi.dispatchInit(this);
	    	
	    	return this;
    }

	@Override public MarketingMaterialBean dispatchInit(MarketingMaterialBean mmb) {

		super.dispatchInit(mmb);

		mmb.setId(getId());
   		mmb.setParentId(getOffer().getId());

   		return mmb;
    }

}
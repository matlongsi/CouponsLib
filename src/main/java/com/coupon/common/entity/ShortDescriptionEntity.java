package com.coupon.common.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.coupon.common.ShortDescription;
import com.coupon.common.bean.ShortDescriptionBean;
import com.coupon.common.init.ShortDescriptionInit;


/**
 * Entity bean implementation for class OfferShortDescription
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="offer_short_description_tbl")
public class ShortDescriptionEntity extends ShortDescription implements Record {

	private static final long serialVersionUID = 1879246496474399981L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="osd_tbl_id")
	private Long sdId;
	@Override public Long getId() { return sdId; }
	@Override public void setId(Long sdId) { this.sdId = sdId; }

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="omm_tbl_fk", updatable=false, nullable=false)
	private MarketingMaterialEntity marketingMaterial;
	public MarketingMaterialEntity getMarketingMaterial() { return marketingMaterial; }
	public void setMarketingMaterial(MarketingMaterialEntity marketingMaterial) { this.marketingMaterial = marketingMaterial; }

	@Column(name="short_description", columnDefinition="VARCHAR", length=MAX_DESCRIPTION_LENGTH, nullable=false)
	private String shortDescription;
    @Override public String getShortDescription() { return shortDescription; }
    @Override public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

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
    public ShortDescriptionEntity() {
    }

    @Override public ShortDescriptionEntity init(ShortDescriptionInit sdi) {

	    	sdi.dispatchInit(this);
	    	
	    	return this;
    }

	@Override public ShortDescriptionBean dispatchInit(ShortDescriptionBean sdb) {
    	
		super.dispatchInit(sdb);

    		sdb.setId(getId());
        sdb.setParentId(getMarketingMaterial().getId());
    	
        return sdb;
    }

}
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

import com.coupon.common.LongDescription;
import com.coupon.common.bean.LongDescriptionBean;
import com.coupon.common.init.LongDescriptionInit;


/**
 * Entity bean implementation for class OfferLongDescription
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="offer_Long_description_tbl")
public class LongDescriptionEntity extends LongDescription implements Record {

	private static final long serialVersionUID = 6315323519138166396L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="old_tbl_id")
	private Long ldId;
	@Override public Long getId() { return ldId; }
	@Override public void setId(Long ldId) { this.ldId = ldId; }

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="omm_tbl_fk", updatable=false, nullable=false)
	private MarketingMaterialEntity marketingMaterial;
	public MarketingMaterialEntity getMarketingMaterial() { return marketingMaterial; }
	public void setMarketingMaterial(MarketingMaterialEntity marketingMaterial) { this.marketingMaterial = marketingMaterial; }

	@Column(name="Long_description", columnDefinition="VARCHAR", length=MAX_DESCRIPTION_LENGTH, nullable=false)
	private String LongDescription;
    public String getLongDescription() { return LongDescription; }
	public void setLongDescription(String LongDescription) { this.LongDescription = LongDescription; }

    @Version
    @Column(name="optimistic_lock_version", columnDefinition="INT UNSIGNED DEFAULT 0", nullable=false)
    private Integer optimisticLockVersion;
	public Integer getOptimisticLockVersion() { return optimisticLockVersion; }
	public void setOptimisticLockVersion(Integer optimisticLockVersion) { this.optimisticLockVersion = optimisticLockVersion; }

	@Embedded
    private RecordHistoryEmbed recordHistory;
	@Override public RecordHistoryEmbed getRecordHistory() { return recordHistory; }
	@Override public void setRecordHistory(RecordHistoryEmbed recordHistory) { this.recordHistory = recordHistory; }

    /**
     * Default constructor. 
     */
    public LongDescriptionEntity() {
    }

    @Override public LongDescriptionEntity init(LongDescriptionInit ldi) {
    	
	    	ldi.dispatchInit(this);
	    	
	    	return this;
    }

	@Override public LongDescriptionBean dispatchInit(LongDescriptionBean ldb) {

		super.dispatchInit(ldb);

	    	ldb.setId(getId());
	    	ldb.setParentId(getMarketingMaterial().getId());
	
	    	return ldb;
    }

}
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

import com.coupon.common.GlobalLocationNumber;
import com.coupon.common.AwarderPointOfSale;
import com.coupon.common.bean.AwarderPointOfSaleBean;
import com.coupon.common.init.AwarderPointOfSaleInit;


/**
 * Entity bean implementation for OfferAwarderPointOfSale
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="offer_awarder_point_of_sale_tbl")
public class AwarderPointOfSaleEntity extends AwarderPointOfSale implements Record {

	private static final long serialVersionUID = -7551927912123727701L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="oapos_tbl_id")
	private Long aposId;
    @Override public Long getId() { return aposId; }
	@Override public void setId(Long aposId) { this.aposId = aposId; }

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="oad_tbl_fk", updatable=false, nullable=false)
	private AwarderDetailEntity awarderDetail;
	public AwarderDetailEntity getAwarderDetail() { return awarderDetail; }
	public void setAwarderDetail(AwarderDetailEntity awarderDetail) { this.awarderDetail = awarderDetail; }

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="store_gln_fk", referencedColumnName="gln_tbl_id", updatable=false)
	private GlobalLocationNumberEntity storeNumber;
	@Override public GlobalLocationNumberEntity getStoreNumber() { return storeNumber; }
	@Override public void setStoreNumber(GlobalLocationNumber storeNumber) { this.storeNumber = GlobalLocationNumberEntity.class.cast(storeNumber); }

	@Column(name="store_internal_id", columnDefinition="VARCHAR", length=MAX_STORE_INTERNAL_ID_LENGTH)
	private String storeInternalId;
	@Override public String getStoreInternalId() { return storeInternalId; }
	@Override public void setStoreInternalId(String storeInternalId) { this.storeInternalId = storeInternalId; }

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
    public AwarderPointOfSaleEntity() {
    }

    @Override public AwarderPointOfSaleEntity init(AwarderPointOfSaleInit aposi) {
    	
	    	aposi.dispatchInit(this);
	    	
	    	return this;
    }

	@Override public AwarderPointOfSaleBean dispatchInit(AwarderPointOfSaleBean aposb) {
    	
		super.dispatchInit(aposb);

	    	aposb.setId(getId());
	    	aposb.setParentId(getAwarderDetail().getId());
	    	
	    	return aposb;
    }

}
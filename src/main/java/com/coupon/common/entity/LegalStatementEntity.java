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

import com.coupon.common.LegalStatement;
import com.coupon.common.bean.LegalStatementBean;
import com.coupon.common.init.LegalStatementInit;


/**
 * Entity bean implementation for class OfferLegalStatement
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="offer_legal_statement_tbl")
public class LegalStatementEntity extends LegalStatement implements Record {

	private static final long serialVersionUID = 7271845134794463718L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ols_tbl_id")
	private Long lsId;
	@Override public Long getId() { return lsId; }
	@Override public void setId(Long lsId) { this.lsId = lsId; }

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="omm_tbl_fk", updatable=false, nullable=false)
	private MarketingMaterialEntity marketingMaterial;
	public MarketingMaterialEntity getMarketingMaterial() { return marketingMaterial; }
	public void setMarketingMaterial(MarketingMaterialEntity marketingMaterial) { this.marketingMaterial = marketingMaterial; }

	@Column(name="legal_statement", columnDefinition="VARCHAR", length=MAX_STATEMENT_LENGTH, nullable=false)
	private String legalStatement;
    @Override public String getLegalStatement() { return legalStatement; }
	@Override public void setLegalStatement(String legalStatement) { this.legalStatement = legalStatement; }

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
    public LegalStatementEntity() {
    }

    @Override public LegalStatementEntity init(LegalStatementInit lsi) {

	    	lsi.dispatchInit(this);
	    	
	    	return this;
    }

	@Override public LegalStatementBean dispatchInit(LegalStatementBean lsb) {

		super.dispatchInit(lsb);
		
	    	lsb.setId(getId());
	    	lsb.setParentId(getMarketingMaterial().getId());
	
	    	return lsb;
    }

}
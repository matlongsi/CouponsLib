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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.coupon.common.FinancialSettlementDetail;
import com.coupon.common.bean.FinancialSettlementDetailBean;
import com.coupon.common.entity.OfferEntity;
import com.coupon.common.init.FinancialSettlementDetailInit;


/**
 * Entity bean implementation for OfferFinancialSettlementDetail 
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="offer_financial_settlement_detail_tbl")
public class FinancialSettlementDetailEntity extends FinancialSettlementDetail implements Record {

	private static final long serialVersionUID = 3755654053954370269L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ofsd_tbl_id")
	private Long fsdId;
    @Override public Long getId() { return fsdId; }
	@Override public void setId(Long fsdId) { this.fsdId = fsdId; }

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cpn_tbl_fk", updatable=false, nullable=false)
	private OfferEntity offer;
    public OfferEntity getOffer() { return offer; }
	public void setOffer(OfferEntity offer) { this.offer = offer; }

	@Column(name="offer_clearing_instruction", columnDefinition="VARCHAR DEFAULT NULL", length=MAX_CLEARING_INSTRUCTION_LENGTH)
    private String offerClearingInstruction;
    @Override public String getOfferClearingInstruction() { return offerClearingInstruction; }
	@Override public void setOfferClearingInstruction(String offerClearingInstruction) { this.offerClearingInstruction = offerClearingInstruction; }

	@Version
    @Column(name="optimistic_lock_version", columnDefinition = "INT UNSIGNED DEFAULT 0", nullable=false)
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
    public FinancialSettlementDetailEntity() {
    }

	@Override public FinancialSettlementDetailEntity init(FinancialSettlementDetailInit fsdi) {
		
		fsdi.dispatchInit(this);

		return this;
	}

	@Override public FinancialSettlementDetailBean dispatchInit(FinancialSettlementDetailBean fsdb) {
		
		super.dispatchInit(fsdb);
		
		fsdb.setId(getId());
		fsdb.setParentId(getOffer().getId());
		
		return fsdb;
	}
	
}
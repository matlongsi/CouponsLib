package com.coupon.common.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.coupon.common.GlobalTradeIdentificationNumber;


/**
 * Entity bean implementation for GlobalTradeIdentificationNumber
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="global_trade_identification_number_tbl",
	uniqueConstraints=@UniqueConstraint(name="UNIQUE_GTIN", columnNames={"company_prefix", "item_reference"}))
@NamedQuery(name="GlobalTradeIdentificationNumberEntity.findByNumber",
			query="SELECT g FROM GlobalTradeIdentificationNumberEntity g "
					+ "WHERE g.companyPrefix = :companyPrefix "
					+ "AND g.itemReference = :itemReference ")
public class GlobalTradeIdentificationNumberEntity extends GlobalTradeIdentificationNumber implements Record {

	private static final long serialVersionUID = -7903037245107378129L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="gtin_tbl_id")
	private Long gtinId;
	@Override public Long getId() { return gtinId; }
	@Override public void setId(Long gtinId) { this.gtinId = gtinId; }

	@Column(name="company_prefix")
    private Long companyPrefix;
	@Override public Long getCompanyPrefix() { return companyPrefix; }
	@Override public void setCompanyPrefix(Long companyPrefix) { this.companyPrefix = companyPrefix; }

    @Column(name="item_reference")
	private Integer itemReference;
    @Override public Integer getItemReference() { return itemReference; }
    @Override public void setItemReference(Integer itemReference) { this.itemReference = itemReference; }

    @Column(name="check_digit")
	private Byte checkDigit;
    @Override public Byte getCheckDigit() { return checkDigit; }
    @Override public void setCheckDigit(Byte checkDigit) { this.checkDigit = checkDigit; }

    @Version
    @Column(name = "optimistic_lock_version", columnDefinition = "INT UNSIGNED DEFAULT 0", nullable = false)
    private Integer optimisticLockVersion;
    @Override public Integer getOptimisticLockVersion() { return optimisticLockVersion; }
    @Override public void setOptimisticLockVersion(Integer optimisticLockVersion) { this.optimisticLockVersion = optimisticLockVersion; }
    
    @Embedded
    private RecordHistoryEmbed recordHistory;
    @Override public RecordHistoryEmbed getRecordHistory() { return this.recordHistory; }
    @Override public void setRecordHistory(RecordHistoryEmbed recordHistory) { this.recordHistory = recordHistory; }

	/**
     * Default constructor. 
     */
    public GlobalTradeIdentificationNumberEntity() {
    }

    @Override public GlobalTradeIdentificationNumberEntity init(GlobalTradeIdentificationNumber gtin) {

	    	super.init(gtin);
	    	
	    	return this;
    }

}
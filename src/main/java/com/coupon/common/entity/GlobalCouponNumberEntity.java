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

import com.coupon.common.GlobalCouponNumber;


/**
 * Entity bean implementation for GlobalCouponNumber
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="global_coupon_number_tbl",
	uniqueConstraints=@UniqueConstraint(name="UNIQUE_GCN", columnNames={"company_prefix", "coupon_reference", "serial_component"}))
@NamedQuery(name="GlobalCouponNumberEntity.findByNumber",
			query="SELECT g FROM GlobalCouponNumberEntity g "
					+ "WHERE g.companyPrefix = :companyPrefix "
					+ "AND g.couponReference = :couponReference "
					+ "AND g.serialComponent = :serialComponent ")
public class GlobalCouponNumberEntity extends GlobalCouponNumber implements Record {

	private static final long serialVersionUID = 4161966034611865977L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gcn_tbl_id")
	private Long gcnId;
    @Override public Long getId() { return gcnId; }
    @Override public void setId(Long gcnId) { this.gcnId = gcnId; }

	@Column(name="company_prefix")
    private Long companyPrefix;
    @Override public Long getCompanyPrefix() { return companyPrefix; }
    @Override public void setCompanyPrefix(Long companyPrefix) { this.companyPrefix = companyPrefix; }

	@Column(name="coupon_reference")
    private Integer couponReference;
    @Override public Integer getCouponReference() { return couponReference; }
    @Override public void setCouponReference(Integer couponReference) { this.couponReference = couponReference; }

	@Column(name="check_digit")
    private Byte checkDigit;
    @Override public Byte getCheckDigit() { return checkDigit; }
    @Override public void setCheckDigit(Byte checkDigit) { this.checkDigit = checkDigit; }

    @Column(name="serial_component")
    private Long serialComponent;
    @Override public Long getSerialComponent() { return serialComponent; }
    @Override public void setSerialComponent(Long serialComponent) { this.serialComponent = serialComponent; }

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
    public GlobalCouponNumberEntity() {
    }
    
    @Override public GlobalCouponNumberEntity init(GlobalCouponNumber gcn) {

	    	super.init(gcn);
	    	
	    	return this;
    }

}
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

import com.coupon.common.GlobalServiceRelationNumber;


/**
 * Entity bean implementation for GlobalServiceRelationNumber
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="global_service_relation_number_tbl",
	uniqueConstraints=@UniqueConstraint(name="UNIQUE_GSRN", columnNames={"company_prefix", "service_reference"}))
@NamedQuery(name="GlobalServiceRelationNumberEntity.findByNumber",
			query="SELECT g FROM GlobalServiceRelationNumberEntity g "
					+ "WHERE g.companyPrefix = :companyPrefix "
					+ "AND g.serviceReference = :serviceReference ")
public class GlobalServiceRelationNumberEntity extends GlobalServiceRelationNumber implements Record {

	private static final long serialVersionUID = -8385483554700629375L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="gsrn_tbl_id")
	private Long gsrnId;
	@Override public Long getId() { return gsrnId; }
	@Override public void setId(Long gsrnId) { this.gsrnId = gsrnId; }

	@Column(name="company_prefix")
    private Long companyPrefix;
	@Override public Long getCompanyPrefix() { return companyPrefix; }
	@Override public void setCompanyPrefix(Long companyPrefix) { this.companyPrefix = companyPrefix; }

    @Column(name="service_reference")
	private Long serviceReference;
    @Override public Long getServiceReference() { return serviceReference; }
    @Override public void setServiceReference(Long serviceReference) { this.serviceReference = serviceReference; }

    @Column(name="check_digit")
	private Byte checkDigit;
    @Override public Byte getCheckDigit() { return checkDigit; }
    @Override public void setCheckDigit(Byte checkDigit) { this.checkDigit = checkDigit; }

    @Version
    @Column(name="optimistic_lock_version", columnDefinition="INT UNSIGNED DEFAULT 0", nullable=false)
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
    public GlobalServiceRelationNumberEntity() {
    }

    @Override public GlobalServiceRelationNumberEntity init(GlobalServiceRelationNumber gsrn) {

	    	super.init(gsrn);
	    	
	    	return this;
    }

}
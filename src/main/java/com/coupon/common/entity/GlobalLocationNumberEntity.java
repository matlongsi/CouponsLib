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

import com.coupon.common.GlobalLocationNumber;


/**
 * Entity bean implementation for GlobalLocationNumber
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="global_location_number_tbl",
	uniqueConstraints=@UniqueConstraint(name="UNIQUE_GLN", columnNames={"company_prefix", "location_reference"}))
@NamedQuery(name="GlobalLocationNumberEntity.findByNumber",
			query="SELECT g FROM GlobalLocationNumberEntity g "
					+ "WHERE g.companyPrefix = :companyPrefix "
					+ "AND g.locationReference = :locationReference ")
public class GlobalLocationNumberEntity extends GlobalLocationNumber implements Record {

	private static final long serialVersionUID = 7848697641089404164L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="gln_tbl_id")
	private Long glnId;
	@Override public Long getId() { return glnId; }
	@Override public void setId(Long glnId) { this.glnId = glnId; }

	@Column(name="company_prefix")
	private Long companyPrefix;
	@Override public Long getCompanyPrefix() { return companyPrefix; }
	@Override public void setCompanyPrefix(Long companyPrefix) { this.companyPrefix = companyPrefix; }

    @Column(name="location_reference")
	private Integer locationReference;
    @Override public Integer getLocationReference() { return locationReference; }
    @Override public void setLocationReference(Integer locationReference) { this.locationReference = locationReference; }

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
    public GlobalLocationNumberEntity() {
    }

    @Override public GlobalLocationNumberEntity init(GlobalLocationNumber gln) {

	    	super.init(gln);
	    	
	    	return this;
    }

}
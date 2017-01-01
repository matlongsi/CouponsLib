package com.coupon.process.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.coupon.common.entity.Record;
import com.coupon.common.entity.RecordListener;
import com.coupon.common.entity.GlobalCouponNumberEntity;
import com.coupon.common.entity.GlobalServiceRelationNumberEntity;
import com.coupon.common.entity.RecordHistoryEmbed;
import com.coupon.process.type.AcquisitionResponseType;


/**
 * Entity bean implementation for CouponAcquisition
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="coupon_acquisition_tbl")
@NamedQueries({
	@NamedQuery(name="CouponAcquisitionEntity.findByCouponAndAccountNumber",
				query="SELECT c FROM CouponAcquisitionEntity c "
						+ "WHERE c.couponInstance = :couponInstance "
						+ "AND c.accountNumber = :accountNumber "),
	@NamedQuery(name="CouponAcquisitionEntity.findByCouponAndAlternateAccountId",
				query="SELECT c FROM CouponAcquisitionEntity c "
						+ "WHERE c.couponInstance = :couponInstance "
						+ "AND c.alternateAccountId = :alternateAccountId ")})
public class CouponAcquisitionEntity implements Serializable, Record {

	private static final long serialVersionUID = 9097200600045305397L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="coupon_acquisition_id")
	private Long canId;
	@Override public Long getId() { return canId; }
	@Override public void setId(Long canId) { this.canId = canId; }
	
	@OneToOne(optional=false, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="gcn_tbl_fk", referencedColumnName="gcn_tbl_id")
	private GlobalCouponNumberEntity couponInstance;
	public GlobalCouponNumberEntity getCouponInstance() { return couponInstance; }
	public void setCouponInstance(GlobalCouponNumberEntity couponInstance) { this.couponInstance= couponInstance; }

	@OneToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="gsrn_tbl_fk", referencedColumnName="gsrn_tbl_id")
	private GlobalServiceRelationNumberEntity accountNumber;
	public GlobalServiceRelationNumberEntity getAccountNumber() { return accountNumber; }
	public void setAccountNumber(GlobalServiceRelationNumberEntity accountNumber) { this.accountNumber = accountNumber; }

	@Column(name="alternate_account_id")
    private String alternateAccountId;
	public String getAlternateAccountId() { return alternateAccountId; }
	public void setAlternateAccountId(String alternateAccountId) { this.alternateAccountId = alternateAccountId; }

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="acquisition_date_time")
	private Date acquisitionDateTime;
	public Date getAcquisitionDateTime() { return acquisitionDateTime; }
	public void setAcquisitionDateTime(Date acquisitionDateTime) { this.acquisitionDateTime = acquisitionDateTime; }
	
	@Column(name="response_code")
	@Enumerated(EnumType.STRING)
	private AcquisitionResponseType responseCode;
	public AcquisitionResponseType getResponseCode() { return responseCode; }
	public void setResponseCode(AcquisitionResponseType responseCode) { this.responseCode = responseCode; }	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="acknowledgement_date_time", columnDefinition="DATETIME DEFAULT NULL")
	private Date acknowledgementDateTime;
	public Date getAcknowledgementDateTime() { return acknowledgementDateTime; }
	public void setAcknowledgementDateTime(Date acknowledgementDateTime) { this.acknowledgementDateTime = acknowledgementDateTime; }

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
	public CouponAcquisitionEntity() {
	}
	
}
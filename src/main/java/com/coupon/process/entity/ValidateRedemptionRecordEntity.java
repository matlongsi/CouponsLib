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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.coupon.common.GlobalLocationNumber;
import com.coupon.common.entity.Record;
import com.coupon.common.entity.RecordListener;
import com.coupon.common.entity.GlobalCouponNumberEntity;
import com.coupon.common.entity.GlobalLocationNumberEntity;
import com.coupon.common.entity.GlobalServiceRelationNumberEntity;
import com.coupon.common.entity.RecordHistoryEmbed;


/**
 * Entity bean implementation for ValidateRedemptionRecord
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="validate_redemption_record_tbl")
@NamedQueries({
	@NamedQuery(name="ValidateRedemptionRecordEntity.findByCouponAndAccountNumber",
				query="SELECT c FROM CouponRedemptionRecordEntity c "
						+ "WHERE c.couponInstance = :couponInstance "
						+ "AND c.accountNumber = :accountNumber "),
	@NamedQuery(name="ValidateRedemptionRecordEntity.findByCouponAndAlternateAccountId",
				query="SELECT c FROM CouponRedemptionRecordEntity c "
						+ "WHERE c.couponInstance = :couponInstance "
						+ "AND c.alternateAccountId = :alternateAccountId ")})
public class ValidateRedemptionRecordEntity implements Serializable, Record {

	private static final long serialVersionUID = 9097200600045305397L;

	public static final int VALIDATION_OVERRIDE_REFERENCE_LENGTH = 20;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="vrr_tbl_id")
	private Long id;
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="coupon_instance_fk", referencedColumnName="gcn_tbl_id")
	private GlobalCouponNumberEntity couponInstance;
	public GlobalCouponNumberEntity getCouponInstance() { return couponInstance; }
	public void setCouponInstance(GlobalCouponNumberEntity couponInstance) { this.couponInstance = couponInstance; }

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="awarder_gln_fk", referencedColumnName="gln_tbl_id")
	private GlobalLocationNumberEntity awarderNumber;
	public GlobalLocationNumber getAwarderNumber() { return awarderNumber; }
	public void setAwarderNumber(GlobalLocationNumber awarderNumber) { this.awarderNumber = GlobalLocationNumberEntity.class.cast(awarderNumber); }

	@ManyToOne(optional=true, fetch=FetchType.LAZY)
	@JoinColumn(name="account_number_fk", referencedColumnName="gsrn_tbl_id")
	private GlobalServiceRelationNumberEntity accountNumber;
	public GlobalServiceRelationNumberEntity getAccountNumber() { return accountNumber; }
	public void setAccountNumber(GlobalServiceRelationNumberEntity accountNumber) { this.accountNumber = accountNumber; }

	@Column(name="alternate_account_id")
    private String alternateAccountId;
	public String getAccountAlternateId() { return alternateAccountId; }
	public void setAlternateAccountId(String alternateAccountId) { this.alternateAccountId = alternateAccountId; }

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="validate_date_time")
	private Date validateDateTime;
	public Date getValidateDateTime() { return validateDateTime; }
	public void setValidateDateTime(Date validateDateTime) { this.validateDateTime = validateDateTime; }

	@OneToOne(optional=false, fetch=FetchType.LAZY, mappedBy="validateRedemptionRecord", cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="vrr_tbl_id", referencedColumnName="vrr_tbl_fk")
	private ValidatePurchaseEntity validatePurchase;
	public ValidatePurchaseEntity getValidatePurchase() { return validatePurchase; }
	public void setValidatePurchase(ValidatePurchaseEntity validatePurchase) { this.validatePurchase = validatePurchase; }

	@Column(name="redeemable", columnDefinition="TINYINT", length=1, nullable=false)
	private boolean redeemable;
	public boolean isRedeemable() { return redeemable; }
	public void setRedeemable(boolean redeemable) { this.redeemable = redeemable; }

	@Version
    @Column(name="optimistic_lock_version", columnDefinition="INT UNSIGNED DEFAULT 0", nullable=false)
	private Integer optimisticLockVersion;
	public Integer getOptimisticLockVersion() { return optimisticLockVersion; }
	public void setOptimisticLockVersion(Integer optimisticLockVersion) { this.optimisticLockVersion = optimisticLockVersion; }

	@Embedded
    private RecordHistoryEmbed recordHistory;
	public RecordHistoryEmbed getRecordHistory() { return recordHistory; }
	public void setRecordHistory(RecordHistoryEmbed recordHistory) { this.recordHistory = recordHistory; }

	public ValidateRedemptionRecordEntity() {
	}

}
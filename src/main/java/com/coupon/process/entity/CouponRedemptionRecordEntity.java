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
import com.coupon.common.AwarderPointOfSale;
import com.coupon.common.entity.Record;
import com.coupon.common.entity.RecordListener;
import com.coupon.common.entity.GlobalCouponNumberEntity;
import com.coupon.common.entity.GlobalLocationNumberEntity;
import com.coupon.common.entity.GlobalServiceRelationNumberEntity;
import com.coupon.common.entity.RecordHistoryEmbed;


/**
 * Entity bean implementation for CouponRedemptionRecord
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="coupon_redemption_record_tbl")
@NamedQueries({
	@NamedQuery(name="CouponRedemptionRecordEntity.findByCouponAndAccountNumber",
				query="SELECT c FROM CouponRedemptionRecordEntity c "
						+ "WHERE c.couponInstance = :couponInstance "
						+ "AND c.accountNumber = :accountNumber "),
	@NamedQuery(name="CouponRedemptionRecordEntity.findByCouponAndAlternateAccountId",
				query="SELECT c FROM CouponRedemptionRecordEntity c "
						+ "WHERE c.couponInstance = :couponInstance "
						+ "AND c.alternateAccountId = :alternateAccountId ")})
public class CouponRedemptionRecordEntity implements Serializable, Record {

	private static final long serialVersionUID = 9097200600045305397L;

	public static final int VALIDATION_OVERRIDE_REFERENCE_LENGTH = 20;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="coupon_redemption_record_tbl_id")
	private Long crrId;
	@Override public Long getId() { return crrId; }
	@Override public void setId(Long crrId) { this.crrId = crrId; }

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="store_gln_fk", referencedColumnName="gln_tbl_id")
	private GlobalLocationNumberEntity storeGln;
	public GlobalLocationNumber getStoreGln() { return storeGln; }
	public void setStoreGln(GlobalLocationNumber storeGln) { this.storeGln = GlobalLocationNumberEntity.class.cast(storeGln); }

	@Column(name="store_internal_id",
			columnDefinition="VARCHAR",
			length=AwarderPointOfSale.MAX_STORE_INTERNAL_ID_LENGTH)
	private String storeInternalId;
	public String getStoreInternalId() { return storeInternalId; }
	public void setStoreInternalId(String storeInternalId) { this.storeInternalId = storeInternalId; }

	@Column(name="pos_terminal_id",
			columnDefinition="VARCHAR",
			length=AwarderPointOfSale.MAX_POS_TERMINAL_ID_LENGTH)
	private String posTerminalId;
	public String getPosTerminalId() { return posTerminalId; }
	public void setPosTerminalId(String posTerminalId) { this.posTerminalId = posTerminalId; }

	@OneToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="coupon_instance_fk", referencedColumnName="gcn_tbl_id")
	private GlobalCouponNumberEntity couponInstance;
	public GlobalCouponNumberEntity getCouponInstance() { return couponInstance; }
	public void setCouponInstance(GlobalCouponNumberEntity couponInstance) { this.couponInstance = couponInstance; }

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
	@Column(name="redemption_date_time")
	private Date redemptionDateTime;
	public Date getRedemptionDateTime() { return redemptionDateTime; }
	public void setRedemptionDateTime(Date redemptionDateTime) { this.redemptionDateTime = redemptionDateTime; }

	@OneToOne(optional=false, fetch=FetchType.LAZY, mappedBy="couponRedemptionRecord", cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="coupon_redemption_record_tbl_id", referencedColumnName="coupon_redemption_record_tbl_fk")
	private CouponRewardEntity couponReward;
	public CouponRewardEntity getCouponReward() { return couponReward; }
	public void setCouponReward(CouponRewardEntity couponReward) { this.couponReward = couponReward; }

	@OneToOne(optional=false, fetch=FetchType.LAZY, mappedBy="couponRedemptionRecord", cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="coupon_redemption_record_tbl_id", referencedColumnName="coupon_redemption_record_tbl_fk")
	private QualifyingPurchaseEntity qualifyingPurchase;
	public QualifyingPurchaseEntity getQualifyingPurchase() { return qualifyingPurchase; }
	public void setQualifyingPurchase(QualifyingPurchaseEntity qualifyingPurchase) { this.qualifyingPurchase = qualifyingPurchase; }

	@Column(name="validation_override_reference",
			columnDefinition="VARCHAR",
			length=VALIDATION_OVERRIDE_REFERENCE_LENGTH)
	private String validationOverrideReference;
	public String getValidationOverrideReference() { return validationOverrideReference; }
	public void setValidationOverrideReference(String validationOverrideReference) { this.validationOverrideReference = validationOverrideReference; }

    @Version
    @Column(name="optimistic_lock_version", columnDefinition="INT UNSIGNED DEFAULT 0", nullable=false)
	private Integer optimisticLockVersion;
    @Override public Integer getOptimisticLockVersion() { return optimisticLockVersion; }
    @Override public void setOptimisticLockVersion(Integer optimisticLockVersion) { this.optimisticLockVersion = optimisticLockVersion; }

	@Embedded
    private RecordHistoryEmbed recordHistory;
	@Override public RecordHistoryEmbed getRecordHistory() { return recordHistory; }
	@Override public void setRecordHistory(RecordHistoryEmbed recordHistory) { this.recordHistory = recordHistory; }

	public CouponRedemptionRecordEntity() {
	}

}
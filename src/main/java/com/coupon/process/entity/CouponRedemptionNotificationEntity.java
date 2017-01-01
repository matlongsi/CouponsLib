package com.coupon.process.entity;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.OneToOne;
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
 * Entity bean implementation for CouponAcquisitionNotification
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="coupon_acquisition_notification_tbl")
public class CouponRedemptionNotificationEntity implements Serializable, Record {

	private static final long serialVersionUID = 9097200600045305397L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="coupon_acquisition_notification_tbl_id")
	private Long canId;
	public Long getId() { return canId; }
	public void setId(Long canId) { this.canId = canId; }
	
	@Embedded
	@JoinColumn(name="header_fk", referencedColumnName="header_tbl_id")
	private HeaderEmbed flowHeader;
	public HeaderEmbed getFlowHeader() { return flowHeader; }
	public void setFlowHeader(HeaderEmbed flowHeader) { this.flowHeader = flowHeader; }
	
	@OneToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="coupon_offer_fk", referencedColumnName="gcn_tbl_id")
	private GlobalCouponNumberEntity couponInstance;
	public GlobalCouponNumberEntity getCouponInstance() { return couponInstance; }
	public void setCouponInstance(GlobalCouponNumberEntity couponInstance) { this.couponInstance = couponInstance; }

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="redemption_date_time")
	private Date redemptionDateTime;
	public Date getRedemptionDateTime() { return redemptionDateTime; }
	public void setRedemptionDateTime(Date redemptionDateTime) { this.redemptionDateTime = redemptionDateTime; }

	@OneToOne(optional=true, fetch=FetchType.LAZY)
	@JoinColumn(name="account_number_fk", referencedColumnName="gsrn_tbl_id")
	private GlobalServiceRelationNumberEntity customerAccountNumber;
	public GlobalServiceRelationNumberEntity getCustomerAccountNumber() { return customerAccountNumber; }
	public void setCustomerAccountNumber(GlobalServiceRelationNumberEntity customerAccountNumber) { this.customerAccountNumber = customerAccountNumber; }

	@Column(name="customer_account_alternate_id")
    private long customerAccountAlternateId;
	public long getCustomerAccountAlternateId() { return customerAccountAlternateId; }
	public void setCustomerAccountAlternateId(long customerAccountAlternateId) { this.customerAccountAlternateId = customerAccountAlternateId; }

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
	public CouponRedemptionNotificationEntity() {
	}
	
}
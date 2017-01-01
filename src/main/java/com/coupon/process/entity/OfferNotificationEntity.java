package com.coupon.process.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
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
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.coupon.common.entity.Record;
import com.coupon.common.entity.RecordListener;
import com.coupon.common.entity.OfferEntity;
import com.coupon.common.entity.RecordHistoryEmbed;
import com.coupon.process.type.NotificationResponseType;


/**
 * Entity bean implementation for OfferNotification
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="offer_notification_tbl")
@NamedQuery(name="OfferNotificationEntity.findByOfferAndAwarderNumber",
			query="SELECT o FROM OfferNotificationEntity o "
					+ "WHERE o.offer.offerNumber = :offerNumber "
					+ "AND o.header.recipient = :awarderNumber ")
public class OfferNotificationEntity implements Serializable, Record {

	private static final long serialVersionUID = 9097200600045305397L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="offer_notification_id")
	private Long onId;
	@Override public Long getId() { return onId; }
	@Override public void setId(Long onId) { this.onId = onId; }

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cpn_tbl_fk", updatable=false)
	private OfferEntity offer;
    public OfferEntity getOffer() { return offer; }
	public void setOffer(OfferEntity offer) { this.offer = offer; }

	@Embedded
	@JoinColumn(name="header_fk", referencedColumnName="header_tbl_id")
	private HeaderEmbed header;
	public HeaderEmbed getHeader() { return header; }
	public void setHeader(HeaderEmbed header) { this.header = header; }

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="acknowledgement_date_time", columnDefinition="DATETIME DEFAULT NULL")
	private Date acknowledgementDateTime;
	public Date getAcknowledgementDateTime() { return acknowledgementDateTime; }
	public void setAcknowledgementDateTime(Date acknowledgementDateTime) { this.acknowledgementDateTime = acknowledgementDateTime; }

	@Column(name="response_code")
	@Enumerated(EnumType.STRING)
	private NotificationResponseType responseCode;
	public NotificationResponseType getResponseCode() { return responseCode; }
	public void setResponseCode(NotificationResponseType responseCode) { this.responseCode = responseCode; }

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="response_date_time")
	private Date responseDateTime;
	public Date getResponseDateTime() { return responseDateTime; }
	public void setResponseDateTime(Date responseDateTime) { this.responseDateTime = responseDateTime; }

	@Version
    @Column(name="optimistic_lock_version", columnDefinition="INT UNSIGNED DEFAULT 0", nullable=false)
    private Integer optimisticLockVersion;
	@Override public Integer getOptimisticLockVersion() { return optimisticLockVersion; }
	@Override public void setOptimisticLockVersion(Integer optimisticLockVersion) { this.optimisticLockVersion = optimisticLockVersion; }

	@Embedded
    private RecordHistoryEmbed recordHistory;
	@Override public RecordHistoryEmbed getRecordHistory() { return recordHistory; }
	@Override public void setRecordHistory(RecordHistoryEmbed recordHistory) { this.recordHistory = recordHistory; }

	public OfferNotificationEntity() {
	}
	
}

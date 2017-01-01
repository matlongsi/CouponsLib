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


/**
 * Entity implementation for OfferSetup
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="offer_setup_tbl")
@NamedQuery(name="OfferSetupEntity.findByOfferNumber",
			query="SELECT o FROM OfferSetupEntity o "
					+ "WHERE o.coupon = :coupon ")
public class OfferSetupEntity implements Serializable, Record {

	private static final long serialVersionUID = -1649354724081463844L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="offer_setup_id")
	private Long osId;
	@Override public Long getId() { return osId; }
	@Override public void setId(Long osId) { this.osId = osId; }

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cpn_tbl_fk", updatable=false)
	private OfferEntity coupon;
    public OfferEntity getCoupon() { return coupon; }
	public void setCoupon(OfferEntity coupon) { this.coupon = coupon; }

	@Embedded
	private HeaderEmbed header;
	public HeaderEmbed getHeader() { return header; }
	public void setHeader(HeaderEmbed header) { this.header = header; }

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
	public OfferSetupEntity() {
	}

}
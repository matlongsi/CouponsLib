package com.coupon.process.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.coupon.common.GlobalLocationNumber;
import com.coupon.common.entity.GlobalLocationNumberEntity;

@Embeddable
@Access(AccessType.FIELD)
public class HeaderEmbed implements Serializable {
	
	private static final long serialVersionUID = -1799032450776920553L;

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="sender_fk", referencedColumnName="gln_tbl_id")
	private GlobalLocationNumberEntity sender;
	public GlobalLocationNumber getSender() { return sender; }
	public void setSender(GlobalLocationNumber sender) { this.sender = GlobalLocationNumberEntity.class.cast(sender); }

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="recipient_fk", referencedColumnName="gln_tbl_id")
	private GlobalLocationNumberEntity recipient;
	public GlobalLocationNumber getRecipient() { return recipient; }
	public void setRecipient(GlobalLocationNumber recipient) { this.recipient = GlobalLocationNumberEntity.class.cast(recipient); }

	/**
	 * Date and time when process was initiated.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="init_date_time", columnDefinition="DATETIME DEFAULT NULL")
	private Date initDateTime;
	public Date getInitDateTime() { return initDateTime; }
	public void setInitDateTime(Date initDateTime) { this.initDateTime = initDateTime; }

	public HeaderEmbed() {
	}

}

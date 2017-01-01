package com.coupon.common.entity;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.coupon.common.TimePeriod;


/**
 * Entity bean implementation for TimePeriod
 */
@Embeddable
@Access(AccessType.FIELD)
public class TimePeriodEmbed extends TimePeriod {

	private static final long serialVersionUID = -7532393239404018099L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date_time", columnDefinition="DATETIME DEFAULT NULL")
	private Date startDateTime;
	@Override public Date getStartDateTime() { return startDateTime; }
	@Override public void setStartDateTime(Date startDateTime) { this.startDateTime.setTime(startDateTime.getTime()); }

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date_time", columnDefinition="DATETIME DEFAULT NULL")
	private Date endDateTime;
	@Override public Date getEndDateTime() { return endDateTime; }
	@Override public void setEndDateTime(Date endDateTime) { this.endDateTime.setTime(endDateTime.getTime()); }

	/**
     * Default constructor. 
     */
	public TimePeriodEmbed() {

		this.startDateTime = new Date();
		this.endDateTime = new Date();
	}

	@Override public TimePeriodEmbed init(TimePeriod tp) {

		super.init(tp);
		
		return this;
	}

}
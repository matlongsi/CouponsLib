package com.coupon.common.bean;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.TimePeriod;


/**
 * Bean implementation for TimePeriod
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("TimePeriodBean")
public class TimePeriodBean extends TimePeriod {

	private static final long serialVersionUID = -7548639703668990019L;

	@NotNull(message="startDateTime is required.")
	@Future(message="startDateTime needs to be a future date and time.")
	private Date startDateTime;
	@Override public Date getStartDateTime() { return startDateTime; }
	@Override public void setStartDateTime(Date startDateTime) { this.startDateTime.setTime(startDateTime.getTime()); }

	@NotNull(message="endDateTime is required.")
	@Future(message="endDateTime needs to be a future date and time.")
	private Date endDateTime;
	@Override public Date getEndDateTime() { return endDateTime; }
	@Override public void setEndDateTime(Date endDateTime) { this.endDateTime.setTime(endDateTime.getTime()); }

	/**
     * Default constructor. 
     */
	public TimePeriodBean() {

		this.startDateTime = new Date();
		this.endDateTime = new Date();
	}

	@Override public TimePeriodBean init(TimePeriod tp) {

		super.init(tp);
		
		return this;
	}

}
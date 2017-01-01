package com.coupon.common;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.TimePeriodBean;


/**
 * Bean abstract class for TimePeriod
 */
@XmlDiscriminatorNode("@type")
@XmlSeeAlso({TimePeriodBean.class})
public abstract class TimePeriod implements Serializable, Comparable<TimePeriod> {

	private static final long serialVersionUID = -7548639703668990019L;

	public abstract Date getEndDateTime();
	public abstract Date getStartDateTime();

	public abstract void setEndDateTime(Date endDateTime);
	public abstract void setStartDateTime(Date startDateTime);

    @Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !TimePeriod.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	TimePeriod tp = TimePeriod.class.cast(obj);
	
	    	return ((getStartDateTime() == null) ?
					(tp.getStartDateTime() == null) : getStartDateTime().equals(tp.getStartDateTime())) &&
		    		((getEndDateTime() == null) ?
					(tp.getEndDateTime() == null) : getEndDateTime().equals(tp.getEndDateTime()));
    }

    @Override public int compareTo(TimePeriod tp) {

		//ascending
	    	return ((getStartDateTime() != null) && !getStartDateTime().equals(tp.getStartDateTime())) ?
	    				getStartDateTime().compareTo(tp.getStartDateTime()) :
				(getEndDateTime() != null) ?
					getEndDateTime().compareTo(tp.getEndDateTime()) :
				(tp.getEndDateTime() == null) ? 0 : -1;
    }
    
    @Override public String toString() {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");

	    	return df.format(getStartDateTime()) + " - "
	    			+ df.format(getEndDateTime());
    }

    @Override public int hashCode() {
    	
        return (int)(31 * getStartDateTime().hashCode() + getEndDateTime().hashCode());
    }
    
    public TimePeriod init(TimePeriod tp) {

		setStartDateTime(tp.getStartDateTime());
		setEndDateTime(tp.getEndDateTime());
		
		return this;
	}

	public boolean overlaps(TimePeriod tp) {
		
		TimePeriod former = (getStartDateTime().getTime() < tp.getStartDateTime().getTime()) ? this : tp;
		TimePeriod later = (getStartDateTime().getTime() < tp.getStartDateTime().getTime()) ? tp : this;
		
		if (later.getStartDateTime().getTime() < former.getEndDateTime().getTime()) {

			return true;
		}

		return false;
	}

	public boolean encloses(TimePeriod tp) {
		
		if ((tp.getStartDateTime().getTime() >= getStartDateTime().getTime()) &&
				(tp.getEndDateTime().getTime() <= getEndDateTime().getTime())) {

			return true;
		}
		
		return false;
	}

	public boolean encloses(Date dt) {
		
		if ((dt.getTime() >= getStartDateTime().getTime()) &&
				(dt.getTime() <= getEndDateTime().getTime())) {

			return true;
		}
		
		return false;
	}

}
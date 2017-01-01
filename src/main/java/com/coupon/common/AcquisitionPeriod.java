package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.AcquisitionPeriodBean;
import com.coupon.common.init.AcquisitionPeriodInit;


/**
 * Bean abstract class for AcquisitionPeriod
 */
@XmlDiscriminatorNode("@type")
@XmlSeeAlso({AcquisitionPeriodBean.class})
public abstract class AcquisitionPeriod implements Serializable, Comparable<AcquisitionPeriod>, AcquisitionPeriodInit {

	private static final long serialVersionUID = 9126420542149970917L;

	public abstract TimePeriod getTimePeriod();
	public abstract void setTimePeriod(TimePeriod timePeriod);
	
    @Override public boolean equals(Object obj) {

		if (obj == this) {
			return true;
		}
		if ((obj == null) || !AcquisitionPeriod.class.isInstance(obj)) {
			return false;
		}
		
		AcquisitionPeriod ap = AcquisitionPeriod.class.cast(obj);
		
		return ((getTimePeriod() == null) ?
				(ap.getTimePeriod() == null) : getTimePeriod().equals(ap.getTimePeriod()));
    }

    @Override public int compareTo(AcquisitionPeriod ap) {

		//ascending
		return (getTimePeriod() != null) ?
					getTimePeriod().compareTo(ap.getTimePeriod()) :
				(ap.getTimePeriod() == null) ? 0 : -1;
    }

	@Override public AcquisitionPeriod doInit(AcquisitionPeriod ap) {

	    	ap.setTimePeriod(getTimePeriod());
	
	    	return ap;
    }

}
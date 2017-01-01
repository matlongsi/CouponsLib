package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.UsageConditionBean;
import com.coupon.common.init.UsageConditionInit;


/**
 * Bean abstract class for OfferUsageCondition
 */
@XmlSeeAlso({UsageConditionBean.class})
@XmlDiscriminatorNode("@type")
public abstract class UsageCondition implements Serializable, UsageConditionInit {

	private static final long serialVersionUID = -7113436787299916840L;

	public static final short MAX_CUMULATIVE_USE = 10000;
	public static final short MAX_USE_PER_TRANSACTION = 10000;

    public abstract Short getMaximumCumulativeUse();
	public abstract void setMaximumCumulativeUse(Short maximumCumulativeUse);

    public abstract Short getMaximumUsePerTransaction();
	public abstract void setMaximumUsePerTransaction(Short maximumUsePerTransaction);

	/**
     * Default constructor. 
     */
    public UsageCondition() {
    }

	@Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !UsageCondition.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	UsageCondition uc = UsageCondition.class.cast(obj);
	    	
	    	return ((getMaximumCumulativeUse() == null) ?
					(uc.getMaximumCumulativeUse() == null) : getMaximumCumulativeUse().equals(uc.getMaximumCumulativeUse()) &&
				(getMaximumUsePerTransaction() == null) ?
					(uc.getMaximumUsePerTransaction() == null) : getMaximumUsePerTransaction().equals(uc.getMaximumUsePerTransaction()));
    }

	@Override public UsageCondition doInit(UsageCondition uc) {

	    	uc.setMaximumCumulativeUse(getMaximumCumulativeUse());
	    	uc.setMaximumUsePerTransaction(getMaximumUsePerTransaction());
	    	
	    	return uc;
    }

}
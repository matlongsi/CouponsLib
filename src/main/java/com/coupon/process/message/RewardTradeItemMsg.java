package com.coupon.process.message;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.RewardTradeItem;
import com.coupon.common.bean.GlobalTradeIdentificationNumberBean;
import com.coupon.common.init.RewardTradeItemInit;


/**
 * Message implementation class for RewardTradeItem
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("RewardTradeItemMsg")
public class RewardTradeItemMsg extends RewardTradeItem {

	private static final long serialVersionUID = 906540110768575117L;

	private GlobalTradeIdentificationNumberBean tradeItemNumber;
    @Override public GlobalTradeIdentificationNumber getTradeItemNumber() { return tradeItemNumber; }
    @Override public void setTradeItemNumber(GlobalTradeIdentificationNumber tradeItemNumber) {
		
		this.tradeItemNumber = new GlobalTradeIdentificationNumberBean().init(tradeItemNumber);
	}

	private Short tradeItemQuantity;
	@Override public Short getTradeItemQuantity() { return tradeItemQuantity; }
	@Override public void setTradeItemQuantity(Short tradeItemQuantity) { this.tradeItemQuantity = tradeItemQuantity; }

    /**
     * Default constructor. 
     */
    public RewardTradeItemMsg() {
    }

    @Override public RewardTradeItemMsg init(RewardTradeItemInit rtii) {
    
    	rtii.dispatchInit(this);
    	
    	return this;
    }

}
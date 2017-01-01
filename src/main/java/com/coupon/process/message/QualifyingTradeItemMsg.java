package com.coupon.process.message;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.PurchaseTradeItem;
import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.init.PurchaseTradeItemInit;


/**
 * Parameter implementation class for QualifyingTradeItem
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("QualifyingTradeItemMsg")
public class QualifyingTradeItemMsg extends PurchaseTradeItem {

	private static final long serialVersionUID = -5624340637483101731L;

	private GlobalTradeIdentificationNumber tradeItemNumber;
	@Override public GlobalTradeIdentificationNumber getTradeItemNumber() { return tradeItemNumber; }
	@Override public void setTradeItemNumber(GlobalTradeIdentificationNumber tradeItemNumber) { this.tradeItemNumber = tradeItemNumber; }

	private Short tradeItemQuantity;
	@Override public Short getTradeItemQuantity() { return tradeItemQuantity; }
	@Override public void setTradeItemQuantity(Short tradeItemQuantity) { this.tradeItemQuantity = tradeItemQuantity; }

	@Size(max=PurchaseTradeItem.MAX_TRADE_ITEM_GROUP_NAME_LENGTH,
			message="tradeItemGroup needs to be " + PurchaseTradeItem.MAX_TRADE_ITEM_GROUP_NAME_LENGTH + " characters or less.")
	private String tradeItemGroup;
	@Override public String getTradeItemGroup() { return tradeItemGroup; }
	@Override public void setTradeItemGroup(String tradeItemGroup) { this.tradeItemGroup = tradeItemGroup; }

    /**
     * Default constructor. 
     */
    public QualifyingTradeItemMsg() {
    }

    @Override public QualifyingTradeItemMsg init(PurchaseTradeItemInit ptii) {
    	
    	ptii.dispatchInit(this);
    	
    	return this;
    }

}
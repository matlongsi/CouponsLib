package com.coupon.process.message;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.coupon.common.entity.GlobalLocationNumberEntity;


/**
 * Message implementation for CouponRedemptionTotal
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class CouponRedemptionTotalMessage implements Serializable {

	private static final long serialVersionUID = 9097200600045305397L;

	private GlobalLocationNumberEntity awarder;
	public GlobalLocationNumberEntity getAwarder() { return awarder; }
	public void setAwarder(GlobalLocationNumberEntity awarder) { this.awarder = awarder; }

	private float valueClaimed;
    public float getValueClaimed() { return valueClaimed; }
    public void setValueClaimed(float valueClaimed) { this.valueClaimed = valueClaimed; }

	private long countClaimed;
    public long getCountClaimed() { return countClaimed; }
    public void setCountClaimed(long countClaimed) { this.countClaimed = countClaimed; }

    private List<CouponRedemptionRecordMessage> redemptionRecords;
	public List<CouponRedemptionRecordMessage> getRedemptionRecords() { return redemptionRecords; }
	public void setRedemptionRecords(List<CouponRedemptionRecordMessage> redemptionRecords) { this.redemptionRecords = redemptionRecords; }
    
    public CouponRedemptionTotalMessage() {
	}
	
}

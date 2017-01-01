package com.coupon.process.message;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.coupon.common.entity.GlobalCouponNumberEntity;
import com.coupon.common.entity.GlobalLocationNumberEntity;
import com.coupon.common.entity.TimePeriodEmbed;


/**
 * Message implementation for CouponRedemptionReport
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class CouponRedemptionReportMessage implements Serializable {

	private static final long serialVersionUID = 9097200600045305397L;

	@NotNull @Valid
	private HeaderMsg header;
	public HeaderMsg getHeader() { return header; }
	public void setHeader(HeaderMsg header) { this.header = header; }

	private GlobalCouponNumberEntity couponOffer;
	public GlobalCouponNumberEntity getCouponInstance() { return couponOffer; }
	public void setCouponInstance(GlobalCouponNumberEntity couponOffer) { this.couponOffer = couponOffer; }

	private GlobalLocationNumberEntity awarderClearingAgent;
	public GlobalLocationNumberEntity getAwarderClearingAgent() { return awarderClearingAgent; }
	public void setAwarderClearingAgent(GlobalLocationNumberEntity awarderClearingAgent) { this.awarderClearingAgent = awarderClearingAgent; }

	private GlobalLocationNumberEntity issuer;
	public GlobalLocationNumberEntity getIssuer() { return issuer; }
	public void setIssuer(GlobalLocationNumberEntity issuer) { this.issuer = issuer; }

	private GlobalLocationNumberEntity issuerClearingAgent;
	public GlobalLocationNumberEntity getIssuerClearingAgent() { return issuerClearingAgent; }
	public void setIssuerClearingAgent(GlobalLocationNumberEntity issuerClearingAgent) { this.issuerClearingAgent = issuerClearingAgent; }

	private TimePeriodEmbed redemptionPeriod;
    public TimePeriodEmbed getRedemptionPeriod() { return redemptionPeriod; }
    public void setRedemptionPeriod(TimePeriodEmbed redemptionPeriod) { this.redemptionPeriod = redemptionPeriod; }

    private List<CouponRedemptionTotalMessage> redemptionTotals;
    public List<CouponRedemptionTotalMessage> getRedemptionTotals() { return redemptionTotals; }
    public void setRedemptionTotals(List<CouponRedemptionTotalMessage> redemptionTotals) { this.redemptionTotals = redemptionTotals; }
    
	public CouponRedemptionReportMessage() {
	}
	
}

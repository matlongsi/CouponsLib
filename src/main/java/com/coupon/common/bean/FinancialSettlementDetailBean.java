package com.coupon.common.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.FinancialSettlementDetail;
import com.coupon.common.init.FinancialSettlementDetailInit;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation class for FinancialSettlementDetail
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("FinancialSettlementDetailBean")
public class FinancialSettlementDetailBean extends FinancialSettlementDetail implements Bean, Hierarchy {

	private static final long serialVersionUID = 646346781104011948L;

	@Null(message="fsdId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="fsdId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="fsdId needs to be unsigned number of 19 digits or less.")
	private Long fsdId;
    @Override public Long getId() { return fsdId; }
	@Override public void setId(Long fsdId) { this.fsdId = fsdId; }

	@NotNull(message="offerId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="offerId needs to be unsigned number of 19 digits or less.")
	private Long offerId;
    @Override public Long getParentId() { return offerId; }
	@Override public void setParentId(Long offerId) { this.offerId = offerId; }
	
	@Size(max=MAX_CLEARING_INSTRUCTION_LENGTH,
			message="offerClearingInstruction needs to be " + MAX_CLEARING_INSTRUCTION_LENGTH + " characters or less.")
    private String offerClearingInstruction;
    @Override public String getOfferClearingInstruction() { return offerClearingInstruction; }
	@Override public void setOfferClearingInstruction(String offerClearingInstruction) { this.offerClearingInstruction = offerClearingInstruction; }

	/**
     * Default constructor. 
     */
    public FinancialSettlementDetailBean() {
    }

	@Override public FinancialSettlementDetailBean init(FinancialSettlementDetailInit fsdi) {
		
		fsdi.dispatchInit(this);

		return this;
	}

	@Override public FinancialSettlementDetail dispatchInit(FinancialSettlementDetailBean fsdb) {
		
		super.dispatchInit(fsdb);
		
		fsdb.setId(getId());
		fsdb.setParentId(getParentId());
		
		return fsdb;
	}

}
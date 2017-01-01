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

import com.coupon.common.LegalStatement;
import com.coupon.common.init.LegalStatementInit;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation for class LegalStatement
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("LegalStatementBean")
public class LegalStatementBean extends LegalStatement implements Bean, Hierarchy {

	private static final long serialVersionUID = -6827879722514020718L;

	@Null(message="lsId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="lsId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="lsId needs to be unsigned number of 19 digits or less.")
	private Long lsId;
	@Override public Long getId() { return lsId; }
	@Override public void setId(Long lsId) { this.lsId = lsId; }

	@NotNull(message="mmId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="mmId needs to be unsigned number of 19 digits or less.")
	private Long mmId;
	@Override public Long getParentId() { return mmId; }
	@Override public void setParentId(Long mmId) { this.mmId = mmId; }
	
	@NotNull(message="legalStatement is required.")
	@Size(max=MAX_STATEMENT_LENGTH,
			message="legalStatement needs to be " + MAX_STATEMENT_LENGTH + " characters or less.")
	private String legalStatement;
    @Override public String getLegalStatement() { return legalStatement; }
	@Override public void setLegalStatement(String legalStatement) { this.legalStatement = legalStatement; }

    /**
     * Default constructor. 
     */
    public LegalStatementBean() {
    }

	@Override public LegalStatementBean init(LegalStatementInit lsi) {

		lsi.dispatchInit(this);
		
		return this;
    }

	@Override public LegalStatementBean dispatchInit(LegalStatementBean lsb) {

		super.dispatchInit(lsb);

	    	lsb.setId(getId());
	    	lsb.setParentId(getParentId());
	
	    	return lsb;
    }

}
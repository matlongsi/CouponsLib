package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.LegalStatementBean;
import com.coupon.common.init.LegalStatementInit;


/**
 * Bean abstract class for OfferLegalStatement
 */
@XmlDiscriminatorNode("@type")
@XmlSeeAlso({LegalStatementBean.class})
public abstract class LegalStatement implements Serializable, Comparable<LegalStatement>, LegalStatementInit {

	private static final long serialVersionUID = -6827879722514020718L;

	public static final int MAX_STATEMENT_LENGTH = 1000;

    public abstract String getLegalStatement();
	public abstract void setLegalStatement(String legalStatement);

    /**
     * Default constructor. 
     */
    public LegalStatement() {
    }

    @Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !LegalStatement.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	LegalStatement ls = LegalStatement.class.cast(obj);
	    	
	    	return ((getLegalStatement() == null) ?
				(ls.getLegalStatement() == null) : getLegalStatement().equals(ls.getLegalStatement()));
    }

    @Override public int compareTo(LegalStatement ls) {
	
	    	//ascending
	    	return getLegalStatement().compareTo(ls.getLegalStatement());
    }

	@Override public LegalStatement doInit(LegalStatement ls) {
    	
	    	ls.setLegalStatement(getLegalStatement());
	
	    	return this;
    }

}
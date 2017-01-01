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

import com.coupon.common.FileContentDescription;
import com.coupon.common.init.FileContentDescriptionInit;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation for FileContentDescription
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("FileContentDescriptionBean")
public class FileContentDescriptionBean extends FileContentDescription implements Bean, Hierarchy {

	private static final long serialVersionUID = -7679010293370150033L;

	@Null(message="fcdId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="fcdId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="fcdId needs to be unsigned number of 19 digits or less.")
	private Long fcdId;
	@Override public Long getId() { return fcdId; }
	@Override public void setId(Long fcdId) { this.fcdId = fcdId; }

	@NotNull(message="aId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="aId needs to be unsigned number of 19 digits or less.")
	private Long aId;
	@Override public Long getParentId() { return this.aId; }
	@Override public void setParentId(Long aId) { this.aId = aId; }

	@NotNull(message="fileContentDescription is required.")
	@Size(max=MAX_DESCRIPTION_LENGTH,
			message="fileContentDescription needs to be " + MAX_DESCRIPTION_LENGTH + " characters or less.")
	private String fileContentDescription;
	@Override public String getFileContentDescription() { return fileContentDescription; }
	@Override public void setFileContentDescription(String fileContentDescription) { this.fileContentDescription = fileContentDescription; }

	/**
     * Default constructor. 
     */
    public FileContentDescriptionBean() {
    }

	@Override public FileContentDescriptionBean init(FileContentDescriptionInit fcdi) {
    	
		fcdi.dispatchInit(this);

		return this;
    }

	@Override public FileContentDescriptionBean dispatchInit(FileContentDescriptionBean fcdb) {
    	
		super.dispatchInit(fcdb);
		
		fcdb.setId(getId());
	    	fcdb.setParentId(getParentId());
	
	    	return fcdb;
    }

}
package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.FileContentDescriptionBean;
import com.coupon.common.init.FileContentDescriptionInit;


/**
 * Abstract class for FileContentDescription
 */
@XmlDiscriminatorNode("@type")
@XmlSeeAlso({FileContentDescriptionBean.class})
public abstract class FileContentDescription implements Serializable, Comparable<FileContentDescription>, FileContentDescriptionInit {

	private static final long serialVersionUID = -735847754961437462L;

	public static final int MAX_DESCRIPTION_LENGTH = 80;

	public abstract String getFileContentDescription();
	public abstract void setFileContentDescription(String fileContentDescription);
	
    @Override public boolean equals(Object obj) {

		if (obj == this) {
			return true;
		}
		if ((obj == null) || !FileContentDescription.class.isInstance(obj)) {
			return false;
		}
		
		FileContentDescription fcd = FileContentDescription.class.cast(obj);
		
		return ((getFileContentDescription() == null) ?
				(fcd.getFileContentDescription() == null) : getFileContentDescription().equals(fcd.getFileContentDescription()));
    }

    @Override public int compareTo(FileContentDescription fcd) {

		//ascending
		return (getFileContentDescription() != null) ?
					getFileContentDescription().compareTo(fcd.getFileContentDescription()) :
				(fcd.getFileContentDescription() == null) ? 0 : -1;
    }

	@Override public FileContentDescription doInit(FileContentDescription fcd) {
	
	    	fcd.setFileContentDescription(getFileContentDescription());
	
	    	return fcd;
    }

}
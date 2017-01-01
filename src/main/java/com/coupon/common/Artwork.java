package com.coupon.common;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.ArtworkBean;
import com.coupon.common.init.ArtworkInit;
import com.coupon.common.type.OfferArtworkType;
import com.coupon.common.utils.ListCompare;


/**
 * Abstract class for OfferArtwork
 */
@XmlDiscriminatorNode("@type")
@XmlSeeAlso({ArtworkBean.class})
public abstract class Artwork implements Serializable, Comparable<Artwork>, ArtworkInit {

	private static final long serialVersionUID = -1213064711773079018L;
	
	public static final int MAX_FILE_NAME_LENGTH = 100;
	public static final int MAX_FILE_FORMAT_NAME_LENGTH = 50;
	public static final int MAX_FILE_URI_LENGTH = 100;

    public abstract OfferArtworkType getArtworkType();
	public abstract void setArtworkType(OfferArtworkType artworkType);

	public abstract String getFileName();
    public abstract void setFileName(String fileName);
	
	public abstract String getFileFormatName();
	public abstract void setFileFormatName(String fileFormatName);
	
	public abstract String getFileUri();
	public abstract void setFileUri(String fileUri);
	
    public abstract List<? extends FileContentDescription> getFileContentDescriptions();
	public abstract <T extends FileContentDescription> void setFileContentDescriptions(List<T> fileContentDescriptions);

    @Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !Artwork.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	Artwork a = Artwork.class.cast(obj);
	    	
	    	return ((getArtworkType() == null) ?
					(a.getArtworkType() == null) : getArtworkType().equals(a.getArtworkType())) &&
		    		((getFileFormatName() == null) ?
					(a.getFileFormatName() == null) : getFileFormatName().equals(a.getFileFormatName())) &&
		    		((getFileName() == null) ?
					(a.getFileName() == null) : getFileName().equals(a.getFileName())) &&
		    		((getFileUri() == null) ?
					(a.getFileUri() == null) : getFileUri().equals(a.getFileUri())) &&
	    			ListCompare.<FileContentDescription>equal(getFileContentDescriptions(), a.getFileContentDescriptions());
    }

    @Override public int compareTo(Artwork a) {

	    	//ascending
	    	return ((getArtworkType() != null) && !getArtworkType().equals(a.getArtworkType())) ?
	    				getArtworkType().compareTo(a.getArtworkType()) :
	    			((getFileName() != null) && !getFileName().equals(a.getFileName())) ?
	    				getFileName().compareTo(a.getFileName()) :
	    			((getFileFormatName() != null) && !getFileFormatName().equals(a.getFileFormatName())) ?
	    				getFileFormatName().compareTo(a.getFileFormatName()) :
	    			(getFileUri() != null) ?
	    				getFileUri().compareTo(a.getFileUri()) :
	    			(a.getFileUri() == null) ? 0 : -1;
    }

	@Override public Artwork doInit(Artwork a) { 
    	
	    	a.setArtworkType(getArtworkType());
	    	a.setFileName(getFileName());
	    	a.setFileFormatName(getFileFormatName());
	    	a.setFileUri(getFileUri());
	    	a.setFileContentDescriptions(getFileContentDescriptions());
	    	
	    	return a;
    }

}
package com.coupon.common.bean;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.validation.groups.ConvertGroup;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.Artwork;
import com.coupon.common.FileContentDescription;
import com.coupon.common.init.ArtworkInit;
import com.coupon.common.type.OfferArtworkType;
import com.coupon.common.validator.ChildValidate;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation class for Artwork
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("ArtworkBean")
public class ArtworkBean extends Artwork implements Bean, Hierarchy {

	private static final long serialVersionUID = -2766217536325977458L;

	@Null(message="aId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="aId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="aId needs to be unsigned number of 19 digits or less.")
	private Long aId;
	@Override public Long getId() { return aId; }
	@Override public void setId(Long aId) { this.aId = aId; }

	@NotNull(message="mmId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="mmId needs to be unsigned number of 19 digits or less.")
	private Long mmId;
	@Override public Long getParentId() { return mmId; }
	@Override public void setParentId(Long mmId) { this.mmId = mmId; }

	@NotNull(message="artworkType is required.")
	private OfferArtworkType artworkType;
	@Override public OfferArtworkType getArtworkType() { return artworkType; }
	@Override public void setArtworkType(OfferArtworkType artworkType) { this.artworkType = artworkType; }

	@NotNull(message="fileName is required.")
    @Size(max=MAX_FILE_NAME_LENGTH,
    			message="fileName needs to be " + MAX_FILE_NAME_LENGTH + " characters or less.")
	private String fileName;
    @Override public String getFileName() { return fileName; }
	@Override public void setFileName(String fileName) { this.fileName = fileName; }

	@NotNull(message="fileFormatName is required.")
	@Size(max=MAX_FILE_FORMAT_NAME_LENGTH,
			message="fileFormatName needs to be " + MAX_FILE_FORMAT_NAME_LENGTH + " characters or less.")
    private String fileFormatName;
    @Override public String getFileFormatName() { return fileFormatName; }
    @Override public void setFileFormatName(String fileFormatName) { this.fileFormatName = fileFormatName; }

	@Size(max=MAX_FILE_URI_LENGTH,
			message="fileUri needs to be " + MAX_FILE_URI_LENGTH + " characters or less.")
	private String fileUri;
    @Override public String getFileUri() { return fileUri; }
    @Override public void setFileUri(String fileUri) { this.fileUri = fileUri; }

    @Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private List<FileContentDescriptionBean> fileContentDescriptions;
	@Override public List<FileContentDescriptionBean> getFileContentDescriptions() { return fileContentDescriptions; }
	@Override public <T extends FileContentDescription> void setFileContentDescriptions(List<T> fileContentDescriptions) {
		
		this.fileContentDescriptions = new ArrayList<FileContentDescriptionBean>();
		for (T fcd : fileContentDescriptions) {
			getFileContentDescriptions().add(new FileContentDescriptionBean().init(fcd));
    		}
	}

    /**
     * Default constructor. 
     */
    public ArtworkBean() {
    }

    @Override public ArtworkBean init(ArtworkInit ai) {

	    	ai.dispatchInit(this);
	    	
	    	return this;
    }

	@Override public ArtworkBean dispatchInit(ArtworkBean ab) { 

		super.dispatchInit(ab);

	    	ab.setId(getId());
	    	ab.setParentId(getParentId());
	    	
	    	return ab;
    }

}
package com.coupon.common.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.coupon.common.Artwork;
import com.coupon.common.FileContentDescription;
import com.coupon.common.bean.ArtworkBean;
import com.coupon.common.bean.Bean;
import com.coupon.common.init.ArtworkInit;
import com.coupon.common.type.OfferArtworkType;


/**
 * Entity implementation for class OfferArtwork
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name = "offer_artwork_tbl")
public class ArtworkEntity extends Artwork implements Record {

	private static final long serialVersionUID = 111957906025493943L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="oa_tbl_id", columnDefinition="BIGINT UNSIGNED", nullable=false)
	private Long aId;
	@Override public Long getId() { return aId; }
	@Override public void setId(Long aId) { this.aId = aId; }

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="omm_tbl_fk", updatable=false, nullable=false)
	private MarketingMaterialEntity marketingMaterial;
    public MarketingMaterialEntity getMarketingMaterial() { return marketingMaterial; }
    public void setMarketingMaterial(MarketingMaterialEntity marketingMaterial) { this.marketingMaterial = marketingMaterial; }

	@Column(name="type_code", columnDefinition="ENUM('PRODUCT_IMAGE', 'OFFER_VIDEO', 'OFFER_LEAFLET')", nullable=false)
    @Enumerated(EnumType.STRING)
	private OfferArtworkType artworkType;
	@Override public OfferArtworkType getArtworkType() { return artworkType; }
	@Override public void setArtworkType(OfferArtworkType artworkType) { this.artworkType = artworkType; }

	@Column(name="file_name", columnDefinition="VARCHAR", length=MAX_FILE_NAME_LENGTH, nullable=false)
	private String fileName;
	@Override public String getFileName() { return fileName; }
	@Override public void setFileName(String fileName) { this.fileName = fileName; }

    @Column(name="file_format_name", columnDefinition="VARCHAR", length=MAX_FILE_FORMAT_NAME_LENGTH, nullable=false)
    private String fileFormatName;
    @Override public String getFileFormatName() { return fileFormatName; }
    @Override public void setFileFormatName(String fileFormatName) { this.fileFormatName = fileFormatName; }
    
    @Column(name="file_uri", columnDefinition="VARCHAR DEFAULT NULL", length=MAX_FILE_URI_LENGTH)
	private String fileUri;
    @Override public String getFileUri() { return fileUri; }
    @Override public void setFileUri(String fileUri) { this.fileUri = fileUri; }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="artwork", cascade=CascadeType.ALL)
	@MapKey(name="fcdId")
	private Map<Long, FileContentDescriptionEntity> fileContentDescriptionsMap;
	public Map<Long, FileContentDescriptionEntity> getFileContentDescriptionsMap() { return fileContentDescriptionsMap; }
    public void setFileContentDescriptionsMap(Map<Long, FileContentDescriptionEntity> fileContentDescriptionsMap) { this.fileContentDescriptionsMap = fileContentDescriptionsMap; }
	
    @Override public List<FileContentDescriptionEntity> getFileContentDescriptions() {

    		return (getFileContentDescriptionsMap() == null) ?
    				null : new ArrayList<FileContentDescriptionEntity>(getFileContentDescriptionsMap().values());
    }

	@Override public <T extends FileContentDescription> void setFileContentDescriptions(List<T> fileContentDescriptions) {
    	
		for (T fcd : fileContentDescriptions) {
			if (getFileContentDescriptionsMap().containsKey(Bean.class.cast(fcd).getId())) {
				getFileContentDescriptionsMap().get(Bean.class.cast(fcd).getId()).init(fcd);
			}
		}
	}

	@Version
    @Column(name="optimistic_lock_version", columnDefinition="INT UNSIGNED DEFAULT 0", nullable=false)
	private Integer optimisticLockVersion;
    @Override public Integer getOptimisticLockVersion() { return optimisticLockVersion; }
    @Override public void setOptimisticLockVersion(Integer optimisticLockVersion) { this.optimisticLockVersion = optimisticLockVersion; }
    
    @Embedded
    private RecordHistoryEmbed recordHistory;
    @Override public RecordHistoryEmbed getRecordHistory() { return recordHistory; }
    @Override public void setRecordHistory(RecordHistoryEmbed recordHistory) { this.recordHistory = recordHistory; }

	/**
     * Default constructor. 
     */
    public ArtworkEntity() {
    }

    @Override public ArtworkEntity init(ArtworkInit ai) {

	    	ai.dispatchInit(this);
	    	
	    	return this;
    }

	@Override public ArtworkBean dispatchInit(ArtworkBean ab) { 

		super.dispatchInit(ab);
			
	    	ab.setId(getId());
	    	ab.setParentId(getMarketingMaterial().getId());
	    	
	    	return ab;
    }

}
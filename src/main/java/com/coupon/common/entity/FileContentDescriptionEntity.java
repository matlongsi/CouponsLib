package com.coupon.common.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.coupon.common.FileContentDescription;
import com.coupon.common.bean.FileContentDescriptionBean;
import com.coupon.common.init.FileContentDescriptionInit;


/**
 * Entity bean implementation for FileContentDescription
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="file_content_description_tbl")
public class FileContentDescriptionEntity extends FileContentDescription implements Record {

	private static final long serialVersionUID = -2725795174879529223L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="fcd_tbl_id")
	private Long fcdId;
	@Override public Long getId() { return fcdId; }
	@Override public void setId(Long fcdId) { this.fcdId = fcdId; }

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="oa_tbl_fk", updatable=false, nullable=false)
	private ArtworkEntity artwork;
	public ArtworkEntity getArtwork() { return artwork; }
	public void setArtwork(ArtworkEntity artwork) { this.artwork = artwork; }

	@Column(name="file_content_description", columnDefinition="VARCHAR", length=MAX_DESCRIPTION_LENGTH, nullable=false)
	private String fileContentDescription;
	@Override public String getFileContentDescription() { return fileContentDescription; }
	@Override public void setFileContentDescription(String fileContentDescription) { this.fileContentDescription = fileContentDescription; }

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
    public FileContentDescriptionEntity() {
    }

    @Override public FileContentDescriptionEntity init(FileContentDescriptionInit fcdi) {
    	
	    	fcdi.dispatchInit(this);
	    	
	    	return this;
    }

    @Override public FileContentDescriptionBean dispatchInit(FileContentDescriptionBean fcdb) {
    	
		super.dispatchInit(fcdb);
		
		fcdb.setId(getId());
	    	fcdb.setParentId(getArtwork().getId());
	
	    	return fcdb;
    }

}
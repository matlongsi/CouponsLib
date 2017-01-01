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

import com.coupon.common.ProductCategory;
import com.coupon.common.bean.ProductCategoryBean;
import com.coupon.common.init.ProductCategoryInit;


/**
 * Session Bean implementation class City
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="offer_product_category_tbl")
public class ProductCategoryEntity extends ProductCategory implements Record {

	private static final long serialVersionUID = -6645022457136174702L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="opc_tbl_id", columnDefinition="BIGINT UNSIGNED")
	private Long pcId;
	@Override public Long getId() { return pcId; }
	@Override public void setId(Long pcId) { this.pcId = pcId; }

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="omm_tbl_fk", updatable=false, nullable=false)
	private MarketingMaterialEntity marketingMaterial;
	public MarketingMaterialEntity getMarketingMaterial() { return marketingMaterial; }
	public void setMarketingMaterial(MarketingMaterialEntity marketingMaterial) { this.marketingMaterial = marketingMaterial; }

	@Column(name="product_category", columnDefinition="VARCHAR", length=MAX_NAME_LENGTH, nullable=false)
	private String categoryName;
	@Override public String getCategoryName() { return categoryName; }
	@Override public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

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
    public ProductCategoryEntity() {

    	setMarketingMaterial(new MarketingMaterialEntity());
    }

    @Override public ProductCategoryEntity init(ProductCategoryInit pci) {
    	
	    	pci.dispatchInit(this);
	    	
	    	return this;
    }

	@Override public ProductCategoryBean dispatchInit(ProductCategoryBean pcb) {

		super.dispatchInit(pcb);

	    	pcb.setId(getId());
	    	pcb.setParentId(getMarketingMaterial().getId());
	    	
	    	return pcb;    	
    }

}
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
import javax.persistence.MapKey;
import javax.persistence.MapKeyClass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.PurchaseRequirement;
import com.coupon.common.PurchaseTradeItem;
import com.coupon.common.bean.PurchaseRequirementBean;
import com.coupon.common.entity.PurchaseTradeItemEntity;
import com.coupon.common.init.PurchaseRequirementInit;
import com.coupon.common.type.PurchaseRequirementType;

/**
 * Entity bean implementation for PurchaseRequirement
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="purchase_requirement_tbl")
public class PurchaseRequirementEntity extends PurchaseRequirement implements Record {

	private static final long serialVersionUID = -7501657805494663944L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pr_tbl_id")
	private Long prId;
    @Override public Long getId() { return prId; }
	@Override public void setId(Long prId) { this.prId = prId; }

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cpn_tbl_fk", updatable=false, nullable=false)
	private OfferEntity offer;
    public OfferEntity getOffer() { return offer; }
	public void setOffer(OfferEntity offer) { this.offer = offer; }

	@OneToMany(fetch=FetchType.LAZY, mappedBy="purchaseRequirement", cascade=CascadeType.ALL)
	@OrderBy(value="tradeItemGroup ASC, tradeItemQuantity DESC")
	@MapKey(name="tradeItemNumber")
	@MapKeyClass(GlobalTradeIdentificationNumber.class)
	private Map<GlobalTradeIdentificationNumber, PurchaseTradeItemEntity> purchaseTradeItemsMap;
	public Map<GlobalTradeIdentificationNumber, PurchaseTradeItemEntity> getPurchaseTradeItemsMap() { return purchaseTradeItemsMap; }
	public void setPurchaseTradeItemsMap(Map<GlobalTradeIdentificationNumber, PurchaseTradeItemEntity> purchaseTradeItemsMap) { this.purchaseTradeItemsMap = purchaseTradeItemsMap; }

	@Override public List<PurchaseTradeItemEntity> getPurchaseTradeItems() {
		
		return (getPurchaseTradeItemsMap() == null) ?
				null : new ArrayList<PurchaseTradeItemEntity>(getPurchaseTradeItemsMap().values());
	}

	@Override public <T extends PurchaseTradeItem> void setPurchaseTradeItems(List<T> purchaseTradeItems) {

		for (T pti : purchaseTradeItems) {
			if (getPurchaseTradeItemsMap().containsKey(pti.getTradeItemNumber())) {
				getPurchaseTradeItemsMap().get(pti.getTradeItemNumber()).init(pti);
			}
		}
	}
	
	@Column(name="purchase_requirement_type_code")
	@Enumerated(EnumType.STRING)
	private PurchaseRequirementType purchaseRequirementType;
	@Override public PurchaseRequirementType getPurchaseRequirementType() { return purchaseRequirementType; }
	@Override public void setPurchaseRequirementType(PurchaseRequirementType purchaseRequirementType) { this.purchaseRequirementType = purchaseRequirementType; }

	@Column(name="purchase_requirement_monetary_amount", columnDefinition="DECIMAL(10, 2)")
	private Float purchaseMonetaryAmount;
	@Override public Float getPurchaseMonetaryAmount() { return purchaseMonetaryAmount; }
	@Override public void setPurchaseMonetaryAmount(Float purchaseMonetaryAmount) { this.purchaseMonetaryAmount = purchaseMonetaryAmount; }

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
    public PurchaseRequirementEntity() {
    }

    @Override public PurchaseRequirementEntity init(PurchaseRequirementInit pri) {
    	
	    	pri.dispatchInit(this);
	    	
	    	return this;
    }

	@Override public PurchaseRequirementBean dispatchInit(PurchaseRequirementBean prb) {

		super.dispatchInit(prb);

	    	prb.setId(getId());
	    	prb.setParentId(getOffer().getId());
	    	
	    	return prb;
	}

}
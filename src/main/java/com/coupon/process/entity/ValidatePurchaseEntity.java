package com.coupon.process.entity;

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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.Purchase;
import com.coupon.common.PurchaseTradeItem;
import com.coupon.common.entity.Record;
import com.coupon.common.entity.RecordListener;
import com.coupon.common.entity.RecordHistoryEmbed;


/**
 * Entity bean implementation for ValidatePurchase
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="validate_purchase_tbl")
public class ValidatePurchaseEntity extends Purchase implements Record {

	private static final long serialVersionUID = -7501657805494663944L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="vp_tbl_id")
	private Long vpId;
    @Override public Long getId() { return vpId; }
    @Override public void setId(Long vpId) { this.vpId = vpId; }

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vrr_tbl_fk", updatable=false, nullable=false)
	private ValidateRedemptionRecordEntity validateRedemptionRecord;
    public ValidateRedemptionRecordEntity getValidateRedemptionRecord() { return validateRedemptionRecord; }
	public void setValidateRedemptionRecord(ValidateRedemptionRecordEntity validateRedemptionRecord) { this.validateRedemptionRecord = validateRedemptionRecord; }

	@OneToMany(fetch=FetchType.LAZY, mappedBy="validatePurchase", cascade=CascadeType.ALL)
	@OrderBy(value="tradeItemQuantity DESC")
	@MapKey(name="tradeItemNumber")
	private Map<GlobalTradeIdentificationNumber, ValidatePurchaseTradeItemEntity> purchaseTradeItemsMap;
	public Map<GlobalTradeIdentificationNumber, ValidatePurchaseTradeItemEntity> getPurchaseTradeItemsMap() { return purchaseTradeItemsMap; }
	public void setPurchaseTradeItemsMap(Map<GlobalTradeIdentificationNumber, ValidatePurchaseTradeItemEntity> purchaseTradeItemsMap) { this.purchaseTradeItemsMap = purchaseTradeItemsMap; }

	@Override public List<ValidatePurchaseTradeItemEntity> getPurchaseTradeItems() {
		
		return new ArrayList<ValidatePurchaseTradeItemEntity>((getPurchaseTradeItemsMap() == null) ? null : getPurchaseTradeItemsMap().values());
	}

	@Override public <T extends PurchaseTradeItem> void setPurchaseTradeItems(List<T> purchaseTradeItems) {

		for (T pti : purchaseTradeItems) {

			if (getPurchaseTradeItemsMap().containsKey(pti.getTradeItemNumber())) {
				
				getPurchaseTradeItemsMap().get(pti.getTradeItemNumber()).init(pti);
			}
		}
	}
	
	@Column(name="purchase_monetary_amount", columnDefinition="DECIMAL(10, 2)")
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
    public ValidatePurchaseEntity() {
    }

}
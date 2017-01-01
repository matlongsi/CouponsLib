package com.coupon.process.entity;

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

import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.PurchaseTradeItem;
import com.coupon.common.entity.Record;
import com.coupon.common.entity.RecordListener;
import com.coupon.common.entity.GlobalTradeIdentificationNumberEntity;
import com.coupon.common.entity.RecordHistoryEmbed;
import com.coupon.common.init.PurchaseTradeItemInit;


/**
 * Entity bean implementation for QualifyingPurchaseTradeItem
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="qualifying_purchase_trade_item_tbl")
public class QualifyingPurchaseTradeItemEntity extends PurchaseTradeItem implements Record {

	private static final long serialVersionUID = 8176226641345450465L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="qpti_tbl_id")
	private Long qptiId;
	@Override public Long getId() { return qptiId; }
	@Override public void setId(Long qptiId) { this.qptiId = qptiId; }

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="qp_tbl_fk", updatable=false, nullable=false)
	private QualifyingPurchaseEntity qualifyingPurchase;
    public QualifyingPurchaseEntity getQualifyingPurchase() { return qualifyingPurchase; }
	public void setQualifyingPurchase(QualifyingPurchaseEntity qualifyingPurchase) { this.qualifyingPurchase = qualifyingPurchase; }

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="trade_item_gtin_fk", referencedColumnName="gtin_tbl_id")
	private GlobalTradeIdentificationNumberEntity tradeItemNumber;
	@Override public GlobalTradeIdentificationNumber getTradeItemNumber() { return tradeItemNumber; }
	@Override public void setTradeItemNumber(GlobalTradeIdentificationNumber tradeItemNumber) {
		
		this.tradeItemNumber = GlobalTradeIdentificationNumberEntity.class.cast(tradeItemNumber);
	}

	@Column(name="trade_item_quantity", columnDefinition="INT UNSIGNED", nullable=false)
	private Short tradeItemQuantity;
	@Override public Short getTradeItemQuantity() { return tradeItemQuantity; }
	@Override public void setTradeItemQuantity(Short tradeItemQuantity) { this.tradeItemQuantity = tradeItemQuantity; }

	@Column(name="trade_item_group",
			columnDefinition="VARCHAR",
			length=PurchaseTradeItem.MAX_TRADE_ITEM_GROUP_NAME_LENGTH,
			nullable=false)
	private String tradeItemGroup;
	@Override public String getTradeItemGroup() { return tradeItemGroup; }
	@Override public void setTradeItemGroup(String tradeItemGroup) { this.tradeItemGroup = tradeItemGroup; }

    @Version
    @Column(name="optimistic_lock_version", columnDefinition="INT UNSIGNED DEFAULT 0", nullable=false)
    private Integer optimisticLockVersion;
    public Integer getOptimisticLockVersion() { return optimisticLockVersion; }
	public void setOptimisticLockVersion(Integer optimisticLockVersion) { this.optimisticLockVersion = optimisticLockVersion; }

    @Embedded
    private RecordHistoryEmbed recordHistory;
	public RecordHistoryEmbed getRecordHistory() { return recordHistory; }
	public void setRecordHistory(RecordHistoryEmbed recordHistory) { this.recordHistory = recordHistory; }

	/**
     * Default constructor. 
     */
    public QualifyingPurchaseTradeItemEntity() {
    }

    @Override public QualifyingPurchaseTradeItemEntity init(PurchaseTradeItemInit ptii) {
    	
    	ptii.dispatchInit(this);
    	
    	return this;
    }

}
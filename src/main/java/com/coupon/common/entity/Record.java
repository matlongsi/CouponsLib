package com.coupon.common.entity;

import com.coupon.common.bean.Bean;


/**
 * Interface for entity record
 */
public interface Record extends Bean {

	public RecordHistoryEmbed getRecordHistory();
	public void setRecordHistory(RecordHistoryEmbed recordHistory);

    public Integer getOptimisticLockVersion();
    public void setOptimisticLockVersion(Integer optimisticLockVersion);

}
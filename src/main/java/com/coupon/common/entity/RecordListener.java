package com.coupon.common.entity;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


public class RecordListener {

    @PrePersist
    public void setInsertStamp(Record be) {

	    	be.setRecordHistory(new RecordHistoryEmbed());
	    	be.getRecordHistory().setStampInsert(new Date());
    }

    @PreUpdate
    public void setStampUpdate(Record be) {
    	
    		be.getRecordHistory().setStampUpdate(new Date());
    }

}

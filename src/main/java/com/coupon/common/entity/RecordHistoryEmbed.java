package com.coupon.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
@Access(AccessType.FIELD)
public class RecordHistoryEmbed implements Serializable {

	private static final long serialVersionUID = 2953431103143984784L;

    @Column(name="stamp_insert", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", updatable=false)
	private Date stampInsert;
	public Date getStampInsert() { return stampInsert; }
	public void setStampInsert(Date stampInsert) { this.stampInsert = stampInsert; }

	@Column(name="stamp_update", columnDefinition="DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP", insertable=false)
	private Date stampUpdate;
	public Date getStampUpdate() { return stampUpdate; }
	public void setStampUpdate(Date stampUpdate) { this.stampUpdate = stampUpdate; }

    public RecordHistoryEmbed() {
    }

}

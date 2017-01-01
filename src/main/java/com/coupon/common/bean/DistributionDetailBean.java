package com.coupon.common.bean;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.ConvertGroup;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.AcquisitionPeriod;
import com.coupon.common.DistributionDetail;
import com.coupon.common.PublicationPeriod;
import com.coupon.common.init.DistributionDetailInit;
import com.coupon.common.validator.ChildValidate;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation class for DistributionDetail
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("DistributionDetailBean")
public class DistributionDetailBean extends DistributionDetail implements Bean, Hierarchy {

	private static final long serialVersionUID = 5811491420809211428L;

	@Null(message="ddId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="ddId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="ddId needs to be unsigned number of 19 digits or less.")
	private Long ddId;
    @Override public Long getId() { return ddId; }
    @Override public void setId(Long ddId) { this.ddId = ddId; }

	@NotNull(message="offerId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="offerId needs to be unsigned number of 19 digits or less.")
	private Long offerId;
    @Override public Long getParentId() { return offerId; }
    @Override public void setParentId(Long offerId) { this.offerId = offerId; }

	@NotNull(message="publicationPeriod is required.")
    @Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private PublicationPeriodBean publicationPeriod;
    @Override public PublicationPeriodBean getPublicationPeriod() { return publicationPeriod; }
    @Override public void setPublicationPeriod(PublicationPeriod publicationPeriod) {

    		this.publicationPeriod = (publicationPeriod == null) ?
    				null : new PublicationPeriodBean().init(publicationPeriod);
    }

    @Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
    private List<AcquisitionPeriodBean> acquisitionPeriods;
    @Override public List<AcquisitionPeriodBean> getAcquisitionPeriods() { return acquisitionPeriods; }
    @Override public <T extends AcquisitionPeriod> void setAcquisitionPeriods(List<T> acquisitionPeriods) {

		this.acquisitionPeriods = new ArrayList<AcquisitionPeriodBean>();
		for (T ap : acquisitionPeriods) {
			this.acquisitionPeriods.add(new AcquisitionPeriodBean().init(ap));
    		}
	}

    @Number(digits=10, optional=true, message="maximumOfferAcquisition needs to be unsigned number of 10 digits or less.")
    private Long maximumOfferAcquisition;
    @Override public Long getMaximumOfferAcquisition() { return maximumOfferAcquisition; }
    @Override public void setMaximumOfferAcquisition(Long maximumOfferAcquisition) { this.maximumOfferAcquisition = maximumOfferAcquisition; }

    @Number(digits=10, optional=true, message="totalAcquisitionCount needs to be unsigned number of 10 digits or less.")
    private Long totalAcquisitionCount;
	@Override public Long getTotalAcquisitionCount() { return totalAcquisitionCount; }
	@Override public void setTotalAcquisitionCount(Long totalAcquisitionCount) { this.totalAcquisitionCount = totalAcquisitionCount; }

    /**
     * Default constructor.
     */
    public DistributionDetailBean() {
    }

	@Override public DistributionDetailBean init(DistributionDetailInit ddi) {

		ddi.dispatchInit(this);

		return this;
	}
	
	@Override public DistributionDetailBean dispatchInit(DistributionDetailBean ddb) {

		super.dispatchInit(ddb);

		ddb.setId(getId());
		ddb.setParentId(getParentId());

		return ddb;
    }

}
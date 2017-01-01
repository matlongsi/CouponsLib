package com.coupon.process.entity;

import com.coupon.common.entity.GlobalLocationNumberEntity;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HeaderEmbed.class)
public abstract class HeaderEmbed_ {

	public static volatile SingularAttribute<HeaderEmbed, Date> initDateTime;
	public static volatile SingularAttribute<HeaderEmbed, GlobalLocationNumberEntity> sender;
	public static volatile SingularAttribute<HeaderEmbed, GlobalLocationNumberEntity> recipient;

}


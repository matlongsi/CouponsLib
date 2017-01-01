package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FileContentDescriptionEntity.class)
public abstract class FileContentDescriptionEntity_ {

	public static volatile SingularAttribute<FileContentDescriptionEntity, String> fileContentDescription;
	public static volatile SingularAttribute<FileContentDescriptionEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<FileContentDescriptionEntity, Long> fcdId;
	public static volatile SingularAttribute<FileContentDescriptionEntity, ArtworkEntity> artwork;
	public static volatile SingularAttribute<FileContentDescriptionEntity, RecordHistoryEmbed> recordHistory;

}


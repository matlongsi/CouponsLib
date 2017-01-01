package com.coupon.common.entity;

import com.coupon.common.type.OfferArtworkType;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtworkEntity.class)
public abstract class ArtworkEntity_ {

	public static volatile MapAttribute<ArtworkEntity, Long, FileContentDescriptionEntity> fileContentDescriptionsMap;
	public static volatile SingularAttribute<ArtworkEntity, String> fileName;
	public static volatile SingularAttribute<ArtworkEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<ArtworkEntity, String> fileUri;
	public static volatile SingularAttribute<ArtworkEntity, MarketingMaterialEntity> marketingMaterial;
	public static volatile SingularAttribute<ArtworkEntity, String> fileFormatName;
	public static volatile SingularAttribute<ArtworkEntity, OfferArtworkType> artworkType;
	public static volatile SingularAttribute<ArtworkEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<ArtworkEntity, Long> aId;

}


package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.LegalEntity;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.consolidated.shared.EntityId;
import fpml.consolidated.shared.EntityName;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapLegalEntity.MapLegalEntityDefault.class)
public abstract class MapLegalEntity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEntityIdentifier mapEntityIdentifier;
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlLegalEntity 
	* @return legalEntity 
	*/
	public LegalEntity evaluate(fpml.consolidated.shared.LegalEntity fpmlLegalEntity) {
		LegalEntity.LegalEntityBuilder legalEntityBuilder = doEvaluate(fpmlLegalEntity);
		
		final LegalEntity legalEntity;
		if (legalEntityBuilder == null) {
			legalEntity = null;
		} else {
			legalEntity = legalEntityBuilder.build();
			objectValidator.validate(LegalEntity.class, legalEntity);
		}
		
		return legalEntity;
	}

	protected abstract LegalEntity.LegalEntityBuilder doEvaluate(fpml.consolidated.shared.LegalEntity fpmlLegalEntity);

	protected abstract MapperC<? extends FieldWithMetaString> entityIdFromLegalEntity(fpml.consolidated.shared.LegalEntity fpmlLegalEntity);

	public static class MapLegalEntityDefault extends MapLegalEntity {
		@Override
		protected LegalEntity.LegalEntityBuilder doEvaluate(fpml.consolidated.shared.LegalEntity fpmlLegalEntity) {
			LegalEntity.LegalEntityBuilder legalEntity = LegalEntity.builder();
			return assignOutput(legalEntity, fpmlLegalEntity);
		}
		
		protected LegalEntity.LegalEntityBuilder assignOutput(LegalEntity.LegalEntityBuilder legalEntity, fpml.consolidated.shared.LegalEntity fpmlLegalEntity) {
			legalEntity = toBuilder(LegalEntity.builder()
				.setEntityId(new ArrayList<>(entityIdFromLegalEntity(fpmlLegalEntity).getMulti()))
				.setName(MapperS.of(fpmlLegalEntity).<EntityName>map("getEntityName", _legalEntity -> _legalEntity.getEntityName())
					.mapSingleToItem(item -> MapperS.of(mapStringWithScheme.evaluate(item.<String>map("getValue", entityName -> entityName.getValue()).get(), item.<String>map("getEntityNameScheme", entityName -> entityName.getEntityNameScheme()).get()))).get())
				.setEntityIdentifier(new ArrayList(mapEntityIdentifier.evaluate(fpmlLegalEntity)))
				.build(), () -> LegalEntity.builder());
			
			legalEntity
				.getOrCreateMeta().setExternalKey(MapperS.of(fpmlLegalEntity).<String>map("getId", _legalEntity -> _legalEntity.getId()).get());
			
			return Optional.ofNullable(legalEntity)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaString> entityIdFromLegalEntity(fpml.consolidated.shared.LegalEntity fpmlLegalEntity) {
			return MapperS.of(fpmlLegalEntity).<EntityId>mapC("getEntityId", legalEntity -> legalEntity.getEntityId())
				.mapItem(item -> MapperS.of(mapStringWithScheme.evaluate(item.<String>map("getValue", entityId -> entityId.getValue()).get(), item.<String>map("getEntityIdScheme", entityId -> entityId.getEntityIdScheme()).get())));
		}
	}
}

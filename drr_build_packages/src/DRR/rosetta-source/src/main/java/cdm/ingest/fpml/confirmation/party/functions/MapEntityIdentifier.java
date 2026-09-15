package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.EntityIdentifier;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.EntityId;
import fpml.consolidated.shared.LegalEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapEntityIdentifier.MapEntityIdentifierDefault.class)
public abstract class MapEntityIdentifier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEntityIdentifierTypeEnum mapEntityIdentifierTypeEnum;
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlLegalEntity 
	* @return entityIdentifier 
	*/
	public List<? extends EntityIdentifier> evaluate(LegalEntity fpmlLegalEntity) {
		List<EntityIdentifier.EntityIdentifierBuilder> entityIdentifierBuilder = doEvaluate(fpmlLegalEntity);
		
		final List<? extends EntityIdentifier> entityIdentifier;
		if (entityIdentifierBuilder == null) {
			entityIdentifier = null;
		} else {
			entityIdentifier = entityIdentifierBuilder.stream().map(EntityIdentifier::build).collect(Collectors.toList());
			objectValidator.validate(EntityIdentifier.class, entityIdentifier);
		}
		
		return entityIdentifier;
	}

	protected abstract List<EntityIdentifier.EntityIdentifierBuilder> doEvaluate(LegalEntity fpmlLegalEntity);

	public static class MapEntityIdentifierDefault extends MapEntityIdentifier {
		@Override
		protected List<EntityIdentifier.EntityIdentifierBuilder> doEvaluate(LegalEntity fpmlLegalEntity) {
			List<EntityIdentifier.EntityIdentifierBuilder> entityIdentifier = new ArrayList<>();
			return assignOutput(entityIdentifier, fpmlLegalEntity);
		}
		
		protected List<EntityIdentifier.EntityIdentifierBuilder> assignOutput(List<EntityIdentifier.EntityIdentifierBuilder> entityIdentifier, LegalEntity fpmlLegalEntity) {
			entityIdentifier.addAll(toBuilder(MapperS.of(fpmlLegalEntity).<EntityId>mapC("getEntityId", legalEntity -> legalEntity.getEntityId())
				.mapItem(item -> MapperS.of(EntityIdentifier.builder()
					.setIdentifier(mapStringWithScheme.evaluate(item.<String>map("getValue", entityId -> entityId.getValue()).get(), item.<String>map("getEntityIdScheme", entityId -> entityId.getEntityIdScheme()).get()))
					.setIdentifierType(mapEntityIdentifierTypeEnum.evaluate(item.<String>map("getEntityIdScheme", entityId -> entityId.getEntityIdScheme()).get()))
					.build())).getMulti()));
			
			return Optional.ofNullable(entityIdentifier)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.base.staticdata.party.EntityTypeEnum;
import cdm.ingest.fpml.confirmation.party.functions.MapLegalEntity;
import cdm.product.asset.ReferencePair;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.EntityType;
import fpml.consolidated.cd.ReferenceObligation;
import fpml.consolidated.shared.LegalEntity;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReferencePair.MapReferencePairDefault.class)
public abstract class MapReferencePair implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapReferenceObligation mapReferenceObligation;

	/**
	* @param fpmlReferencePair 
	* @return referencePair 
	*/
	public ReferencePair evaluate(fpml.consolidated.cd.ReferencePair fpmlReferencePair) {
		ReferencePair.ReferencePairBuilder referencePairBuilder = doEvaluate(fpmlReferencePair);
		
		final ReferencePair referencePair;
		if (referencePairBuilder == null) {
			referencePair = null;
		} else {
			referencePair = referencePairBuilder.build();
			objectValidator.validate(ReferencePair.class, referencePair);
		}
		
		return referencePair;
	}

	protected abstract ReferencePair.ReferencePairBuilder doEvaluate(fpml.consolidated.cd.ReferencePair fpmlReferencePair);

	public static class MapReferencePairDefault extends MapReferencePair {
		@Override
		protected ReferencePair.ReferencePairBuilder doEvaluate(fpml.consolidated.cd.ReferencePair fpmlReferencePair) {
			ReferencePair.ReferencePairBuilder referencePair = ReferencePair.builder();
			return assignOutput(referencePair, fpmlReferencePair);
		}
		
		protected ReferencePair.ReferencePairBuilder assignOutput(ReferencePair.ReferencePairBuilder referencePair, fpml.consolidated.cd.ReferencePair fpmlReferencePair) {
			referencePair = toBuilder(ReferencePair.builder()
				.setReferenceEntity(mapLegalEntity.evaluate(MapperS.of(fpmlReferencePair).<LegalEntity>map("getReferenceEntity", _referencePair -> _referencePair.getReferenceEntity()).get()))
				.setReferenceObligation(mapReferenceObligation.evaluate(MapperS.of(fpmlReferencePair).<ReferenceObligation>map("getReferenceObligation", _referencePair -> _referencePair.getReferenceObligation()).get()))
				.setNoReferenceObligation(MapperS.of(fpmlReferencePair).<Boolean>map("getNoReferenceObligation", _referencePair -> _referencePair.getNoReferenceObligation()).get())
				.setEntityTypeValue(MapperS.of(fpmlReferencePair).<EntityType>map("getEntityType", _referencePair -> _referencePair.getEntityType()).<String>map("getValue", entityType -> entityType.getValue()).checkedMap("to-enum", EntityTypeEnum::fromDisplayName, IllegalArgumentException.class).get())
				.build(), () -> ReferencePair.builder());
			
			referencePair
				.getOrCreateEntityType()
				.getOrCreateMeta().setScheme(MapperS.of(fpmlReferencePair).<EntityType>map("getEntityType", _referencePair -> _referencePair.getEntityType()).<String>map("getEntityTypeScheme", entityType -> entityType.getEntityTypeScheme()).get());
			
			return Optional.ofNullable(referencePair)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

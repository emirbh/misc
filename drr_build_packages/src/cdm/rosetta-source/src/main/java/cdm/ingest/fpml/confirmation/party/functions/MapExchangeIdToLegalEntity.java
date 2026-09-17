package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.LegalEntity;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.ExchangeId;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapExchangeIdToLegalEntity.MapExchangeIdToLegalEntityDefault.class)
public abstract class MapExchangeIdToLegalEntity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlExchangeId 
	* @return legalEntity 
	*/
	public LegalEntity evaluate(ExchangeId fpmlExchangeId) {
		LegalEntity.LegalEntityBuilder legalEntityBuilder = doEvaluate(fpmlExchangeId);
		
		final LegalEntity legalEntity;
		if (legalEntityBuilder == null) {
			legalEntity = null;
		} else {
			legalEntity = legalEntityBuilder.build();
			objectValidator.validate(LegalEntity.class, legalEntity);
		}
		
		return legalEntity;
	}

	protected abstract LegalEntity.LegalEntityBuilder doEvaluate(ExchangeId fpmlExchangeId);

	public static class MapExchangeIdToLegalEntityDefault extends MapExchangeIdToLegalEntity {
		@Override
		protected LegalEntity.LegalEntityBuilder doEvaluate(ExchangeId fpmlExchangeId) {
			LegalEntity.LegalEntityBuilder legalEntity = LegalEntity.builder();
			return assignOutput(legalEntity, fpmlExchangeId);
		}
		
		protected LegalEntity.LegalEntityBuilder assignOutput(LegalEntity.LegalEntityBuilder legalEntity, ExchangeId fpmlExchangeId) {
			legalEntity = toBuilder(LegalEntity.builder()
				.setName(mapStringWithScheme.evaluate(MapperS.of(fpmlExchangeId).<String>map("getValue", exchangeId -> exchangeId.getValue()).get(), MapperS.of(fpmlExchangeId).<String>map("getExchangeIdScheme", exchangeId -> exchangeId.getExchangeIdScheme()).get()))
				.build());
			
			return Optional.ofNullable(legalEntity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

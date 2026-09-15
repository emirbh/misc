package cdm.ingest.fpml.confirmation.product.volatilityswaptransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.product.volatilityswap.functions.MapVolatilityLegToPerformancePayout;
import cdm.product.template.EconomicTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import fpml.consolidated.volatility.swaps.VolatilitySwapTransactionSupplement;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVolatilitySwapTransactionSupplementEconomicTerms.MapVolatilitySwapTransactionSupplementEconomicTermsDefault.class)
public abstract class MapVolatilitySwapTransactionSupplementEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapVolatilityLegToPerformancePayout mapVolatilityLegToPerformancePayout;

	/**
	* @param fpmlVolatilitySwapTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlVolatilitySwapTransactionSupplement, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapVolatilitySwapTransactionSupplementEconomicTermsDefault extends MapVolatilitySwapTransactionSupplementEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlVolatilitySwapTransactionSupplement, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout(MapperS.of(fpmlVolatilitySwapTransactionSupplement).<VolatilityLeg>mapC("getVolatilityLeg", volatilitySwapTransactionSupplement -> volatilitySwapTransactionSupplement.getVolatilityLeg())
					.mapItem(item -> MapperS.of(mapVolatilityLegToPerformancePayout.evaluate(item.get(), cdmCounterpartyList))).getMulti())
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

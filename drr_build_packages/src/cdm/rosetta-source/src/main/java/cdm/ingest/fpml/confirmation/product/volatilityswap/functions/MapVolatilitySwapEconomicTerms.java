package cdm.ingest.fpml.confirmation.product.volatilityswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.EconomicTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import fpml.consolidated.volatility.swaps.VolatilitySwap;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVolatilitySwapEconomicTerms.MapVolatilitySwapEconomicTermsDefault.class)
public abstract class MapVolatilitySwapEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapVolatilityLegToPerformancePayout mapVolatilityLegToPerformancePayout;

	/**
	* @param fpmlVolatilitySwap 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(VolatilitySwap fpmlVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlVolatilitySwap, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(VolatilitySwap fpmlVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapVolatilitySwapEconomicTermsDefault extends MapVolatilitySwapEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(VolatilitySwap fpmlVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlVolatilitySwap, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, VolatilitySwap fpmlVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList) {
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout(MapperS.of(fpmlVolatilitySwap).<VolatilityLeg>mapC("getVolatilityLeg", volatilitySwap -> volatilitySwap.getVolatilityLeg())
					.mapItem(item -> MapperS.of(mapVolatilityLegToPerformancePayout.evaluate(item.get(), cdmCounterpartyList))).getMulti())
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

package cdm.ingest.fpml.confirmation.product.fxvolatilityswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.fx.FxVolatilitySwap;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxVolatilitySwapEconomicTerms.MapFxVolatilitySwapEconomicTermsDefault.class)
public abstract class MapFxVolatilitySwapEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxVolatilitySwapPayout mapFxVolatilitySwapPayout;

	/**
	* @param fpmlFxVolatilitySwap 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(FxVolatilitySwap fpmlFxVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlFxVolatilitySwap, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(FxVolatilitySwap fpmlFxVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFxVolatilitySwapEconomicTermsDefault extends MapFxVolatilitySwapEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(FxVolatilitySwap fpmlFxVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlFxVolatilitySwap, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, FxVolatilitySwap fpmlFxVolatilitySwap, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout = mapFxVolatilitySwapPayout.evaluate(fpmlFxVolatilitySwap, cdmCounterpartyList);
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout((payout == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout)))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

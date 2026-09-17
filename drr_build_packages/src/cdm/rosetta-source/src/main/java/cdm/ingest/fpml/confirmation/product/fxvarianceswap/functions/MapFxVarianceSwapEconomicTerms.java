package cdm.ingest.fpml.confirmation.product.fxvarianceswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.fx.FxVarianceSwap;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxVarianceSwapEconomicTerms.MapFxVarianceSwapEconomicTermsDefault.class)
public abstract class MapFxVarianceSwapEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxPerformanceSwapToReturnTerms mapFxPerformanceSwapToReturnTerms;
	@Inject protected MapFxVarianceSwapPayout mapFxVarianceSwapPayout;

	/**
	* @param fpmlFxVarianceSwap 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(FxVarianceSwap fpmlFxVarianceSwap, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlFxVarianceSwap, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(FxVarianceSwap fpmlFxVarianceSwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFxVarianceSwapEconomicTermsDefault extends MapFxVarianceSwapEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(FxVarianceSwap fpmlFxVarianceSwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlFxVarianceSwap, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, FxVarianceSwap fpmlFxVarianceSwap, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout = mapFxVarianceSwapPayout.evaluate(fpmlFxVarianceSwap, mapFxPerformanceSwapToReturnTerms.evaluate(fpmlFxVarianceSwap), cdmCounterpartyList);
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout((payout == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout)))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

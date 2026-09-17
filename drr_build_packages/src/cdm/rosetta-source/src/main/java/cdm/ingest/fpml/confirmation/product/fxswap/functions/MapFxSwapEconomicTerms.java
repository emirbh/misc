package cdm.ingest.fpml.confirmation.product.fxswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.EconomicTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.fx.FxSwap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxSwapEconomicTerms.MapFxSwapEconomicTermsDefault.class)
public abstract class MapFxSwapEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxSwapPayoutList mapFxSwapPayoutList;

	/**
	* @param fpmlFxSwap 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(FxSwap fpmlFxSwap, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlFxSwap, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(FxSwap fpmlFxSwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFxSwapEconomicTermsDefault extends MapFxSwapEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(FxSwap fpmlFxSwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlFxSwap, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, FxSwap fpmlFxSwap, List<? extends Counterparty> cdmCounterpartyList) {
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout(new ArrayList(mapFxSwapPayoutList.evaluate(fpmlFxSwap, cdmCounterpartyList)))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

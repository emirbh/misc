package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.EconomicTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.CancelableProvision;
import fpml.consolidated.ird.EarlyTerminationProvision;
import fpml.consolidated.ird.ExtendibleProvision;
import fpml.consolidated.ird.InterestRateStream;
import fpml.consolidated.ird.Swap;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSwapEconomicTerms.MapSwapEconomicTermsDefault.class)
public abstract class MapSwapEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapSwapPayout mapSwapPayout;
	@Inject protected MapTerminationProvision mapTerminationProvision;

	/**
	* @param fpmlSwap 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(Swap fpmlSwap, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlSwap, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(Swap fpmlSwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapSwapEconomicTermsDefault extends MapSwapEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(Swap fpmlSwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlSwap, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, Swap fpmlSwap, List<? extends Counterparty> cdmCounterpartyList) {
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout(MapperS.of(fpmlSwap).<InterestRateStream>mapC("getSwapStream", swap -> swap.getSwapStream())
					.mapItem(item -> MapperS.of(mapSwapPayout.evaluate(item.get(), cdmCounterpartyList))).getMulti())
				.setTerminationProvision(mapTerminationProvision.evaluate(MapperS.of(fpmlSwap).<EarlyTerminationProvision>map("getEarlyTerminationProvision", swap -> swap.getEarlyTerminationProvision()).get(), MapperS.of(fpmlSwap).<CancelableProvision>map("getCancelableProvision", swap -> swap.getCancelableProvision()).get(), MapperS.of(fpmlSwap).<ExtendibleProvision>map("getExtendibleProvision", swap -> swap.getExtendibleProvision()).get(), cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

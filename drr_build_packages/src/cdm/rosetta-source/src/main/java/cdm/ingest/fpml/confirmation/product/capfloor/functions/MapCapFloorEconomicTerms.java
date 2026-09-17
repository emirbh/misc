package cdm.ingest.fpml.confirmation.product.capfloor.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.product.swap.functions.MapSwapPayout;
import cdm.ingest.fpml.confirmation.product.swap.functions.MapTerminationProvision;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.CapFloor;
import fpml.consolidated.ird.EarlyTerminationProvision;
import fpml.consolidated.ird.InterestRateStream;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCapFloorEconomicTerms.MapCapFloorEconomicTermsDefault.class)
public abstract class MapCapFloorEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapSwapPayout mapSwapPayout;
	@Inject protected MapTerminationProvision mapTerminationProvision;

	/**
	* @param fpmlCapFloor 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(CapFloor fpmlCapFloor, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlCapFloor, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(CapFloor fpmlCapFloor, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCapFloorEconomicTermsDefault extends MapCapFloorEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(CapFloor fpmlCapFloor, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlCapFloor, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, CapFloor fpmlCapFloor, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout = mapSwapPayout.evaluate(MapperS.of(fpmlCapFloor).<InterestRateStream>map("getCapFloorStream", capFloor -> capFloor.getCapFloorStream()).get(), cdmCounterpartyList);
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout((payout == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout)))
				.setTerminationProvision(mapTerminationProvision.evaluate(MapperS.of(fpmlCapFloor).<EarlyTerminationProvision>map("getEarlyTerminationProvision", capFloor -> capFloor.getEarlyTerminationProvision()).get(), null, null, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

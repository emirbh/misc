package cdm.ingest.fpml.confirmation.product.swaption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.product.swap.functions.MapTerminationProvision;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.EarlyTerminationProvision;
import fpml.consolidated.ird.Swaption;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSwaptionEconomicTerms.MapSwaptionEconomicTermsDefault.class)
public abstract class MapSwaptionEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapSwaptionPayout mapSwaptionPayout;
	@Inject protected MapTerminationProvision mapTerminationProvision;

	/**
	* @param fpmlSwaption 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(Swaption fpmlSwaption, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlSwaption, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(Swaption fpmlSwaption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapSwaptionEconomicTermsDefault extends MapSwaptionEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(Swaption fpmlSwaption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlSwaption, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, Swaption fpmlSwaption, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout = mapSwaptionPayout.evaluate(fpmlSwaption, cdmCounterpartyList);
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout((payout == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout)))
				.setTerminationProvision(mapTerminationProvision.evaluate(MapperS.of(fpmlSwaption).<EarlyTerminationProvision>map("getEarlyTerminationProvision", swaption -> swaption.getEarlyTerminationProvision()).get(), null, null, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

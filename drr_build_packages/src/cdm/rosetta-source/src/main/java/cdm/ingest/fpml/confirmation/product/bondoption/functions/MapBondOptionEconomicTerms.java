package cdm.ingest.fpml.confirmation.product.bondoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.bond.option.BondOption;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBondOptionEconomicTerms.MapBondOptionEconomicTermsDefault.class)
public abstract class MapBondOptionEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBondOptionPayout mapBondOptionPayout;

	/**
	* @param fpmlBondOption 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(BondOption fpmlBondOption, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlBondOption, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(BondOption fpmlBondOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapBondOptionEconomicTermsDefault extends MapBondOptionEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(BondOption fpmlBondOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlBondOption, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, BondOption fpmlBondOption, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout = mapBondOptionPayout.evaluate(fpmlBondOption, cdmCounterpartyList);
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout((payout == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout)))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

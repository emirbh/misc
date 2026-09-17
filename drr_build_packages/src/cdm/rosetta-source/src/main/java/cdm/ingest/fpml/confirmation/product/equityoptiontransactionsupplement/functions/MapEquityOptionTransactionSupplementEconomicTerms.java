package cdm.ingest.fpml.confirmation.product.equityoptiontransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.eqd.EquityOptionTransactionSupplement;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquityOptionTransactionSupplementEconomicTerms.MapEquityOptionTransactionSupplementEconomicTermsDefault.class)
public abstract class MapEquityOptionTransactionSupplementEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEquityOptionTransactionSupplementPayout mapEquityOptionTransactionSupplementPayout;

	/**
	* @param fpmlEquityOptionTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlEquityOptionTransactionSupplement, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapEquityOptionTransactionSupplementEconomicTermsDefault extends MapEquityOptionTransactionSupplementEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlEquityOptionTransactionSupplement, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout = mapEquityOptionTransactionSupplementPayout.evaluate(fpmlEquityOptionTransactionSupplement, cdmCounterpartyList);
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout((payout == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout)))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

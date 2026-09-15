package cdm.ingest.fpml.confirmation.product.varianceoptiontransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.variance.swaps.VarianceOptionTransactionSupplement;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVarianceOptionTransactionSupplementEconomicTerms.MapVarianceOptionTransactionSupplementEconomicTermsDefault.class)
public abstract class MapVarianceOptionTransactionSupplementEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapVarianceOptionTransactionSupplementPayout mapVarianceOptionTransactionSupplementPayout;

	/**
	* @param fpmlVarianceOptionTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlVarianceOptionTransactionSupplement, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapVarianceOptionTransactionSupplementEconomicTermsDefault extends MapVarianceOptionTransactionSupplementEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlVarianceOptionTransactionSupplement, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout = mapVarianceOptionTransactionSupplementPayout.evaluate(fpmlVarianceOptionTransactionSupplement, cdmCounterpartyList);
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout((payout == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout)))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

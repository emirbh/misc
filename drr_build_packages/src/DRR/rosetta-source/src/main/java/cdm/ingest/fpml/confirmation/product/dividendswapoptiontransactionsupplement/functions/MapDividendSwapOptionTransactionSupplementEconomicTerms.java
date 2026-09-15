package cdm.ingest.fpml.confirmation.product.dividendswapoptiontransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.dividend.swaps.DividendSwapOptionTransactionSupplement;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendSwapOptionTransactionSupplementEconomicTerms.MapDividendSwapOptionTransactionSupplementEconomicTermsDefault.class)
public abstract class MapDividendSwapOptionTransactionSupplementEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDividendSwapOptionTransactionSupplementPayout mapDividendSwapOptionTransactionSupplementPayout;

	/**
	* @param fpmlDividendSwapOptionTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlDividendSwapOptionTransactionSupplement, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapDividendSwapOptionTransactionSupplementEconomicTermsDefault extends MapDividendSwapOptionTransactionSupplementEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlDividendSwapOptionTransactionSupplement, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout = mapDividendSwapOptionTransactionSupplementPayout.evaluate(fpmlDividendSwapOptionTransactionSupplement, cdmCounterpartyList);
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout((payout == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout)))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

package cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.doc.TradeHeader;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditDefaultSwapOptionEconomicTerms.MapCreditDefaultSwapOptionEconomicTermsDefault.class)
public abstract class MapCreditDefaultSwapOptionEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCreditDefaultSwapOptionPayout mapCreditDefaultSwapOptionPayout;

	/**
	* @param fpmlCreditDefaultSwapOption 
	* @param cdmCounterpartyList 
	* @param fpmlTradeHeader 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList, TradeHeader fpmlTradeHeader) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlCreditDefaultSwapOption, cdmCounterpartyList, fpmlTradeHeader);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList, TradeHeader fpmlTradeHeader);

	public static class MapCreditDefaultSwapOptionEconomicTermsDefault extends MapCreditDefaultSwapOptionEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList, TradeHeader fpmlTradeHeader) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlCreditDefaultSwapOption, cdmCounterpartyList, fpmlTradeHeader);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList, TradeHeader fpmlTradeHeader) {
			final Payout payout = mapCreditDefaultSwapOptionPayout.evaluate(fpmlCreditDefaultSwapOption, cdmCounterpartyList, fpmlTradeHeader, null);
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout((payout == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout)))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

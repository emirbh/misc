package cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
import cdm.product.template.EconomicTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.dividend.swaps.DividendLeg;
import fpml.consolidated.dividend.swaps.DividendSwapTransactionSupplement;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendSwapTransactionSupplementEconomicTerms.MapDividendSwapTransactionSupplementEconomicTermsDefault.class)
public abstract class MapDividendSwapTransactionSupplementEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapDividendSwapTransactionSupplementPayoutList mapDividendSwapTransactionSupplementPayoutList;

	/**
	* @param fpmlDividendSwapTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlDividendSwapTransactionSupplement, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends DividendLeg> dividendLeg(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapDividendSwapTransactionSupplementEconomicTermsDefault extends MapDividendSwapTransactionSupplementEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlDividendSwapTransactionSupplement, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout(new ArrayList(mapDividendSwapTransactionSupplementPayoutList.evaluate(fpmlDividendSwapTransactionSupplement, cdmCounterpartyList)))
				.setEffectiveDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlDividendSwapTransactionSupplement).<DividendLeg>map("getDividendLeg", dividendSwapTransactionSupplement -> dividendSwapTransactionSupplement.getDividendLeg()).<AdjustableOrRelativeDate>map("getEffectiveDate", _dividendLeg -> _dividendLeg.getEffectiveDate()).get()))
				.setTerminationDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlDividendSwapTransactionSupplement).<DividendLeg>map("getDividendLeg", dividendSwapTransactionSupplement -> dividendSwapTransactionSupplement.getDividendLeg()).<AdjustableOrRelativeDate>map("getTerminationDate", _dividendLeg -> _dividendLeg.getTerminationDate()).get()))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends DividendLeg> dividendLeg(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlDividendSwapTransactionSupplement).<DividendLeg>map("getDividendLeg", dividendSwapTransactionSupplement -> dividendSwapTransactionSupplement.getDividendLeg());
		}
	}
}

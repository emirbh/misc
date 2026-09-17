package cdm.ingest.fpml.confirmation.product.varianceswaptransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.product.varianceswap.functions.MapVarianceLegToPerformancePayout;
import cdm.product.template.EconomicTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.variance.swaps.VarianceLeg;
import fpml.consolidated.variance.swaps.VarianceSwapTransactionSupplement;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVarianceSwapTransactionSupplementEconomicTerms.MapVarianceSwapTransactionSupplementEconomicTermsDefault.class)
public abstract class MapVarianceSwapTransactionSupplementEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapVarianceLegToPerformancePayout mapVarianceLegToPerformancePayout;

	/**
	* @param fpmlVarianceSwapTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(VarianceSwapTransactionSupplement fpmlVarianceSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlVarianceSwapTransactionSupplement, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(VarianceSwapTransactionSupplement fpmlVarianceSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapVarianceSwapTransactionSupplementEconomicTermsDefault extends MapVarianceSwapTransactionSupplementEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(VarianceSwapTransactionSupplement fpmlVarianceSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlVarianceSwapTransactionSupplement, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, VarianceSwapTransactionSupplement fpmlVarianceSwapTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout(MapperS.of(fpmlVarianceSwapTransactionSupplement).<VarianceLeg>mapC("getVarianceLeg", varianceSwapTransactionSupplement -> varianceSwapTransactionSupplement.getVarianceLeg())
					.mapItem(item -> MapperS.of(mapVarianceLegToPerformancePayout.evaluate(item.get(), cdmCounterpartyList))).getMulti())
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

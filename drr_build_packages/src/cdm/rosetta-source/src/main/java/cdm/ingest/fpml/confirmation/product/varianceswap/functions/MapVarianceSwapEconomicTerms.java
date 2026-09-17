package cdm.ingest.fpml.confirmation.product.varianceswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
import cdm.product.template.EconomicTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.variance.swaps.VarianceLeg;
import fpml.consolidated.variance.swaps.VarianceSwap;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapVarianceSwapEconomicTerms.MapVarianceSwapEconomicTermsDefault.class)
public abstract class MapVarianceSwapEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapVarianceLegToPerformancePayout mapVarianceLegToPerformancePayout;

	/**
	* @param fpmlVarianceSwap 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(VarianceSwap fpmlVarianceSwap, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlVarianceSwap, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(VarianceSwap fpmlVarianceSwap, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperC<? extends VarianceLeg> fpmlEffectiveDates(VarianceSwap fpmlVarianceSwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapVarianceSwapEconomicTermsDefault extends MapVarianceSwapEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(VarianceSwap fpmlVarianceSwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlVarianceSwap, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, VarianceSwap fpmlVarianceSwap, List<? extends Counterparty> cdmCounterpartyList) {
			economicTerms = toBuilder(EconomicTerms.builder()
				.setEffectiveDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlVarianceSwap).<VarianceLeg>mapC("getVarianceLeg", varianceSwap -> varianceSwap.getVarianceLeg()).<AdjustableOrRelativeDate>map("getEffectiveDate", varianceLeg -> varianceLeg.getEffectiveDate())
					.first().get()))
				.setTerminationDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlVarianceSwap).<VarianceLeg>mapC("getVarianceLeg", varianceSwap -> varianceSwap.getVarianceLeg()).<AdjustableOrRelativeDate>map("getTerminationDate", varianceLeg -> varianceLeg.getTerminationDate())
					.first().get()))
				.setPayout(MapperS.of(fpmlVarianceSwap).<VarianceLeg>mapC("getVarianceLeg", varianceSwap -> varianceSwap.getVarianceLeg())
					.mapItem(item -> MapperS.of(mapVarianceLegToPerformancePayout.evaluate(item.get(), cdmCounterpartyList))).getMulti())
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends VarianceLeg> fpmlEffectiveDates(VarianceSwap fpmlVarianceSwap, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlVarianceSwap).<VarianceLeg>mapC("getVarianceLeg", varianceSwap -> varianceSwap.getVarianceLeg())
				.filterItemNullSafe(item -> exists(item.<AdjustableOrRelativeDate>map("getEffectiveDate", varianceLeg -> varianceLeg.getEffectiveDate())).get());
		}
	}
}

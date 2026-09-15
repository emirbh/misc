package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapDateOffsetToRelativeDateOffset;
import cdm.product.common.settlement.SettlementDate;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityExercise;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.shared.DateOffset;
import fpml.consolidated.shared.IdentifiedCurrency;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCommodityExerciseToSettlementTerms.MapCommodityExerciseToSettlementTermsDefault.class)
public abstract class MapCommodityExerciseToSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDateOffsetToRelativeDateOffset mapDateOffsetToRelativeDateOffset;

	/**
	* @param fpmlCommodityExercise 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(CommodityExercise fpmlCommodityExercise) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlCommodityExercise);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(CommodityExercise fpmlCommodityExercise);

	public static class MapCommodityExerciseToSettlementTermsDefault extends MapCommodityExerciseToSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(CommodityExercise fpmlCommodityExercise) {
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlCommodityExercise);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, CommodityExercise fpmlCommodityExercise) {
			SettlementTypeEnum ifThenElseResult = null;
			if (exists(MapperS.of(fpmlCommodityExercise).<IdentifiedCurrency>map("getSettlementCurrency", commodityExercise -> commodityExercise.getSettlementCurrency())).getOrDefault(false)) {
				ifThenElseResult = SettlementTypeEnum.CASH;
			}
			settlementTerms = toBuilder(SettlementTerms.builder()
				.setSettlementType(ifThenElseResult)
				.setSettlementCurrencyValue(MapperS.of(fpmlCommodityExercise).<IdentifiedCurrency>map("getSettlementCurrency", commodityExercise -> commodityExercise.getSettlementCurrency()).<String>map("getValue", identifiedCurrency -> identifiedCurrency.getValue()).get())
				.setSettlementDate(SettlementDate.builder()
					.setAdjustableOrRelativeDate(AdjustableOrAdjustedOrRelativeDate.builder()
						.setRelativeDate(mapDateOffsetToRelativeDateOffset.evaluate(MapperS.of(fpmlCommodityExercise).<CommodityRelativePaymentDates>map("getRelativePaymentDates", commodityExercise -> commodityExercise.getRelativePaymentDates()).<DateOffset>map("getPaymentDaysOffset", commodityRelativePaymentDates -> commodityRelativePaymentDates.getPaymentDaysOffset()).get()))
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

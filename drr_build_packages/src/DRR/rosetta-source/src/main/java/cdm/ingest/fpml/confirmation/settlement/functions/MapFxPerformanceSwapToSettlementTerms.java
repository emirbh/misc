package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapDateWithId;
import cdm.product.common.settlement.SettlementDate;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxPerformanceSwap;
import fpml.consolidated.shared.AdjustableOrAdjustedDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.FxCashSettlementSimple;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFxPerformanceSwapToSettlementTerms.MapFxPerformanceSwapToSettlementTermsDefault.class)
public abstract class MapFxPerformanceSwapToSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDateWithId mapDateWithId;

	/**
	* @param fpmlFxPerformanceSwap 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(FxPerformanceSwap fpmlFxPerformanceSwap) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlFxPerformanceSwap);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(FxPerformanceSwap fpmlFxPerformanceSwap);

	public static class MapFxPerformanceSwapToSettlementTermsDefault extends MapFxPerformanceSwapToSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(FxPerformanceSwap fpmlFxPerformanceSwap) {
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlFxPerformanceSwap);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, FxPerformanceSwap fpmlFxPerformanceSwap) {
			SettlementTypeEnum ifThenElseResult = null;
			if (exists(MapperS.of(fpmlFxPerformanceSwap).<FxCashSettlementSimple>map("getCashSettlement", fxPerformanceSwap -> fxPerformanceSwap.getCashSettlement()).<Currency>map("getSettlementCurrency", fxCashSettlementSimple -> fxCashSettlementSimple.getSettlementCurrency())).getOrDefault(false)) {
				ifThenElseResult = SettlementTypeEnum.CASH;
			}
			settlementTerms = toBuilder(SettlementTerms.builder()
				.setSettlementType(ifThenElseResult)
				.setSettlementCurrencyValue(MapperS.of(fpmlFxPerformanceSwap).<FxCashSettlementSimple>map("getCashSettlement", fxPerformanceSwap -> fxPerformanceSwap.getCashSettlement()).<Currency>map("getSettlementCurrency", fxCashSettlementSimple -> fxCashSettlementSimple.getSettlementCurrency()).<String>map("getValue", currency -> currency.getValue()).get())
				.setSettlementDate(SettlementDate.builder()
					.setAdjustableOrRelativeDate(AdjustableOrAdjustedOrRelativeDate.builder()
						.setAdjustedDate(mapDateWithId.evaluate(MapperS.of(fpmlFxPerformanceSwap).<AdjustableOrAdjustedDate>map("getSettlementDate", fxPerformanceSwap -> fxPerformanceSwap.getSettlementDate()).<IdentifiedDate>map("getAdjustedDate", adjustableOrAdjustedDate -> adjustableOrAdjustedDate.getAdjustedDate()).get()))
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

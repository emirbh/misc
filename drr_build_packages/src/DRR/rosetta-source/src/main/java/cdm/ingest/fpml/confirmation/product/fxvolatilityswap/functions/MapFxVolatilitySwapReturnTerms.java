package cdm.ingest.fpml.confirmation.product.fxvolatilityswap.functions;

import cdm.base.math.UnitType;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceTypeEnum;
import cdm.product.asset.VolatilityReturnTerms;
import cdm.product.template.ReturnTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.fx.FxPerformanceFixedLeg;
import fpml.consolidated.fx.FxPerformanceSwap;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFxVolatilitySwapReturnTerms.MapFxVolatilitySwapReturnTermsDefault.class)
public abstract class MapFxVolatilitySwapReturnTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlFxPerformanceSwap 
	* @return returnTerms 
	*/
	public ReturnTerms evaluate(FxPerformanceSwap fpmlFxPerformanceSwap) {
		ReturnTerms.ReturnTermsBuilder returnTermsBuilder = doEvaluate(fpmlFxPerformanceSwap);
		
		final ReturnTerms returnTerms;
		if (returnTermsBuilder == null) {
			returnTerms = null;
		} else {
			returnTerms = returnTermsBuilder.build();
			objectValidator.validate(ReturnTerms.class, returnTerms);
		}
		
		return returnTerms;
	}

	protected abstract ReturnTerms.ReturnTermsBuilder doEvaluate(FxPerformanceSwap fpmlFxPerformanceSwap);

	protected abstract MapperS<? extends QuotedCurrencyPair> fpmlQuotedCurrencyPair(FxPerformanceSwap fpmlFxPerformanceSwap);

	protected abstract MapperS<QuoteBasisEnum> fpmlQuoteBasis(FxPerformanceSwap fpmlFxPerformanceSwap);

	public static class MapFxVolatilitySwapReturnTermsDefault extends MapFxVolatilitySwapReturnTerms {
		@Override
		protected ReturnTerms.ReturnTermsBuilder doEvaluate(FxPerformanceSwap fpmlFxPerformanceSwap) {
			ReturnTerms.ReturnTermsBuilder returnTerms = ReturnTerms.builder();
			return assignOutput(returnTerms, fpmlFxPerformanceSwap);
		}
		
		protected ReturnTerms.ReturnTermsBuilder assignOutput(ReturnTerms.ReturnTermsBuilder returnTerms, FxPerformanceSwap fpmlFxPerformanceSwap) {
			final BigDecimal bigDecimal = MapperS.of(fpmlFxPerformanceSwap).<BigDecimal>map("getAnnualizationFactor", fxPerformanceSwap -> fxPerformanceSwap.getAnnualizationFactor()).get();
			final String ifThenElseResult0;
			if (areEqual(fpmlQuoteBasis(fpmlFxPerformanceSwap), MapperS.of(QuoteBasisEnum.CURRENCY_1_PER_CURRENCY_2), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(fpmlFxPerformanceSwap).<QuotedCurrencyPair>map("getQuotedCurrencyPair", fxPerformanceSwap -> fxPerformanceSwap.getQuotedCurrencyPair()).<Currency>map("getCurrency1", quotedCurrencyPair -> quotedCurrencyPair.getCurrency1()).<String>map("getValue", currency -> currency.getValue()).get();
			} else if (areEqual(fpmlQuoteBasis(fpmlFxPerformanceSwap), MapperS.of(QuoteBasisEnum.CURRENCY_2_PER_CURRENCY_1), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(fpmlFxPerformanceSwap).<QuotedCurrencyPair>map("getQuotedCurrencyPair", fxPerformanceSwap -> fxPerformanceSwap.getQuotedCurrencyPair()).<Currency>map("getCurrency2", quotedCurrencyPair -> quotedCurrencyPair.getCurrency2()).<String>map("getValue", currency -> currency.getValue()).get();
			} else {
				ifThenElseResult0 = null;
			}
			final String ifThenElseResult1;
			if (areEqual(fpmlQuoteBasis(fpmlFxPerformanceSwap), MapperS.of(QuoteBasisEnum.CURRENCY_1_PER_CURRENCY_2), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(fpmlFxPerformanceSwap).<QuotedCurrencyPair>map("getQuotedCurrencyPair", fxPerformanceSwap -> fxPerformanceSwap.getQuotedCurrencyPair()).<Currency>map("getCurrency2", quotedCurrencyPair -> quotedCurrencyPair.getCurrency2()).<String>map("getValue", currency -> currency.getValue()).get();
			} else if (areEqual(fpmlQuoteBasis(fpmlFxPerformanceSwap), MapperS.of(QuoteBasisEnum.CURRENCY_2_PER_CURRENCY_1), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(fpmlFxPerformanceSwap).<QuotedCurrencyPair>map("getQuotedCurrencyPair", fxPerformanceSwap -> fxPerformanceSwap.getQuotedCurrencyPair()).<Currency>map("getCurrency1", quotedCurrencyPair -> quotedCurrencyPair.getCurrency1()).<String>map("getValue", currency -> currency.getValue()).get();
			} else {
				ifThenElseResult1 = null;
			}
			returnTerms = toBuilder(ReturnTerms.builder()
				.setVolatilityReturnTerms(VolatilityReturnTerms.builder()
					.setAnnualizationFactor((bigDecimal == null ? null : bigDecimal.intValueExact()))
					.setMeanAdjustment(MapperS.of(fpmlFxPerformanceSwap).<Boolean>map("getMeanAdjustment", fxPerformanceSwap -> fxPerformanceSwap.getMeanAdjustment()).get())
					.setVolatilityStrikePrice(Price.builder()
						.setValue(MapperS.of(fpmlFxPerformanceSwap).<FxPerformanceFixedLeg>map("getFixedLeg", fxPerformanceSwap -> fxPerformanceSwap.getFixedLeg()).<BigDecimal>map("getFixedRate", fxPerformanceFixedLeg -> fxPerformanceFixedLeg.getFixedRate()).get())
						.setUnit(UnitType.builder()
							.setCurrencyValue(ifThenElseResult0)
							.build())
						.setPerUnitOf(UnitType.builder()
							.setCurrencyValue(ifThenElseResult1)
							.build())
						.setPriceType(PriceTypeEnum.INTEREST_RATE)
						.build())
					.setValuationTerms(null)
					.setExpectedN(null)
					.build())
				.build());
			
			return Optional.ofNullable(returnTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends QuotedCurrencyPair> fpmlQuotedCurrencyPair(FxPerformanceSwap fpmlFxPerformanceSwap) {
			return MapperS.of(fpmlFxPerformanceSwap).<QuotedCurrencyPair>map("getQuotedCurrencyPair", fxPerformanceSwap -> fxPerformanceSwap.getQuotedCurrencyPair());
		}
		
		@Override
		protected MapperS<QuoteBasisEnum> fpmlQuoteBasis(FxPerformanceSwap fpmlFxPerformanceSwap) {
			return MapperS.of(fpmlFxPerformanceSwap).<QuotedCurrencyPair>map("getQuotedCurrencyPair", fxPerformanceSwap -> fxPerformanceSwap.getQuotedCurrencyPair()).<QuoteBasisEnum>map("getQuoteBasis", quotedCurrencyPair -> quotedCurrencyPair.getQuoteBasis());
		}
	}
}

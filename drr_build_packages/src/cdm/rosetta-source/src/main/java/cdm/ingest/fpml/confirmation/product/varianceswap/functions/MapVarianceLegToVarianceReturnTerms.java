package cdm.ingest.fpml.confirmation.product.varianceswap.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.staticdata.asset.common.Asset;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapAsset;
import cdm.observable.asset.DividendApplicability;
import cdm.observable.asset.Observable;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceTypeEnum;
import cdm.product.asset.BoundedVariance;
import cdm.product.asset.ValuationTerms;
import cdm.product.asset.VarianceCapFloor;
import cdm.product.asset.VarianceReturnTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.ExchangeTradedContract;
import fpml.consolidated.eq.shared.EquityValuation;
import fpml.consolidated.eq.shared.Variance;
import fpml.consolidated.fpmlenum.RealisedVarianceMethodEnum;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.variance.swaps.VarianceAmount;
import fpml.consolidated.variance.swaps.VarianceLeg;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapVarianceLegToVarianceReturnTerms.MapVarianceLegToVarianceReturnTermsDefault.class)
public abstract class MapVarianceLegToVarianceReturnTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAsset mapAsset;

	/**
	* @param fpmlVarianceLeg 
	* @return varianceReturnTerms 
	*/
	public VarianceReturnTerms evaluate(VarianceLeg fpmlVarianceLeg) {
		VarianceReturnTerms.VarianceReturnTermsBuilder varianceReturnTermsBuilder = doEvaluate(fpmlVarianceLeg);
		
		final VarianceReturnTerms varianceReturnTerms;
		if (varianceReturnTermsBuilder == null) {
			varianceReturnTerms = null;
		} else {
			varianceReturnTerms = varianceReturnTermsBuilder.build();
			objectValidator.validate(VarianceReturnTerms.class, varianceReturnTerms);
		}
		
		return varianceReturnTerms;
	}

	protected abstract VarianceReturnTerms.VarianceReturnTermsBuilder doEvaluate(VarianceLeg fpmlVarianceLeg);

	protected abstract MapperS<? extends ExchangeTradedContract> fpmlAsset(VarianceLeg fpmlVarianceLeg);

	protected abstract MapperS<? extends Variance> fpmlVariance(VarianceLeg fpmlVarianceLeg);

	public static class MapVarianceLegToVarianceReturnTermsDefault extends MapVarianceLegToVarianceReturnTerms {
		@Override
		protected VarianceReturnTerms.VarianceReturnTermsBuilder doEvaluate(VarianceLeg fpmlVarianceLeg) {
			VarianceReturnTerms.VarianceReturnTermsBuilder varianceReturnTerms = VarianceReturnTerms.builder();
			return assignOutput(varianceReturnTerms, fpmlVarianceLeg);
		}
		
		protected VarianceReturnTerms.VarianceReturnTermsBuilder assignOutput(VarianceReturnTerms.VarianceReturnTermsBuilder varianceReturnTerms, VarianceLeg fpmlVarianceLeg) {
			Price ifThenElseResult0 = null;
			if (exists(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance()).<BigDecimal>map("getVarianceStrikePrice", variance -> variance.getVarianceStrikePrice())).getOrDefault(false)) {
				ifThenElseResult0 = Price.builder()
					.setValue(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance()).<BigDecimal>map("getVarianceStrikePrice", variance -> variance.getVarianceStrikePrice()).get())
					.setPriceType(PriceTypeEnum.VARIANCE)
					.build();
			}
			String ifThenElseResult1 = null;
			if (exists(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance()).<BigDecimal>map("getVegaNotionalAmount", variance -> variance.getVegaNotionalAmount())).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance()).<NonNegativeMoney>map("getVarianceAmount", variance -> variance.getVarianceAmount()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).<String>map("getValue", currency -> currency.getValue()).get();
			}
			Asset ifThenElseResult2 = null;
			if (exists(fpmlAsset(fpmlVarianceLeg)).getOrDefault(false)) {
				ifThenElseResult2 = mapAsset.evaluate(fpmlAsset(fpmlVarianceLeg).get());
			}
			varianceReturnTerms = toBuilder(VarianceReturnTerms.builder()
				.setValuationTerms(ValuationTerms.builder()
					.setFuturesPriceValuation(MapperS.of(fpmlVarianceLeg).<EquityValuation>map("getValuation", varianceLeg -> varianceLeg.getValuation()).<Boolean>map("getFuturesPriceValuation", equityValuation -> equityValuation.getFuturesPriceValuation()).get())
					.setOptionsPriceValuation(MapperS.of(fpmlVarianceLeg).<EquityValuation>map("getValuation", varianceLeg -> varianceLeg.getValuation()).<Boolean>map("getOptionsPriceValuation", equityValuation -> equityValuation.getOptionsPriceValuation()).get())
					.build())
				.setDividendApplicability(DividendApplicability.builder()
					.setOptionsExchangeDividends(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Boolean>map("getOptionsExchangeDividends", varianceAmount -> varianceAmount.getOptionsExchangeDividends()).get())
					.setAdditionalDividends(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Boolean>map("getAdditionalDividends", varianceAmount -> varianceAmount.getAdditionalDividends()).get())
					.setAllDividends(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Boolean>map("getAllDividends", varianceAmount -> varianceAmount.getAllDividends()).get())
					.build())
				.setInitialLevel(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance()).<BigDecimal>map("getInitialLevel", variance -> variance.getInitialLevel()).get())
				.setVarianceStrikePrice(ifThenElseResult0)
				.setVarianceCapFloor(VarianceCapFloor.builder()
					.setBoundedVariance(BoundedVariance.builder()
						.setRealisedVarianceMethod(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance()).<fpml.consolidated.eq.shared.BoundedVariance>map("getBoundedVariance", variance -> variance.getBoundedVariance()).<RealisedVarianceMethodEnum>map("getRealisedVarianceMethod", boundedVariance -> boundedVariance.getRealisedVarianceMethod()).checkedMap("to-enum", e -> cdm.product.asset.RealisedVarianceMethodEnum.valueOf(e.name()), IllegalArgumentException.class).get())
						.setDaysInRangeAdjustment(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance()).<fpml.consolidated.eq.shared.BoundedVariance>map("getBoundedVariance", variance -> variance.getBoundedVariance()).<Boolean>map("getDaysInRangeAdjustment", boundedVariance -> boundedVariance.getDaysInRangeAdjustment()).get())
						.setUpperBarrier(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance()).<fpml.consolidated.eq.shared.BoundedVariance>map("getBoundedVariance", variance -> variance.getBoundedVariance()).<BigDecimal>map("getUpperBarrier", boundedVariance -> boundedVariance.getUpperBarrier()).get())
						.setLowerBarrier(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance()).<fpml.consolidated.eq.shared.BoundedVariance>map("getBoundedVariance", variance -> variance.getBoundedVariance()).<BigDecimal>map("getLowerBarrier", boundedVariance -> boundedVariance.getLowerBarrier()).get())
						.build())
					.setVarianceCap(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance()).<Boolean>map("getVarianceCap", variance -> variance.getVarianceCap()).get())
					.build())
				.setVegaNotionalAmount(NonNegativeQuantitySchedule.builder()
					.setValue(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance()).<BigDecimal>map("getVegaNotionalAmount", variance -> variance.getVegaNotionalAmount()).get())
					.setUnit(UnitType.builder()
						.setCurrencyValue(ifThenElseResult1)
						.build())
					.build())
				.setExchangeTradedContractNearestValue(Observable.builder()
					.setAsset(ifThenElseResult2)
					.build())
				.setExpectedN(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance()).<Integer>map("getExpectedN", variance -> variance.getExpectedN()).get())
				.build());
			
			return Optional.ofNullable(varianceReturnTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ExchangeTradedContract> fpmlAsset(VarianceLeg fpmlVarianceLeg) {
			return MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance()).<ExchangeTradedContract>map("getExchangeTradedContractNearest", variance -> variance.getExchangeTradedContractNearest());
		}
		
		@Override
		protected MapperS<? extends Variance> fpmlVariance(VarianceLeg fpmlVarianceLeg) {
			return MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance());
		}
	}
}

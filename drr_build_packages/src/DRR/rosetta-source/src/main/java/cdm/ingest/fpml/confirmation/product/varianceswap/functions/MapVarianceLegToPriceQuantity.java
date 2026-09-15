package cdm.ingest.fpml.confirmation.product.varianceswap.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalAmountToQuantityWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapUnderlyerToObservableWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eq.shared.Variance;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.Step;
import fpml.consolidated.variance.swaps.VarianceAmount;
import fpml.consolidated.variance.swaps.VarianceLeg;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVarianceLegToPriceQuantity.MapVarianceLegToPriceQuantityDefault.class)
public abstract class MapVarianceLegToPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNotionalAmountToQuantityWithLocation mapNotionalAmountToQuantityWithLocation;
	@Inject protected MapUnderlyerToObservableWithLocation mapUnderlyerToObservableWithLocation;

	/**
	* @param fpmlVarianceLeg 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(VarianceLeg fpmlVarianceLeg) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlVarianceLeg);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(VarianceLeg fpmlVarianceLeg);

	public static class MapVarianceLegToPriceQuantityDefault extends MapVarianceLegToPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(VarianceLeg fpmlVarianceLeg) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlVarianceLeg);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, VarianceLeg fpmlVarianceLeg) {
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule = mapNotionalAmountToQuantityWithLocation.evaluate(MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance()).<NonNegativeMoney>map("getVarianceAmount", variance -> variance.getVarianceAmount()).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount()).get(), Collections.<Step>emptyList(), MapperS.of(fpmlVarianceLeg).<VarianceAmount>map("getAmount", varianceLeg -> varianceLeg.getAmount()).<Variance>map("getVariance", varianceAmount -> varianceAmount.getVariance()).<NonNegativeMoney>map("getVarianceAmount", variance -> variance.getVarianceAmount()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get(), fpmlVarianceLeg);
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setQuantity((fieldWithMetaNonNegativeQuantitySchedule == null ? Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList() : Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule)))
				.setObservable(mapUnderlyerToObservableWithLocation.evaluate(MapperS.of(fpmlVarianceLeg).<Underlyer>map("getUnderlyer", varianceLeg -> varianceLeg.getUnderlyer()).get()))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

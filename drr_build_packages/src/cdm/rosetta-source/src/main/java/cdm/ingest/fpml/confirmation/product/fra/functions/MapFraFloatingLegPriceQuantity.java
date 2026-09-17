package cdm.ingest.fpml.confirmation.product.fra.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuantityKey;
import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuantityWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFloatingRateIndexToRateOptionObservableWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapMoneyToQuantity;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.Fra;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.Period;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFraFloatingLegPriceQuantity.MapFraFloatingLegPriceQuantityDefault.class)
public abstract class MapFraFloatingLegPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithLocation createQuantityWithLocation;
	@Inject protected FloatingLeg floatingLeg;
	@Inject protected MapFloatingRateIndexToRateOptionObservableWithLocation mapFloatingRateIndexToRateOptionObservableWithLocation;
	@Inject protected MapMoneyToQuantity mapMoneyToQuantity;

	/**
	* @param fpmlFra 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(Fra fpmlFra) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlFra);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(Fra fpmlFra);

	public static class MapFraFloatingLegPriceQuantityDefault extends MapFraFloatingLegPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(Fra fpmlFra) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlFra);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, Fra fpmlFra) {
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule = createQuantityWithLocation.evaluate(mapMoneyToQuantity.evaluate(MapperS.of(fpmlFra).<Money>map("getNotional", fra -> fra.getNotional()).get()), createQuantityKey.evaluate(null, floatingLeg.evaluate()));
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setQuantity((fieldWithMetaNonNegativeQuantitySchedule == null ? Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList() : Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule)))
				.setObservable(mapFloatingRateIndexToRateOptionObservableWithLocation.evaluate(MapperS.of(fpmlFra).<FloatingRateIndex>map("getFloatingRateIndex", fra -> fra.getFloatingRateIndex()).get(), MapperS.of(fpmlFra).<Period>mapC("getIndexTenor", fra -> fra.getIndexTenor())
					.first().get(), floatingLeg.evaluate()))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

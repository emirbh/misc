package cdm.ingest.fpml.confirmation.product.fra.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuantityKey;
import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuantityWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFixedRateToPriceScheduleWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapMoneyToQuantity;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.Fra;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.IdentifiedRate;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFraFixedLegPriceQuantity.MapFraFixedLegPriceQuantityDefault.class)
public abstract class MapFraFixedLegPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithLocation createQuantityWithLocation;
	@Inject protected FixedLeg fixedLeg;
	@Inject protected MapFixedRateToPriceScheduleWithLocation mapFixedRateToPriceScheduleWithLocation;
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

	public static class MapFraFixedLegPriceQuantityDefault extends MapFraFixedLegPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(Fra fpmlFra) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlFra);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, Fra fpmlFra) {
			final FieldWithMetaPriceSchedule fieldWithMetaPriceSchedule = mapFixedRateToPriceScheduleWithLocation.evaluate(MapperS.of(fpmlFra).<IdentifiedRate>map("getFixedRate", fra -> fra.getFixedRate()).<BigDecimal>map("getValue", identifiedRate -> identifiedRate.getValue()).get(), Collections.<Step>emptyList(), MapperS.of(fpmlFra).<Money>map("getNotional", fra -> fra.getNotional()).<Currency>map("getCurrency", money -> money.getCurrency()).get(), fixedLeg.evaluate());
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule = createQuantityWithLocation.evaluate(mapMoneyToQuantity.evaluate(MapperS.of(fpmlFra).<Money>map("getNotional", fra -> fra.getNotional()).get()), createQuantityKey.evaluate(null, fixedLeg.evaluate()));
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setPrice((fieldWithMetaPriceSchedule == null ? Collections.<FieldWithMetaPriceSchedule>emptyList() : Collections.singletonList(fieldWithMetaPriceSchedule)))
				.setQuantity((fieldWithMetaNonNegativeQuantitySchedule == null ? Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList() : Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule)))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

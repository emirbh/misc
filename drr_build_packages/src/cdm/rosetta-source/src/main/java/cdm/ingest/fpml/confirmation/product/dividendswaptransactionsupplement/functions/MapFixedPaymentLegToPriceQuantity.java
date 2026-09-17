package cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalAmountToQuantityWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.dividend.swaps.FixedPaymentAmount;
import fpml.consolidated.dividend.swaps.FixedPaymentLeg;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFixedPaymentLegToPriceQuantity.MapFixedPaymentLegToPriceQuantityDefault.class)
public abstract class MapFixedPaymentLegToPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNotionalAmountToQuantityWithLocation mapNotionalAmountToQuantityWithLocation;

	/**
	* @param fpmlFixedPaymentLeg 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(FixedPaymentLeg fpmlFixedPaymentLeg) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlFixedPaymentLeg);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(FixedPaymentLeg fpmlFixedPaymentLeg);

	protected abstract MapperS<? extends NonNegativeMoney> fpmlFixedPaymentAmount(FixedPaymentLeg fpmlFixedPaymentLeg);

	public static class MapFixedPaymentLegToPriceQuantityDefault extends MapFixedPaymentLegToPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(FixedPaymentLeg fpmlFixedPaymentLeg) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlFixedPaymentLeg);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, FixedPaymentLeg fpmlFixedPaymentLeg) {
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule = mapNotionalAmountToQuantityWithLocation.evaluate(fpmlFixedPaymentAmount(fpmlFixedPaymentLeg).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount()).get(), Collections.<Step>emptyList(), fpmlFixedPaymentAmount(fpmlFixedPaymentLeg).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get(), fpmlFixedPaymentLeg);
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setQuantity((fieldWithMetaNonNegativeQuantitySchedule == null ? Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList() : Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule)))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends NonNegativeMoney> fpmlFixedPaymentAmount(FixedPaymentLeg fpmlFixedPaymentLeg) {
			return MapperS.of(fpmlFixedPaymentLeg).<FixedPaymentAmount>mapC("getFixedPayment", fixedPaymentLeg -> fixedPaymentLeg.getFixedPayment())
				.first().<NonNegativeMoney>map("getPaymentAmount", fixedPaymentAmount -> fixedPaymentAmount.getPaymentAmount());
		}
	}
}

package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalAmountToQuantityWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapRateOptionToObservableWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.InterestCalculation;
import fpml.consolidated.eq.shared.InterestLeg;
import fpml.consolidated.eq.shared.ReturnLeg;
import fpml.consolidated.eq.shared.ReturnSwapNotional;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NotionalAmount;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapInterestLegToPriceQuantity.MapInterestLegToPriceQuantityDefault.class)
public abstract class MapInterestLegToPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapInterestCalculationToPriceListWithLocation mapInterestCalculationToPriceListWithLocation;
	@Inject protected MapNotionalAmountToQuantityWithLocation mapNotionalAmountToQuantityWithLocation;
	@Inject protected MapRateOptionToObservableWithLocation mapRateOptionToObservableWithLocation;

	/**
	* @param fpmlInterestLeg 
	* @param fpmlReturnLeg 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(InterestLeg fpmlInterestLeg, ReturnLeg fpmlReturnLeg) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlInterestLeg, fpmlReturnLeg);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(InterestLeg fpmlInterestLeg, ReturnLeg fpmlReturnLeg);

	public static class MapInterestLegToPriceQuantityDefault extends MapInterestLegToPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(InterestLeg fpmlInterestLeg, ReturnLeg fpmlReturnLeg) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlInterestLeg, fpmlReturnLeg);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, InterestLeg fpmlInterestLeg, ReturnLeg fpmlReturnLeg) {
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule = mapNotionalAmountToQuantityWithLocation.evaluate(MapperS.of(fpmlInterestLeg).<ReturnSwapNotional>map("getNotional", interestLeg -> interestLeg.getNotional()).<NotionalAmount>map("getNotionalAmount", returnSwapNotional -> returnSwapNotional.getNotionalAmount()).<BigDecimal>map("getAmount", notionalAmount -> notionalAmount.getAmount()).get(), Collections.<Step>emptyList(), MapperS.of(fpmlInterestLeg).<ReturnSwapNotional>map("getNotional", interestLeg -> interestLeg.getNotional()).<NotionalAmount>map("getNotionalAmount", returnSwapNotional -> returnSwapNotional.getNotionalAmount()).<Currency>map("getCurrency", notionalAmount -> notionalAmount.getCurrency()).get(), fpmlInterestLeg);
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setPrice(new ArrayList(mapInterestCalculationToPriceListWithLocation.evaluate(MapperS.of(fpmlInterestLeg).<InterestCalculation>map("getInterestCalculation", interestLeg -> interestLeg.getInterestCalculation()).get(), MapperS.of(fpmlInterestLeg).<ReturnSwapNotional>map("getNotional", interestLeg -> interestLeg.getNotional()).<NotionalAmount>map("getNotionalAmount", returnSwapNotional -> returnSwapNotional.getNotionalAmount()).<Currency>map("getCurrency", notionalAmount -> notionalAmount.getCurrency()).getOrDefault(MapperS.of(fpmlReturnLeg).<ReturnSwapNotional>map("getNotional", returnLeg -> returnLeg.getNotional()).<NotionalAmount>map("getNotionalAmount", returnSwapNotional -> returnSwapNotional.getNotionalAmount()).<Currency>map("getCurrency", notionalAmount -> notionalAmount.getCurrency()).get()), fpmlInterestLeg)))
				.setQuantity((fieldWithMetaNonNegativeQuantitySchedule == null ? Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList() : Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule)))
				.setObservable(mapRateOptionToObservableWithLocation.evaluate(MapperS.of(fpmlInterestLeg).<InterestCalculation>map("getInterestCalculation", interestLeg -> interestLeg.getInterestCalculation()).<FloatingRateCalculation>map("getFloatingRateCalculation", interestCalculation -> interestCalculation.getFloatingRateCalculation()).get(), fpmlInterestLeg))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

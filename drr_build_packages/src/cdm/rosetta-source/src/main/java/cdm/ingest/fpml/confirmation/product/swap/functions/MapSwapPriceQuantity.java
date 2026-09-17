package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapRateOptionToObservableWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.Calculation;
import fpml.consolidated.ird.CalculationPeriodAmount;
import fpml.consolidated.ird.InterestRateStream;
import fpml.consolidated.shared.Rate;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSwapPriceQuantity.MapSwapPriceQuantityDefault.class)
public abstract class MapSwapPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCalculationPeriodAmountToPriceList mapCalculationPeriodAmountToPriceList;
	@Inject protected MapCalculationPeriodAmountToQuantityList mapCalculationPeriodAmountToQuantityList;
	@Inject protected MapRateOptionToObservableWithLocation mapRateOptionToObservableWithLocation;

	/**
	* @param fpmlSwapStream 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(InterestRateStream fpmlSwapStream) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlSwapStream);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(InterestRateStream fpmlSwapStream);

	protected abstract MapperS<? extends CalculationPeriodAmount> calculationPeriodAmount(InterestRateStream fpmlSwapStream);

	public static class MapSwapPriceQuantityDefault extends MapSwapPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(InterestRateStream fpmlSwapStream) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlSwapStream);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, InterestRateStream fpmlSwapStream) {
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setPrice(new ArrayList(mapCalculationPeriodAmountToPriceList.evaluate(calculationPeriodAmount(fpmlSwapStream).get(), fpmlSwapStream)))
				.setQuantity(new ArrayList(mapCalculationPeriodAmountToQuantityList.evaluate(calculationPeriodAmount(fpmlSwapStream).get(), fpmlSwapStream)))
				.setObservable(mapRateOptionToObservableWithLocation.evaluate(calculationPeriodAmount(fpmlSwapStream).<Calculation>map("getCalculation", _calculationPeriodAmount -> _calculationPeriodAmount.getCalculation()).<Rate>map("getRateCalculation", calculation -> calculation.getRateCalculation()).get(), fpmlSwapStream))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends CalculationPeriodAmount> calculationPeriodAmount(InterestRateStream fpmlSwapStream) {
			return MapperS.of(fpmlSwapStream).<CalculationPeriodAmount>map("getCalculationPeriodAmount", interestRateStream -> interestRateStream.getCalculationPeriodAmount());
		}
	}
}

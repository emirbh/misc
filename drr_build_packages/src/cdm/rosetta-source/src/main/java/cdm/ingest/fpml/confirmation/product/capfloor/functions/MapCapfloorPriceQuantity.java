package cdm.ingest.fpml.confirmation.product.capfloor.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapRateOptionToObservableWithLocation;
import cdm.ingest.fpml.confirmation.product.swap.functions.MapCalculationPeriodAmountToQuantityList;
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


@ImplementedBy(MapCapfloorPriceQuantity.MapCapfloorPriceQuantityDefault.class)
public abstract class MapCapfloorPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCalculationPeriodAmountToQuantityList mapCalculationPeriodAmountToQuantityList;
	@Inject protected MapCapfloorCalculationPeriodAmountToPriceList mapCapfloorCalculationPeriodAmountToPriceList;
	@Inject protected MapRateOptionToObservableWithLocation mapRateOptionToObservableWithLocation;

	/**
	* @param fpmlCapFloorStream 
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(InterestRateStream fpmlCapFloorStream) {
		PriceQuantity.PriceQuantityBuilder priceQuantityBuilder = doEvaluate(fpmlCapFloorStream);
		
		final PriceQuantity priceQuantity;
		if (priceQuantityBuilder == null) {
			priceQuantity = null;
		} else {
			priceQuantity = priceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, priceQuantity);
		}
		
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(InterestRateStream fpmlCapFloorStream);

	protected abstract MapperS<? extends CalculationPeriodAmount> calculationPeriodAmount(InterestRateStream fpmlCapFloorStream);

	public static class MapCapfloorPriceQuantityDefault extends MapCapfloorPriceQuantity {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(InterestRateStream fpmlCapFloorStream) {
			PriceQuantity.PriceQuantityBuilder priceQuantity = PriceQuantity.builder();
			return assignOutput(priceQuantity, fpmlCapFloorStream);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, InterestRateStream fpmlCapFloorStream) {
			priceQuantity = toBuilder(PriceQuantity.builder()
				.setPrice(new ArrayList(mapCapfloorCalculationPeriodAmountToPriceList.evaluate(calculationPeriodAmount(fpmlCapFloorStream).get(), fpmlCapFloorStream)))
				.setQuantity(new ArrayList(mapCalculationPeriodAmountToQuantityList.evaluate(calculationPeriodAmount(fpmlCapFloorStream).get(), fpmlCapFloorStream)))
				.setObservable(mapRateOptionToObservableWithLocation.evaluate(calculationPeriodAmount(fpmlCapFloorStream).<Calculation>map("getCalculation", _calculationPeriodAmount -> _calculationPeriodAmount.getCalculation()).<Rate>map("getRateCalculation", calculation -> calculation.getRateCalculation()).get(), fpmlCapFloorStream))
				.build());
			
			return Optional.ofNullable(priceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends CalculationPeriodAmount> calculationPeriodAmount(InterestRateStream fpmlCapFloorStream) {
			return MapperS.of(fpmlCapFloorStream).<CalculationPeriodAmount>map("getCalculationPeriodAmount", interestRateStream -> interestRateStream.getCalculationPeriodAmount());
		}
	}
}

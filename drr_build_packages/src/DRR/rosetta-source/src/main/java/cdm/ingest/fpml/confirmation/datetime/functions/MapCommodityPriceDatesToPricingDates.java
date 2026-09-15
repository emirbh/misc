package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.product.common.settlement.PricingDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.com.CommodityPricingDates;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityPriceDatesToPricingDates.MapCommodityPriceDatesToPricingDatesDefault.class)
public abstract class MapCommodityPriceDatesToPricingDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapParametricDates mapParametricDates;

	/**
	* @param fpmlCommodityPricingDates 
	* @return pricingDates 
	*/
	public PricingDates evaluate(CommodityPricingDates fpmlCommodityPricingDates) {
		PricingDates.PricingDatesBuilder pricingDatesBuilder = doEvaluate(fpmlCommodityPricingDates);
		
		final PricingDates pricingDates;
		if (pricingDatesBuilder == null) {
			pricingDates = null;
		} else {
			pricingDates = pricingDatesBuilder.build();
			objectValidator.validate(PricingDates.class, pricingDates);
		}
		
		return pricingDates;
	}

	protected abstract PricingDates.PricingDatesBuilder doEvaluate(CommodityPricingDates fpmlCommodityPricingDates);

	public static class MapCommodityPriceDatesToPricingDatesDefault extends MapCommodityPriceDatesToPricingDates {
		@Override
		protected PricingDates.PricingDatesBuilder doEvaluate(CommodityPricingDates fpmlCommodityPricingDates) {
			PricingDates.PricingDatesBuilder pricingDates = PricingDates.builder();
			return assignOutput(pricingDates, fpmlCommodityPricingDates);
		}
		
		protected PricingDates.PricingDatesBuilder assignOutput(PricingDates.PricingDatesBuilder pricingDates, CommodityPricingDates fpmlCommodityPricingDates) {
			pricingDates = toBuilder(PricingDates.builder()
				.setParametricDates(mapParametricDates.evaluate(fpmlCommodityPricingDates))
				.build());
			
			return Optional.ofNullable(pricingDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

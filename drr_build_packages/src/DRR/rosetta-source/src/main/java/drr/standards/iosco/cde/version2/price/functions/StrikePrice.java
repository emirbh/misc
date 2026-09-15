package drr.standards.iosco.cde.version2.price.functions;

import cdm.observable.asset.PriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.trade.ReportableEventBase;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(StrikePrice.StrikePriceDefault.class)
public abstract class StrikePrice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.price.functions.StrikePrice strikePrice;

	/**
	* @param reportableEvent 
	* @return prices 
	*/
	public PriceSchedule evaluate(ReportableEventBase reportableEvent) {
		PriceSchedule.PriceScheduleBuilder pricesBuilder = doEvaluate(reportableEvent);
		
		final PriceSchedule prices;
		if (pricesBuilder == null) {
			prices = null;
		} else {
			prices = pricesBuilder.build();
			objectValidator.validate(PriceSchedule.class, prices);
		}
		
		return prices;
	}

	protected abstract PriceSchedule.PriceScheduleBuilder doEvaluate(ReportableEventBase reportableEvent);

	public static class StrikePriceDefault extends StrikePrice {
		@Override
		protected PriceSchedule.PriceScheduleBuilder doEvaluate(ReportableEventBase reportableEvent) {
			PriceSchedule.PriceScheduleBuilder prices = PriceSchedule.builder();
			return assignOutput(prices, reportableEvent);
		}
		
		protected PriceSchedule.PriceScheduleBuilder assignOutput(PriceSchedule.PriceScheduleBuilder prices, ReportableEventBase reportableEvent) {
			prices = toBuilder(strikePrice.evaluate(reportableEvent));
			
			return Optional.ofNullable(prices)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

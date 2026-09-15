package drr.regulation.common.functions;

import cdm.observable.asset.PriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableInformationBase;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(LastAvailableSpotPrice.LastAvailableSpotPriceDefault.class)
public abstract class LastAvailableSpotPrice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportableInformation 
	* @return lastAvailableSpotPrice 
	*/
	public PriceSchedule evaluate(ReportableInformationBase reportableInformation) {
		PriceSchedule.PriceScheduleBuilder lastAvailableSpotPriceBuilder = doEvaluate(reportableInformation);
		
		final PriceSchedule lastAvailableSpotPrice;
		if (lastAvailableSpotPriceBuilder == null) {
			lastAvailableSpotPrice = null;
		} else {
			lastAvailableSpotPrice = lastAvailableSpotPriceBuilder.build();
			objectValidator.validate(PriceSchedule.class, lastAvailableSpotPrice);
		}
		
		return lastAvailableSpotPrice;
	}

	protected abstract PriceSchedule.PriceScheduleBuilder doEvaluate(ReportableInformationBase reportableInformation);

	public static class LastAvailableSpotPriceDefault extends LastAvailableSpotPrice {
		@Override
		protected PriceSchedule.PriceScheduleBuilder doEvaluate(ReportableInformationBase reportableInformation) {
			PriceSchedule.PriceScheduleBuilder lastAvailableSpotPrice = PriceSchedule.builder();
			return assignOutput(lastAvailableSpotPrice, reportableInformation);
		}
		
		protected PriceSchedule.PriceScheduleBuilder assignOutput(PriceSchedule.PriceScheduleBuilder lastAvailableSpotPrice, ReportableInformationBase reportableInformation) {
			lastAvailableSpotPrice = toBuilder(MapperS.of(reportableInformation).<PriceSchedule>map("getUnderlyingAssetLastAvailableSpotPrice", reportableInformationBase -> reportableInformationBase.getUnderlyingAssetLastAvailableSpotPrice()).get());
			
			return Optional.ofNullable(lastAvailableSpotPrice)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

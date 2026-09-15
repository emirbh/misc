package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.DatedValue;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCommodityOptionStrikePriceSchedule.MapCommodityOptionStrikePriceScheduleDefault.class)
public abstract class MapCommodityOptionStrikePriceSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlStrikePricePerUnitStep 
	* @param fpmlCommodityStrikePriceDates 
	* @return strikePriceSchedule 
	*/
	public List<? extends DatedValue> evaluate(List<? extends NonNegativeMoney> fpmlStrikePricePerUnitStep, List<Date> fpmlCommodityStrikePriceDates) {
		List<DatedValue.DatedValueBuilder> strikePriceScheduleBuilder = doEvaluate(fpmlStrikePricePerUnitStep, fpmlCommodityStrikePriceDates);
		
		final List<? extends DatedValue> strikePriceSchedule;
		if (strikePriceScheduleBuilder == null) {
			strikePriceSchedule = null;
		} else {
			strikePriceSchedule = strikePriceScheduleBuilder.stream().map(DatedValue::build).collect(Collectors.toList());
			objectValidator.validate(DatedValue.class, strikePriceSchedule);
		}
		
		return strikePriceSchedule;
	}

	protected abstract List<DatedValue.DatedValueBuilder> doEvaluate(List<? extends NonNegativeMoney> fpmlStrikePricePerUnitStep, List<Date> fpmlCommodityStrikePriceDates);

	public static class MapCommodityOptionStrikePriceScheduleDefault extends MapCommodityOptionStrikePriceSchedule {
		@Override
		protected List<DatedValue.DatedValueBuilder> doEvaluate(List<? extends NonNegativeMoney> fpmlStrikePricePerUnitStep, List<Date> fpmlCommodityStrikePriceDates) {
			if (fpmlStrikePricePerUnitStep == null) {
				fpmlStrikePricePerUnitStep = Collections.emptyList();
			}
			if (fpmlCommodityStrikePriceDates == null) {
				fpmlCommodityStrikePriceDates = Collections.emptyList();
			}
			List<DatedValue.DatedValueBuilder> strikePriceSchedule = new ArrayList<>();
			return assignOutput(strikePriceSchedule, fpmlStrikePricePerUnitStep, fpmlCommodityStrikePriceDates);
		}
		
		protected List<DatedValue.DatedValueBuilder> assignOutput(List<DatedValue.DatedValueBuilder> strikePriceSchedule, List<? extends NonNegativeMoney> fpmlStrikePricePerUnitStep, List<Date> fpmlCommodityStrikePriceDates) {
			return Optional.ofNullable(strikePriceSchedule)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

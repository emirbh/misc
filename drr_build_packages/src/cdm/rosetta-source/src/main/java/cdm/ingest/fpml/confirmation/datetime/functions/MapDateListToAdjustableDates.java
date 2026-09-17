package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDateListToAdjustableDates.MapDateListToAdjustableDatesDefault.class)
public abstract class MapDateListToAdjustableDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDateList 
	* @return adjustableDates 
	*/
	public AdjustableDates evaluate(List<Date> fpmlDateList) {
		AdjustableDates.AdjustableDatesBuilder adjustableDatesBuilder = doEvaluate(fpmlDateList);
		
		final AdjustableDates adjustableDates;
		if (adjustableDatesBuilder == null) {
			adjustableDates = null;
		} else {
			adjustableDates = adjustableDatesBuilder.build();
			objectValidator.validate(AdjustableDates.class, adjustableDates);
		}
		
		return adjustableDates;
	}

	protected abstract AdjustableDates.AdjustableDatesBuilder doEvaluate(List<Date> fpmlDateList);

	public static class MapDateListToAdjustableDatesDefault extends MapDateListToAdjustableDates {
		@Override
		protected AdjustableDates.AdjustableDatesBuilder doEvaluate(List<Date> fpmlDateList) {
			if (fpmlDateList == null) {
				fpmlDateList = Collections.emptyList();
			}
			AdjustableDates.AdjustableDatesBuilder adjustableDates = AdjustableDates.builder();
			return assignOutput(adjustableDates, fpmlDateList);
		}
		
		protected AdjustableDates.AdjustableDatesBuilder assignOutput(AdjustableDates.AdjustableDatesBuilder adjustableDates, List<Date> fpmlDateList) {
			adjustableDates = toBuilder(AdjustableDates.builder()
				.setAdjustedDateValue(fpmlDateList)
				.build());
			
			return Optional.ofNullable(adjustableDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

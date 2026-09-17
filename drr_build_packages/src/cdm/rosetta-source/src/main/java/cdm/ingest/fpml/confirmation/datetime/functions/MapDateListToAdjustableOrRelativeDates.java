package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableOrRelativeDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDateListToAdjustableOrRelativeDates.MapDateListToAdjustableOrRelativeDatesDefault.class)
public abstract class MapDateListToAdjustableOrRelativeDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDateListToAdjustableDates mapDateListToAdjustableDates;

	/**
	* @param fpmlDateList 
	* @return adjustableOrRelativeDates 
	*/
	public AdjustableOrRelativeDates evaluate(List<Date> fpmlDateList) {
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder adjustableOrRelativeDatesBuilder = doEvaluate(fpmlDateList);
		
		final AdjustableOrRelativeDates adjustableOrRelativeDates;
		if (adjustableOrRelativeDatesBuilder == null) {
			adjustableOrRelativeDates = null;
		} else {
			adjustableOrRelativeDates = adjustableOrRelativeDatesBuilder.build();
			objectValidator.validate(AdjustableOrRelativeDates.class, adjustableOrRelativeDates);
		}
		
		return adjustableOrRelativeDates;
	}

	protected abstract AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder doEvaluate(List<Date> fpmlDateList);

	public static class MapDateListToAdjustableOrRelativeDatesDefault extends MapDateListToAdjustableOrRelativeDates {
		@Override
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder doEvaluate(List<Date> fpmlDateList) {
			if (fpmlDateList == null) {
				fpmlDateList = Collections.emptyList();
			}
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder adjustableOrRelativeDates = AdjustableOrRelativeDates.builder();
			return assignOutput(adjustableOrRelativeDates, fpmlDateList);
		}
		
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder assignOutput(AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder adjustableOrRelativeDates, List<Date> fpmlDateList) {
			adjustableOrRelativeDates = toBuilder(AdjustableOrRelativeDates.builder()
				.setAdjustableDates(mapDateListToAdjustableDates.evaluate(fpmlDateList))
				.build());
			
			return Optional.ofNullable(adjustableOrRelativeDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableDatesOrRelativeDateOffset.MapAdjustableDatesOrRelativeDateOffsetDefault.class)
public abstract class MapAdjustableDatesOrRelativeDateOffset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDates mapAdjustableDates;

	/**
	* @param fpmlAdjustableDatesOrRelativeDateOffset 
	* @return adjustableRelativeOrPeriodicDates 
	*/
	public AdjustableRelativeOrPeriodicDates evaluate(AdjustableDatesOrRelativeDateOffset fpmlAdjustableDatesOrRelativeDateOffset) {
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder adjustableRelativeOrPeriodicDatesBuilder = doEvaluate(fpmlAdjustableDatesOrRelativeDateOffset);
		
		final AdjustableRelativeOrPeriodicDates adjustableRelativeOrPeriodicDates;
		if (adjustableRelativeOrPeriodicDatesBuilder == null) {
			adjustableRelativeOrPeriodicDates = null;
		} else {
			adjustableRelativeOrPeriodicDates = adjustableRelativeOrPeriodicDatesBuilder.build();
			objectValidator.validate(AdjustableRelativeOrPeriodicDates.class, adjustableRelativeOrPeriodicDates);
		}
		
		return adjustableRelativeOrPeriodicDates;
	}

	protected abstract AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder doEvaluate(AdjustableDatesOrRelativeDateOffset fpmlAdjustableDatesOrRelativeDateOffset);

	public static class MapAdjustableDatesOrRelativeDateOffsetDefault extends MapAdjustableDatesOrRelativeDateOffset {
		@Override
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder doEvaluate(AdjustableDatesOrRelativeDateOffset fpmlAdjustableDatesOrRelativeDateOffset) {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder adjustableRelativeOrPeriodicDates = AdjustableRelativeOrPeriodicDates.builder();
			return assignOutput(adjustableRelativeOrPeriodicDates, fpmlAdjustableDatesOrRelativeDateOffset);
		}
		
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder assignOutput(AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder adjustableRelativeOrPeriodicDates, AdjustableDatesOrRelativeDateOffset fpmlAdjustableDatesOrRelativeDateOffset) {
			adjustableRelativeOrPeriodicDates = toBuilder(AdjustableRelativeOrPeriodicDates.builder()
				.setAdjustableDates(mapAdjustableDates.evaluate(MapperS.of(fpmlAdjustableDatesOrRelativeDateOffset).<AdjustableDates>map("getAdjustableDates", adjustableDatesOrRelativeDateOffset -> adjustableDatesOrRelativeDateOffset.getAdjustableDates()).get()))
				.build());
			
			return Optional.ofNullable(adjustableRelativeOrPeriodicDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

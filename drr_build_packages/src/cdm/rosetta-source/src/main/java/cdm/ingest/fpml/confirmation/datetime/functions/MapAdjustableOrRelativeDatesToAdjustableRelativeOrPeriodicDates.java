package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableOrRelativeDates;
import fpml.consolidated.shared.RelativeDates;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableOrRelativeDatesToAdjustableRelativeOrPeriodicDates.MapAdjustableOrRelativeDatesToAdjustableRelativeOrPeriodicDatesDefault.class)
public abstract class MapAdjustableOrRelativeDatesToAdjustableRelativeOrPeriodicDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDates mapAdjustableDates;
	@Inject protected MapRelativeDates mapRelativeDates;

	/**
	* @param fpmlAdjustableOrRelativeDates 
	* @return adjustableRelativeOrPeriodicDates 
	*/
	public AdjustableRelativeOrPeriodicDates evaluate(AdjustableOrRelativeDates fpmlAdjustableOrRelativeDates) {
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder adjustableRelativeOrPeriodicDatesBuilder = doEvaluate(fpmlAdjustableOrRelativeDates);
		
		final AdjustableRelativeOrPeriodicDates adjustableRelativeOrPeriodicDates;
		if (adjustableRelativeOrPeriodicDatesBuilder == null) {
			adjustableRelativeOrPeriodicDates = null;
		} else {
			adjustableRelativeOrPeriodicDates = adjustableRelativeOrPeriodicDatesBuilder.build();
			objectValidator.validate(AdjustableRelativeOrPeriodicDates.class, adjustableRelativeOrPeriodicDates);
		}
		
		return adjustableRelativeOrPeriodicDates;
	}

	protected abstract AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder doEvaluate(AdjustableOrRelativeDates fpmlAdjustableOrRelativeDates);

	public static class MapAdjustableOrRelativeDatesToAdjustableRelativeOrPeriodicDatesDefault extends MapAdjustableOrRelativeDatesToAdjustableRelativeOrPeriodicDates {
		@Override
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder doEvaluate(AdjustableOrRelativeDates fpmlAdjustableOrRelativeDates) {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder adjustableRelativeOrPeriodicDates = AdjustableRelativeOrPeriodicDates.builder();
			return assignOutput(adjustableRelativeOrPeriodicDates, fpmlAdjustableOrRelativeDates);
		}
		
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder assignOutput(AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder adjustableRelativeOrPeriodicDates, AdjustableOrRelativeDates fpmlAdjustableOrRelativeDates) {
			final AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder withMetaArgument = AdjustableRelativeOrPeriodicDates.builder()
				.setAdjustableDates(mapAdjustableDates.evaluate(MapperS.of(fpmlAdjustableOrRelativeDates).<AdjustableDates>map("getAdjustableDates", adjustableOrRelativeDates -> adjustableOrRelativeDates.getAdjustableDates()).get()))
				.setRelativeDates(mapRelativeDates.evaluate(MapperS.of(fpmlAdjustableOrRelativeDates).<RelativeDates>map("getRelativeDates", adjustableOrRelativeDates -> adjustableOrRelativeDates.getRelativeDates()).get()))
				.build() == null ? null : AdjustableRelativeOrPeriodicDates.builder()
				.setAdjustableDates(mapAdjustableDates.evaluate(MapperS.of(fpmlAdjustableOrRelativeDates).<AdjustableDates>map("getAdjustableDates", adjustableOrRelativeDates -> adjustableOrRelativeDates.getAdjustableDates()).get()))
				.setRelativeDates(mapRelativeDates.evaluate(MapperS.of(fpmlAdjustableOrRelativeDates).<RelativeDates>map("getRelativeDates", adjustableOrRelativeDates -> adjustableOrRelativeDates.getRelativeDates()).get()))
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlAdjustableOrRelativeDates).<String>map("getId", adjustableOrRelativeDates -> adjustableOrRelativeDates.getId()).get());
			adjustableRelativeOrPeriodicDates = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(adjustableRelativeOrPeriodicDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

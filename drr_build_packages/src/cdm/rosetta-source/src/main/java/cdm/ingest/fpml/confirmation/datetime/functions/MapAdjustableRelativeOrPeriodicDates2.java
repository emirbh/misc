package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates2;
import fpml.consolidated.shared.PeriodicDates;
import fpml.consolidated.shared.RelativeDates;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableRelativeOrPeriodicDates2.MapAdjustableRelativeOrPeriodicDates2Default.class)
public abstract class MapAdjustableRelativeOrPeriodicDates2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDates mapAdjustableDates;
	@Inject protected MapPeriodicDates mapPeriodicDates;
	@Inject protected MapRelativeDates mapRelativeDates;

	/**
	* @param fpmlAdjustableRelativeOrPeriodicDates2 
	* @return adjustableRelativeOrPeriodicDates 
	*/
	public AdjustableRelativeOrPeriodicDates evaluate(AdjustableRelativeOrPeriodicDates2 fpmlAdjustableRelativeOrPeriodicDates2) {
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder adjustableRelativeOrPeriodicDatesBuilder = doEvaluate(fpmlAdjustableRelativeOrPeriodicDates2);
		
		final AdjustableRelativeOrPeriodicDates adjustableRelativeOrPeriodicDates;
		if (adjustableRelativeOrPeriodicDatesBuilder == null) {
			adjustableRelativeOrPeriodicDates = null;
		} else {
			adjustableRelativeOrPeriodicDates = adjustableRelativeOrPeriodicDatesBuilder.build();
			objectValidator.validate(AdjustableRelativeOrPeriodicDates.class, adjustableRelativeOrPeriodicDates);
		}
		
		return adjustableRelativeOrPeriodicDates;
	}

	protected abstract AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder doEvaluate(AdjustableRelativeOrPeriodicDates2 fpmlAdjustableRelativeOrPeriodicDates2);

	public static class MapAdjustableRelativeOrPeriodicDates2Default extends MapAdjustableRelativeOrPeriodicDates2 {
		@Override
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder doEvaluate(AdjustableRelativeOrPeriodicDates2 fpmlAdjustableRelativeOrPeriodicDates2) {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder adjustableRelativeOrPeriodicDates = AdjustableRelativeOrPeriodicDates.builder();
			return assignOutput(adjustableRelativeOrPeriodicDates, fpmlAdjustableRelativeOrPeriodicDates2);
		}
		
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder assignOutput(AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder adjustableRelativeOrPeriodicDates, AdjustableRelativeOrPeriodicDates2 fpmlAdjustableRelativeOrPeriodicDates2) {
			final AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder withMetaArgument = AdjustableRelativeOrPeriodicDates.builder()
				.setAdjustableDates(mapAdjustableDates.evaluate(MapperS.of(fpmlAdjustableRelativeOrPeriodicDates2).<AdjustableDates>map("getAdjustableDates", adjustableRelativeOrPeriodicDates2 -> adjustableRelativeOrPeriodicDates2.getAdjustableDates()).get()))
				.setRelativeDates(mapRelativeDates.evaluate(MapperS.of(fpmlAdjustableRelativeOrPeriodicDates2).<RelativeDates>map("getRelativeDates", adjustableRelativeOrPeriodicDates2 -> adjustableRelativeOrPeriodicDates2.getRelativeDates()).get()))
				.setPeriodicDates(mapPeriodicDates.evaluate(MapperS.of(fpmlAdjustableRelativeOrPeriodicDates2).<PeriodicDates>map("getPeriodicDates", adjustableRelativeOrPeriodicDates2 -> adjustableRelativeOrPeriodicDates2.getPeriodicDates()).get()))
				.build() == null ? null : AdjustableRelativeOrPeriodicDates.builder()
				.setAdjustableDates(mapAdjustableDates.evaluate(MapperS.of(fpmlAdjustableRelativeOrPeriodicDates2).<AdjustableDates>map("getAdjustableDates", adjustableRelativeOrPeriodicDates2 -> adjustableRelativeOrPeriodicDates2.getAdjustableDates()).get()))
				.setRelativeDates(mapRelativeDates.evaluate(MapperS.of(fpmlAdjustableRelativeOrPeriodicDates2).<RelativeDates>map("getRelativeDates", adjustableRelativeOrPeriodicDates2 -> adjustableRelativeOrPeriodicDates2.getRelativeDates()).get()))
				.setPeriodicDates(mapPeriodicDates.evaluate(MapperS.of(fpmlAdjustableRelativeOrPeriodicDates2).<PeriodicDates>map("getPeriodicDates", adjustableRelativeOrPeriodicDates2 -> adjustableRelativeOrPeriodicDates2.getPeriodicDates()).get()))
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlAdjustableRelativeOrPeriodicDates2).<String>map("getId", adjustableRelativeOrPeriodicDates2 -> adjustableRelativeOrPeriodicDates2.getId()).get());
			adjustableRelativeOrPeriodicDates = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(adjustableRelativeOrPeriodicDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

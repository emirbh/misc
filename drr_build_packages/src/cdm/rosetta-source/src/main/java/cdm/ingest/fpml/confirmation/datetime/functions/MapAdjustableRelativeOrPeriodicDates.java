package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.PeriodicDates;
import fpml.consolidated.shared.RelativeDateSequence;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableRelativeOrPeriodicDates.MapAdjustableRelativeOrPeriodicDatesDefault.class)
public abstract class MapAdjustableRelativeOrPeriodicDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDates mapAdjustableDates;
	@Inject protected MapPeriodicDates mapPeriodicDates;
	@Inject protected MapRelativeDateSequenceToRelativeDates mapRelativeDateSequenceToRelativeDates;

	/**
	* @param fpmlAdjustableRelativeOrPeriodicDates 
	* @return adjustableRelativeOrPeriodicDates 
	*/
	public AdjustableRelativeOrPeriodicDates evaluate(fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates fpmlAdjustableRelativeOrPeriodicDates) {
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder adjustableRelativeOrPeriodicDatesBuilder = doEvaluate(fpmlAdjustableRelativeOrPeriodicDates);
		
		final AdjustableRelativeOrPeriodicDates adjustableRelativeOrPeriodicDates;
		if (adjustableRelativeOrPeriodicDatesBuilder == null) {
			adjustableRelativeOrPeriodicDates = null;
		} else {
			adjustableRelativeOrPeriodicDates = adjustableRelativeOrPeriodicDatesBuilder.build();
			objectValidator.validate(AdjustableRelativeOrPeriodicDates.class, adjustableRelativeOrPeriodicDates);
		}
		
		return adjustableRelativeOrPeriodicDates;
	}

	protected abstract AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder doEvaluate(fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates fpmlAdjustableRelativeOrPeriodicDates);

	public static class MapAdjustableRelativeOrPeriodicDatesDefault extends MapAdjustableRelativeOrPeriodicDates {
		@Override
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder doEvaluate(fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates fpmlAdjustableRelativeOrPeriodicDates) {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder adjustableRelativeOrPeriodicDates = AdjustableRelativeOrPeriodicDates.builder();
			return assignOutput(adjustableRelativeOrPeriodicDates, fpmlAdjustableRelativeOrPeriodicDates);
		}
		
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder assignOutput(AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder adjustableRelativeOrPeriodicDates, fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates fpmlAdjustableRelativeOrPeriodicDates) {
			final AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder withMetaArgument = AdjustableRelativeOrPeriodicDates.builder()
				.setAdjustableDates(mapAdjustableDates.evaluate(MapperS.of(fpmlAdjustableRelativeOrPeriodicDates).<AdjustableDates>map("getAdjustableDates", _adjustableRelativeOrPeriodicDates -> _adjustableRelativeOrPeriodicDates.getAdjustableDates()).get()))
				.setRelativeDates(mapRelativeDateSequenceToRelativeDates.evaluate(MapperS.of(fpmlAdjustableRelativeOrPeriodicDates).<RelativeDateSequence>map("getRelativeDateSequence", _adjustableRelativeOrPeriodicDates -> _adjustableRelativeOrPeriodicDates.getRelativeDateSequence()).get()))
				.setPeriodicDates(mapPeriodicDates.evaluate(MapperS.of(fpmlAdjustableRelativeOrPeriodicDates).<PeriodicDates>map("getPeriodicDates", _adjustableRelativeOrPeriodicDates -> _adjustableRelativeOrPeriodicDates.getPeriodicDates()).get()))
				.build() == null ? null : AdjustableRelativeOrPeriodicDates.builder()
				.setAdjustableDates(mapAdjustableDates.evaluate(MapperS.of(fpmlAdjustableRelativeOrPeriodicDates).<AdjustableDates>map("getAdjustableDates", _adjustableRelativeOrPeriodicDates -> _adjustableRelativeOrPeriodicDates.getAdjustableDates()).get()))
				.setRelativeDates(mapRelativeDateSequenceToRelativeDates.evaluate(MapperS.of(fpmlAdjustableRelativeOrPeriodicDates).<RelativeDateSequence>map("getRelativeDateSequence", _adjustableRelativeOrPeriodicDates -> _adjustableRelativeOrPeriodicDates.getRelativeDateSequence()).get()))
				.setPeriodicDates(mapPeriodicDates.evaluate(MapperS.of(fpmlAdjustableRelativeOrPeriodicDates).<PeriodicDates>map("getPeriodicDates", _adjustableRelativeOrPeriodicDates -> _adjustableRelativeOrPeriodicDates.getPeriodicDates()).get()))
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlAdjustableRelativeOrPeriodicDates).<String>map("getId", _adjustableRelativeOrPeriodicDates -> _adjustableRelativeOrPeriodicDates.getId()).get());
			adjustableRelativeOrPeriodicDates = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(adjustableRelativeOrPeriodicDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

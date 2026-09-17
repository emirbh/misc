package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AdjustedRelativeDateOffset;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableDateOrAdjustedRelativeDate.MapAdjustableDateOrAdjustedRelativeDateDefault.class)
public abstract class MapAdjustableDateOrAdjustedRelativeDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDate mapAdjustableDate;
	@Inject protected MapAdjustedRelativeDateOffset mapAdjustedRelativeDateOffset;

	/**
	* @param fpmlAdjustableDate 
	* @param fpmlRelativeDate 
	* @return adjustableOrRelativeDate 
	*/
	public AdjustableOrRelativeDate evaluate(AdjustableDate fpmlAdjustableDate, AdjustedRelativeDateOffset fpmlRelativeDate) {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDateBuilder = doEvaluate(fpmlAdjustableDate, fpmlRelativeDate);
		
		final AdjustableOrRelativeDate adjustableOrRelativeDate;
		if (adjustableOrRelativeDateBuilder == null) {
			adjustableOrRelativeDate = null;
		} else {
			adjustableOrRelativeDate = adjustableOrRelativeDateBuilder.build();
			objectValidator.validate(AdjustableOrRelativeDate.class, adjustableOrRelativeDate);
		}
		
		return adjustableOrRelativeDate;
	}

	protected abstract AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(AdjustableDate fpmlAdjustableDate, AdjustedRelativeDateOffset fpmlRelativeDate);

	public static class MapAdjustableDateOrAdjustedRelativeDateDefault extends MapAdjustableDateOrAdjustedRelativeDate {
		@Override
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(AdjustableDate fpmlAdjustableDate, AdjustedRelativeDateOffset fpmlRelativeDate) {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate = AdjustableOrRelativeDate.builder();
			return assignOutput(adjustableOrRelativeDate, fpmlAdjustableDate, fpmlRelativeDate);
		}
		
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder assignOutput(AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate, AdjustableDate fpmlAdjustableDate, AdjustedRelativeDateOffset fpmlRelativeDate) {
			adjustableOrRelativeDate = toBuilder(AdjustableOrRelativeDate.builder()
				.setAdjustableDate(mapAdjustableDate.evaluate(fpmlAdjustableDate))
				.setRelativeDate(mapAdjustedRelativeDateOffset.evaluate(fpmlRelativeDate))
				.build());
			
			return Optional.ofNullable(adjustableOrRelativeDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

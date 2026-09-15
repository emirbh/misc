package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.AdjustableDate2;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableDate2ToAdjustableOrRelativeDate.MapAdjustableDate2ToAdjustableOrRelativeDateDefault.class)
public abstract class MapAdjustableDate2ToAdjustableOrRelativeDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDate2ToAdjustableDate mapAdjustableDate2ToAdjustableDate;

	/**
	* @param fpmlAdjustableDate2 
	* @return adjustableOrRelativeDate 
	*/
	public AdjustableOrRelativeDate evaluate(AdjustableDate2 fpmlAdjustableDate2) {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDateBuilder = doEvaluate(fpmlAdjustableDate2);
		
		final AdjustableOrRelativeDate adjustableOrRelativeDate;
		if (adjustableOrRelativeDateBuilder == null) {
			adjustableOrRelativeDate = null;
		} else {
			adjustableOrRelativeDate = adjustableOrRelativeDateBuilder.build();
			objectValidator.validate(AdjustableOrRelativeDate.class, adjustableOrRelativeDate);
		}
		
		return adjustableOrRelativeDate;
	}

	protected abstract AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(AdjustableDate2 fpmlAdjustableDate2);

	public static class MapAdjustableDate2ToAdjustableOrRelativeDateDefault extends MapAdjustableDate2ToAdjustableOrRelativeDate {
		@Override
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(AdjustableDate2 fpmlAdjustableDate2) {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate = AdjustableOrRelativeDate.builder();
			return assignOutput(adjustableOrRelativeDate, fpmlAdjustableDate2);
		}
		
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder assignOutput(AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate, AdjustableDate2 fpmlAdjustableDate2) {
			adjustableOrRelativeDate = toBuilder(AdjustableOrRelativeDate.builder()
				.setAdjustableDate(mapAdjustableDate2ToAdjustableDate.evaluate(fpmlAdjustableDate2))
				.build());
			
			return Optional.ofNullable(adjustableOrRelativeDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

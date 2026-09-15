package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustedDateToAdjustableOrRelativeDate.MapAdjustedDateToAdjustableOrRelativeDateDefault.class)
public abstract class MapAdjustedDateToAdjustableOrRelativeDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustedDateToAdjustableDate mapAdjustedDateToAdjustableDate;

	/**
	* @param adjustedDate 
	* @param id 
	* @return adjustableOrRelativeDate 
	*/
	public AdjustableOrRelativeDate evaluate(Date adjustedDate, String id) {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDateBuilder = doEvaluate(adjustedDate, id);
		
		final AdjustableOrRelativeDate adjustableOrRelativeDate;
		if (adjustableOrRelativeDateBuilder == null) {
			adjustableOrRelativeDate = null;
		} else {
			adjustableOrRelativeDate = adjustableOrRelativeDateBuilder.build();
			objectValidator.validate(AdjustableOrRelativeDate.class, adjustableOrRelativeDate);
		}
		
		return adjustableOrRelativeDate;
	}

	protected abstract AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(Date adjustedDate, String id);

	public static class MapAdjustedDateToAdjustableOrRelativeDateDefault extends MapAdjustedDateToAdjustableOrRelativeDate {
		@Override
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(Date adjustedDate, String id) {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate = AdjustableOrRelativeDate.builder();
			return assignOutput(adjustableOrRelativeDate, adjustedDate, id);
		}
		
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder assignOutput(AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate, Date adjustedDate, String id) {
			adjustableOrRelativeDate = toBuilder(AdjustableOrRelativeDate.builder()
				.setAdjustableDate(mapAdjustedDateToAdjustableDate.evaluate(adjustedDate))
				.build(), () -> AdjustableOrRelativeDate.builder());
			
			adjustableOrRelativeDate
				.getOrCreateMeta().setExternalKey(id);
			
			return Optional.ofNullable(adjustableOrRelativeDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

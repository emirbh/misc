package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustedDateToAdjustableDate.MapAdjustedDateToAdjustableDateDefault.class)
public abstract class MapAdjustedDateToAdjustableDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param adjustedDate 
	* @return adjustableDate 
	*/
	public AdjustableDate evaluate(Date adjustedDate) {
		AdjustableDate.AdjustableDateBuilder adjustableDateBuilder = doEvaluate(adjustedDate);
		
		final AdjustableDate adjustableDate;
		if (adjustableDateBuilder == null) {
			adjustableDate = null;
		} else {
			adjustableDate = adjustableDateBuilder.build();
			objectValidator.validate(AdjustableDate.class, adjustableDate);
		}
		
		return adjustableDate;
	}

	protected abstract AdjustableDate.AdjustableDateBuilder doEvaluate(Date adjustedDate);

	public static class MapAdjustedDateToAdjustableDateDefault extends MapAdjustedDateToAdjustableDate {
		@Override
		protected AdjustableDate.AdjustableDateBuilder doEvaluate(Date adjustedDate) {
			AdjustableDate.AdjustableDateBuilder adjustableDate = AdjustableDate.builder();
			return assignOutput(adjustableDate, adjustedDate);
		}
		
		protected AdjustableDate.AdjustableDateBuilder assignOutput(AdjustableDate.AdjustableDateBuilder adjustableDate, Date adjustedDate) {
			adjustableDate = toBuilder(AdjustableDate.builder()
				.setAdjustedDateValue(adjustedDate)
				.build());
			
			return Optional.ofNullable(adjustableDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

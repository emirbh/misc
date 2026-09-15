package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDateToAdjustableDate.MapDateToAdjustableDateDefault.class)
public abstract class MapDateToAdjustableDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDateList 
	* @return adjustableDate 
	*/
	public AdjustableDate evaluate(Date fpmlDateList) {
		AdjustableDate.AdjustableDateBuilder adjustableDateBuilder = doEvaluate(fpmlDateList);
		
		final AdjustableDate adjustableDate;
		if (adjustableDateBuilder == null) {
			adjustableDate = null;
		} else {
			adjustableDate = adjustableDateBuilder.build();
			objectValidator.validate(AdjustableDate.class, adjustableDate);
		}
		
		return adjustableDate;
	}

	protected abstract AdjustableDate.AdjustableDateBuilder doEvaluate(Date fpmlDateList);

	public static class MapDateToAdjustableDateDefault extends MapDateToAdjustableDate {
		@Override
		protected AdjustableDate.AdjustableDateBuilder doEvaluate(Date fpmlDateList) {
			AdjustableDate.AdjustableDateBuilder adjustableDate = AdjustableDate.builder();
			return assignOutput(adjustableDate, fpmlDateList);
		}
		
		protected AdjustableDate.AdjustableDateBuilder assignOutput(AdjustableDate.AdjustableDateBuilder adjustableDate, Date fpmlDateList) {
			adjustableDate = toBuilder(AdjustableDate.builder()
				.setAdjustedDateValue(fpmlDateList)
				.build());
			
			return Optional.ofNullable(adjustableDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

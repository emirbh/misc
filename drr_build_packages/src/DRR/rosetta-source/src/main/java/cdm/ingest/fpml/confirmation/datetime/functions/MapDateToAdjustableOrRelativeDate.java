package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDateToAdjustableOrRelativeDate.MapDateToAdjustableOrRelativeDateDefault.class)
public abstract class MapDateToAdjustableOrRelativeDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDateToAdjustableDate mapDateToAdjustableDate;

	/**
	* @param fpmlDateList 
	* @return adjustableOrRelativeDate 
	*/
	public AdjustableOrRelativeDate evaluate(Date fpmlDateList) {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDateBuilder = doEvaluate(fpmlDateList);
		
		final AdjustableOrRelativeDate adjustableOrRelativeDate;
		if (adjustableOrRelativeDateBuilder == null) {
			adjustableOrRelativeDate = null;
		} else {
			adjustableOrRelativeDate = adjustableOrRelativeDateBuilder.build();
			objectValidator.validate(AdjustableOrRelativeDate.class, adjustableOrRelativeDate);
		}
		
		return adjustableOrRelativeDate;
	}

	protected abstract AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(Date fpmlDateList);

	public static class MapDateToAdjustableOrRelativeDateDefault extends MapDateToAdjustableOrRelativeDate {
		@Override
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(Date fpmlDateList) {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate = AdjustableOrRelativeDate.builder();
			return assignOutput(adjustableOrRelativeDate, fpmlDateList);
		}
		
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder assignOutput(AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate, Date fpmlDateList) {
			adjustableOrRelativeDate = toBuilder(AdjustableOrRelativeDate.builder()
				.setAdjustableDate(mapDateToAdjustableDate.evaluate(fpmlDateList))
				.build());
			
			return Optional.ofNullable(adjustableOrRelativeDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

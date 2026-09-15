package cdm.ingest.fpml.confirmation.product.fra.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapRelativeDateOffset;
import cdm.product.common.schedule.ResetDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFraResetDates.MapFraResetDatesDefault.class)
public abstract class MapFraResetDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;

	/**
	* @param fpmlRelativeDateOffset 
	* @return resetDates 
	*/
	public ResetDates evaluate(RelativeDateOffset fpmlRelativeDateOffset) {
		ResetDates.ResetDatesBuilder resetDatesBuilder = doEvaluate(fpmlRelativeDateOffset);
		
		final ResetDates resetDates;
		if (resetDatesBuilder == null) {
			resetDates = null;
		} else {
			resetDates = resetDatesBuilder.build();
			objectValidator.validate(ResetDates.class, resetDates);
		}
		
		return resetDates;
	}

	protected abstract ResetDates.ResetDatesBuilder doEvaluate(RelativeDateOffset fpmlRelativeDateOffset);

	public static class MapFraResetDatesDefault extends MapFraResetDates {
		@Override
		protected ResetDates.ResetDatesBuilder doEvaluate(RelativeDateOffset fpmlRelativeDateOffset) {
			ResetDates.ResetDatesBuilder resetDates = ResetDates.builder();
			return assignOutput(resetDates, fpmlRelativeDateOffset);
		}
		
		protected ResetDates.ResetDatesBuilder assignOutput(ResetDates.ResetDatesBuilder resetDates, RelativeDateOffset fpmlRelativeDateOffset) {
			resetDates = toBuilder(ResetDates.builder()
				.setFixingDates(mapRelativeDateOffset.evaluate(fpmlRelativeDateOffset))
				.build());
			
			return Optional.ofNullable(resetDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

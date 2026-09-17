package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapUnadjustedDateToAdjustableDate.MapUnadjustedDateToAdjustableDateDefault.class)
public abstract class MapUnadjustedDateToAdjustableDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param unadjustedDate 
	* @return adjustableDate 
	*/
	public AdjustableDate evaluate(Date unadjustedDate) {
		AdjustableDate.AdjustableDateBuilder adjustableDateBuilder = doEvaluate(unadjustedDate);
		
		final AdjustableDate adjustableDate;
		if (adjustableDateBuilder == null) {
			adjustableDate = null;
		} else {
			adjustableDate = adjustableDateBuilder.build();
			objectValidator.validate(AdjustableDate.class, adjustableDate);
		}
		
		return adjustableDate;
	}

	protected abstract AdjustableDate.AdjustableDateBuilder doEvaluate(Date unadjustedDate);

	public static class MapUnadjustedDateToAdjustableDateDefault extends MapUnadjustedDateToAdjustableDate {
		@Override
		protected AdjustableDate.AdjustableDateBuilder doEvaluate(Date unadjustedDate) {
			AdjustableDate.AdjustableDateBuilder adjustableDate = AdjustableDate.builder();
			return assignOutput(adjustableDate, unadjustedDate);
		}
		
		protected AdjustableDate.AdjustableDateBuilder assignOutput(AdjustableDate.AdjustableDateBuilder adjustableDate, Date unadjustedDate) {
			adjustableDate = toBuilder(AdjustableDate.builder()
				.setUnadjustedDate(unadjustedDate)
				.build());
			
			return Optional.ofNullable(adjustableDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

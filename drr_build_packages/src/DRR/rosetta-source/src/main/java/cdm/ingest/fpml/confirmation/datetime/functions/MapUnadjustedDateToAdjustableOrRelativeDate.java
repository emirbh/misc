package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapUnadjustedDateToAdjustableOrRelativeDate.MapUnadjustedDateToAdjustableOrRelativeDateDefault.class)
public abstract class MapUnadjustedDateToAdjustableOrRelativeDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapUnadjustedDateToAdjustableDate mapUnadjustedDateToAdjustableDate;

	/**
	* @param unadjustedDate 
	* @param id 
	* @return adjustableOrRelativeDate 
	*/
	public AdjustableOrRelativeDate evaluate(Date unadjustedDate, String id) {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDateBuilder = doEvaluate(unadjustedDate, id);
		
		final AdjustableOrRelativeDate adjustableOrRelativeDate;
		if (adjustableOrRelativeDateBuilder == null) {
			adjustableOrRelativeDate = null;
		} else {
			adjustableOrRelativeDate = adjustableOrRelativeDateBuilder.build();
			objectValidator.validate(AdjustableOrRelativeDate.class, adjustableOrRelativeDate);
		}
		
		return adjustableOrRelativeDate;
	}

	protected abstract AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(Date unadjustedDate, String id);

	public static class MapUnadjustedDateToAdjustableOrRelativeDateDefault extends MapUnadjustedDateToAdjustableOrRelativeDate {
		@Override
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(Date unadjustedDate, String id) {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate = AdjustableOrRelativeDate.builder();
			return assignOutput(adjustableOrRelativeDate, unadjustedDate, id);
		}
		
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder assignOutput(AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate, Date unadjustedDate, String id) {
			adjustableOrRelativeDate = toBuilder(AdjustableOrRelativeDate.builder()
				.setAdjustableDate(mapUnadjustedDateToAdjustableDate.evaluate(unadjustedDate))
				.build(), () -> AdjustableOrRelativeDate.builder());
			
			adjustableOrRelativeDate
				.getOrCreateMeta().setExternalKey(id);
			
			return Optional.ofNullable(adjustableOrRelativeDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.shared.AdjustableOrAdjustedDate;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.IdentifiedDate;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableOrAdjustedDateToAdjustableOrAdjustedOrRelativeDate.MapAdjustableOrAdjustedDateToAdjustableOrAdjustedOrRelativeDateDefault.class)
public abstract class MapAdjustableOrAdjustedDateToAdjustableOrAdjustedOrRelativeDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;

	/**
	* @param fpmlAdjustableOrAdjustedDate 
	* @return adjustableOrAdjustedOrRelativeDate 
	*/
	public AdjustableOrAdjustedOrRelativeDate evaluate(AdjustableOrAdjustedDate fpmlAdjustableOrAdjustedDate) {
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder adjustableOrAdjustedOrRelativeDateBuilder = doEvaluate(fpmlAdjustableOrAdjustedDate);
		
		final AdjustableOrAdjustedOrRelativeDate adjustableOrAdjustedOrRelativeDate;
		if (adjustableOrAdjustedOrRelativeDateBuilder == null) {
			adjustableOrAdjustedOrRelativeDate = null;
		} else {
			adjustableOrAdjustedOrRelativeDate = adjustableOrAdjustedOrRelativeDateBuilder.build();
			objectValidator.validate(AdjustableOrAdjustedOrRelativeDate.class, adjustableOrAdjustedOrRelativeDate);
		}
		
		return adjustableOrAdjustedOrRelativeDate;
	}

	protected abstract AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder doEvaluate(AdjustableOrAdjustedDate fpmlAdjustableOrAdjustedDate);

	public static class MapAdjustableOrAdjustedDateToAdjustableOrAdjustedOrRelativeDateDefault extends MapAdjustableOrAdjustedDateToAdjustableOrAdjustedOrRelativeDate {
		@Override
		protected AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder doEvaluate(AdjustableOrAdjustedDate fpmlAdjustableOrAdjustedDate) {
			AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder adjustableOrAdjustedOrRelativeDate = AdjustableOrAdjustedOrRelativeDate.builder();
			return assignOutput(adjustableOrAdjustedOrRelativeDate, fpmlAdjustableOrAdjustedDate);
		}
		
		protected AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder assignOutput(AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder adjustableOrAdjustedOrRelativeDate, AdjustableOrAdjustedDate fpmlAdjustableOrAdjustedDate) {
			adjustableOrAdjustedOrRelativeDate = toBuilder(AdjustableOrAdjustedOrRelativeDate.builder()
				.setUnadjustedDate(MapperS.of(fpmlAdjustableOrAdjustedDate).<IdentifiedDate>map("getUnadjustedDate", adjustableOrAdjustedDate -> adjustableOrAdjustedDate.getUnadjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setDateAdjustments(mapBusinessDayAdjustments.evaluate(MapperS.of(fpmlAdjustableOrAdjustedDate).<BusinessDayAdjustments>map("getDateAdjustments", adjustableOrAdjustedDate -> adjustableOrAdjustedDate.getDateAdjustments()).get()))
				.setAdjustedDateValue(MapperS.of(fpmlAdjustableOrAdjustedDate).<IdentifiedDate>map("getAdjustedDate", adjustableOrAdjustedDate -> adjustableOrAdjustedDate.getAdjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setRelativeDate(null)
				.build());
			
			return Optional.ofNullable(adjustableOrAdjustedOrRelativeDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

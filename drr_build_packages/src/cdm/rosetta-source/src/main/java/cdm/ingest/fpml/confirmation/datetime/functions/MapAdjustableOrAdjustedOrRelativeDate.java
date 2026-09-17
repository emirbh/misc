package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.RelativeDateOffset;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableOrAdjustedOrRelativeDate.MapAdjustableOrAdjustedOrRelativeDateDefault.class)
public abstract class MapAdjustableOrAdjustedOrRelativeDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;

	/**
	* @param fpmlUnadjustedDate 
	* @param fpmlAdjustableDate 
	* @param fpmlRelativeDate 
	* @return adjustableOrAdjustedOrRelativeDate 
	*/
	public AdjustableOrAdjustedOrRelativeDate evaluate(Date fpmlUnadjustedDate, AdjustableDate fpmlAdjustableDate, RelativeDateOffset fpmlRelativeDate) {
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder adjustableOrAdjustedOrRelativeDateBuilder = doEvaluate(fpmlUnadjustedDate, fpmlAdjustableDate, fpmlRelativeDate);
		
		final AdjustableOrAdjustedOrRelativeDate adjustableOrAdjustedOrRelativeDate;
		if (adjustableOrAdjustedOrRelativeDateBuilder == null) {
			adjustableOrAdjustedOrRelativeDate = null;
		} else {
			adjustableOrAdjustedOrRelativeDate = adjustableOrAdjustedOrRelativeDateBuilder.build();
			objectValidator.validate(AdjustableOrAdjustedOrRelativeDate.class, adjustableOrAdjustedOrRelativeDate);
		}
		
		return adjustableOrAdjustedOrRelativeDate;
	}

	protected abstract AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder doEvaluate(Date fpmlUnadjustedDate, AdjustableDate fpmlAdjustableDate, RelativeDateOffset fpmlRelativeDate);

	public static class MapAdjustableOrAdjustedOrRelativeDateDefault extends MapAdjustableOrAdjustedOrRelativeDate {
		@Override
		protected AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder doEvaluate(Date fpmlUnadjustedDate, AdjustableDate fpmlAdjustableDate, RelativeDateOffset fpmlRelativeDate) {
			AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder adjustableOrAdjustedOrRelativeDate = AdjustableOrAdjustedOrRelativeDate.builder();
			return assignOutput(adjustableOrAdjustedOrRelativeDate, fpmlUnadjustedDate, fpmlAdjustableDate, fpmlRelativeDate);
		}
		
		protected AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder assignOutput(AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder adjustableOrAdjustedOrRelativeDate, Date fpmlUnadjustedDate, AdjustableDate fpmlAdjustableDate, RelativeDateOffset fpmlRelativeDate) {
			adjustableOrAdjustedOrRelativeDate = toBuilder(AdjustableOrAdjustedOrRelativeDate.builder()
				.setUnadjustedDate(fpmlUnadjustedDate)
				.setDateAdjustments(mapBusinessDayAdjustments.evaluate(MapperS.of(fpmlAdjustableDate).<BusinessDayAdjustments>map("getDateAdjustments", adjustableDate -> adjustableDate.getDateAdjustments()).get()))
				.setAdjustedDateValue(MapperS.of(fpmlAdjustableDate).<IdentifiedDate>map("getAdjustedDate", adjustableDate -> adjustableDate.getAdjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setRelativeDate(mapRelativeDateOffset.evaluate(fpmlRelativeDate))
				.build());
			
			return Optional.ofNullable(adjustableOrAdjustedOrRelativeDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

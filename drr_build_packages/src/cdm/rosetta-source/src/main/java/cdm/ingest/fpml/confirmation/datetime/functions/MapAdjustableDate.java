package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.IdentifiedDate;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableDate.MapAdjustableDateDefault.class)
public abstract class MapAdjustableDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;

	/**
	* @param fpmlAdjustableDate 
	* @return adjustableDate 
	*/
	public AdjustableDate evaluate(fpml.consolidated.shared.AdjustableDate fpmlAdjustableDate) {
		AdjustableDate.AdjustableDateBuilder adjustableDateBuilder = doEvaluate(fpmlAdjustableDate);
		
		final AdjustableDate adjustableDate;
		if (adjustableDateBuilder == null) {
			adjustableDate = null;
		} else {
			adjustableDate = adjustableDateBuilder.build();
			objectValidator.validate(AdjustableDate.class, adjustableDate);
		}
		
		return adjustableDate;
	}

	protected abstract AdjustableDate.AdjustableDateBuilder doEvaluate(fpml.consolidated.shared.AdjustableDate fpmlAdjustableDate);

	public static class MapAdjustableDateDefault extends MapAdjustableDate {
		@Override
		protected AdjustableDate.AdjustableDateBuilder doEvaluate(fpml.consolidated.shared.AdjustableDate fpmlAdjustableDate) {
			AdjustableDate.AdjustableDateBuilder adjustableDate = AdjustableDate.builder();
			return assignOutput(adjustableDate, fpmlAdjustableDate);
		}
		
		protected AdjustableDate.AdjustableDateBuilder assignOutput(AdjustableDate.AdjustableDateBuilder adjustableDate, fpml.consolidated.shared.AdjustableDate fpmlAdjustableDate) {
			adjustableDate = toBuilder(AdjustableDate.builder()
				.setUnadjustedDate(MapperS.of(fpmlAdjustableDate).<IdentifiedDate>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setDateAdjustments(mapBusinessDayAdjustments.evaluate(MapperS.of(fpmlAdjustableDate).<BusinessDayAdjustments>map("getDateAdjustments", _adjustableDate -> _adjustableDate.getDateAdjustments()).get()))
				.setAdjustedDateValue(MapperS.of(fpmlAdjustableDate).<IdentifiedDate>map("getAdjustedDate", _adjustableDate -> _adjustableDate.getAdjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.build());
			
			return Optional.ofNullable(adjustableDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

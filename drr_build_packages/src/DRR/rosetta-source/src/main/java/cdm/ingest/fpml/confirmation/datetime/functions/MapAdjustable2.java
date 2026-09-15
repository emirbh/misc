package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.shared.AdjustableDate2;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.IdentifiedDate;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustable2.MapAdjustable2Default.class)
public abstract class MapAdjustable2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;

	/**
	* @param fpmlAdjustableDate2 
	* @return adjustableDate 
	*/
	public AdjustableDate evaluate(AdjustableDate2 fpmlAdjustableDate2) {
		AdjustableDate.AdjustableDateBuilder adjustableDateBuilder = doEvaluate(fpmlAdjustableDate2);
		
		final AdjustableDate adjustableDate;
		if (adjustableDateBuilder == null) {
			adjustableDate = null;
		} else {
			adjustableDate = adjustableDateBuilder.build();
			objectValidator.validate(AdjustableDate.class, adjustableDate);
		}
		
		return adjustableDate;
	}

	protected abstract AdjustableDate.AdjustableDateBuilder doEvaluate(AdjustableDate2 fpmlAdjustableDate2);

	public static class MapAdjustable2Default extends MapAdjustable2 {
		@Override
		protected AdjustableDate.AdjustableDateBuilder doEvaluate(AdjustableDate2 fpmlAdjustableDate2) {
			AdjustableDate.AdjustableDateBuilder adjustableDate = AdjustableDate.builder();
			return assignOutput(adjustableDate, fpmlAdjustableDate2);
		}
		
		protected AdjustableDate.AdjustableDateBuilder assignOutput(AdjustableDate.AdjustableDateBuilder adjustableDate, AdjustableDate2 fpmlAdjustableDate2) {
			adjustableDate = toBuilder(AdjustableDate.builder()
				.setUnadjustedDate(MapperS.of(fpmlAdjustableDate2).<IdentifiedDate>map("getUnadjustedDate", adjustableDate2 -> adjustableDate2.getUnadjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setDateAdjustments(mapBusinessDayAdjustments.evaluate(MapperS.of(fpmlAdjustableDate2).<BusinessDayAdjustments>map("getDateAdjustments", adjustableDate2 -> adjustableDate2.getDateAdjustments()).get()))
				.setAdjustedDateValue(MapperS.of(fpmlAdjustableDate2).<IdentifiedDate>map("getAdjustedDate", adjustableDate2 -> adjustableDate2.getAdjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.build());
			
			return Optional.ofNullable(adjustableDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

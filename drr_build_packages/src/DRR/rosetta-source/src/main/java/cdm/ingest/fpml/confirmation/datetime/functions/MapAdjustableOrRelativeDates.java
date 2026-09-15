package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableOrRelativeDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.RelativeDates;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableOrRelativeDates.MapAdjustableOrRelativeDatesDefault.class)
public abstract class MapAdjustableOrRelativeDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapRelativeDates mapRelativeDates;

	/**
	* @param fpmlAdjustableOrRelativeDates 
	* @return adjustableOrRelativeDates 
	*/
	public AdjustableOrRelativeDates evaluate(fpml.consolidated.shared.AdjustableOrRelativeDates fpmlAdjustableOrRelativeDates) {
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder adjustableOrRelativeDatesBuilder = doEvaluate(fpmlAdjustableOrRelativeDates);
		
		final AdjustableOrRelativeDates adjustableOrRelativeDates;
		if (adjustableOrRelativeDatesBuilder == null) {
			adjustableOrRelativeDates = null;
		} else {
			adjustableOrRelativeDates = adjustableOrRelativeDatesBuilder.build();
			objectValidator.validate(AdjustableOrRelativeDates.class, adjustableOrRelativeDates);
		}
		
		return adjustableOrRelativeDates;
	}

	protected abstract AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder doEvaluate(fpml.consolidated.shared.AdjustableOrRelativeDates fpmlAdjustableOrRelativeDates);

	public static class MapAdjustableOrRelativeDatesDefault extends MapAdjustableOrRelativeDates {
		@Override
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder doEvaluate(fpml.consolidated.shared.AdjustableOrRelativeDates fpmlAdjustableOrRelativeDates) {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder adjustableOrRelativeDates = AdjustableOrRelativeDates.builder();
			return assignOutput(adjustableOrRelativeDates, fpmlAdjustableOrRelativeDates);
		}
		
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder assignOutput(AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder adjustableOrRelativeDates, fpml.consolidated.shared.AdjustableOrRelativeDates fpmlAdjustableOrRelativeDates) {
			final MapperS<AdjustableDates> thenArg0 = MapperS.of(fpmlAdjustableOrRelativeDates).<AdjustableDates>map("getAdjustableDates", _adjustableOrRelativeDates -> _adjustableOrRelativeDates.getAdjustableDates());
			final MapperC<IdentifiedDate> thenArg1 = thenArg0.<IdentifiedDate>mapC("getUnadjustedDate", adjustableDates -> adjustableDates.getUnadjustedDate());
			adjustableOrRelativeDates = toBuilder(AdjustableOrRelativeDates.builder()
				.setAdjustableDates(MapperS.of(cdm.base.datetime.AdjustableDates.builder()
					.setUnadjustedDate(thenArg1.<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).getMulti())
					.setDateAdjustments(mapBusinessDayAdjustments.evaluate(thenArg0.<BusinessDayAdjustments>map("getDateAdjustments", adjustableDates -> adjustableDates.getDateAdjustments()).get()))
					.build()).get())
				.setRelativeDates(mapRelativeDates.evaluate(MapperS.of(fpmlAdjustableOrRelativeDates).<RelativeDates>map("getRelativeDates", _adjustableOrRelativeDates -> _adjustableOrRelativeDates.getRelativeDates()).get()))
				.build());
			
			return Optional.ofNullable(adjustableOrRelativeDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

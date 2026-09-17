package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableDates;
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


@ImplementedBy(MapAdjustableDates.MapAdjustableDatesDefault.class)
public abstract class MapAdjustableDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapDateWithId mapDateWithId;

	/**
	* @param fpmlAdjustableDates 
	* @return adjustableDates 
	*/
	public AdjustableDates evaluate(fpml.consolidated.shared.AdjustableDates fpmlAdjustableDates) {
		AdjustableDates.AdjustableDatesBuilder adjustableDatesBuilder = doEvaluate(fpmlAdjustableDates);
		
		final AdjustableDates adjustableDates;
		if (adjustableDatesBuilder == null) {
			adjustableDates = null;
		} else {
			adjustableDates = adjustableDatesBuilder.build();
			objectValidator.validate(AdjustableDates.class, adjustableDates);
		}
		
		return adjustableDates;
	}

	protected abstract AdjustableDates.AdjustableDatesBuilder doEvaluate(fpml.consolidated.shared.AdjustableDates fpmlAdjustableDates);

	public static class MapAdjustableDatesDefault extends MapAdjustableDates {
		@Override
		protected AdjustableDates.AdjustableDatesBuilder doEvaluate(fpml.consolidated.shared.AdjustableDates fpmlAdjustableDates) {
			AdjustableDates.AdjustableDatesBuilder adjustableDates = AdjustableDates.builder();
			return assignOutput(adjustableDates, fpmlAdjustableDates);
		}
		
		protected AdjustableDates.AdjustableDatesBuilder assignOutput(AdjustableDates.AdjustableDatesBuilder adjustableDates, fpml.consolidated.shared.AdjustableDates fpmlAdjustableDates) {
			adjustableDates = toBuilder(AdjustableDates.builder()
				.setUnadjustedDate(MapperS.of(fpmlAdjustableDates).<IdentifiedDate>mapC("getUnadjustedDate", _adjustableDates -> _adjustableDates.getUnadjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).getMulti())
				.setDateAdjustments(mapBusinessDayAdjustments.evaluate(MapperS.of(fpmlAdjustableDates).<BusinessDayAdjustments>map("getDateAdjustments", _adjustableDates -> _adjustableDates.getDateAdjustments()).get()))
				.setAdjustedDate(MapperS.of(fpmlAdjustableDates).<IdentifiedDate>mapC("getAdjustedDate", _adjustableDates -> _adjustableDates.getAdjustedDate())
					.mapItem(item -> MapperS.of(mapDateWithId.evaluate(item.get()))).getMulti())
				.build());
			
			return Optional.ofNullable(adjustableDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

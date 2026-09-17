package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.RelativeDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fpmlenum.PeriodEnum;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.DateReference;
import fpml.consolidated.shared.IdentifiedDate;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRelativeDates.MapRelativeDatesDefault.class)
public abstract class MapRelativeDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterReference mapBusinessCenterReference;
	@Inject protected MapBusinessCenters mapBusinessCenters;
	@Inject protected MapDateReference mapDateReference;

	/**
	* @param fpmlRelativeDates 
	* @return relativeDates 
	*/
	public RelativeDates evaluate(fpml.consolidated.shared.RelativeDates fpmlRelativeDates) {
		RelativeDates.RelativeDatesBuilder relativeDatesBuilder = doEvaluate(fpmlRelativeDates);
		
		final RelativeDates relativeDates;
		if (relativeDatesBuilder == null) {
			relativeDates = null;
		} else {
			relativeDates = relativeDatesBuilder.build();
			objectValidator.validate(RelativeDates.class, relativeDates);
		}
		
		return relativeDates;
	}

	protected abstract RelativeDates.RelativeDatesBuilder doEvaluate(fpml.consolidated.shared.RelativeDates fpmlRelativeDates);

	public static class MapRelativeDatesDefault extends MapRelativeDates {
		@Override
		protected RelativeDates.RelativeDatesBuilder doEvaluate(fpml.consolidated.shared.RelativeDates fpmlRelativeDates) {
			RelativeDates.RelativeDatesBuilder relativeDates = RelativeDates.builder();
			return assignOutput(relativeDates, fpmlRelativeDates);
		}
		
		protected RelativeDates.RelativeDatesBuilder assignOutput(RelativeDates.RelativeDatesBuilder relativeDates, fpml.consolidated.shared.RelativeDates fpmlRelativeDates) {
			relativeDates = toBuilder(RelativeDates.builder()
				.setPeriodMultiplier(MapperS.of(fpmlRelativeDates).<Integer>map("getPeriodMultiplier", _relativeDates -> _relativeDates.getPeriodMultiplier()).get())
				.setPeriod(MapperS.of(fpmlRelativeDates).<PeriodEnum>map("getPeriod", _relativeDates -> _relativeDates.getPeriod()).checkedMap("to-enum", e -> cdm.base.datetime.PeriodEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setDayType(MapperS.of(fpmlRelativeDates).<DayTypeEnum>map("getDayType", _relativeDates -> _relativeDates.getDayType()).checkedMap("to-enum", e -> cdm.base.datetime.DayTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setBusinessDayConvention(MapperS.of(fpmlRelativeDates).<BusinessDayConventionEnum>map("getBusinessDayConvention", _relativeDates -> _relativeDates.getBusinessDayConvention()).checkedMap("to-enum", e -> cdm.base.datetime.BusinessDayConventionEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setBusinessCenters(mapBusinessCenters.evaluate(MapperS.of(fpmlRelativeDates).<BusinessCenters>map("getBusinessCenters", _relativeDates -> _relativeDates.getBusinessCenters()).get()))
				.setBusinessCentersReference(mapBusinessCenterReference.evaluate(MapperS.of(fpmlRelativeDates).<BusinessCentersReference>map("getBusinessCentersReference", _relativeDates -> _relativeDates.getBusinessCentersReference()).get()))
				.setDateRelativeTo(mapDateReference.evaluate(MapperS.of(fpmlRelativeDates).<DateReference>map("getDateRelativeTo", _relativeDates -> _relativeDates.getDateRelativeTo()).get()))
				.setAdjustedDate(MapperS.of(fpmlRelativeDates).<IdentifiedDate>map("getAdjustedDate", _relativeDates -> _relativeDates.getAdjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.build());
			
			return Optional.ofNullable(relativeDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

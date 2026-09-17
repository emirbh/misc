package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.RelativeDateOffset;
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


@ImplementedBy(MapRelativeDateOffset.MapRelativeDateOffsetDefault.class)
public abstract class MapRelativeDateOffset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterReference mapBusinessCenterReference;
	@Inject protected MapBusinessCenters mapBusinessCenters;
	@Inject protected MapDateReference mapDateReference;

	/**
	* @param fpmlRelativeDateOffset 
	* @return relativeDateOffset 
	*/
	public RelativeDateOffset evaluate(fpml.consolidated.shared.RelativeDateOffset fpmlRelativeDateOffset) {
		RelativeDateOffset.RelativeDateOffsetBuilder relativeDateOffsetBuilder = doEvaluate(fpmlRelativeDateOffset);
		
		final RelativeDateOffset relativeDateOffset;
		if (relativeDateOffsetBuilder == null) {
			relativeDateOffset = null;
		} else {
			relativeDateOffset = relativeDateOffsetBuilder.build();
			objectValidator.validate(RelativeDateOffset.class, relativeDateOffset);
		}
		
		return relativeDateOffset;
	}

	protected abstract RelativeDateOffset.RelativeDateOffsetBuilder doEvaluate(fpml.consolidated.shared.RelativeDateOffset fpmlRelativeDateOffset);

	public static class MapRelativeDateOffsetDefault extends MapRelativeDateOffset {
		@Override
		protected RelativeDateOffset.RelativeDateOffsetBuilder doEvaluate(fpml.consolidated.shared.RelativeDateOffset fpmlRelativeDateOffset) {
			RelativeDateOffset.RelativeDateOffsetBuilder relativeDateOffset = RelativeDateOffset.builder();
			return assignOutput(relativeDateOffset, fpmlRelativeDateOffset);
		}
		
		protected RelativeDateOffset.RelativeDateOffsetBuilder assignOutput(RelativeDateOffset.RelativeDateOffsetBuilder relativeDateOffset, fpml.consolidated.shared.RelativeDateOffset fpmlRelativeDateOffset) {
			relativeDateOffset = toBuilder(RelativeDateOffset.builder()
				.setPeriodMultiplier(MapperS.of(fpmlRelativeDateOffset).<Integer>map("getPeriodMultiplier", _relativeDateOffset -> _relativeDateOffset.getPeriodMultiplier()).get())
				.setPeriod(MapperS.of(fpmlRelativeDateOffset).<PeriodEnum>map("getPeriod", _relativeDateOffset -> _relativeDateOffset.getPeriod()).checkedMap("to-enum", e -> cdm.base.datetime.PeriodEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setDayType(MapperS.of(fpmlRelativeDateOffset).<DayTypeEnum>map("getDayType", _relativeDateOffset -> _relativeDateOffset.getDayType()).checkedMap("to-enum", e -> cdm.base.datetime.DayTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setBusinessDayConvention(MapperS.of(fpmlRelativeDateOffset).<BusinessDayConventionEnum>map("getBusinessDayConvention", _relativeDateOffset -> _relativeDateOffset.getBusinessDayConvention()).checkedMap("to-enum", e -> cdm.base.datetime.BusinessDayConventionEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setBusinessCenters(mapBusinessCenters.evaluate(MapperS.of(fpmlRelativeDateOffset).<BusinessCenters>map("getBusinessCenters", _relativeDateOffset -> _relativeDateOffset.getBusinessCenters()).get()))
				.setBusinessCentersReference(mapBusinessCenterReference.evaluate(MapperS.of(fpmlRelativeDateOffset).<BusinessCentersReference>map("getBusinessCentersReference", _relativeDateOffset -> _relativeDateOffset.getBusinessCentersReference()).get()))
				.setDateRelativeTo(mapDateReference.evaluate(MapperS.of(fpmlRelativeDateOffset).<DateReference>map("getDateRelativeTo", _relativeDateOffset -> _relativeDateOffset.getDateRelativeTo()).get()))
				.setAdjustedDate(MapperS.of(fpmlRelativeDateOffset).<IdentifiedDate>map("getAdjustedDate", _relativeDateOffset -> _relativeDateOffset.getAdjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.build());
			
			return Optional.ofNullable(relativeDateOffset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

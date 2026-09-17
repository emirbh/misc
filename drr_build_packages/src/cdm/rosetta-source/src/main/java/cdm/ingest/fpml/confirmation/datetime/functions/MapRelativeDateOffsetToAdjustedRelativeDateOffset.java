package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustedRelativeDateOffset;
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
import fpml.consolidated.shared.RelativeDateOffset;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRelativeDateOffsetToAdjustedRelativeDateOffset.MapRelativeDateOffsetToAdjustedRelativeDateOffsetDefault.class)
public abstract class MapRelativeDateOffsetToAdjustedRelativeDateOffset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterReference mapBusinessCenterReference;
	@Inject protected MapBusinessCenters mapBusinessCenters;
	@Inject protected MapDateReference mapDateReference;

	/**
	* @param fpmlRelativeDateOffset 
	* @return adjustedRelativeDateOffset 
	*/
	public AdjustedRelativeDateOffset evaluate(RelativeDateOffset fpmlRelativeDateOffset) {
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder adjustedRelativeDateOffsetBuilder = doEvaluate(fpmlRelativeDateOffset);
		
		final AdjustedRelativeDateOffset adjustedRelativeDateOffset;
		if (adjustedRelativeDateOffsetBuilder == null) {
			adjustedRelativeDateOffset = null;
		} else {
			adjustedRelativeDateOffset = adjustedRelativeDateOffsetBuilder.build();
			objectValidator.validate(AdjustedRelativeDateOffset.class, adjustedRelativeDateOffset);
		}
		
		return adjustedRelativeDateOffset;
	}

	protected abstract AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder doEvaluate(RelativeDateOffset fpmlRelativeDateOffset);

	public static class MapRelativeDateOffsetToAdjustedRelativeDateOffsetDefault extends MapRelativeDateOffsetToAdjustedRelativeDateOffset {
		@Override
		protected AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder doEvaluate(RelativeDateOffset fpmlRelativeDateOffset) {
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder adjustedRelativeDateOffset = AdjustedRelativeDateOffset.builder();
			return assignOutput(adjustedRelativeDateOffset, fpmlRelativeDateOffset);
		}
		
		protected AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder assignOutput(AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder adjustedRelativeDateOffset, RelativeDateOffset fpmlRelativeDateOffset) {
			adjustedRelativeDateOffset = toBuilder(AdjustedRelativeDateOffset.builder()
				.setPeriodMultiplier(MapperS.of(fpmlRelativeDateOffset).<Integer>map("getPeriodMultiplier", relativeDateOffset -> relativeDateOffset.getPeriodMultiplier()).get())
				.setPeriod(MapperS.of(fpmlRelativeDateOffset).<PeriodEnum>map("getPeriod", relativeDateOffset -> relativeDateOffset.getPeriod()).checkedMap("to-enum", e -> cdm.base.datetime.PeriodEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setDayType(MapperS.of(fpmlRelativeDateOffset).<DayTypeEnum>map("getDayType", relativeDateOffset -> relativeDateOffset.getDayType()).checkedMap("to-enum", e -> cdm.base.datetime.DayTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setBusinessDayConvention(MapperS.of(fpmlRelativeDateOffset).<BusinessDayConventionEnum>map("getBusinessDayConvention", relativeDateOffset -> relativeDateOffset.getBusinessDayConvention()).checkedMap("to-enum", e -> cdm.base.datetime.BusinessDayConventionEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setBusinessCenters(mapBusinessCenters.evaluate(MapperS.of(fpmlRelativeDateOffset).<BusinessCenters>map("getBusinessCenters", relativeDateOffset -> relativeDateOffset.getBusinessCenters()).get()))
				.setBusinessCentersReference(mapBusinessCenterReference.evaluate(MapperS.of(fpmlRelativeDateOffset).<BusinessCentersReference>map("getBusinessCentersReference", relativeDateOffset -> relativeDateOffset.getBusinessCentersReference()).get()))
				.setDateRelativeTo(mapDateReference.evaluate(MapperS.of(fpmlRelativeDateOffset).<DateReference>map("getDateRelativeTo", relativeDateOffset -> relativeDateOffset.getDateRelativeTo()).get()))
				.setAdjustedDate(MapperS.of(fpmlRelativeDateOffset).<IdentifiedDate>map("getAdjustedDate", relativeDateOffset -> relativeDateOffset.getAdjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.build());
			
			return Optional.ofNullable(adjustedRelativeDateOffset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

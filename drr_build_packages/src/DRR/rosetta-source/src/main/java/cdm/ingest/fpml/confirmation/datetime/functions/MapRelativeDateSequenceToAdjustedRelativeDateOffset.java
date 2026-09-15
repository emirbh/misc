package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustedRelativeDateOffset;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fpmlenum.PeriodEnum;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.DateOffset;
import fpml.consolidated.shared.DateReference;
import fpml.consolidated.shared.RelativeDateSequence;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRelativeDateSequenceToAdjustedRelativeDateOffset.MapRelativeDateSequenceToAdjustedRelativeDateOffsetDefault.class)
public abstract class MapRelativeDateSequenceToAdjustedRelativeDateOffset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterReference mapBusinessCenterReference;
	@Inject protected MapBusinessCenters mapBusinessCenters;
	@Inject protected MapDateReference mapDateReference;

	/**
	* @param fpmlRelativeDateSequence 
	* @return adjustedRelativeDateOffset 
	*/
	public AdjustedRelativeDateOffset evaluate(RelativeDateSequence fpmlRelativeDateSequence) {
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder adjustedRelativeDateOffsetBuilder = doEvaluate(fpmlRelativeDateSequence);
		
		final AdjustedRelativeDateOffset adjustedRelativeDateOffset;
		if (adjustedRelativeDateOffsetBuilder == null) {
			adjustedRelativeDateOffset = null;
		} else {
			adjustedRelativeDateOffset = adjustedRelativeDateOffsetBuilder.build();
			objectValidator.validate(AdjustedRelativeDateOffset.class, adjustedRelativeDateOffset);
		}
		
		return adjustedRelativeDateOffset;
	}

	protected abstract AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder doEvaluate(RelativeDateSequence fpmlRelativeDateSequence);

	protected abstract MapperS<? extends DateOffset> firstDateOffset(RelativeDateSequence fpmlRelativeDateSequence);

	public static class MapRelativeDateSequenceToAdjustedRelativeDateOffsetDefault extends MapRelativeDateSequenceToAdjustedRelativeDateOffset {
		@Override
		protected AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder doEvaluate(RelativeDateSequence fpmlRelativeDateSequence) {
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder adjustedRelativeDateOffset = AdjustedRelativeDateOffset.builder();
			return assignOutput(adjustedRelativeDateOffset, fpmlRelativeDateSequence);
		}
		
		protected AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder assignOutput(AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder adjustedRelativeDateOffset, RelativeDateSequence fpmlRelativeDateSequence) {
			adjustedRelativeDateOffset = toBuilder(AdjustedRelativeDateOffset.builder()
				.setPeriodMultiplier(firstDateOffset(fpmlRelativeDateSequence).<Integer>map("getPeriodMultiplier", dateOffset -> dateOffset.getPeriodMultiplier()).get())
				.setPeriod(firstDateOffset(fpmlRelativeDateSequence).<PeriodEnum>map("getPeriod", dateOffset -> dateOffset.getPeriod()).checkedMap("to-enum", e -> cdm.base.datetime.PeriodEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setDayType(firstDateOffset(fpmlRelativeDateSequence).<DayTypeEnum>map("getDayType", dateOffset -> dateOffset.getDayType()).checkedMap("to-enum", e -> cdm.base.datetime.DayTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setBusinessDayConvention(firstDateOffset(fpmlRelativeDateSequence).<BusinessDayConventionEnum>map("getBusinessDayConvention", dateOffset -> dateOffset.getBusinessDayConvention()).checkedMap("to-enum", e -> cdm.base.datetime.BusinessDayConventionEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setBusinessCenters(mapBusinessCenters.evaluate(MapperS.of(fpmlRelativeDateSequence).<BusinessCenters>map("getBusinessCenters", relativeDateSequence -> relativeDateSequence.getBusinessCenters()).get()))
				.setBusinessCentersReference(mapBusinessCenterReference.evaluate(MapperS.of(fpmlRelativeDateSequence).<BusinessCentersReference>map("getBusinessCentersReference", relativeDateSequence -> relativeDateSequence.getBusinessCentersReference()).get()))
				.setDateRelativeTo(mapDateReference.evaluate(MapperS.of(fpmlRelativeDateSequence).<DateReference>map("getDateRelativeTo", relativeDateSequence -> relativeDateSequence.getDateRelativeTo()).get()))
				.build());
			
			return Optional.ofNullable(adjustedRelativeDateOffset)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends DateOffset> firstDateOffset(RelativeDateSequence fpmlRelativeDateSequence) {
			return MapperS.of(fpmlRelativeDateSequence).<DateOffset>mapC("getDateOffset", relativeDateSequence -> relativeDateSequence.getDateOffset())
				.first();
		}
	}
}

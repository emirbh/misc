package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.RelativeDateOffset;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fpmlenum.PeriodEnum;
import fpml.consolidated.shared.DateOffset;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDateOffsetToRelativeDateOffset.MapDateOffsetToRelativeDateOffsetDefault.class)
public abstract class MapDateOffsetToRelativeDateOffset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlRelativeDateOffset 
	* @return relativeDateOffset 
	*/
	public RelativeDateOffset evaluate(DateOffset fpmlRelativeDateOffset) {
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

	protected abstract RelativeDateOffset.RelativeDateOffsetBuilder doEvaluate(DateOffset fpmlRelativeDateOffset);

	public static class MapDateOffsetToRelativeDateOffsetDefault extends MapDateOffsetToRelativeDateOffset {
		@Override
		protected RelativeDateOffset.RelativeDateOffsetBuilder doEvaluate(DateOffset fpmlRelativeDateOffset) {
			RelativeDateOffset.RelativeDateOffsetBuilder relativeDateOffset = RelativeDateOffset.builder();
			return assignOutput(relativeDateOffset, fpmlRelativeDateOffset);
		}
		
		protected RelativeDateOffset.RelativeDateOffsetBuilder assignOutput(RelativeDateOffset.RelativeDateOffsetBuilder relativeDateOffset, DateOffset fpmlRelativeDateOffset) {
			relativeDateOffset = toBuilder(RelativeDateOffset.builder()
				.setPeriodMultiplier(MapperS.of(fpmlRelativeDateOffset).<Integer>map("getPeriodMultiplier", dateOffset -> dateOffset.getPeriodMultiplier()).get())
				.setPeriod(MapperS.of(fpmlRelativeDateOffset).<PeriodEnum>map("getPeriod", dateOffset -> dateOffset.getPeriod()).checkedMap("to-enum", e -> cdm.base.datetime.PeriodEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setDayType(MapperS.of(fpmlRelativeDateOffset).<DayTypeEnum>map("getDayType", dateOffset -> dateOffset.getDayType()).checkedMap("to-enum", e -> cdm.base.datetime.DayTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setBusinessDayConvention(MapperS.of(fpmlRelativeDateOffset).<BusinessDayConventionEnum>map("getBusinessDayConvention", dateOffset -> dateOffset.getBusinessDayConvention()).checkedMap("to-enum", e -> cdm.base.datetime.BusinessDayConventionEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.build());
			
			return Optional.ofNullable(relativeDateOffset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

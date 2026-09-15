package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.ingest.fpml.confirmation.other.functions.MapPeriodExtendedEnum;
import cdm.ingest.fpml.confirmation.other.functions.MapWeeklyRollConventionEnum;
import cdm.product.common.schedule.ResetFrequency;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.PeriodExtendedEnum;
import fpml.consolidated.fpmlenum.WeeklyRollConventionEnum;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapResetFrequency.MapResetFrequencyDefault.class)
public abstract class MapResetFrequency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPeriodExtendedEnum mapPeriodExtendedEnum;
	@Inject protected MapWeeklyRollConventionEnum mapWeeklyRollConventionEnum;

	/**
	* @param fpmlResetFrequency 
	* @return resetFrequency 
	*/
	public ResetFrequency evaluate(fpml.consolidated.shared.ResetFrequency fpmlResetFrequency) {
		ResetFrequency.ResetFrequencyBuilder resetFrequencyBuilder = doEvaluate(fpmlResetFrequency);
		
		final ResetFrequency resetFrequency;
		if (resetFrequencyBuilder == null) {
			resetFrequency = null;
		} else {
			resetFrequency = resetFrequencyBuilder.build();
			objectValidator.validate(ResetFrequency.class, resetFrequency);
		}
		
		return resetFrequency;
	}

	protected abstract ResetFrequency.ResetFrequencyBuilder doEvaluate(fpml.consolidated.shared.ResetFrequency fpmlResetFrequency);

	public static class MapResetFrequencyDefault extends MapResetFrequency {
		@Override
		protected ResetFrequency.ResetFrequencyBuilder doEvaluate(fpml.consolidated.shared.ResetFrequency fpmlResetFrequency) {
			ResetFrequency.ResetFrequencyBuilder resetFrequency = ResetFrequency.builder();
			return assignOutput(resetFrequency, fpmlResetFrequency);
		}
		
		protected ResetFrequency.ResetFrequencyBuilder assignOutput(ResetFrequency.ResetFrequencyBuilder resetFrequency, fpml.consolidated.shared.ResetFrequency fpmlResetFrequency) {
			resetFrequency = toBuilder(ResetFrequency.builder()
				.setPeriodMultiplier(MapperS.of(fpmlResetFrequency).<Integer>map("getPeriodMultiplier", _resetFrequency -> _resetFrequency.getPeriodMultiplier()).get())
				.setPeriod(mapPeriodExtendedEnum.evaluate(MapperS.of(fpmlResetFrequency).<PeriodExtendedEnum>map("getPeriod", _resetFrequency -> _resetFrequency.getPeriod()).map("to-string", PeriodExtendedEnum::toDisplayString).get()))
				.setWeeklyRollConvention(mapWeeklyRollConventionEnum.evaluate(MapperS.of(fpmlResetFrequency).<WeeklyRollConventionEnum>map("getWeeklyRollConvention", _resetFrequency -> _resetFrequency.getWeeklyRollConvention()).map("to-string", WeeklyRollConventionEnum::toDisplayString).get()))
				.build());
			
			return Optional.ofNullable(resetFrequency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

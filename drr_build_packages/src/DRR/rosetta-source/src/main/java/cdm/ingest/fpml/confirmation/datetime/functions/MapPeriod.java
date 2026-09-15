package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.Period;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.PeriodEnum;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPeriod.MapPeriodDefault.class)
public abstract class MapPeriod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlPeriod 
	* @return period 
	*/
	public Period evaluate(fpml.consolidated.shared.Period fpmlPeriod) {
		Period.PeriodBuilder periodBuilder = doEvaluate(fpmlPeriod);
		
		final Period period;
		if (periodBuilder == null) {
			period = null;
		} else {
			period = periodBuilder.build();
			objectValidator.validate(Period.class, period);
		}
		
		return period;
	}

	protected abstract Period.PeriodBuilder doEvaluate(fpml.consolidated.shared.Period fpmlPeriod);

	public static class MapPeriodDefault extends MapPeriod {
		@Override
		protected Period.PeriodBuilder doEvaluate(fpml.consolidated.shared.Period fpmlPeriod) {
			Period.PeriodBuilder period = Period.builder();
			return assignOutput(period, fpmlPeriod);
		}
		
		protected Period.PeriodBuilder assignOutput(Period.PeriodBuilder period, fpml.consolidated.shared.Period fpmlPeriod) {
			period = toBuilder(Period.builder()
				.setPeriodMultiplier(MapperS.of(fpmlPeriod).<Integer>map("getPeriodMultiplier", _period -> _period.getPeriodMultiplier()).get())
				.setPeriod(MapperS.of(fpmlPeriod).<PeriodEnum>map("getPeriod", _period -> _period.getPeriod()).checkedMap("to-enum", e -> cdm.base.datetime.PeriodEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.build());
			
			return Optional.ofNullable(period)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

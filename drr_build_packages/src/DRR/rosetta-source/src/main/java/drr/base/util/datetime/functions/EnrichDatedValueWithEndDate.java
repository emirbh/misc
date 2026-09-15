package drr.base.util.datetime.functions;

import cdm.base.datetime.DateRange;
import cdm.base.math.DatedValue;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.SchedulePeriod;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.util.datetime.ValuePeriod;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EnrichDatedValueWithEndDate.EnrichDatedValueWithEndDateDefault.class)
public abstract class EnrichDatedValueWithEndDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param datedValue 
	* @param calculationSchedule 
	* @return valuePeriod 
	*/
	public List<? extends ValuePeriod> evaluate(List<? extends DatedValue> datedValue, CalculationSchedule calculationSchedule) {
		List<ValuePeriod.ValuePeriodBuilder> valuePeriodBuilder = doEvaluate(datedValue, calculationSchedule);
		
		final List<? extends ValuePeriod> valuePeriod;
		if (valuePeriodBuilder == null) {
			valuePeriod = null;
		} else {
			valuePeriod = valuePeriodBuilder.stream().map(ValuePeriod::build).collect(Collectors.toList());
			objectValidator.validate(ValuePeriod.class, valuePeriod);
		}
		
		return valuePeriod;
	}

	protected abstract List<ValuePeriod.ValuePeriodBuilder> doEvaluate(List<? extends DatedValue> datedValue, CalculationSchedule calculationSchedule);

	public static class EnrichDatedValueWithEndDateDefault extends EnrichDatedValueWithEndDate {
		@Override
		protected List<ValuePeriod.ValuePeriodBuilder> doEvaluate(List<? extends DatedValue> datedValue, CalculationSchedule calculationSchedule) {
			if (datedValue == null) {
				datedValue = Collections.emptyList();
			}
			List<ValuePeriod.ValuePeriodBuilder> valuePeriod = new ArrayList<>();
			return assignOutput(valuePeriod, datedValue, calculationSchedule);
		}
		
		protected List<ValuePeriod.ValuePeriodBuilder> assignOutput(List<ValuePeriod.ValuePeriodBuilder> valuePeriod, List<? extends DatedValue> datedValue, CalculationSchedule calculationSchedule) {
			final MapperC<ValuePeriod> thenArg = MapperC.<DatedValue>of(datedValue)
				.mapItem(period -> {
					final MapperC<SchedulePeriod> thenArg0;
					if (exists(MapperS.of(calculationSchedule)).getOrDefault(false)) {
						thenArg0 = MapperS.of(calculationSchedule).<SchedulePeriod>mapC("getSchedulePeriod", _calculationSchedule -> _calculationSchedule.getSchedulePeriod())
							.filterItemNullSafe(customPeriod -> areEqual(period.<Date>map("getDate", _datedValue -> _datedValue.getDate()), customPeriod.<DateRange>map("getCalculationPeriod", schedulePeriod -> schedulePeriod.getCalculationPeriod()).<Date>map("getStartDate", dateRange -> dateRange.getStartDate()), CardinalityOperator.All).get());
					} else {
						thenArg0 = MapperC.<SchedulePeriod>ofNull();
					}
					final MapperC<Date> thenArg1 = thenArg0
						.mapItem(item -> item.<DateRange>map("getCalculationPeriod", schedulePeriod -> schedulePeriod.getCalculationPeriod()).<Date>map("getEndDate", dateRange -> dateRange.getEndDate()));
					return MapperS.of(ValuePeriod.builder()
						.setValue(period.<BigDecimal>map("getValue", _datedValue -> _datedValue.getValue()).get())
						.setEffectiveDate(period.<Date>map("getDate", _datedValue -> _datedValue.getDate()).get())
						.setEndDate(MapperS.of(thenArg1.get()).get())
						.build());
				});
			valuePeriod.addAll(toBuilder(thenArg
				.sort(item -> item.<Date>map("getEffectiveDate", _valuePeriod -> _valuePeriod.getEffectiveDate())).getMulti()));
			
			return Optional.ofNullable(valuePeriod)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

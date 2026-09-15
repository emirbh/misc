package drr.standards.iosco.cde.version3.quantity.reports;

import cdm.base.math.DatedValue;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.quantity.NotionalPeriod;
import drr.base.trade.quantity.reports.QuantityScheduleRule;
import drr.standards.iso.functions.FormatToShortFraction5DecimalNumber;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalAmountScheduleRule.NotionalAmountScheduleRuleDefault.class)
public abstract class NotionalAmountScheduleRule implements ReportFunction<PayoutLegWithAuxiliary, List<? extends NotionalPeriod>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToShortFraction5DecimalNumber formatToShortFraction5DecimalNumber;
	@Inject protected QuantityScheduleRule quantityScheduleRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends NotionalPeriod> evaluate(PayoutLegWithAuxiliary input) {
		List<NotionalPeriod.NotionalPeriodBuilder> outputBuilder = doEvaluate(input);
		
		final List<? extends NotionalPeriod> output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.stream().map(NotionalPeriod::build).collect(Collectors.toList());
			objectValidator.validate(NotionalPeriod.class, output);
		}
		
		return output;
	}

	protected abstract List<NotionalPeriod.NotionalPeriodBuilder> doEvaluate(PayoutLegWithAuxiliary input);

	public static class NotionalAmountScheduleRuleDefault extends NotionalAmountScheduleRule {
		@Override
		protected List<NotionalPeriod.NotionalPeriodBuilder> doEvaluate(PayoutLegWithAuxiliary input) {
			List<NotionalPeriod.NotionalPeriodBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<NotionalPeriod.NotionalPeriodBuilder> assignOutput(List<NotionalPeriod.NotionalPeriodBuilder> output, PayoutLegWithAuxiliary input) {
			final NonNegativeQuantitySchedule nonNegativeQuantitySchedule = quantityScheduleRule.evaluate(input);
			final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg0 = nonNegativeQuantitySchedule == null ? MapperS.<ReferenceWithMetaNonNegativeQuantitySchedule>ofNull() : MapperS.of(ReferenceWithMetaNonNegativeQuantitySchedule.builder().setValue(nonNegativeQuantitySchedule).build());
			final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> exists(item.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", _nonNegativeQuantitySchedule -> _nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).get());
			final MapperC<DatedValue> thenArg2 = thenArg1
				.mapSingleToList(item -> item.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()).<DatedValue>mapC("getDatedValue", _nonNegativeQuantitySchedule -> _nonNegativeQuantitySchedule.getDatedValue()));
			output = toBuilder(thenArg2
				.mapItem(notionalAmountPeriod -> {
					final MapperS<BigDecimal> thenArg = notionalAmountPeriod.<BigDecimal>map("getValue", datedValue -> datedValue.getValue());
					return MapperS.of(NotionalPeriod.builder()
						.setValue(MapperS.of(formatToShortFraction5DecimalNumber.evaluate(thenArg.get())).get())
						.setEffectiveDate(notionalAmountPeriod.<Date>map("getDate", datedValue -> datedValue.getDate()).get())
						.setEndDate(null)
						.build());
				}).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

package drr.base.trade.price.functions;

import cdm.base.datetime.DateRange;
import cdm.base.math.DatedValue;
import cdm.observable.asset.PriceComposite;
import cdm.observable.asset.PriceOperandEnum;
import cdm.observable.asset.PriceSchedule;
import cdm.product.template.SchedulePeriod;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExtractPriceValue.ExtractPriceValueDefault.class)
public abstract class ExtractPriceValue implements RosettaFunction {

	/**
	* @param price 
	* @param schedulePeriod 
	* @return amount 
	*/
	public BigDecimal evaluate(PriceSchedule price, SchedulePeriod schedulePeriod) {
		BigDecimal amount = doEvaluate(price, schedulePeriod);
		
		return amount;
	}

	protected abstract BigDecimal doEvaluate(PriceSchedule price, SchedulePeriod schedulePeriod);

	public static class ExtractPriceValueDefault extends ExtractPriceValue {
		@Override
		protected BigDecimal doEvaluate(PriceSchedule price, SchedulePeriod schedulePeriod) {
			BigDecimal amount = null;
			return assignOutput(amount, price, schedulePeriod);
		}
		
		protected BigDecimal assignOutput(BigDecimal amount, PriceSchedule price, SchedulePeriod schedulePeriod) {
			if (areEqual(MapperS.of(price).<PriceComposite>map("getComposite", priceSchedule -> priceSchedule.getComposite()).<PriceOperandEnum>map("getOperandType", priceComposite -> priceComposite.getOperandType()), MapperS.of(PriceOperandEnum.ACCRUED_INTEREST), CardinalityOperator.All).getOrDefault(false)) {
				amount = MapperS.of(price).<PriceComposite>map("getComposite", priceSchedule -> priceSchedule.getComposite()).<BigDecimal>map("getBaseValue", priceComposite -> priceComposite.getBaseValue()).get();
			} else if (exists(MapperS.of(price).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())).getOrDefault(false)) {
				amount = MapperS.of(price).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()).get();
			} else if (exists(MapperS.of(price).<DatedValue>mapC("getDatedValue", priceSchedule -> priceSchedule.getDatedValue())).getOrDefault(false)) {
				final MapperC<DatedValue> thenArg0 = MapperS.of(price).<DatedValue>mapC("getDatedValue", priceSchedule -> priceSchedule.getDatedValue())
					.filterItemNullSafe(item -> areEqual(item.<Date>map("getDate", datedValue -> datedValue.getDate()), MapperS.of(schedulePeriod).<DateRange>map("getCalculationPeriod", _schedulePeriod -> _schedulePeriod.getCalculationPeriod()).<Date>map("getStartDate", dateRange -> dateRange.getStartDate()), CardinalityOperator.All).get());
				final MapperC<BigDecimal> thenArg1 = thenArg0
					.mapItem(item -> item.<BigDecimal>map("getValue", datedValue -> datedValue.getValue()));
				amount = MapperS.of(thenArg1.get()).get();
			} else {
				amount = null;
			}
			
			return amount;
		}
	}
}

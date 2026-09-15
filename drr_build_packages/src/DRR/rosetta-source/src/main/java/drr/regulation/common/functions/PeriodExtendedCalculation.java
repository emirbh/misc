package drr.regulation.common.functions;

import cdm.base.datetime.PeriodEnum;
import cdm.base.datetime.PeriodExtendedEnum;
import cdm.base.datetime.functions.DateDifference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PeriodExtendedCalculation.PeriodExtendedCalculationDefault.class)
public abstract class PeriodExtendedCalculation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected DateDifference dateDifference;
	@Inject protected PeriodCalculation periodCalculation;

	/**
	* @param periodExtended 
	* @param periodMultiplier 
	* @param effectiveDate 
	* @param terminationDate 
	* @return result 
	*/
	public Integer evaluate(PeriodExtendedEnum periodExtended, Integer periodMultiplier, Date effectiveDate, Date terminationDate) {
		Integer result = doEvaluate(periodExtended, periodMultiplier, effectiveDate, terminationDate);
		
		return result;
	}

	protected abstract Integer doEvaluate(PeriodExtendedEnum periodExtended, Integer periodMultiplier, Date effectiveDate, Date terminationDate);

	protected abstract MapperS<PeriodEnum> period(PeriodExtendedEnum periodExtended, Integer periodMultiplier, Date effectiveDate, Date terminationDate);

	public static class PeriodExtendedCalculationDefault extends PeriodExtendedCalculation {
		@Override
		protected Integer doEvaluate(PeriodExtendedEnum periodExtended, Integer periodMultiplier, Date effectiveDate, Date terminationDate) {
			Integer result = null;
			return assignOutput(result, periodExtended, periodMultiplier, effectiveDate, terminationDate);
		}
		
		protected Integer assignOutput(Integer result, PeriodExtendedEnum periodExtended, Integer periodMultiplier, Date effectiveDate, Date terminationDate) {
			if (exists(period(periodExtended, periodMultiplier, effectiveDate, terminationDate)).getOrDefault(false)) {
				result = periodCalculation.evaluate(period(periodExtended, periodMultiplier, effectiveDate, terminationDate).get(), periodMultiplier);
			} else if (areEqual(MapperS.of(periodExtended), MapperS.of(PeriodExtendedEnum.T), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(periodExtended), MapperS.of(PeriodExtendedEnum.C), CardinalityOperator.All)).getOrDefault(false)) {
				result = MapperMaths.<Integer, Integer, Integer>multiply(MapperS.of(periodMultiplier), MapperS.of(dateDifference.evaluate(effectiveDate, terminationDate))).get();
			} else {
				result = null;
			}
			
			return result;
		}
		
		@Override
		protected MapperS<PeriodEnum> period(PeriodExtendedEnum periodExtended, Integer periodMultiplier, Date effectiveDate, Date terminationDate) {
			return MapperS.of(periodExtended).checkedMap("to-enum", e -> PeriodEnum.valueOf(e.name()), IllegalArgumentException.class);
		}
	}
}

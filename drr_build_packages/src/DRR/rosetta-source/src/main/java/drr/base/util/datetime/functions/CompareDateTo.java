package drr.base.util.datetime.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CompareDateTo.CompareDateToDefault.class)
public abstract class CompareDateTo implements RosettaFunction {

	/**
	* @param date 
	* @param year 
	* @param month 
	* @param day 
	* @return result 
	*/
	public Integer evaluate(Date date, Integer year, Integer month, Integer day) {
		Integer result = doEvaluate(date, year, month, day);
		
		return result;
	}

	protected abstract Integer doEvaluate(Date date, Integer year, Integer month, Integer day);

	public static class CompareDateToDefault extends CompareDateTo {
		@Override
		protected Integer doEvaluate(Date date, Integer year, Integer month, Integer day) {
			Integer result = null;
			return assignOutput(result, date, year, month, day);
		}
		
		protected Integer assignOutput(Integer result, Date date, Integer year, Integer month, Integer day) {
			if (notExists(MapperS.of(date)).getOrDefault(false)) {
				result = null;
			} else if (notEqual(MapperS.of(date).<Integer>map("Year", Date::getYear), MapperS.of(year), CardinalityOperator.Any).getOrDefault(false)) {
				result = MapperMaths.<Integer, Integer, Integer>subtract(MapperS.of(date).<Integer>map("Year", Date::getYear), MapperS.of(year)).get();
			} else if (notEqual(MapperS.of(date).<Integer>map("Month", Date::getMonth), MapperS.of(month), CardinalityOperator.Any).getOrDefault(false)) {
				result = MapperMaths.<Integer, Integer, Integer>subtract(MapperS.of(date).<Integer>map("Month", Date::getMonth), MapperS.of(month)).get();
			} else if (notEqual(MapperS.of(date).<Integer>map("Day", Date::getDay), MapperS.of(day), CardinalityOperator.Any).getOrDefault(false)) {
				result = MapperMaths.<Integer, Integer, Integer>subtract(MapperS.of(date).<Integer>map("Day", Date::getDay), MapperS.of(day)).get();
			} else {
				result = 0;
			}
			
			return result;
		}
	}
}

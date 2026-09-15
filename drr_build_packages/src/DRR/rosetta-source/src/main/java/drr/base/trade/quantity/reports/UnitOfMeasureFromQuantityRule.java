package drr.base.trade.quantity.reports;

import cdm.base.math.Measure;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.standards.iso.functions.UnitToISO20022UnitOfMeasure;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnitOfMeasureFromQuantityRule.UnitOfMeasureFromQuantityRuleDefault.class)
public abstract class UnitOfMeasureFromQuantityRule implements ReportFunction<NonNegativeQuantitySchedule, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected UnitToISO20022UnitOfMeasure unitToISO20022UnitOfMeasure;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(NonNegativeQuantitySchedule input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(NonNegativeQuantitySchedule input);

	public static class UnitOfMeasureFromQuantityRuleDefault extends UnitOfMeasureFromQuantityRule {
		@Override
		protected String doEvaluate(NonNegativeQuantitySchedule input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, NonNegativeQuantitySchedule input) {
			final MapperS<UnitType> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(item.<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier())).getOrDefault(false)) {
						return item.<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier()).<UnitType>map("getUnit", measure -> measure.getUnit());
					}
					return item.<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit());
				});
			output = MapperS.of(unitToISO20022UnitOfMeasure.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}

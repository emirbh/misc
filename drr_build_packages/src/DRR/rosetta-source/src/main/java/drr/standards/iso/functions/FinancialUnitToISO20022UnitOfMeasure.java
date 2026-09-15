package drr.standards.iso.functions;

import cdm.base.math.FinancialUnitEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FinancialUnitToISO20022UnitOfMeasure.FinancialUnitToISO20022UnitOfMeasureDefault.class)
public abstract class FinancialUnitToISO20022UnitOfMeasure implements RosettaFunction {

	/**
	* @param financialUnit 
	* @return result 
	*/
	public String evaluate(FinancialUnitEnum financialUnit) {
		String result = doEvaluate(financialUnit);
		
		return result;
	}

	protected abstract String doEvaluate(FinancialUnitEnum financialUnit);

	public static class FinancialUnitToISO20022UnitOfMeasureDefault extends FinancialUnitToISO20022UnitOfMeasure {
		@Override
		protected String doEvaluate(FinancialUnitEnum financialUnit) {
			String result = null;
			return assignOutput(result, financialUnit);
		}
		
		protected String assignOutput(String result, FinancialUnitEnum financialUnit) {
			if (areEqual(MapperS.of(financialUnit), MapperS.of(FinancialUnitEnum.CONTRACT), CardinalityOperator.All).getOrDefault(false)) {
				result = null;
			} else if (areEqual(MapperS.of(financialUnit), MapperS.of(FinancialUnitEnum.CONTRACTUAL_PRODUCT), CardinalityOperator.All).getOrDefault(false)) {
				result = "ACCY";
			} else if (areEqual(MapperS.of(financialUnit), MapperS.of(FinancialUnitEnum.INDEX_UNIT), CardinalityOperator.All).getOrDefault(false)) {
				result = "IPNT";
			} else if (areEqual(MapperS.of(financialUnit), MapperS.of(FinancialUnitEnum.LOG_NORMAL_VOLATILITY), CardinalityOperator.All).getOrDefault(false)) {
				result = null;
			} else if (areEqual(MapperS.of(financialUnit), MapperS.of(FinancialUnitEnum.SHARE), CardinalityOperator.All).getOrDefault(false)) {
				result = "SHAS";
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

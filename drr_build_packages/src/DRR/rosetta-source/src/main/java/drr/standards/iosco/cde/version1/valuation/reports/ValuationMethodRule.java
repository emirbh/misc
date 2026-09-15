package drr.standards.iosco.cde.version1.valuation.reports;

import cdm.event.common.Valuation;
import cdm.event.common.ValuationSourceEnum;
import cdm.event.common.ValuationTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.standards.iso.ValuationType1Code;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ValuationMethodRule.ValuationMethodRuleDefault.class)
public abstract class ValuationMethodRule implements ReportFunction<Valuation, ValuationType1Code> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ValuationType1Code evaluate(Valuation input) {
		ValuationType1Code output = doEvaluate(input);
		
		return output;
	}

	protected abstract ValuationType1Code doEvaluate(Valuation input);

	public static class ValuationMethodRuleDefault extends ValuationMethodRule {
		@Override
		protected ValuationType1Code doEvaluate(Valuation input) {
			ValuationType1Code output = null;
			return assignOutput(output, input);
		}
		
		protected ValuationType1Code assignOutput(ValuationType1Code output, Valuation input) {
			if (exists(MapperS.of(input).<ValuationSourceEnum>map("getSource", valuation -> valuation.getSource())).andNullSafe(areEqual(MapperS.of(input).<ValuationSourceEnum>map("getSource", valuation -> valuation.getSource()), MapperS.of(ValuationSourceEnum.CENTRAL_COUNTERPARTY), CardinalityOperator.All)).getOrDefault(false)) {
				output = ValuationType1Code.CCPV;
			} else if (exists(MapperS.of(input).<ValuationTypeEnum>map("getMethod", valuation -> valuation.getMethod())).andNullSafe(areEqual(MapperS.of(input).<ValuationTypeEnum>map("getMethod", valuation -> valuation.getMethod()), MapperS.of(ValuationTypeEnum.MARK_TO_MARKET), CardinalityOperator.All)).getOrDefault(false)) {
				output = ValuationType1Code.MTMA;
			} else if (exists(MapperS.of(input).<ValuationTypeEnum>map("getMethod", valuation -> valuation.getMethod())).andNullSafe(areEqual(MapperS.of(input).<ValuationTypeEnum>map("getMethod", valuation -> valuation.getMethod()), MapperS.of(ValuationTypeEnum.MARK_TO_MODEL), CardinalityOperator.All)).getOrDefault(false)) {
				output = ValuationType1Code.MTMO;
			} else {
				output = null;
			}
			
			return output;
		}
	}
}

package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.RiskReductionTechniqueEnum;
import javax.inject.Inject;


@ImplementedBy(TypeOfPTRRTechniqueRule.TypeOfPTRRTechniqueRuleDefault.class)
public abstract class TypeOfPTRRTechniqueRule implements ReportFunction<TransactionReportInstruction, RiskReductionTechniqueEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected drr.regulation.common.trade.event.reports.TypeOfPTRRTechniqueRule typeOfPTRRTechniqueRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public RiskReductionTechniqueEnum evaluate(TransactionReportInstruction input) {
		RiskReductionTechniqueEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract RiskReductionTechniqueEnum doEvaluate(TransactionReportInstruction input);

	public static class TypeOfPTRRTechniqueRuleDefault extends TypeOfPTRRTechniqueRule {
		@Override
		protected RiskReductionTechniqueEnum doEvaluate(TransactionReportInstruction input) {
			RiskReductionTechniqueEnum output = null;
			return assignOutput(output, input);
		}
		
		protected RiskReductionTechniqueEnum assignOutput(RiskReductionTechniqueEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableAction.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(item.get())))).get());
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(typeOfPTRRTechniqueRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}

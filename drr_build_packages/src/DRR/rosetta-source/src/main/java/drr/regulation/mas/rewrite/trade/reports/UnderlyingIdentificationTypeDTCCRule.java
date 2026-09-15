package drr.regulation.mas.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetUnderlyingIdentificationType;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlyingIdentificationTypeDTCCRule.UnderlyingIdentificationTypeDTCCRuleDefault.class)
public abstract class UnderlyingIdentificationTypeDTCCRule implements ReportFunction<TransactionReportInstruction, UnderlyingIdentificationTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetUnderlyingIdentificationType getUnderlyingIdentificationType;
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;
	@Inject protected UnderlyingIdOtherDTCCRule underlyingIdOtherDTCCRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public UnderlyingIdentificationTypeEnum evaluate(TransactionReportInstruction input) {
		UnderlyingIdentificationTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract UnderlyingIdentificationTypeEnum doEvaluate(TransactionReportInstruction input);

	public static class UnderlyingIdentificationTypeDTCCRuleDefault extends UnderlyingIdentificationTypeDTCCRule {
		@Override
		protected UnderlyingIdentificationTypeEnum doEvaluate(TransactionReportInstruction input) {
			UnderlyingIdentificationTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected UnderlyingIdentificationTypeEnum assignOutput(UnderlyingIdentificationTypeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForMAS.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(getUnderlyingIdentificationType.evaluate(item.get()))).getOrDefault(false)) {
						return MapperS.of(getUnderlyingIdentificationType.evaluate(item.get()));
					}
					if (exists(MapperS.of(underlyingIdOtherDTCCRule.evaluate(item.get()))).getOrDefault(false)) {
						return MapperS.of(UnderlyingIdentificationTypeEnum.O);
					}
					return MapperS.<UnderlyingIdentificationTypeEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}

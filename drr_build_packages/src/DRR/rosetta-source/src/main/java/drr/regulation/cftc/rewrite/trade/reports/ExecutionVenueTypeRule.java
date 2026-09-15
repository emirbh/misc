package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ExecutionVenueTypeEnum;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.ReportableExecutionVenue;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExecutionVenueTypeRule.ExecutionVenueTypeRuleDefault.class)
public abstract class ExecutionVenueTypeRule implements ReportFunction<TransactionReportInstruction, ExecutionVenueTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ExecutionVenueTypeEnum evaluate(TransactionReportInstruction input) {
		ExecutionVenueTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ExecutionVenueTypeEnum doEvaluate(TransactionReportInstruction input);

	public static class ExecutionVenueTypeRuleDefault extends ExecutionVenueTypeRule {
		@Override
		protected ExecutionVenueTypeEnum doEvaluate(TransactionReportInstruction input) {
			ExecutionVenueTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ExecutionVenueTypeEnum assignOutput(ExecutionVenueTypeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.mapSingleToList(item -> item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation()));
			final MapperC<ReportableJurisdictionInformation> thenArg2 = thenArg1
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(SupervisoryBodyEnum.CFTC), CardinalityOperator.All).get());
			final MapperS<ReportableJurisdictionInformation> thenArg3 = MapperS.of(thenArg2.get());
			output = thenArg3
				.mapSingleToItem(item -> {
					if (exists(item).getOrDefault(false)) {
						return item.<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<ReportableExecutionVenue>map("getReportableExecutionVenue", transactionInformation -> transactionInformation.getReportableExecutionVenue()).<ExecutionVenueTypeEnum>map("getExecutionVenueType", reportableExecutionVenue -> reportableExecutionVenue.getExecutionVenueType());
					}
					return MapperS.<ExecutionVenueTypeEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}

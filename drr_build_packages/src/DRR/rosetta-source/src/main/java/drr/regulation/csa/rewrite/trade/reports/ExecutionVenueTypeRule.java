package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ExecutionVenueTypeEnum;
import drr.regulation.common.ReportableExecutionVenue;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.SupervisoryBodyForCSA;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExecutionVenueTypeRule.ExecutionVenueTypeRuleDefault.class)
public abstract class ExecutionVenueTypeRule implements ReportFunction<TransactionReportInstruction, List<ExecutionVenueTypeEnum>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected SupervisoryBodyForCSA supervisoryBodyForCSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<ExecutionVenueTypeEnum> evaluate(TransactionReportInstruction input) {
		List<ExecutionVenueTypeEnum> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<ExecutionVenueTypeEnum> doEvaluate(TransactionReportInstruction input);

	public static class ExecutionVenueTypeRuleDefault extends ExecutionVenueTypeRule {
		@Override
		protected List<ExecutionVenueTypeEnum> doEvaluate(TransactionReportInstruction input) {
			List<ExecutionVenueTypeEnum> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<ExecutionVenueTypeEnum> assignOutput(List<ExecutionVenueTypeEnum> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.mapSingleToList(item -> item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation()));
			final MapperC<ReportableJurisdictionInformation> thenArg2 = thenArg1
				.filterItemNullSafe(item -> areEqual(MapperC.<SupervisoryBodyEnum>of(supervisoryBodyForCSA.evaluate()), item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), CardinalityOperator.Any).get());
			output = thenArg2
				.mapItem(item -> {
					if (exists(item).getOrDefault(false)) {
						return item.<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<ReportableExecutionVenue>map("getReportableExecutionVenue", transactionInformation -> transactionInformation.getReportableExecutionVenue()).<ExecutionVenueTypeEnum>map("getExecutionVenueType", reportableExecutionVenue -> reportableExecutionVenue.getExecutionVenueType());
					}
					return MapperS.<ExecutionVenueTypeEnum>ofNull();
				}).getMulti();
			
			return output;
		}
	}
}

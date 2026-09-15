package drr.regulation.cftc.rewrite.dtcc.trade.reports;

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

@ImplementedBy(DTCC_LargeNotionalOffFacilitySwapElectionIndicatorRule.DTCC_LargeNotionalOffFacilitySwapElectionIndicatorRuleDefault.class)
public abstract class DTCC_LargeNotionalOffFacilitySwapElectionIndicatorRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(TransactionReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction input);

	public static class DTCC_LargeNotionalOffFacilitySwapElectionIndicatorRuleDefault extends DTCC_LargeNotionalOffFacilitySwapElectionIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.mapSingleToList(item -> item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation()));
			final MapperC<ReportableJurisdictionInformation> thenArg2 = thenArg1
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(SupervisoryBodyEnum.CFTC), CardinalityOperator.All).get());
			final MapperS<ReportableJurisdictionInformation> thenArg3 = MapperS.of(thenArg2.get());
			final MapperS<TransactionInformation> thenArg4 = thenArg3
				.mapSingleToItem(item -> item.<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()));
			output = thenArg4
				.mapSingleToItem(item -> {
					if (notEqual(item.<ReportableExecutionVenue>map("getReportableExecutionVenue", transactionInformation -> transactionInformation.getReportableExecutionVenue()).<ExecutionVenueTypeEnum>map("getExecutionVenueType", reportableExecutionVenue -> reportableExecutionVenue.getExecutionVenueType()), MapperS.of(ExecutionVenueTypeEnum.SEF), CardinalityOperator.Any).andNullSafe(notEqual(item.<ReportableExecutionVenue>map("getReportableExecutionVenue", transactionInformation -> transactionInformation.getReportableExecutionVenue()).<ExecutionVenueTypeEnum>map("getExecutionVenueType", reportableExecutionVenue -> reportableExecutionVenue.getExecutionVenueType()), MapperS.of(ExecutionVenueTypeEnum.DCM), CardinalityOperator.Any)).getOrDefault(false)) {
						return item.<Boolean>map("getLargeSizeTrade", transactionInformation -> transactionInformation.getLargeSizeTrade());
					}
					return MapperS.<Boolean>ofNull();
				}).get();
			
			return output;
		}
	}
}

package drr.regulation.common.trade.link.reports;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.event.common.PositionIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SubsequentPositionUTIRule.SubsequentPositionUTIRuleDefault.class)
public abstract class SubsequentPositionUTIRule implements ReportFunction<TransactionReportInstruction, String> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class SubsequentPositionUTIRuleDefault extends SubsequentPositionUTIRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<PositionIdentifier> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<PositionIdentifier>map("getSubsequentPositionUTI", reportableInformation -> reportableInformation.getSubsequentPositionUTI())).getOrDefault(false)) {
						return item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<PositionIdentifier>map("getSubsequentPositionUTI", reportableInformation -> reportableInformation.getSubsequentPositionUTI());
					}
					return MapperS.<PositionIdentifier>ofNull();
				});
			final MapperS<PositionIdentifier> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", positionIdentifier -> positionIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER), CardinalityOperator.All).get());
			final MapperC<FieldWithMetaString> thenArg2 = thenArg1
				.mapSingleToList(item -> item.<AssignedIdentifier>mapC("getAssignedIdentifier", positionIdentifier -> positionIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
			final MapperC<FieldWithMetaString> thenArg3 = distinctIgnoringPrecision(thenArg2);
			final FieldWithMetaString fieldWithMetaString = MapperS.of(thenArg3.get()).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}

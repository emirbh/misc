package drr.regulation.cftc.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart45TransactionReportReportingTimestampCondition")
@ImplementedBy(CFTCPart45TransactionReportReportingTimestampCondition.Default.class)
public interface CFTCPart45TransactionReportReportingTimestampCondition extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportReportingTimestampCondition";
	String DEFINITION = "reportingTimestamp = executionTimestamp or reportingTimestamp > executionTimestamp";
	
	class Default implements CFTCPart45TransactionReportReportingTimestampCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart45TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart45TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart45TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			try {
				return areEqual(MapperS.of(cFTCPart45TransactionReport).<ZonedDateTime>map("getReportingTimestamp", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getReportingTimestamp()), MapperS.of(cFTCPart45TransactionReport).<ZonedDateTime>map("getExecutionTimestamp", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getExecutionTimestamp()), CardinalityOperator.All).orNullSafe(greaterThan(MapperS.of(cFTCPart45TransactionReport).<ZonedDateTime>map("getReportingTimestamp", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getReportingTimestamp()), MapperS.of(cFTCPart45TransactionReport).<ZonedDateTime>map("getExecutionTimestamp", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getExecutionTimestamp()), CardinalityOperator.All));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportReportingTimestampCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}

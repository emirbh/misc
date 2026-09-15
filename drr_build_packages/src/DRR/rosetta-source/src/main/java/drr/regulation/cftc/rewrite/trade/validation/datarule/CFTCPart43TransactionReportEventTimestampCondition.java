package drr.regulation.cftc.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart43TransactionReportEventTimestampCondition")
@ImplementedBy(CFTCPart43TransactionReportEventTimestampCondition.Default.class)
public interface CFTCPart43TransactionReportEventTimestampCondition extends Validator<CFTCPart43TransactionReport> {
	
	String NAME = "CFTCPart43TransactionReportEventTimestampCondition";
	String DEFINITION = "eventTimestamp = executionTimestamp or eventTimestamp > executionTimestamp";
	
	class Default implements CFTCPart43TransactionReportEventTimestampCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart43TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			try {
				return areEqual(MapperS.of(cFTCPart43TransactionReport).<ZonedDateTime>map("getEventTimestamp", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getEventTimestamp()), MapperS.of(cFTCPart43TransactionReport).<ZonedDateTime>map("getExecutionTimestamp", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getExecutionTimestamp()), CardinalityOperator.All).orNullSafe(greaterThan(MapperS.of(cFTCPart43TransactionReport).<ZonedDateTime>map("getEventTimestamp", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getEventTimestamp()), MapperS.of(cFTCPart43TransactionReport).<ZonedDateTime>map("getExecutionTimestamp", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getExecutionTimestamp()), CardinalityOperator.All));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart43TransactionReportEventTimestampCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			return Collections.emptyList();
		}
	}
}

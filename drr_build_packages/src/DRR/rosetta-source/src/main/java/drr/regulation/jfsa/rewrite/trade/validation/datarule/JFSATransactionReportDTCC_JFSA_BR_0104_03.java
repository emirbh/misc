package drr.regulation.jfsa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("JFSATransactionReportDTCC_JFSA_BR_0104_03")
@ImplementedBy(JFSATransactionReportDTCC_JFSA_BR_0104_03.Default.class)
public interface JFSATransactionReportDTCC_JFSA_BR_0104_03 extends Validator<JFSATransactionReport> {
	
	String NAME = "JFSATransactionReportDTCC_JFSA_BR_0104_03";
	String DEFINITION = "if ActionTypeEnum -> TERM = actionType then eventTimestamp >= executionTimestamp and eventTimestamp <= reportingTimestamp and eventTimestamp -> date <= expirationDate and eventTimestamp -> date = earlyTerminationDate";
	
	class Default implements JFSATransactionReportDTCC_JFSA_BR_0104_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			ComparisonResult result = executeDataRule(jFSATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(JFSATransactionReport jFSATransactionReport) {
			try {
				if (areEqual(MapperS.of(ActionTypeEnum.TERM), MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), CardinalityOperator.All).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(jFSATransactionReport).<ZonedDateTime>map("getEventTimestamp", _jFSATransactionReport -> _jFSATransactionReport.getEventTimestamp()), MapperS.of(jFSATransactionReport).<ZonedDateTime>map("getExecutionTimestamp", _jFSATransactionReport -> _jFSATransactionReport.getExecutionTimestamp()), CardinalityOperator.All).andNullSafe(lessThanEquals(MapperS.of(jFSATransactionReport).<ZonedDateTime>map("getEventTimestamp", _jFSATransactionReport -> _jFSATransactionReport.getEventTimestamp()), MapperS.of(jFSATransactionReport).<ZonedDateTime>map("getReportingTimestamp", _jFSATransactionReport -> _jFSATransactionReport.getReportingTimestamp()), CardinalityOperator.All)).andNullSafe(lessThanEquals(MapperS.of(jFSATransactionReport).<ZonedDateTime>map("getEventTimestamp", _jFSATransactionReport -> _jFSATransactionReport.getEventTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), MapperS.of(jFSATransactionReport).<Date>map("getExpirationDate", _jFSATransactionReport -> _jFSATransactionReport.getExpirationDate()), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(jFSATransactionReport).<ZonedDateTime>map("getEventTimestamp", _jFSATransactionReport -> _jFSATransactionReport.getEventTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), MapperS.of(jFSATransactionReport).<Date>map("getEarlyTerminationDate", _jFSATransactionReport -> _jFSATransactionReport.getEarlyTerminationDate()), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements JFSATransactionReportDTCC_JFSA_BR_0104_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			return Collections.emptyList();
		}
	}
}

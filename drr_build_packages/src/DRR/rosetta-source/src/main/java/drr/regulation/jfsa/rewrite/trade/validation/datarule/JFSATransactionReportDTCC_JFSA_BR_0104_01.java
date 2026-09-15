package drr.regulation.jfsa.rewrite.trade.validation.datarule;

import cdm.base.datetime.functions.DateDifference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.jfsa.rewrite.functions.EventTimestamp_Validation;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("JFSATransactionReportDTCC_JFSA_BR_0104_01")
@ImplementedBy(JFSATransactionReportDTCC_JFSA_BR_0104_01.Default.class)
public interface JFSATransactionReportDTCC_JFSA_BR_0104_01 extends Validator<JFSATransactionReport> {
	
	String NAME = "JFSATransactionReportDTCC_JFSA_BR_0104_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR] any = actionType then EventTimestamp_Validation( eventTimestamp, executionTimestamp, reportingTimestamp, expirationDate, earlyTerminationDate ) else if actionType = ActionTypeEnum -> REVI then eventTimestamp exists and reportingTimestamp exists and eventTimestamp <= reportingTimestamp and DateDifference( eventTimestamp -> date, reportingTimestamp -> date ) <= 2 else True";
	
	class Default implements JFSATransactionReportDTCC_JFSA_BR_0104_01 {
	
		@Inject protected DateDifference dateDifference;
		
		@Inject protected EventTimestamp_Validation eventTimestamp_Validation;
		
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR)), MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(eventTimestamp_Validation.evaluate(MapperS.of(jFSATransactionReport).<ZonedDateTime>map("getEventTimestamp", _jFSATransactionReport -> _jFSATransactionReport.getEventTimestamp()).get(), MapperS.of(jFSATransactionReport).<ZonedDateTime>map("getExecutionTimestamp", _jFSATransactionReport -> _jFSATransactionReport.getExecutionTimestamp()).get(), MapperS.of(jFSATransactionReport).<ZonedDateTime>map("getReportingTimestamp", _jFSATransactionReport -> _jFSATransactionReport.getReportingTimestamp()).get(), MapperS.of(jFSATransactionReport).<Date>map("getExpirationDate", _jFSATransactionReport -> _jFSATransactionReport.getExpirationDate()).get(), MapperS.of(jFSATransactionReport).<Date>map("getEarlyTerminationDate", _jFSATransactionReport -> _jFSATransactionReport.getEarlyTerminationDate()).get())));
				}
				if (areEqual(MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), MapperS.of(ActionTypeEnum.REVI), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(jFSATransactionReport).<ZonedDateTime>map("getEventTimestamp", _jFSATransactionReport -> _jFSATransactionReport.getEventTimestamp())).andNullSafe(exists(MapperS.of(jFSATransactionReport).<ZonedDateTime>map("getReportingTimestamp", _jFSATransactionReport -> _jFSATransactionReport.getReportingTimestamp()))).andNullSafe(lessThanEquals(MapperS.of(jFSATransactionReport).<ZonedDateTime>map("getEventTimestamp", _jFSATransactionReport -> _jFSATransactionReport.getEventTimestamp()), MapperS.of(jFSATransactionReport).<ZonedDateTime>map("getReportingTimestamp", _jFSATransactionReport -> _jFSATransactionReport.getReportingTimestamp()), CardinalityOperator.All)).andNullSafe(lessThanEquals(MapperS.of(dateDifference.evaluate(MapperS.of(jFSATransactionReport).<ZonedDateTime>map("getEventTimestamp", _jFSATransactionReport -> _jFSATransactionReport.getEventTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperS.of(jFSATransactionReport).<ZonedDateTime>map("getReportingTimestamp", _jFSATransactionReport -> _jFSATransactionReport.getReportingTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())), MapperS.of(2), CardinalityOperator.All));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(true));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements JFSATransactionReportDTCC_JFSA_BR_0104_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			return Collections.emptyList();
		}
	}
}

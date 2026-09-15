package drr.regulation.jfsa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ClearedEnum;
import drr.standards.iso.EventTypeEnum;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("JFSATransactionReportDTCC_JFSA_BR_0024_01")
@ImplementedBy(JFSATransactionReportDTCC_JFSA_BR_0024_01.Default.class)
public interface JFSATransactionReportDTCC_JFSA_BR_0024_01 extends Validator<JFSATransactionReport> {
	
	String NAME = "JFSATransactionReportDTCC_JFSA_BR_0024_01";
	String DEFINITION = "if cleared = Y and actionType = ActionTypeEnum -> NEWT and [EventTypeEnum -> CLRG, EventTypeEnum -> CLAL] any = eventType then clearingReceiptTimestamp exists";
	
	class Default implements JFSATransactionReportDTCC_JFSA_BR_0024_01 {
	
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
				if (areEqual(MapperS.of(jFSATransactionReport).<ClearedEnum>map("getCleared", _jFSATransactionReport -> _jFSATransactionReport.getCleared()), MapperS.of(ClearedEnum.Y), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All)).andNullSafe(areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.CLAL)), MapperS.of(jFSATransactionReport).<EventTypeEnum>map("getEventType", _jFSATransactionReport -> _jFSATransactionReport.getEventType()), CardinalityOperator.Any)).getOrDefault(false)) {
					return exists(MapperS.of(jFSATransactionReport).<ZonedDateTime>map("getClearingReceiptTimestamp", _jFSATransactionReport -> _jFSATransactionReport.getClearingReceiptTimestamp()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements JFSATransactionReportDTCC_JFSA_BR_0024_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			return Collections.emptyList();
		}
	}
}

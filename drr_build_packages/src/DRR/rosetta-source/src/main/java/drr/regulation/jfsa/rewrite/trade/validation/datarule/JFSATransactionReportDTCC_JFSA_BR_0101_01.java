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
import drr.standards.iso.EventTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("JFSATransactionReportDTCC_JFSA_BR_0101_01")
@ImplementedBy(JFSATransactionReportDTCC_JFSA_BR_0101_01.Default.class)
public interface JFSATransactionReportDTCC_JFSA_BR_0101_01 extends Validator<JFSATransactionReport> {
	
	String NAME = "JFSATransactionReportDTCC_JFSA_BR_0101_01";
	String DEFINITION = "if actionType = ActionTypeEnum -> NEWT then [EventTypeEnum -> TRAD, EventTypeEnum -> NOVA, EventTypeEnum -> COMP, EventTypeEnum -> CLRG, EventTypeEnum -> EXER, EventTypeEnum -> ALOC, EventTypeEnum -> CLAL, EventTypeEnum -> PTNG, EventTypeEnum -> CORP] any = eventType else if actionType = ActionTypeEnum -> MODI then [EventTypeEnum -> TRAD, EventTypeEnum -> NOVA, EventTypeEnum -> COMP, EventTypeEnum -> ETRM, EventTypeEnum -> EXER, EventTypeEnum -> ALOC, EventTypeEnum -> CREV, EventTypeEnum -> CORP, EventTypeEnum -> UPDT] any = eventType else if actionType = ActionTypeEnum -> PRTO then EventTypeEnum -> PTNG = eventType else if actionType = ActionTypeEnum -> TERM then [EventTypeEnum -> NOVA, EventTypeEnum -> COMP, EventTypeEnum -> ETRM, EventTypeEnum -> CLRG, EventTypeEnum -> EXER, EventTypeEnum -> ALOC, EventTypeEnum -> CLAL, EventTypeEnum -> CREV, EventTypeEnum -> CORP] any = eventType else if [ActionTypeEnum -> CORR, ActionTypeEnum -> REVI, ActionTypeEnum -> EROR, ActionTypeEnum -> VALU, ActionTypeEnum -> MARU] any = actionType then True";
	
	class Default implements JFSATransactionReportDTCC_JFSA_BR_0101_01 {
	
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
				if (areEqual(MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.TRAD), MapperS.of(EventTypeEnum.NOVA), MapperS.of(EventTypeEnum.COMP), MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.EXER), MapperS.of(EventTypeEnum.ALOC), MapperS.of(EventTypeEnum.CLAL), MapperS.of(EventTypeEnum.PTNG), MapperS.of(EventTypeEnum.CORP)), MapperS.of(jFSATransactionReport).<EventTypeEnum>map("getEventType", _jFSATransactionReport -> _jFSATransactionReport.getEventType()), CardinalityOperator.Any);
				}
				if (areEqual(MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), MapperS.of(ActionTypeEnum.MODI), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.TRAD), MapperS.of(EventTypeEnum.NOVA), MapperS.of(EventTypeEnum.COMP), MapperS.of(EventTypeEnum.ETRM), MapperS.of(EventTypeEnum.EXER), MapperS.of(EventTypeEnum.ALOC), MapperS.of(EventTypeEnum.CREV), MapperS.of(EventTypeEnum.CORP), MapperS.of(EventTypeEnum.UPDT)), MapperS.of(jFSATransactionReport).<EventTypeEnum>map("getEventType", _jFSATransactionReport -> _jFSATransactionReport.getEventType()), CardinalityOperator.Any);
				}
				if (areEqual(MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), MapperS.of(ActionTypeEnum.PRTO), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperS.of(EventTypeEnum.PTNG), MapperS.of(jFSATransactionReport).<EventTypeEnum>map("getEventType", _jFSATransactionReport -> _jFSATransactionReport.getEventType()), CardinalityOperator.All);
				}
				if (areEqual(MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.NOVA), MapperS.of(EventTypeEnum.COMP), MapperS.of(EventTypeEnum.ETRM), MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.EXER), MapperS.of(EventTypeEnum.ALOC), MapperS.of(EventTypeEnum.CLAL), MapperS.of(EventTypeEnum.CREV), MapperS.of(EventTypeEnum.CORP)), MapperS.of(jFSATransactionReport).<EventTypeEnum>map("getEventType", _jFSATransactionReport -> _jFSATransactionReport.getEventType()), CardinalityOperator.Any);
				}
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.EROR), MapperS.of(ActionTypeEnum.VALU), MapperS.of(ActionTypeEnum.MARU)), MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements JFSATransactionReportDTCC_JFSA_BR_0101_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			return Collections.emptyList();
		}
	}
}

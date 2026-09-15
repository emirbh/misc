package drr.regulation.cftc.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart45TransactionReportEventTypeCondition")
@ImplementedBy(CFTCPart45TransactionReportEventTypeCondition.Default.class)
public interface CFTCPart45TransactionReportEventTypeCondition extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportEventTypeCondition";
	String DEFINITION = "if actionType = ActionTypeEnum -> NEWT then [EventTypeEnum -> TRAD, EventTypeEnum -> NOVA, EventTypeEnum -> COMP, EventTypeEnum -> CLRG, EventTypeEnum -> EXER, EventTypeEnum -> ALOC, EventTypeEnum -> CLAL, EventTypeEnum -> PTNG, EventTypeEnum -> CORP] any = eventType else if actionType = ActionTypeEnum -> MODI then [EventTypeEnum -> TRAD, EventTypeEnum -> NOVA, EventTypeEnum -> COMP, EventTypeEnum -> EXER, EventTypeEnum -> ALOC, EventTypeEnum -> CREV, EventTypeEnum -> CORP, EventTypeEnum -> UPDT] any = eventType else if actionType = ActionTypeEnum -> TERM then [EventTypeEnum -> NOVA, EventTypeEnum -> COMP, EventTypeEnum -> ETRM, EventTypeEnum -> CLRG, EventTypeEnum -> EXER, EventTypeEnum -> ALOC, EventTypeEnum -> CLAL, EventTypeEnum -> CREV, EventTypeEnum -> CORP] any = eventType else if actionType = ActionTypeEnum -> PRTO then eventType = EventTypeEnum -> PTNG else [ActionTypeEnum -> CORR, ActionTypeEnum -> EROR, ActionTypeEnum -> REVI, ActionTypeEnum -> VALU, ActionTypeEnum -> MARU] any = actionType and eventType is absent";
	
	class Default implements CFTCPart45TransactionReportEventTypeCondition {
	
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
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<ActionTypeEnum>map("getActionType", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.TRAD), MapperS.of(EventTypeEnum.NOVA), MapperS.of(EventTypeEnum.COMP), MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.EXER), MapperS.of(EventTypeEnum.ALOC), MapperS.of(EventTypeEnum.CLAL), MapperS.of(EventTypeEnum.PTNG), MapperS.of(EventTypeEnum.CORP)), MapperS.of(cFTCPart45TransactionReport).<EventTypeEnum>map("getEventType", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getEventType()), CardinalityOperator.Any);
				}
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<ActionTypeEnum>map("getActionType", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getActionType()), MapperS.of(ActionTypeEnum.MODI), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.TRAD), MapperS.of(EventTypeEnum.NOVA), MapperS.of(EventTypeEnum.COMP), MapperS.of(EventTypeEnum.EXER), MapperS.of(EventTypeEnum.ALOC), MapperS.of(EventTypeEnum.CREV), MapperS.of(EventTypeEnum.CORP), MapperS.of(EventTypeEnum.UPDT)), MapperS.of(cFTCPart45TransactionReport).<EventTypeEnum>map("getEventType", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getEventType()), CardinalityOperator.Any);
				}
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<ActionTypeEnum>map("getActionType", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getActionType()), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.NOVA), MapperS.of(EventTypeEnum.COMP), MapperS.of(EventTypeEnum.ETRM), MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.EXER), MapperS.of(EventTypeEnum.ALOC), MapperS.of(EventTypeEnum.CLAL), MapperS.of(EventTypeEnum.CREV), MapperS.of(EventTypeEnum.CORP)), MapperS.of(cFTCPart45TransactionReport).<EventTypeEnum>map("getEventType", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getEventType()), CardinalityOperator.Any);
				}
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<ActionTypeEnum>map("getActionType", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getActionType()), MapperS.of(ActionTypeEnum.PRTO), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperS.of(cFTCPart45TransactionReport).<EventTypeEnum>map("getEventType", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getEventType()), MapperS.of(EventTypeEnum.PTNG), CardinalityOperator.All);
				}
				return areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.EROR), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.VALU), MapperS.of(ActionTypeEnum.MARU)), MapperS.of(cFTCPart45TransactionReport).<ActionTypeEnum>map("getActionType", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(notExists(MapperS.of(cFTCPart45TransactionReport).<EventTypeEnum>map("getEventType", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getEventType())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportEventTypeCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}

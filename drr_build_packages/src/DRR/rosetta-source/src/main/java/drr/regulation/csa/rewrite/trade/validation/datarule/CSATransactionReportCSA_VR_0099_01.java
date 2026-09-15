package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportCSA_VR_0099_01")
@ImplementedBy(CSATransactionReportCSA_VR_0099_01.Default.class)
public interface CSATransactionReportCSA_VR_0099_01 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportCSA_VR_0099_01";
	String DEFINITION = "if actionType = NEWT then [EventTypeEnum -> TRAD, EventTypeEnum -> NOVA, EventTypeEnum -> COMP, EventTypeEnum -> CLRG, EventTypeEnum -> EXER, EventTypeEnum -> ALOC, EventTypeEnum -> CLAL, EventTypeEnum -> PTNG, EventTypeEnum -> CORP, EventTypeEnum -> UPDT, EventTypeEnum -> INCP] any = eventType else if actionType = MODI then [EventTypeEnum -> TRAD, EventTypeEnum -> NOVA, EventTypeEnum -> COMP, EventTypeEnum -> ETRM, EventTypeEnum -> EXER, EventTypeEnum -> ALOC, EventTypeEnum -> CREV, EventTypeEnum -> CORP, EventTypeEnum -> UPDT, EventTypeEnum -> INCP] any = eventType else if actionType = TERM then [EventTypeEnum -> NOVA, EventTypeEnum -> COMP, EventTypeEnum -> ETRM, EventTypeEnum -> CLRG, EventTypeEnum -> EXER, EventTypeEnum -> ALOC, EventTypeEnum -> CLAL, EventTypeEnum -> CREV, EventTypeEnum -> CORP, EventTypeEnum -> INCP] any = eventType else if actionType = PRTO then eventType = EventTypeEnum -> PTNG else [ActionTypeEnum -> CORR, ActionTypeEnum -> EROR, ActionTypeEnum -> REVI, ActionTypeEnum -> VALU, ActionTypeEnum -> MARU, ActionTypeEnum -> POSC] any = actionType and eventType is absent";
	
	class Default implements CSATransactionReportCSA_VR_0099_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			ComparisonResult result = executeDataRule(cSATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSATransactionReport cSATransactionReport) {
			try {
				if (areEqual(MapperS.of(cSATransactionReport).<ActionTypeEnum>map("getActionType", _cSATransactionReport -> _cSATransactionReport.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.TRAD), MapperS.of(EventTypeEnum.NOVA), MapperS.of(EventTypeEnum.COMP), MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.EXER), MapperS.of(EventTypeEnum.ALOC), MapperS.of(EventTypeEnum.CLAL), MapperS.of(EventTypeEnum.PTNG), MapperS.of(EventTypeEnum.CORP), MapperS.of(EventTypeEnum.UPDT), MapperS.of(EventTypeEnum.INCP)), MapperS.of(cSATransactionReport).<EventTypeEnum>map("getEventType", _cSATransactionReport -> _cSATransactionReport.getEventType()), CardinalityOperator.Any);
				}
				if (areEqual(MapperS.of(cSATransactionReport).<ActionTypeEnum>map("getActionType", _cSATransactionReport -> _cSATransactionReport.getActionType()), MapperS.of(ActionTypeEnum.MODI), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.TRAD), MapperS.of(EventTypeEnum.NOVA), MapperS.of(EventTypeEnum.COMP), MapperS.of(EventTypeEnum.ETRM), MapperS.of(EventTypeEnum.EXER), MapperS.of(EventTypeEnum.ALOC), MapperS.of(EventTypeEnum.CREV), MapperS.of(EventTypeEnum.CORP), MapperS.of(EventTypeEnum.UPDT), MapperS.of(EventTypeEnum.INCP)), MapperS.of(cSATransactionReport).<EventTypeEnum>map("getEventType", _cSATransactionReport -> _cSATransactionReport.getEventType()), CardinalityOperator.Any);
				}
				if (areEqual(MapperS.of(cSATransactionReport).<ActionTypeEnum>map("getActionType", _cSATransactionReport -> _cSATransactionReport.getActionType()), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.NOVA), MapperS.of(EventTypeEnum.COMP), MapperS.of(EventTypeEnum.ETRM), MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.EXER), MapperS.of(EventTypeEnum.ALOC), MapperS.of(EventTypeEnum.CLAL), MapperS.of(EventTypeEnum.CREV), MapperS.of(EventTypeEnum.CORP), MapperS.of(EventTypeEnum.INCP)), MapperS.of(cSATransactionReport).<EventTypeEnum>map("getEventType", _cSATransactionReport -> _cSATransactionReport.getEventType()), CardinalityOperator.Any);
				}
				if (areEqual(MapperS.of(cSATransactionReport).<ActionTypeEnum>map("getActionType", _cSATransactionReport -> _cSATransactionReport.getActionType()), MapperS.of(ActionTypeEnum.PRTO), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperS.of(cSATransactionReport).<EventTypeEnum>map("getEventType", _cSATransactionReport -> _cSATransactionReport.getEventType()), MapperS.of(EventTypeEnum.PTNG), CardinalityOperator.All);
				}
				return areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.EROR), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.VALU), MapperS.of(ActionTypeEnum.MARU), MapperS.of(ActionTypeEnum.POSC)), MapperS.of(cSATransactionReport).<ActionTypeEnum>map("getActionType", _cSATransactionReport -> _cSATransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(notExists(MapperS.of(cSATransactionReport).<EventTypeEnum>map("getEventType", _cSATransactionReport -> _cSATransactionReport.getEventType())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportCSA_VR_0099_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}

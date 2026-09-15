package drr.regulation.asic.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_1102_01")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_1102_01.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_1102_01 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_1102_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI, ActionTypeEnum -> TERM, ActionTypeEnum -> PRTO, ActionTypeEnum -> EROR, ActionTypeEnum -> MARU, ActionTypeEnum -> VALU] any = actionType then if actionType = ActionTypeEnum -> NEWT then [EventTypeEnum -> TRAD, EventTypeEnum -> NOVA, EventTypeEnum -> COMP, EventTypeEnum -> CLRG, EventTypeEnum -> EXER, EventTypeEnum -> ALOC, EventTypeEnum -> PTNG, EventTypeEnum -> CORP, EventTypeEnum -> INCP] any = eventType else if actionType = ActionTypeEnum -> MODI then [EventTypeEnum -> TRAD, EventTypeEnum -> NOVA, EventTypeEnum -> COMP, EventTypeEnum -> ETRM, EventTypeEnum -> EXER, EventTypeEnum -> ALOC, EventTypeEnum -> CREV, EventTypeEnum -> CORP, EventTypeEnum -> INCP, EventTypeEnum -> UPDT] any = eventType else if actionType = ActionTypeEnum -> TERM then [EventTypeEnum -> NOVA, EventTypeEnum -> COMP, EventTypeEnum -> ETRM, EventTypeEnum -> CLRG, EventTypeEnum -> EXER, EventTypeEnum -> ALOC, EventTypeEnum -> CREV, EventTypeEnum -> CORP, EventTypeEnum -> INCP] any = eventType else if actionType = ActionTypeEnum -> PRTO then eventType = EventTypeEnum -> PTNG";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_1102_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			ComparisonResult result = executeDataRule(aSICTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ASICTransactionReport aSICTransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.TERM), MapperS.of(ActionTypeEnum.PRTO), MapperS.of(ActionTypeEnum.EROR), MapperS.of(ActionTypeEnum.MARU), MapperS.of(ActionTypeEnum.VALU)), MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (areEqual(MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).getOrDefault(false)) {
						return areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.TRAD), MapperS.of(EventTypeEnum.NOVA), MapperS.of(EventTypeEnum.COMP), MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.EXER), MapperS.of(EventTypeEnum.ALOC), MapperS.of(EventTypeEnum.PTNG), MapperS.of(EventTypeEnum.CORP), MapperS.of(EventTypeEnum.INCP)), MapperS.of(aSICTransactionReport).<EventTypeEnum>map("getEventType", _aSICTransactionReport -> _aSICTransactionReport.getEventType()), CardinalityOperator.Any);
					}
					if (areEqual(MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), MapperS.of(ActionTypeEnum.MODI), CardinalityOperator.All).getOrDefault(false)) {
						return areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.TRAD), MapperS.of(EventTypeEnum.NOVA), MapperS.of(EventTypeEnum.COMP), MapperS.of(EventTypeEnum.ETRM), MapperS.of(EventTypeEnum.EXER), MapperS.of(EventTypeEnum.ALOC), MapperS.of(EventTypeEnum.CREV), MapperS.of(EventTypeEnum.CORP), MapperS.of(EventTypeEnum.INCP), MapperS.of(EventTypeEnum.UPDT)), MapperS.of(aSICTransactionReport).<EventTypeEnum>map("getEventType", _aSICTransactionReport -> _aSICTransactionReport.getEventType()), CardinalityOperator.Any);
					}
					if (areEqual(MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All).getOrDefault(false)) {
						return areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.NOVA), MapperS.of(EventTypeEnum.COMP), MapperS.of(EventTypeEnum.ETRM), MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.EXER), MapperS.of(EventTypeEnum.ALOC), MapperS.of(EventTypeEnum.CREV), MapperS.of(EventTypeEnum.CORP), MapperS.of(EventTypeEnum.INCP)), MapperS.of(aSICTransactionReport).<EventTypeEnum>map("getEventType", _aSICTransactionReport -> _aSICTransactionReport.getEventType()), CardinalityOperator.Any);
					}
					if (areEqual(MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), MapperS.of(ActionTypeEnum.PRTO), CardinalityOperator.All).getOrDefault(false)) {
						return areEqual(MapperS.of(aSICTransactionReport).<EventTypeEnum>map("getEventType", _aSICTransactionReport -> _aSICTransactionReport.getEventType()), MapperS.of(EventTypeEnum.PTNG), CardinalityOperator.All);
					}
					return ComparisonResult.ofEmpty();
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_1102_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}

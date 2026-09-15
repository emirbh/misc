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
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_1099_01")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_1099_01.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_1099_01 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_1099_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType then if ((actionType = ActionTypeEnum -> NEWT and eventType = EventTypeEnum -> ALOC) or ((actionType = ActionTypeEnum -> NEWT or actionType = ActionTypeEnum -> MODI) and eventType = EventTypeEnum -> INCP)) then priorUTI exists and priorUTI <> uniqueTransactionIdentifier else if (actionType = ActionTypeEnum -> NEWT and (eventType = EventTypeEnum -> TRAD or eventType = EventTypeEnum -> PTNG)) then priorUTI is absent";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_1099_01 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (areEqual(MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(aSICTransactionReport).<EventTypeEnum>map("getEventType", _aSICTransactionReport -> _aSICTransactionReport.getEventType()), MapperS.of(EventTypeEnum.ALOC), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), MapperS.of(ActionTypeEnum.MODI), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(aSICTransactionReport).<EventTypeEnum>map("getEventType", _aSICTransactionReport -> _aSICTransactionReport.getEventType()), MapperS.of(EventTypeEnum.INCP), CardinalityOperator.All))).getOrDefault(false)) {
						return exists(MapperS.of(aSICTransactionReport).<String>map("getPriorUTI", _aSICTransactionReport -> _aSICTransactionReport.getPriorUTI())).andNullSafe(notEqual(MapperS.of(aSICTransactionReport).<String>map("getPriorUTI", _aSICTransactionReport -> _aSICTransactionReport.getPriorUTI()), MapperS.of(aSICTransactionReport).<String>map("getUniqueTransactionIdentifier", _aSICTransactionReport -> _aSICTransactionReport.getUniqueTransactionIdentifier()), CardinalityOperator.Any));
					}
					if (areEqual(MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(aSICTransactionReport).<EventTypeEnum>map("getEventType", _aSICTransactionReport -> _aSICTransactionReport.getEventType()), MapperS.of(EventTypeEnum.TRAD), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(aSICTransactionReport).<EventTypeEnum>map("getEventType", _aSICTransactionReport -> _aSICTransactionReport.getEventType()), MapperS.of(EventTypeEnum.PTNG), CardinalityOperator.All))).getOrDefault(false)) {
						return notExists(MapperS.of(aSICTransactionReport).<String>map("getPriorUTI", _aSICTransactionReport -> _aSICTransactionReport.getPriorUTI()));
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
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_1099_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}

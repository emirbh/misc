package drr.regulation.fca.ukemir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import drr.standards.iso.RiskReductionTechniqueEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2005_02")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2005_02.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2005_02 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2005_02";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> TERM, ActionTypeEnum -> REVI] any = actionType then if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> TERM] any = actionType then if (eventType = EventTypeEnum -> COMP and typeOfPTRRTechnique = PWOS) or eventType <> EventTypeEnum -> COMP then ptrrId is absent";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2005_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			ComparisonResult result = executeDataRule(fCAUKEMIRTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.TERM), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.TERM)), MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
						if (areEqual(MapperS.of(fCAUKEMIRTransactionReport).<EventTypeEnum>map("getEventType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getEventType()), MapperS.of(EventTypeEnum.COMP), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(fCAUKEMIRTransactionReport).<RiskReductionTechniqueEnum>map("getTypeOfPTRRTechnique", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getTypeOfPTRRTechnique()), MapperS.of(RiskReductionTechniqueEnum.PWOS), CardinalityOperator.All)).orNullSafe(notEqual(MapperS.of(fCAUKEMIRTransactionReport).<EventTypeEnum>map("getEventType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getEventType()), MapperS.of(EventTypeEnum.COMP), CardinalityOperator.Any)).getOrDefault(false)) {
							return notExists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getPtrrId", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getPtrrId()));
						}
						return ComparisonResult.ofEmpty();
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
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2005_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}

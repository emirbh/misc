package drr.regulation.esma.emir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.qualification.event.functions.IsVRAllowedForActionType;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import drr.standards.iso.RiskReductionTechniqueEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2039_01")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2039_01.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2039_01 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2039_01";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) or actionType = ActionTypeEnum -> TERM then if ptrr = True or ([ActionTypeEnum -> TERM, ActionTypeEnum -> MODI] any = actionType and eventType = COMP) then [RiskReductionTechniqueEnum -> PWOS, RiskReductionTechniqueEnum -> PWAS, RiskReductionTechniqueEnum -> PRBM, RiskReductionTechniqueEnum -> OTHR] any = typeOfPTRRTechnique";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2039_01 {
	
		@Inject protected IsVRAllowedForActionType isVRAllowedForActionType;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			ComparisonResult result = executeDataRule(eSMAEMIRTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			try {
				if (ComparisonResult.ofNullSafe(MapperS.of(isVRAllowedForActionType.evaluate(MapperS.of(eSMAEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getActionType()).get()))).orNullSafe(areEqual(MapperS.of(eSMAEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getActionType()), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All)).getOrDefault(false)) {
					if (areEqual(MapperS.of(eSMAEMIRTransactionReport).<Boolean>map("getPtrr", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getPtrr()), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.TERM), MapperS.of(ActionTypeEnum.MODI)), MapperS.of(eSMAEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(eSMAEMIRTransactionReport).<EventTypeEnum>map("getEventType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getEventType()), MapperS.of(EventTypeEnum.COMP), CardinalityOperator.All))).getOrDefault(false)) {
						return areEqual(MapperC.<RiskReductionTechniqueEnum>of(MapperS.of(RiskReductionTechniqueEnum.PWOS), MapperS.of(RiskReductionTechniqueEnum.PWAS), MapperS.of(RiskReductionTechniqueEnum.PRBM), MapperS.of(RiskReductionTechniqueEnum.OTHR)), MapperS.of(eSMAEMIRTransactionReport).<RiskReductionTechniqueEnum>map("getTypeOfPTRRTechnique", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getTypeOfPTRRTechnique()), CardinalityOperator.Any);
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
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2039_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}

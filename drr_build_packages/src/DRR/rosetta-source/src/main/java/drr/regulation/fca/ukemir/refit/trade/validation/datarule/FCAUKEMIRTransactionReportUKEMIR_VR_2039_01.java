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
import drr.base.qualification.event.functions.IsVRAllowedForActionType;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
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
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2039_01")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2039_01.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2039_01 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2039_01";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) or actionType = ActionTypeEnum -> TERM then if ptrr = True or ([ActionTypeEnum -> TERM, ActionTypeEnum -> MODI] any = actionType and eventType = EventTypeEnum -> COMP) then [RiskReductionTechniqueEnum -> PWOS, RiskReductionTechniqueEnum -> PWAS, RiskReductionTechniqueEnum -> PRBM, RiskReductionTechniqueEnum -> OTHR] any = typeOfPTRRTechnique";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2039_01 {
	
		@Inject protected IsVRAllowedForActionType isVRAllowedForActionType;
		
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
				if (ComparisonResult.ofNullSafe(MapperS.of(isVRAllowedForActionType.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()).get()))).orNullSafe(areEqual(MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All)).getOrDefault(false)) {
					if (areEqual(MapperS.of(fCAUKEMIRTransactionReport).<Boolean>map("getPtrr", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getPtrr()), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.TERM), MapperS.of(ActionTypeEnum.MODI)), MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(fCAUKEMIRTransactionReport).<EventTypeEnum>map("getEventType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getEventType()), MapperS.of(EventTypeEnum.COMP), CardinalityOperator.All))).getOrDefault(false)) {
						return areEqual(MapperC.<RiskReductionTechniqueEnum>of(MapperS.of(RiskReductionTechniqueEnum.PWOS), MapperS.of(RiskReductionTechniqueEnum.PWAS), MapperS.of(RiskReductionTechniqueEnum.PRBM), MapperS.of(RiskReductionTechniqueEnum.OTHR)), MapperS.of(fCAUKEMIRTransactionReport).<RiskReductionTechniqueEnum>map("getTypeOfPTRRTechnique", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getTypeOfPTRRTechnique()), CardinalityOperator.Any);
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
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2039_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}

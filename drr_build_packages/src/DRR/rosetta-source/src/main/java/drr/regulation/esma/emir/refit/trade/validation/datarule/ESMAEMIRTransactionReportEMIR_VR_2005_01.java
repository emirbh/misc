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
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
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
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2005_01")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2005_01.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2005_01 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2005_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> TERM, ActionTypeEnum -> REVI] any = actionType then if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> TERM] any = actionType and eventType = COMP and [RiskReductionTechniqueEnum -> PWAS, RiskReductionTechniqueEnum -> PRBM, RiskReductionTechniqueEnum -> OTHR] any = typeOfPTRRTechnique then ptrrId exists";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2005_01 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.TERM), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(eSMAEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.TERM)), MapperS.of(eSMAEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(eSMAEMIRTransactionReport).<EventTypeEnum>map("getEventType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getEventType()), MapperS.of(EventTypeEnum.COMP), CardinalityOperator.All)).andNullSafe(areEqual(MapperC.<RiskReductionTechniqueEnum>of(MapperS.of(RiskReductionTechniqueEnum.PWAS), MapperS.of(RiskReductionTechniqueEnum.PRBM), MapperS.of(RiskReductionTechniqueEnum.OTHR)), MapperS.of(eSMAEMIRTransactionReport).<RiskReductionTechniqueEnum>map("getTypeOfPTRRTechnique", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getTypeOfPTRRTechnique()), CardinalityOperator.Any)).getOrDefault(false)) {
						return exists(MapperS.of(eSMAEMIRTransactionReport).<String>map("getPtrrId", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getPtrrId()));
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
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2005_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}

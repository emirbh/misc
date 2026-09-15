package drr.regulation.esma.emir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.qualification.event.functions.IsVRAllowedForActionType;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.Direction2Enum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_1017_01")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_1017_01.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_1017_01 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_1017_01";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then (direction1 exists and leg1 -> direction2 is absent and leg2 -> direction2 is absent) or (direction1 is absent and leg1 -> direction2 exists and leg2 -> direction2 exists)";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_1017_01 {
	
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
				final Boolean _boolean = isVRAllowedForActionType.evaluate(MapperS.of(eSMAEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getActionType()).get());
				if ((_boolean == null ? false : _boolean)) {
					return exists(MapperS.of(eSMAEMIRTransactionReport).<Direction1Enum>map("getDirection1", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getDirection1())).andNullSafe(notExists(MapperS.of(eSMAEMIRTransactionReport).<CommonLeg>map("getLeg1", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getLeg1()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()))).andNullSafe(notExists(MapperS.of(eSMAEMIRTransactionReport).<CommonLeg>map("getLeg2", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getLeg2()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()))).orNullSafe(notExists(MapperS.of(eSMAEMIRTransactionReport).<Direction1Enum>map("getDirection1", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getDirection1())).andNullSafe(exists(MapperS.of(eSMAEMIRTransactionReport).<CommonLeg>map("getLeg1", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getLeg1()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()))).andNullSafe(exists(MapperS.of(eSMAEMIRTransactionReport).<CommonLeg>map("getLeg2", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getLeg2()).<Direction2Enum>map("getDirection2", commonLeg -> commonLeg.getDirection2()))));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_1017_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}

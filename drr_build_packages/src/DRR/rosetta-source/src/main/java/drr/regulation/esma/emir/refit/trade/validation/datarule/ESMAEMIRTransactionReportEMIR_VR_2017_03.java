package drr.regulation.esma.emir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.qualification.event.functions.IsVRAllowedForActionType;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2017_03")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2017_03.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2017_03 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2017_03";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if underlyingIdentificationType <> B then customBasketCode is absent else customBasketCode exists";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2017_03 {
	
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
					if (notEqual(MapperS.of(eSMAEMIRTransactionReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.B), CardinalityOperator.Any).getOrDefault(false)) {
						return notExists(MapperS.of(eSMAEMIRTransactionReport).<String>map("getCustomBasketCode", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getCustomBasketCode()));
					}
					return exists(MapperS.of(eSMAEMIRTransactionReport).<String>map("getCustomBasketCode", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getCustomBasketCode()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2017_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}

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
import drr.regulation.common.CommonContractType;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2139_01")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2139_01.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2139_01 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2139_01";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if [CommonContractType -> OPTN, CommonContractType -> SWPT] any = contractType then optionPremiumAmount >= 0 else optionPremiumAmount is absent";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2139_01 {
	
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
				final Boolean _boolean = isVRAllowedForActionType.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()).get());
				if ((_boolean == null ? false : _boolean)) {
					if (areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWPT)), MapperS.of(fCAUKEMIRTransactionReport).<CommonContractType>map("getContractType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getContractType()), CardinalityOperator.Any).getOrDefault(false)) {
						return greaterThanEquals(MapperS.of(fCAUKEMIRTransactionReport).<BigDecimal>map("getOptionPremiumAmount", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getOptionPremiumAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All);
					}
					return notExists(MapperS.of(fCAUKEMIRTransactionReport).<BigDecimal>map("getOptionPremiumAmount", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getOptionPremiumAmount()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2139_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}

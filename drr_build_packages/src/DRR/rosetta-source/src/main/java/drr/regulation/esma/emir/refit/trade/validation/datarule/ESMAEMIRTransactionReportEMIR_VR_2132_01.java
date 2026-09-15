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
import drr.regulation.common.CommonContractType;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.OptionTypeCode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2132_01")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2132_01.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2132_01 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2132_01";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if [CommonContractType -> OPTN, CommonContractType -> SWPT] any = contractType then optionType exists and [OptionTypeCode -> PUTO, OptionTypeCode -> CALL, OptionTypeCode -> OTHR] any = optionType else optionType is absent";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2132_01 {
	
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
					if (areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWPT)), MapperS.of(eSMAEMIRTransactionReport).<CommonContractType>map("getContractType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getContractType()), CardinalityOperator.Any).getOrDefault(false)) {
						return exists(MapperS.of(eSMAEMIRTransactionReport).<OptionTypeCode>map("getOptionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getOptionType())).andNullSafe(areEqual(MapperC.<OptionTypeCode>of(MapperS.of(OptionTypeCode.PUTO), MapperS.of(OptionTypeCode.CALL), MapperS.of(OptionTypeCode.OTHR)), MapperS.of(eSMAEMIRTransactionReport).<OptionTypeCode>map("getOptionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getOptionType()), CardinalityOperator.Any));
					}
					return notExists(MapperS.of(eSMAEMIRTransactionReport).<OptionTypeCode>map("getOptionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getOptionType()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2132_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}

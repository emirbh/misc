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
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
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
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2095_01")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2095_01.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2095_01 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2095_01";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then (if assetClass = INTR and [CommonContractType -> FRAS, CommonContractType -> SWAP, CommonContractType -> SWPT] any = contractType then (leg2 -> fixedRate exists and leg2 -> periodicPayment -> nameOfTheFloatingRate is absent) or (leg2 -> fixedRate is absent and leg2 -> periodicPayment -> nameOfTheFloatingRate exists) else True)";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2095_01 {
	
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
					if (areEqual(MapperS.of(fCAUKEMIRTransactionReport).<CommonAssetClass>map("getAssetClass", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.INTR), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.FRAS), MapperS.of(CommonContractType.SWAP), MapperS.of(CommonContractType.SWPT)), MapperS.of(fCAUKEMIRTransactionReport).<CommonContractType>map("getContractType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getContractType()), CardinalityOperator.Any)).getOrDefault(false)) {
						return exists(MapperS.of(fCAUKEMIRTransactionReport).<CommonLeg>map("getLeg2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate())).andNullSafe(notExists(MapperS.of(fCAUKEMIRTransactionReport).<CommonLeg>map("getLeg2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<String>map("getNameOfTheFloatingRate", commonPeriodicPayment -> commonPeriodicPayment.getNameOfTheFloatingRate()))).orNullSafe(notExists(MapperS.of(fCAUKEMIRTransactionReport).<CommonLeg>map("getLeg2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate())).andNullSafe(exists(MapperS.of(fCAUKEMIRTransactionReport).<CommonLeg>map("getLeg2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<String>map("getNameOfTheFloatingRate", commonPeriodicPayment -> commonPeriodicPayment.getNameOfTheFloatingRate()))));
					}
					return ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2095_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}

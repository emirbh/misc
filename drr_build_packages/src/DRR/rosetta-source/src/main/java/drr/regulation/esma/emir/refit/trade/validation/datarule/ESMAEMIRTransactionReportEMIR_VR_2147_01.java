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
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
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
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2147_01")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2147_01.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2147_01 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2147_01";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if assetClass = CRDT and underlyingIdentificationType = X then indexFactor exists and indexFactor >= 0 and indexFactor <= 1 else indexFactor is absent";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2147_01 {
	
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
					if (areEqual(MapperS.of(eSMAEMIRTransactionReport).<CommonAssetClass>map("getAssetClass", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.CRDT), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(eSMAEMIRTransactionReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All)).getOrDefault(false)) {
						return exists(MapperS.of(eSMAEMIRTransactionReport).<BigDecimal>map("getIndexFactor", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getIndexFactor())).andNullSafe(greaterThanEquals(MapperS.of(eSMAEMIRTransactionReport).<BigDecimal>map("getIndexFactor", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getIndexFactor()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).andNullSafe(lessThanEquals(MapperS.of(eSMAEMIRTransactionReport).<BigDecimal>map("getIndexFactor", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getIndexFactor()), MapperS.of(BigDecimal.valueOf(1)), CardinalityOperator.All));
					}
					return notExists(MapperS.of(eSMAEMIRTransactionReport).<BigDecimal>map("getIndexFactor", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getIndexFactor()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2147_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}

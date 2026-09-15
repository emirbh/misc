package drr.regulation.asic.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_1085_01")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_1085_01.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_1085_01 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_1085_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and [CommonAssetClass -> CRDT, CommonAssetClass -> COMM, CommonAssetClass -> INTR] any = assetClass and contractType = CommonContractType -> SWPT then maturityDateOfTheUnderlying exists and maturityDateOfTheUnderlying > expirationDate";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_1085_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			ComparisonResult result = executeDataRule(aSICTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ASICTransactionReport aSICTransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.CRDT), MapperS.of(CommonAssetClass.COMM), MapperS.of(CommonAssetClass.INTR)), MapperS.of(aSICTransactionReport).<CommonAssetClass>map("getAssetClass", _aSICTransactionReport -> _aSICTransactionReport.getAssetClass()), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(aSICTransactionReport).<CommonContractType>map("getContractType", _aSICTransactionReport -> _aSICTransactionReport.getContractType()), MapperS.of(CommonContractType.SWPT), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(aSICTransactionReport).<Date>map("getMaturityDateOfTheUnderlying", _aSICTransactionReport -> _aSICTransactionReport.getMaturityDateOfTheUnderlying())).andNullSafe(greaterThan(MapperS.of(aSICTransactionReport).<Date>map("getMaturityDateOfTheUnderlying", _aSICTransactionReport -> _aSICTransactionReport.getMaturityDateOfTheUnderlying()), MapperS.of(aSICTransactionReport).<Date>map("getExpirationDate", _aSICTransactionReport -> _aSICTransactionReport.getExpirationDate()), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_1085_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}

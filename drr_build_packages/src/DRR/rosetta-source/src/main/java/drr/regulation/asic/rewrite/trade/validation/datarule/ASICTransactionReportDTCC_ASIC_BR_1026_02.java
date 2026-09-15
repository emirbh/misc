package drr.regulation.asic.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.CommonLeg;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_1026_02")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_1026_02.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_1026_02 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_1026_02";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and assetClass = CommonAssetClass -> CURR and [CommonContractType -> CFDS, CommonContractType -> FORW, CommonContractType -> SWPT, CommonContractType -> OTHR, CommonContractType -> SWAP] any = contractType then leg1 -> notionalAmount exists or leg1 -> notionalAmount = 9999999999999999999999999 and if [CommonAssetClass -> CRDT, CommonAssetClass -> EQUI, CommonAssetClass -> INTR] any = assetClass and leg1 -> notionalAmount < 0 then False else True";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_1026_02 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(aSICTransactionReport).<CommonAssetClass>map("getAssetClass", _aSICTransactionReport -> _aSICTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.CURR), CardinalityOperator.All)).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.CFDS), MapperS.of(CommonContractType.FORW), MapperS.of(CommonContractType.SWPT), MapperS.of(CommonContractType.OTHR), MapperS.of(CommonContractType.SWAP)), MapperS.of(aSICTransactionReport).<CommonContractType>map("getContractType", _aSICTransactionReport -> _aSICTransactionReport.getContractType()), CardinalityOperator.Any)).getOrDefault(false)) {
					final BigInteger bigInteger = new BigInteger("9999999999999999999999999");
					final ComparisonResult ifThenElseResult;
					if (areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.CRDT), MapperS.of(CommonAssetClass.EQUI), MapperS.of(CommonAssetClass.INTR)), MapperS.of(aSICTransactionReport).<CommonAssetClass>map("getAssetClass", _aSICTransactionReport -> _aSICTransactionReport.getAssetClass()), CardinalityOperator.Any).andNullSafe(lessThan(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg1", _aSICTransactionReport -> _aSICTransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).getOrDefault(false)) {
						ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(false));
					} else {
						ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(true));
					}
					return exists(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg1", _aSICTransactionReport -> _aSICTransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount())).orNullSafe(areEqual(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg1", _aSICTransactionReport -> _aSICTransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()), (bigInteger == null ? MapperS.<BigDecimal>ofNull() : MapperS.of(new BigDecimal(bigInteger))), CardinalityOperator.All).andNullSafe(ifThenElseResult));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_1026_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}

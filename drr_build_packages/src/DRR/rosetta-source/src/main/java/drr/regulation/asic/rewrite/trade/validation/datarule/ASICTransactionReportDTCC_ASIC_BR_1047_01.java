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
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_1047_01")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_1047_01.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_1047_01 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_1047_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and (([CommonAssetClass -> INTR, CommonAssetClass -> CRDT] any = assetClass and contractType = CommonContractType -> CFDS) or (CommonAssetClass -> CURR = assetClass and [CommonContractType -> CFDS, CommonContractType -> FRAS, CommonContractType -> FORW, CommonContractType -> OPTN, CommonContractType -> SWAP, CommonContractType -> SWPT, CommonContractType -> OTHR] any = contractType)) then if ((priceNotation = Monetary and price -> monetary = 999999999999999999) or (priceNotation = Decimal and price -> decimal = 99999999999)) then True";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_1047_01 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.INTR), MapperS.of(CommonAssetClass.CRDT)), MapperS.of(aSICTransactionReport).<CommonAssetClass>map("getAssetClass", _aSICTransactionReport -> _aSICTransactionReport.getAssetClass()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(aSICTransactionReport).<CommonContractType>map("getContractType", _aSICTransactionReport -> _aSICTransactionReport.getContractType()), MapperS.of(CommonContractType.CFDS), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(CommonAssetClass.CURR), MapperS.of(aSICTransactionReport).<CommonAssetClass>map("getAssetClass", _aSICTransactionReport -> _aSICTransactionReport.getAssetClass()), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.CFDS), MapperS.of(CommonContractType.FRAS), MapperS.of(CommonContractType.FORW), MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWAP), MapperS.of(CommonContractType.SWPT), MapperS.of(CommonContractType.OTHR)), MapperS.of(aSICTransactionReport).<CommonContractType>map("getContractType", _aSICTransactionReport -> _aSICTransactionReport.getContractType()), CardinalityOperator.Any)))).getOrDefault(false)) {
					if (areEqual(MapperS.of(aSICTransactionReport).<PriceNotationEnum>map("getPriceNotation", _aSICTransactionReport -> _aSICTransactionReport.getPriceNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(aSICTransactionReport).<PriceFormat>map("getPrice", _aSICTransactionReport -> _aSICTransactionReport.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(999999999999999999l)), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(aSICTransactionReport).<PriceNotationEnum>map("getPriceNotation", _aSICTransactionReport -> _aSICTransactionReport.getPriceNotation()), MapperS.of(PriceNotationEnum.DECIMAL), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(aSICTransactionReport).<PriceFormat>map("getPrice", _aSICTransactionReport -> _aSICTransactionReport.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()), MapperS.of(BigDecimal.valueOf(99999999999l)), CardinalityOperator.All))).getOrDefault(false)) {
						return ComparisonResult.ofNullSafe(MapperS.of(true));
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
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_1047_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}

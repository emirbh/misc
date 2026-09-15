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
import drr.base.trade.price.PricePeriod;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.price.functions.Price_Validation_02;
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
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_1047_06")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_1047_06.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_1047_06 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_1047_06";
	String DEFINITION = "if ([CommonAssetClass -> EQUI, CommonAssetClass -> COMM] any = assetClass and [CommonContractType -> FRAS, CommonContractType -> OPTN, CommonContractType -> SWPT, CommonContractType -> OTHR] any = contractType) then common.price.Price_Validation_02( actionType, leg1, leg2, strikePrice, optionPremiumAmount, price, priceSchedule )";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_1047_06 {
	
		@Inject protected Price_Validation_02 price_Validation_02;
		
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
				if (areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.EQUI), MapperS.of(CommonAssetClass.COMM)), MapperS.of(aSICTransactionReport).<CommonAssetClass>map("getAssetClass", _aSICTransactionReport -> _aSICTransactionReport.getAssetClass()), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.FRAS), MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWPT), MapperS.of(CommonContractType.OTHR)), MapperS.of(aSICTransactionReport).<CommonContractType>map("getContractType", _aSICTransactionReport -> _aSICTransactionReport.getContractType()), CardinalityOperator.Any)).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(price_Validation_02.evaluate(MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()).get(), MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg1", _aSICTransactionReport -> _aSICTransactionReport.getLeg1()).get(), MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg2", _aSICTransactionReport -> _aSICTransactionReport.getLeg2()).get(), MapperS.of(aSICTransactionReport).<PriceFormat>map("getStrikePrice", _aSICTransactionReport -> _aSICTransactionReport.getStrikePrice()).get(), MapperS.of(aSICTransactionReport).<BigDecimal>map("getOptionPremiumAmount", _aSICTransactionReport -> _aSICTransactionReport.getOptionPremiumAmount()).get(), MapperS.of(aSICTransactionReport).<PriceFormat>map("getPrice", _aSICTransactionReport -> _aSICTransactionReport.getPrice()).get(), MapperS.of(aSICTransactionReport).<PricePeriod>mapC("getPriceSchedule", _aSICTransactionReport -> _aSICTransactionReport.getPriceSchedule()).getMulti())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_1047_06 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}

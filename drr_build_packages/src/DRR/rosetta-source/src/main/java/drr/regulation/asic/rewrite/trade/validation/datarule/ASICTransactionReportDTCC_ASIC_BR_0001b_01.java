package drr.regulation.asic.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
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
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.price.BarrierPrice;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_0001b_01")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_0001b_01.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_0001b_01 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_0001b_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and [CommonContractType -> OPTN, CommonContractType -> SWPT, CommonContractType -> FORW] any = contractType then if barrier -> lower -> price -> monetary exists then barrier -> lower -> currency exists";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_0001b_01 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWPT), MapperS.of(CommonContractType.FORW)), MapperS.of(aSICTransactionReport).<CommonContractType>map("getContractType", _aSICTransactionReport -> _aSICTransactionReport.getContractType()), CardinalityOperator.Any)).getOrDefault(false)) {
					if (exists(MapperS.of(aSICTransactionReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", _aSICTransactionReport -> _aSICTransactionReport.getBarrier()).<BarrierPrice>map("getLower", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getLower()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary())).getOrDefault(false)) {
						return exists(MapperS.of(aSICTransactionReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", _aSICTransactionReport -> _aSICTransactionReport.getBarrier()).<BarrierPrice>map("getLower", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getLower()).<ISOCurrencyCodeEnum>map("getCurrency", barrierPrice -> barrierPrice.getCurrency()));
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
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_0001b_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}

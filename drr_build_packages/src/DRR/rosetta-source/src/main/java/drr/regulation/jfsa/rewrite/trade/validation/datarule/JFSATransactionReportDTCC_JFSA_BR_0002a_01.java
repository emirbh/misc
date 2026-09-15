package drr.regulation.jfsa.rewrite.trade.validation.datarule;

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
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.price.BarrierPrice;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("JFSATransactionReportDTCC_JFSA_BR_0002a_01")
@ImplementedBy(JFSATransactionReportDTCC_JFSA_BR_0002a_01.Default.class)
public interface JFSATransactionReportDTCC_JFSA_BR_0002a_01 extends Validator<JFSATransactionReport> {
	
	String NAME = "JFSATransactionReportDTCC_JFSA_BR_0002a_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and [CommonContractType -> OPTN, CommonContractType -> SWPT, CommonContractType -> SWAP, CommonContractType -> CFDS] any = contractType and assetClass <> CommonAssetClass -> CURR then (if barrier -> _single -> price -> monetary exists then barrier -> _single -> currency exists)";
	
	class Default implements JFSATransactionReportDTCC_JFSA_BR_0002a_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			ComparisonResult result = executeDataRule(jFSATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(JFSATransactionReport jFSATransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWPT), MapperS.of(CommonContractType.SWAP), MapperS.of(CommonContractType.CFDS)), MapperS.of(jFSATransactionReport).<CommonContractType>map("getContractType", _jFSATransactionReport -> _jFSATransactionReport.getContractType()), CardinalityOperator.Any)).andNullSafe(notEqual(MapperS.of(jFSATransactionReport).<CommonAssetClass>map("getAssetClass", _jFSATransactionReport -> _jFSATransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.CURR), CardinalityOperator.Any)).getOrDefault(false)) {
					if (exists(MapperS.of(jFSATransactionReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", _jFSATransactionReport -> _jFSATransactionReport.getBarrier()).<BarrierPrice>map("get_single", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.get_single()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary())).getOrDefault(false)) {
						return exists(MapperS.of(jFSATransactionReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", _jFSATransactionReport -> _jFSATransactionReport.getBarrier()).<BarrierPrice>map("get_single", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.get_single()).<ISOCurrencyCodeEnum>map("getCurrency", barrierPrice -> barrierPrice.getCurrency()));
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
	class NoOp implements JFSATransactionReportDTCC_JFSA_BR_0002a_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			return Collections.emptyList();
		}
	}
}

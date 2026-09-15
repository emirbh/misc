package drr.regulation.asic.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.quantity.functions.NotionalCurrrencyLeg1_01_Validation;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_1034_01")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_1034_01.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_1034_01 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_1034_01";
	String DEFINITION = "common.quantity.NotionalCurrrencyLeg1_01_Validation( actionType, assetClass, leg1 -> notionalAmount, leg1 -> notionalCurrency )";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_1034_01 {
	
		@Inject protected NotionalCurrrencyLeg1_01_Validation notionalCurrrencyLeg1_01_Validation;
		
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
				return ComparisonResult.ofNullSafe(MapperS.of(notionalCurrrencyLeg1_01_Validation.evaluate(MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()).get(), MapperS.of(aSICTransactionReport).<CommonAssetClass>map("getAssetClass", _aSICTransactionReport -> _aSICTransactionReport.getAssetClass()).get(), MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg1", _aSICTransactionReport -> _aSICTransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()).get(), MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg1", _aSICTransactionReport -> _aSICTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_1034_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}

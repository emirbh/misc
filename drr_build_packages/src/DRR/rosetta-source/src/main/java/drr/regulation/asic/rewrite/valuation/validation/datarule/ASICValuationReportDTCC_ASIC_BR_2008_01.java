package drr.regulation.asic.rewrite.valuation.validation.datarule;

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
import drr.regulation.asic.rewrite.valuation.ASICValuationReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICValuationReportDTCC_ASIC_BR_2008_01")
@ImplementedBy(ASICValuationReportDTCC_ASIC_BR_2008_01.Default.class)
public interface ASICValuationReportDTCC_ASIC_BR_2008_01 extends Validator<ASICValuationReport> {
	
	String NAME = "ASICValuationReportDTCC_ASIC_BR_2008_01";
	String DEFINITION = "if actionType = VALU then [ISOCurrencyCodeEnum -> XAG, ISOCurrencyCodeEnum -> XAU, ISOCurrencyCodeEnum -> XBA, ISOCurrencyCodeEnum -> XBB, ISOCurrencyCodeEnum -> XBC, ISOCurrencyCodeEnum -> XBD, ISOCurrencyCodeEnum -> XDR, ISOCurrencyCodeEnum -> XPD, ISOCurrencyCodeEnum -> XPT, ISOCurrencyCodeEnum -> XTS, ISOCurrencyCodeEnum -> XXX] all <> valuationCurrency";
	
	class Default implements ASICValuationReportDTCC_ASIC_BR_2008_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICValuationReport aSICValuationReport) {
			ComparisonResult result = executeDataRule(aSICValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ASICValuationReport aSICValuationReport) {
			try {
				if (areEqual(MapperS.of(aSICValuationReport).<ActionTypeEnum>map("getActionType", _aSICValuationReport -> _aSICValuationReport.getActionType()), MapperS.of(ActionTypeEnum.VALU), CardinalityOperator.All).getOrDefault(false)) {
					return notEqual(MapperC.<ISOCurrencyCodeEnum>of(MapperS.of(ISOCurrencyCodeEnum.XAG), MapperS.of(ISOCurrencyCodeEnum.XAU), MapperS.of(ISOCurrencyCodeEnum.XBA), MapperS.of(ISOCurrencyCodeEnum.XBB), MapperS.of(ISOCurrencyCodeEnum.XBC), MapperS.of(ISOCurrencyCodeEnum.XBD), MapperS.of(ISOCurrencyCodeEnum.XDR), MapperS.of(ISOCurrencyCodeEnum.XPD), MapperS.of(ISOCurrencyCodeEnum.XPT), MapperS.of(ISOCurrencyCodeEnum.XTS), MapperS.of(ISOCurrencyCodeEnum.XXX)), MapperS.of(aSICValuationReport).<ISOCurrencyCodeEnum>map("getValuationCurrency", _aSICValuationReport -> _aSICValuationReport.getValuationCurrency()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICValuationReportDTCC_ASIC_BR_2008_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICValuationReport aSICValuationReport) {
			return Collections.emptyList();
		}
	}
}

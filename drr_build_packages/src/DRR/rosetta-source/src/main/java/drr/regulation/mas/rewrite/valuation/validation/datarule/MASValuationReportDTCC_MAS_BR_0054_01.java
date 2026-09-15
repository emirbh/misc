package drr.regulation.mas.rewrite.valuation.validation.datarule;

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
import drr.regulation.mas.rewrite.valuation.MASValuationReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MASValuationReportDTCC_MAS_BR_0054_01")
@ImplementedBy(MASValuationReportDTCC_MAS_BR_0054_01.Default.class)
public interface MASValuationReportDTCC_MAS_BR_0054_01 extends Validator<MASValuationReport> {
	
	String NAME = "MASValuationReportDTCC_MAS_BR_0054_01";
	String DEFINITION = "if actionType = VALU and [ISOCurrencyCodeEnum -> XAG, ISOCurrencyCodeEnum -> XAU, ISOCurrencyCodeEnum -> XBA, ISOCurrencyCodeEnum -> XBB, ISOCurrencyCodeEnum -> XBC, ISOCurrencyCodeEnum -> XBD, ISOCurrencyCodeEnum -> XDR, ISOCurrencyCodeEnum -> XPD, ISOCurrencyCodeEnum -> XPT, ISOCurrencyCodeEnum -> XTS, ISOCurrencyCodeEnum -> XXX] any = valuationCurrency then False";
	
	class Default implements MASValuationReportDTCC_MAS_BR_0054_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASValuationReport mASValuationReport) {
			ComparisonResult result = executeDataRule(mASValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MASValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MASValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MASValuationReport mASValuationReport) {
			try {
				if (areEqual(MapperS.of(mASValuationReport).<ActionTypeEnum>map("getActionType", _mASValuationReport -> _mASValuationReport.getActionType()), MapperS.of(ActionTypeEnum.VALU), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<ISOCurrencyCodeEnum>of(MapperS.of(ISOCurrencyCodeEnum.XAG), MapperS.of(ISOCurrencyCodeEnum.XAU), MapperS.of(ISOCurrencyCodeEnum.XBA), MapperS.of(ISOCurrencyCodeEnum.XBB), MapperS.of(ISOCurrencyCodeEnum.XBC), MapperS.of(ISOCurrencyCodeEnum.XBD), MapperS.of(ISOCurrencyCodeEnum.XDR), MapperS.of(ISOCurrencyCodeEnum.XPD), MapperS.of(ISOCurrencyCodeEnum.XPT), MapperS.of(ISOCurrencyCodeEnum.XTS), MapperS.of(ISOCurrencyCodeEnum.XXX)), MapperS.of(mASValuationReport).<ISOCurrencyCodeEnum>map("getValuationCurrency", _mASValuationReport -> _mASValuationReport.getValuationCurrency()), CardinalityOperator.Any)).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(false));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASValuationReportDTCC_MAS_BR_0054_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASValuationReport mASValuationReport) {
			return Collections.emptyList();
		}
	}
}

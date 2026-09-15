package drr.regulation.fca.ukemir.refit.margin.validation.datarule;

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
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRMarginReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRMarginReportUKEMIR_VR_3025_02")
@ImplementedBy(FCAUKEMIRMarginReportUKEMIR_VR_3025_02.Default.class)
public interface FCAUKEMIRMarginReportUKEMIR_VR_3025_02 extends Validator<FCAUKEMIRMarginReport> {
	
	String NAME = "FCAUKEMIRMarginReportUKEMIR_VR_3025_02";
	String DEFINITION = "if variationMarginCollectedByCounterparty1Currency exists then [ISOCurrencyCodeEnum -> XAG, ISOCurrencyCodeEnum -> XAU, ISOCurrencyCodeEnum -> XBA, ISOCurrencyCodeEnum -> XBB, ISOCurrencyCodeEnum -> XBC, ISOCurrencyCodeEnum -> XBD, ISOCurrencyCodeEnum -> XDR, ISOCurrencyCodeEnum -> XPD, ISOCurrencyCodeEnum -> XPT, ISOCurrencyCodeEnum -> XXX] all <> variationMarginCollectedByCounterparty1Currency";
	
	class Default implements FCAUKEMIRMarginReportUKEMIR_VR_3025_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			ComparisonResult result = executeDataRule(fCAUKEMIRMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			try {
				if (exists(MapperS.of(fCAUKEMIRMarginReport).<ISOCurrencyCodeEnum>map("getVariationMarginCollectedByCounterparty1Currency", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getVariationMarginCollectedByCounterparty1Currency())).getOrDefault(false)) {
					return notEqual(MapperC.<ISOCurrencyCodeEnum>of(MapperS.of(ISOCurrencyCodeEnum.XAG), MapperS.of(ISOCurrencyCodeEnum.XAU), MapperS.of(ISOCurrencyCodeEnum.XBA), MapperS.of(ISOCurrencyCodeEnum.XBB), MapperS.of(ISOCurrencyCodeEnum.XBC), MapperS.of(ISOCurrencyCodeEnum.XBD), MapperS.of(ISOCurrencyCodeEnum.XDR), MapperS.of(ISOCurrencyCodeEnum.XPD), MapperS.of(ISOCurrencyCodeEnum.XPT), MapperS.of(ISOCurrencyCodeEnum.XXX)), MapperS.of(fCAUKEMIRMarginReport).<ISOCurrencyCodeEnum>map("getVariationMarginCollectedByCounterparty1Currency", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getVariationMarginCollectedByCounterparty1Currency()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRMarginReportUKEMIR_VR_3025_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}

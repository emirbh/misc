package drr.regulation.cftc.rewrite.margin.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.margin.CFTCMarginReport;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCMarginReportCFTC_VR_0128_01")
@ImplementedBy(CFTCMarginReportCFTC_VR_0128_01.Default.class)
public interface CFTCMarginReportCFTC_VR_0128_01 extends Validator<CFTCMarginReport> {
	
	String NAME = "CFTCMarginReportCFTC_VR_0128_01";
	String DEFINITION = "if variationMarginCollectedByTheCounterparty1PreHaircut exists then variationMarginCollectedByCounterparty1Currency exists else variationMarginCollectedByCounterparty1Currency is absent";
	
	class Default implements CFTCMarginReportCFTC_VR_0128_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCMarginReport cFTCMarginReport) {
			ComparisonResult result = executeDataRule(cFTCMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCMarginReport cFTCMarginReport) {
			try {
				if (exists(MapperS.of(cFTCMarginReport).<BigDecimal>map("getVariationMarginCollectedByTheCounterparty1PreHaircut", _cFTCMarginReport -> _cFTCMarginReport.getVariationMarginCollectedByTheCounterparty1PreHaircut())).getOrDefault(false)) {
					return exists(MapperS.of(cFTCMarginReport).<ISOCurrencyCodeEnum>map("getVariationMarginCollectedByCounterparty1Currency", _cFTCMarginReport -> _cFTCMarginReport.getVariationMarginCollectedByCounterparty1Currency()));
				}
				return notExists(MapperS.of(cFTCMarginReport).<ISOCurrencyCodeEnum>map("getVariationMarginCollectedByCounterparty1Currency", _cFTCMarginReport -> _cFTCMarginReport.getVariationMarginCollectedByCounterparty1Currency()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCMarginReportCFTC_VR_0128_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCMarginReport cFTCMarginReport) {
			return Collections.emptyList();
		}
	}
}

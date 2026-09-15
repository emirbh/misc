package drr.regulation.esma.emir.refit.margin.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.esma.emir.refit.margin.ESMAEMIRMarginReport;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRMarginReportEMIR_VR_3017_01")
@ImplementedBy(ESMAEMIRMarginReportEMIR_VR_3017_01.Default.class)
public interface ESMAEMIRMarginReportEMIR_VR_3017_01 extends Validator<ESMAEMIRMarginReport> {
	
	String NAME = "ESMAEMIRMarginReportEMIR_VR_3017_01";
	String DEFINITION = "if variationMarginPostedByTheCounterparty1PreHaircut exists and variationMarginPostedByTheCounterparty1PostHaircut exists then variationMarginPostedByCounterparty1Currency exists else variationMarginPostedByCounterparty1Currency is absent";
	
	class Default implements ESMAEMIRMarginReportEMIR_VR_3017_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			ComparisonResult result = executeDataRule(eSMAEMIRMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			try {
				if (exists(MapperS.of(eSMAEMIRMarginReport).<BigDecimal>map("getVariationMarginPostedByTheCounterparty1PreHaircut", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginPostedByTheCounterparty1PreHaircut())).andNullSafe(exists(MapperS.of(eSMAEMIRMarginReport).<BigDecimal>map("getVariationMarginPostedByTheCounterparty1PostHaircut", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginPostedByTheCounterparty1PostHaircut()))).getOrDefault(false)) {
					return exists(MapperS.of(eSMAEMIRMarginReport).<ISOCurrencyCodeEnum>map("getVariationMarginPostedByCounterparty1Currency", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginPostedByCounterparty1Currency()));
				}
				return notExists(MapperS.of(eSMAEMIRMarginReport).<ISOCurrencyCodeEnum>map("getVariationMarginPostedByCounterparty1Currency", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginPostedByCounterparty1Currency()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRMarginReportEMIR_VR_3017_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}

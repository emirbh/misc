package drr.regulation.fca.ukemir.refit.margin.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRMarginReport;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRMarginReportUKEMIR_VR_3025_01")
@ImplementedBy(FCAUKEMIRMarginReportUKEMIR_VR_3025_01.Default.class)
public interface FCAUKEMIRMarginReportUKEMIR_VR_3025_01 extends Validator<FCAUKEMIRMarginReport> {
	
	String NAME = "FCAUKEMIRMarginReportUKEMIR_VR_3025_01";
	String DEFINITION = "if variationMarginCollectedByTheCounterparty1PreHaircut exists and variationMarginCollectedByTheCounterparty1PostHaircut exists then variationMarginCollectedByCounterparty1Currency exists";
	
	class Default implements FCAUKEMIRMarginReportUKEMIR_VR_3025_01 {
	
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
				if (exists(MapperS.of(fCAUKEMIRMarginReport).<BigDecimal>map("getVariationMarginCollectedByTheCounterparty1PreHaircut", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getVariationMarginCollectedByTheCounterparty1PreHaircut())).andNullSafe(exists(MapperS.of(fCAUKEMIRMarginReport).<BigDecimal>map("getVariationMarginCollectedByTheCounterparty1PostHaircut", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getVariationMarginCollectedByTheCounterparty1PostHaircut()))).getOrDefault(false)) {
					return exists(MapperS.of(fCAUKEMIRMarginReport).<ISOCurrencyCodeEnum>map("getVariationMarginCollectedByCounterparty1Currency", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getVariationMarginCollectedByCounterparty1Currency()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRMarginReportUKEMIR_VR_3025_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}

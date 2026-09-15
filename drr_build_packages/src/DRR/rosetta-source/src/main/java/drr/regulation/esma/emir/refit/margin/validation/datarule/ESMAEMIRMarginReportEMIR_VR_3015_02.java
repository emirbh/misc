package drr.regulation.esma.emir.refit.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.esma.emir.refit.margin.ESMAEMIRMarginReport;
import drr.standards.iso.CollateralisationType3Code;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ESMAEMIRMarginReportEMIR_VR_3015_02")
@ImplementedBy(ESMAEMIRMarginReportEMIR_VR_3015_02.Default.class)
public interface ESMAEMIRMarginReportEMIR_VR_3015_02 extends Validator<ESMAEMIRMarginReport> {
	
	String NAME = "ESMAEMIRMarginReportEMIR_VR_3015_02";
	String DEFINITION = "if [CollateralisationType3Code -> PRC1, CollateralisationType3Code -> OWC1] contains collateralisationCategory then variationMarginPostedByTheCounterparty1PreHaircut exists and variationMarginPostedByTheCounterparty1PreHaircut >= 0";
	
	class Default implements ESMAEMIRMarginReportEMIR_VR_3015_02 {
	
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
				if (contains(MapperC.<CollateralisationType3Code>of(MapperS.of(CollateralisationType3Code.PRC1), MapperS.of(CollateralisationType3Code.OWC1)), MapperS.of(eSMAEMIRMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getCollateralisationCategory())).getOrDefault(false)) {
					return exists(MapperS.of(eSMAEMIRMarginReport).<BigDecimal>map("getVariationMarginPostedByTheCounterparty1PreHaircut", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginPostedByTheCounterparty1PreHaircut())).andNullSafe(greaterThanEquals(MapperS.of(eSMAEMIRMarginReport).<BigDecimal>map("getVariationMarginPostedByTheCounterparty1PreHaircut", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginPostedByTheCounterparty1PreHaircut()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRMarginReportEMIR_VR_3015_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}

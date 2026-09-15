package drr.regulation.esma.emir.refit.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("ESMAEMIRMarginReportEMIR_VR_3016_02")
@ImplementedBy(ESMAEMIRMarginReportEMIR_VR_3016_02.Default.class)
public interface ESMAEMIRMarginReportEMIR_VR_3016_02 extends Validator<ESMAEMIRMarginReport> {
	
	String NAME = "ESMAEMIRMarginReportEMIR_VR_3016_02";
	String DEFINITION = "if [CollateralisationType3Code -> UNCL, CollateralisationType3Code -> PRC2, CollateralisationType3Code -> OWC2] contains collateralisationCategory then variationMarginPostedByTheCounterparty1PostHaircut is absent else variationMarginPostedByTheCounterparty1PostHaircut exists";
	
	class Default implements ESMAEMIRMarginReportEMIR_VR_3016_02 {
	
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
				if (contains(MapperC.<CollateralisationType3Code>of(MapperS.of(CollateralisationType3Code.UNCL), MapperS.of(CollateralisationType3Code.PRC2), MapperS.of(CollateralisationType3Code.OWC2)), MapperS.of(eSMAEMIRMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getCollateralisationCategory())).getOrDefault(false)) {
					return notExists(MapperS.of(eSMAEMIRMarginReport).<BigDecimal>map("getVariationMarginPostedByTheCounterparty1PostHaircut", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginPostedByTheCounterparty1PostHaircut()));
				}
				return exists(MapperS.of(eSMAEMIRMarginReport).<BigDecimal>map("getVariationMarginPostedByTheCounterparty1PostHaircut", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginPostedByTheCounterparty1PostHaircut()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRMarginReportEMIR_VR_3016_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}

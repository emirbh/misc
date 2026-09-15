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
@RosettaDataRule("ESMAEMIRMarginReportEMIR_VR_3023_03")
@ImplementedBy(ESMAEMIRMarginReportEMIR_VR_3023_03.Default.class)
public interface ESMAEMIRMarginReportEMIR_VR_3023_03 extends Validator<ESMAEMIRMarginReport> {
	
	String NAME = "ESMAEMIRMarginReportEMIR_VR_3023_03";
	String DEFINITION = "if [CollateralisationType3Code -> UNCL, CollateralisationType3Code -> PRC1, CollateralisationType3Code -> OWC1] any = collateralisationCategory then variationMarginCollectedByTheCounterparty1PreHaircut is absent";
	
	class Default implements ESMAEMIRMarginReportEMIR_VR_3023_03 {
	
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
				if (areEqual(MapperC.<CollateralisationType3Code>of(MapperS.of(CollateralisationType3Code.UNCL), MapperS.of(CollateralisationType3Code.PRC1), MapperS.of(CollateralisationType3Code.OWC1)), MapperS.of(eSMAEMIRMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getCollateralisationCategory()), CardinalityOperator.Any).getOrDefault(false)) {
					return notExists(MapperS.of(eSMAEMIRMarginReport).<BigDecimal>map("getVariationMarginCollectedByTheCounterparty1PreHaircut", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginCollectedByTheCounterparty1PreHaircut()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRMarginReportEMIR_VR_3023_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}

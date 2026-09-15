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
@RosettaDataRule("ESMAEMIRMarginReportEMIR_VR_3015_01")
@ImplementedBy(ESMAEMIRMarginReportEMIR_VR_3015_01.Default.class)
public interface ESMAEMIRMarginReportEMIR_VR_3015_01 extends Validator<ESMAEMIRMarginReport> {
	
	String NAME = "ESMAEMIRMarginReportEMIR_VR_3015_01";
	String DEFINITION = "if [CollateralisationType3Code -> PRCL, CollateralisationType3Code -> OWP1, CollateralisationType3Code -> OWP2, CollateralisationType3Code -> FLCL] any = collateralisationCategory then (if (variationMarginCollectedByTheCounterparty1PreHaircut exists and variationMarginCollectedByTheCounterparty1PreHaircut = 0 and variationMarginPostedByTheCounterparty1PreHaircut exists and variationMarginPostedByTheCounterparty1PreHaircut >= 0) then True else if (variationMarginCollectedByTheCounterparty1PreHaircut exists and variationMarginCollectedByTheCounterparty1PreHaircut >= 0 and variationMarginPostedByTheCounterparty1PreHaircut exists and variationMarginPostedByTheCounterparty1PreHaircut = 0) then True else False)";
	
	class Default implements ESMAEMIRMarginReportEMIR_VR_3015_01 {
	
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
				if (areEqual(MapperC.<CollateralisationType3Code>of(MapperS.of(CollateralisationType3Code.PRCL), MapperS.of(CollateralisationType3Code.OWP1), MapperS.of(CollateralisationType3Code.OWP2), MapperS.of(CollateralisationType3Code.FLCL)), MapperS.of(eSMAEMIRMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getCollateralisationCategory()), CardinalityOperator.Any).getOrDefault(false)) {
					if (exists(MapperS.of(eSMAEMIRMarginReport).<BigDecimal>map("getVariationMarginCollectedByTheCounterparty1PreHaircut", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginCollectedByTheCounterparty1PreHaircut())).andNullSafe(areEqual(MapperS.of(eSMAEMIRMarginReport).<BigDecimal>map("getVariationMarginCollectedByTheCounterparty1PreHaircut", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginCollectedByTheCounterparty1PreHaircut()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).andNullSafe(exists(MapperS.of(eSMAEMIRMarginReport).<BigDecimal>map("getVariationMarginPostedByTheCounterparty1PreHaircut", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginPostedByTheCounterparty1PreHaircut()))).andNullSafe(greaterThanEquals(MapperS.of(eSMAEMIRMarginReport).<BigDecimal>map("getVariationMarginPostedByTheCounterparty1PreHaircut", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginPostedByTheCounterparty1PreHaircut()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).getOrDefault(false)) {
						return ComparisonResult.ofNullSafe(MapperS.of(true));
					}
					if (exists(MapperS.of(eSMAEMIRMarginReport).<BigDecimal>map("getVariationMarginCollectedByTheCounterparty1PreHaircut", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginCollectedByTheCounterparty1PreHaircut())).andNullSafe(greaterThanEquals(MapperS.of(eSMAEMIRMarginReport).<BigDecimal>map("getVariationMarginCollectedByTheCounterparty1PreHaircut", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginCollectedByTheCounterparty1PreHaircut()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).andNullSafe(exists(MapperS.of(eSMAEMIRMarginReport).<BigDecimal>map("getVariationMarginPostedByTheCounterparty1PreHaircut", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginPostedByTheCounterparty1PreHaircut()))).andNullSafe(areEqual(MapperS.of(eSMAEMIRMarginReport).<BigDecimal>map("getVariationMarginPostedByTheCounterparty1PreHaircut", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getVariationMarginPostedByTheCounterparty1PreHaircut()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).getOrDefault(false)) {
						return ComparisonResult.ofNullSafe(MapperS.of(true));
					}
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
	class NoOp implements ESMAEMIRMarginReportEMIR_VR_3015_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}

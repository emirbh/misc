package drr.regulation.fca.ukemir.refit.margin.validation.datarule;

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
import drr.standards.iso.CollateralisationType3Code;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRMarginReportUKEMIR_VR_3023_01")
@ImplementedBy(FCAUKEMIRMarginReportUKEMIR_VR_3023_01.Default.class)
public interface FCAUKEMIRMarginReportUKEMIR_VR_3023_01 extends Validator<FCAUKEMIRMarginReport> {
	
	String NAME = "FCAUKEMIRMarginReportUKEMIR_VR_3023_01";
	String DEFINITION = "if [CollateralisationType3Code -> PRCL, CollateralisationType3Code -> OWP1, CollateralisationType3Code -> OWP2, CollateralisationType3Code -> FLCL] any = collateralisationCategory then (variationMarginPostedByTheCounterparty1PreHaircut >= 0 and variationMarginCollectedByTheCounterparty1PreHaircut = 0) or (variationMarginPostedByTheCounterparty1PreHaircut = 0 and variationMarginCollectedByTheCounterparty1PreHaircut >= 0)";
	
	class Default implements FCAUKEMIRMarginReportUKEMIR_VR_3023_01 {
	
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
				if (areEqual(MapperC.<CollateralisationType3Code>of(MapperS.of(CollateralisationType3Code.PRCL), MapperS.of(CollateralisationType3Code.OWP1), MapperS.of(CollateralisationType3Code.OWP2), MapperS.of(CollateralisationType3Code.FLCL)), MapperS.of(fCAUKEMIRMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getCollateralisationCategory()), CardinalityOperator.Any).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(fCAUKEMIRMarginReport).<BigDecimal>map("getVariationMarginPostedByTheCounterparty1PreHaircut", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getVariationMarginPostedByTheCounterparty1PreHaircut()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(fCAUKEMIRMarginReport).<BigDecimal>map("getVariationMarginCollectedByTheCounterparty1PreHaircut", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getVariationMarginCollectedByTheCounterparty1PreHaircut()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(fCAUKEMIRMarginReport).<BigDecimal>map("getVariationMarginPostedByTheCounterparty1PreHaircut", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getVariationMarginPostedByTheCounterparty1PreHaircut()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).andNullSafe(greaterThanEquals(MapperS.of(fCAUKEMIRMarginReport).<BigDecimal>map("getVariationMarginCollectedByTheCounterparty1PreHaircut", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getVariationMarginCollectedByTheCounterparty1PreHaircut()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRMarginReportUKEMIR_VR_3023_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}

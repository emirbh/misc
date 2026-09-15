package drr.regulation.csa.rewrite.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.margin.CSAMarginReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSAMarginReportDTCC_CSA_VR_0093_02")
@ImplementedBy(CSAMarginReportDTCC_CSA_VR_0093_02.Default.class)
public interface CSAMarginReportDTCC_CSA_VR_0093_02 extends Validator<CSAMarginReport> {
	
	String NAME = "CSAMarginReportDTCC_CSA_VR_0093_02";
	String DEFINITION = "if usiID exists or uti exists then variationMarginCollateralPortfolioCode = \"TRANSACTIONLEVEL\" or variationMarginCollateralPortfolioCode = \"NOTAPPLICABLE\"";
	
	class Default implements CSAMarginReportDTCC_CSA_VR_0093_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAMarginReport cSAMarginReport) {
			ComparisonResult result = executeDataRule(cSAMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSAMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSAMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSAMarginReport cSAMarginReport) {
			try {
				if (exists(MapperS.of(cSAMarginReport).<String>map("getUsiID", _cSAMarginReport -> _cSAMarginReport.getUsiID())).orNullSafe(exists(MapperS.of(cSAMarginReport).<String>map("getUti", _cSAMarginReport -> _cSAMarginReport.getUti()))).getOrDefault(false)) {
					return areEqual(MapperS.of(cSAMarginReport).<String>map("getVariationMarginCollateralPortfolioCode", _cSAMarginReport -> _cSAMarginReport.getVariationMarginCollateralPortfolioCode()), MapperS.of("TRANSACTIONLEVEL"), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cSAMarginReport).<String>map("getVariationMarginCollateralPortfolioCode", _cSAMarginReport -> _cSAMarginReport.getVariationMarginCollateralPortfolioCode()), MapperS.of("NOTAPPLICABLE"), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSAMarginReportDTCC_CSA_VR_0093_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAMarginReport cSAMarginReport) {
			return Collections.emptyList();
		}
	}
}

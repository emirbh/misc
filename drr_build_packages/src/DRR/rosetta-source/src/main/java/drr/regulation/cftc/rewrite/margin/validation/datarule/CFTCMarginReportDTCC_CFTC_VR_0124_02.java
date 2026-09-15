package drr.regulation.cftc.rewrite.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.margin.CFTCMarginReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCMarginReportDTCC_CFTC_VR_0124_02")
@ImplementedBy(CFTCMarginReportDTCC_CFTC_VR_0124_02.Default.class)
public interface CFTCMarginReportDTCC_CFTC_VR_0124_02 extends Validator<CFTCMarginReport> {
	
	String NAME = "CFTCMarginReportDTCC_CFTC_VR_0124_02";
	String DEFINITION = "if uniqueSwapIdentifier exists or uti exists then variationMarginCollateralPortfolioCode = \"TRANSACTIONLEVEL\" or variationMarginCollateralPortfolioCode = \"NOTAPPLICABLE\"";
	
	class Default implements CFTCMarginReportDTCC_CFTC_VR_0124_02 {
	
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
				if (exists(MapperS.of(cFTCMarginReport).<String>map("getUniqueSwapIdentifier", _cFTCMarginReport -> _cFTCMarginReport.getUniqueSwapIdentifier())).orNullSafe(exists(MapperS.of(cFTCMarginReport).<String>map("getUti", _cFTCMarginReport -> _cFTCMarginReport.getUti()))).getOrDefault(false)) {
					return areEqual(MapperS.of(cFTCMarginReport).<String>map("getVariationMarginCollateralPortfolioCode", _cFTCMarginReport -> _cFTCMarginReport.getVariationMarginCollateralPortfolioCode()), MapperS.of("TRANSACTIONLEVEL"), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCMarginReport).<String>map("getVariationMarginCollateralPortfolioCode", _cFTCMarginReport -> _cFTCMarginReport.getVariationMarginCollateralPortfolioCode()), MapperS.of("NOTAPPLICABLE"), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCMarginReportDTCC_CFTC_VR_0124_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCMarginReport cFTCMarginReport) {
			return Collections.emptyList();
		}
	}
}

package drr.regulation.jfsa.rewrite.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.jfsa.rewrite.margin.JFSAMarginReport;
import drr.standards.iso.MarginActionEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("JFSAMarginReportDTCC_JFSA_BR_0063_03")
@ImplementedBy(JFSAMarginReportDTCC_JFSA_BR_0063_03.Default.class)
public interface JFSAMarginReportDTCC_JFSA_BR_0063_03 extends Validator<JFSAMarginReport> {
	
	String NAME = "JFSAMarginReportDTCC_JFSA_BR_0063_03";
	String DEFINITION = "if actionType = MarginActionEnum -> MARU then (if uti is absent and initialMarginCollateralPortfolioCode = \"NOAP\" then variationMarginCollateralPortfolioCode exists else if collateralPortfolioIndicator = False then variationMarginCollateralPortfolioCode is absent else if uti exists and variationMarginCollateralPortfolioCode = \"NOAP\" then False)";
	
	class Default implements JFSAMarginReportDTCC_JFSA_BR_0063_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSAMarginReport jFSAMarginReport) {
			ComparisonResult result = executeDataRule(jFSAMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSAMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSAMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(JFSAMarginReport jFSAMarginReport) {
			try {
				if (areEqual(MapperS.of(jFSAMarginReport).<MarginActionEnum>map("getActionType", _jFSAMarginReport -> _jFSAMarginReport.getActionType()), MapperS.of(MarginActionEnum.MARU), CardinalityOperator.All).getOrDefault(false)) {
					if (notExists(MapperS.of(jFSAMarginReport).<String>map("getUti", _jFSAMarginReport -> _jFSAMarginReport.getUti())).andNullSafe(areEqual(MapperS.of(jFSAMarginReport).<String>map("getInitialMarginCollateralPortfolioCode", _jFSAMarginReport -> _jFSAMarginReport.getInitialMarginCollateralPortfolioCode()), MapperS.of("NOAP"), CardinalityOperator.All)).getOrDefault(false)) {
						return exists(MapperS.of(jFSAMarginReport).<String>map("getVariationMarginCollateralPortfolioCode", _jFSAMarginReport -> _jFSAMarginReport.getVariationMarginCollateralPortfolioCode()));
					}
					if (areEqual(MapperS.of(jFSAMarginReport).<Boolean>map("getCollateralPortfolioIndicator", _jFSAMarginReport -> _jFSAMarginReport.getCollateralPortfolioIndicator()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
						return notExists(MapperS.of(jFSAMarginReport).<String>map("getVariationMarginCollateralPortfolioCode", _jFSAMarginReport -> _jFSAMarginReport.getVariationMarginCollateralPortfolioCode()));
					}
					if (exists(MapperS.of(jFSAMarginReport).<String>map("getUti", _jFSAMarginReport -> _jFSAMarginReport.getUti())).andNullSafe(areEqual(MapperS.of(jFSAMarginReport).<String>map("getVariationMarginCollateralPortfolioCode", _jFSAMarginReport -> _jFSAMarginReport.getVariationMarginCollateralPortfolioCode()), MapperS.of("NOAP"), CardinalityOperator.All)).getOrDefault(false)) {
						return ComparisonResult.ofNullSafe(MapperS.of(false));
					}
					return ComparisonResult.ofEmpty();
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements JFSAMarginReportDTCC_JFSA_BR_0063_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSAMarginReport jFSAMarginReport) {
			return Collections.emptyList();
		}
	}
}

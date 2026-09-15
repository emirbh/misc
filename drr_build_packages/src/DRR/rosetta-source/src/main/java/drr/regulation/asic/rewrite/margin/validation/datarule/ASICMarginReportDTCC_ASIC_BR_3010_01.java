package drr.regulation.asic.rewrite.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.asic.rewrite.margin.ASICMarginReport;
import drr.standards.iso.MarginActionEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICMarginReportDTCC_ASIC_BR_3010_01")
@ImplementedBy(ASICMarginReportDTCC_ASIC_BR_3010_01.Default.class)
public interface ASICMarginReportDTCC_ASIC_BR_3010_01 extends Validator<ASICMarginReport> {
	
	String NAME = "ASICMarginReportDTCC_ASIC_BR_3010_01";
	String DEFINITION = "if actionType <> MarginActionEnum -> MARU then if initialMarginCollateralPortfolioCode = \"NOAP\" then False else True";
	
	class Default implements ASICMarginReportDTCC_ASIC_BR_3010_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICMarginReport aSICMarginReport) {
			ComparisonResult result = executeDataRule(aSICMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ASICMarginReport aSICMarginReport) {
			try {
				if (notEqual(MapperS.of(aSICMarginReport).<MarginActionEnum>map("getActionType", _aSICMarginReport -> _aSICMarginReport.getActionType()), MapperS.of(MarginActionEnum.MARU), CardinalityOperator.Any).getOrDefault(false)) {
					if (areEqual(MapperS.of(aSICMarginReport).<String>map("getInitialMarginCollateralPortfolioCode", _aSICMarginReport -> _aSICMarginReport.getInitialMarginCollateralPortfolioCode()), MapperS.of("NOAP"), CardinalityOperator.All).getOrDefault(false)) {
						return ComparisonResult.ofNullSafe(MapperS.of(false));
					}
					return ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICMarginReportDTCC_ASIC_BR_3010_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICMarginReport aSICMarginReport) {
			return Collections.emptyList();
		}
	}
}

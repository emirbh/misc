package drr.regulation.mas.rewrite.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.mas.rewrite.margin.MASMarginReport;
import drr.standards.iso.MarginActionEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MASMarginReportDTCC_MAS_BR_0010_02")
@ImplementedBy(MASMarginReportDTCC_MAS_BR_0010_02.Default.class)
public interface MASMarginReportDTCC_MAS_BR_0010_02 extends Validator<MASMarginReport> {
	
	String NAME = "MASMarginReportDTCC_MAS_BR_0010_02";
	String DEFINITION = "if [MarginActionEnum -> MARU, MarginActionEnum -> CORR] any = actionType then (if ((initialMarginCollateralPortfolioCode = \"NOAP\" or initialMarginCollateralPortfolioCode is absent) and variationMarginCollateralPortfolioCode = \"NOAP\" or collateralPortfolioIndicator = False) then required choice uti, uniqueTransactionIdentifierProprietary else if collateralPortfolioIndicator = True then uti is absent and uniqueTransactionIdentifierProprietary is absent)";
	
	class Default implements MASMarginReportDTCC_MAS_BR_0010_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASMarginReport mASMarginReport) {
			ComparisonResult result = executeDataRule(mASMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MASMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MASMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MASMarginReport mASMarginReport) {
			try {
				if (areEqual(MapperC.<MarginActionEnum>of(MapperS.of(MarginActionEnum.MARU), MapperS.of(MarginActionEnum.CORR)), MapperS.of(mASMarginReport).<MarginActionEnum>map("getActionType", _mASMarginReport -> _mASMarginReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (areEqual(MapperS.of(mASMarginReport).<String>map("getInitialMarginCollateralPortfolioCode", _mASMarginReport -> _mASMarginReport.getInitialMarginCollateralPortfolioCode()), MapperS.of("NOAP"), CardinalityOperator.All).orNullSafe(notExists(MapperS.of(mASMarginReport).<String>map("getInitialMarginCollateralPortfolioCode", _mASMarginReport -> _mASMarginReport.getInitialMarginCollateralPortfolioCode()))).andNullSafe(areEqual(MapperS.of(mASMarginReport).<String>map("getVariationMarginCollateralPortfolioCode", _mASMarginReport -> _mASMarginReport.getVariationMarginCollateralPortfolioCode()), MapperS.of("NOAP"), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(mASMarginReport).<Boolean>map("getCollateralPortfolioIndicator", _mASMarginReport -> _mASMarginReport.getCollateralPortfolioIndicator()), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
						return choice(MapperS.of(mASMarginReport), Arrays.asList("uti", "uniqueTransactionIdentifierProprietary"), ChoiceRuleValidationMethod.REQUIRED);
					}
					if (areEqual(MapperS.of(mASMarginReport).<Boolean>map("getCollateralPortfolioIndicator", _mASMarginReport -> _mASMarginReport.getCollateralPortfolioIndicator()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						return notExists(MapperS.of(mASMarginReport).<String>map("getUti", _mASMarginReport -> _mASMarginReport.getUti())).andNullSafe(notExists(MapperS.of(mASMarginReport).<String>map("getUniqueTransactionIdentifierProprietary", _mASMarginReport -> _mASMarginReport.getUniqueTransactionIdentifierProprietary())));
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
	class NoOp implements MASMarginReportDTCC_MAS_BR_0010_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASMarginReport mASMarginReport) {
			return Collections.emptyList();
		}
	}
}

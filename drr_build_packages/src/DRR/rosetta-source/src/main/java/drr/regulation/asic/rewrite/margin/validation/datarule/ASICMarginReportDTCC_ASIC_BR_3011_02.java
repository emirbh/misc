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
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICMarginReportDTCC_ASIC_BR_3011_02")
@ImplementedBy(ASICMarginReportDTCC_ASIC_BR_3011_02.Default.class)
public interface ASICMarginReportDTCC_ASIC_BR_3011_02 extends Validator<ASICMarginReport> {
	
	String NAME = "ASICMarginReportDTCC_ASIC_BR_3011_02";
	String DEFINITION = "if actionType = MarginActionEnum -> MARU or actionType = MarginActionEnum -> CORR and initialMarginCollateralPortfolioCode = \"NOAP\" and (uti is absent and uniqueTransactionIdentifierProprietary is absent) then variationMarginCollectedByTheCounterparty1PreHaircut exists else if (uti exists or uniqueTransactionIdentifierProprietary exists) and variationMarginCollateralPortfolioCode <> \"NOAP\" or initialMarginCollateralPortfolioCode = \"NOAP\" then variationMarginCollateralPortfolioCode is absent";
	
	class Default implements ASICMarginReportDTCC_ASIC_BR_3011_02 {
	
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
				if (areEqual(MapperS.of(aSICMarginReport).<MarginActionEnum>map("getActionType", _aSICMarginReport -> _aSICMarginReport.getActionType()), MapperS.of(MarginActionEnum.MARU), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(aSICMarginReport).<MarginActionEnum>map("getActionType", _aSICMarginReport -> _aSICMarginReport.getActionType()), MapperS.of(MarginActionEnum.CORR), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(aSICMarginReport).<String>map("getInitialMarginCollateralPortfolioCode", _aSICMarginReport -> _aSICMarginReport.getInitialMarginCollateralPortfolioCode()), MapperS.of("NOAP"), CardinalityOperator.All)).andNullSafe(notExists(MapperS.of(aSICMarginReport).<String>map("getUti", _aSICMarginReport -> _aSICMarginReport.getUti())).andNullSafe(notExists(MapperS.of(aSICMarginReport).<String>map("getUniqueTransactionIdentifierProprietary", _aSICMarginReport -> _aSICMarginReport.getUniqueTransactionIdentifierProprietary()))))).getOrDefault(false)) {
					return exists(MapperS.of(aSICMarginReport).<BigDecimal>map("getVariationMarginCollectedByTheCounterparty1PreHaircut", _aSICMarginReport -> _aSICMarginReport.getVariationMarginCollectedByTheCounterparty1PreHaircut()));
				}
				if (exists(MapperS.of(aSICMarginReport).<String>map("getUti", _aSICMarginReport -> _aSICMarginReport.getUti())).orNullSafe(exists(MapperS.of(aSICMarginReport).<String>map("getUniqueTransactionIdentifierProprietary", _aSICMarginReport -> _aSICMarginReport.getUniqueTransactionIdentifierProprietary()))).andNullSafe(notEqual(MapperS.of(aSICMarginReport).<String>map("getVariationMarginCollateralPortfolioCode", _aSICMarginReport -> _aSICMarginReport.getVariationMarginCollateralPortfolioCode()), MapperS.of("NOAP"), CardinalityOperator.Any)).orNullSafe(areEqual(MapperS.of(aSICMarginReport).<String>map("getInitialMarginCollateralPortfolioCode", _aSICMarginReport -> _aSICMarginReport.getInitialMarginCollateralPortfolioCode()), MapperS.of("NOAP"), CardinalityOperator.All)).getOrDefault(false)) {
					return notExists(MapperS.of(aSICMarginReport).<String>map("getVariationMarginCollateralPortfolioCode", _aSICMarginReport -> _aSICMarginReport.getVariationMarginCollateralPortfolioCode()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICMarginReportDTCC_ASIC_BR_3011_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICMarginReport aSICMarginReport) {
			return Collections.emptyList();
		}
	}
}

package drr.regulation.mas.rewrite.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
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
@RosettaDataRule("MASMarginReportDTCC_MAS_BR_0058_04")
@ImplementedBy(MASMarginReportDTCC_MAS_BR_0058_04.Default.class)
public interface MASMarginReportDTCC_MAS_BR_0058_04 extends Validator<MASMarginReport> {
	
	String NAME = "MASMarginReportDTCC_MAS_BR_0058_04";
	String DEFINITION = "if [MarginActionEnum -> CORR, MarginActionEnum -> MARU] any = actionType then if (uti exists or uniqueTransactionIdentifierProprietary exists) and variationMarginCollateralPortfolioCode <> \"NOAP\" then False";
	
	class Default implements MASMarginReportDTCC_MAS_BR_0058_04 {
	
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
				if (areEqual(MapperC.<MarginActionEnum>of(MapperS.of(MarginActionEnum.CORR), MapperS.of(MarginActionEnum.MARU)), MapperS.of(mASMarginReport).<MarginActionEnum>map("getActionType", _mASMarginReport -> _mASMarginReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (exists(MapperS.of(mASMarginReport).<String>map("getUti", _mASMarginReport -> _mASMarginReport.getUti())).orNullSafe(exists(MapperS.of(mASMarginReport).<String>map("getUniqueTransactionIdentifierProprietary", _mASMarginReport -> _mASMarginReport.getUniqueTransactionIdentifierProprietary()))).andNullSafe(notEqual(MapperS.of(mASMarginReport).<String>map("getVariationMarginCollateralPortfolioCode", _mASMarginReport -> _mASMarginReport.getVariationMarginCollateralPortfolioCode()), MapperS.of("NOAP"), CardinalityOperator.Any)).getOrDefault(false)) {
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
	class NoOp implements MASMarginReportDTCC_MAS_BR_0058_04 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASMarginReport mASMarginReport) {
			return Collections.emptyList();
		}
	}
}

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
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.MarginActionEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICMarginReportDTCC_ASIC_BR_3015_01")
@ImplementedBy(ASICMarginReportDTCC_ASIC_BR_3015_01.Default.class)
public interface ASICMarginReportDTCC_ASIC_BR_3015_01 extends Validator<ASICMarginReport> {
	
	String NAME = "ASICMarginReportDTCC_ASIC_BR_3015_01";
	String DEFINITION = "if actionType = MarginActionEnum -> MARU or actionType = MarginActionEnum -> CORR then if (collateralisationCategory = CollateralisationType3Code -> OWC1 or collateralisationCategory = CollateralisationType3Code -> OWP1 or collateralisationCategory = CollateralisationType3Code -> FLCL) then initialMarginCollectedByCounterparty1PreHaircut exists and initialMarginCollectedByCounterparty1PreHaircut >= 0 else if (collateralisationCategory <> CollateralisationType3Code -> OWC1 or collateralisationCategory <> CollateralisationType3Code -> OWP1 or collateralisationCategory <> CollateralisationType3Code -> FLCL) then initialMarginCollectedByCounterparty1PreHaircut is absent";
	
	class Default implements ASICMarginReportDTCC_ASIC_BR_3015_01 {
	
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
				if (areEqual(MapperS.of(aSICMarginReport).<MarginActionEnum>map("getActionType", _aSICMarginReport -> _aSICMarginReport.getActionType()), MapperS.of(MarginActionEnum.MARU), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(aSICMarginReport).<MarginActionEnum>map("getActionType", _aSICMarginReport -> _aSICMarginReport.getActionType()), MapperS.of(MarginActionEnum.CORR), CardinalityOperator.All)).getOrDefault(false)) {
					if (areEqual(MapperS.of(aSICMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _aSICMarginReport -> _aSICMarginReport.getCollateralisationCategory()), MapperS.of(CollateralisationType3Code.OWC1), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(aSICMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _aSICMarginReport -> _aSICMarginReport.getCollateralisationCategory()), MapperS.of(CollateralisationType3Code.OWP1), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(aSICMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _aSICMarginReport -> _aSICMarginReport.getCollateralisationCategory()), MapperS.of(CollateralisationType3Code.FLCL), CardinalityOperator.All)).getOrDefault(false)) {
						return exists(MapperS.of(aSICMarginReport).<BigDecimal>map("getInitialMarginCollectedByCounterparty1PreHaircut", _aSICMarginReport -> _aSICMarginReport.getInitialMarginCollectedByCounterparty1PreHaircut())).andNullSafe(greaterThanEquals(MapperS.of(aSICMarginReport).<BigDecimal>map("getInitialMarginCollectedByCounterparty1PreHaircut", _aSICMarginReport -> _aSICMarginReport.getInitialMarginCollectedByCounterparty1PreHaircut()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All));
					}
					if (notEqual(MapperS.of(aSICMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _aSICMarginReport -> _aSICMarginReport.getCollateralisationCategory()), MapperS.of(CollateralisationType3Code.OWC1), CardinalityOperator.Any).orNullSafe(notEqual(MapperS.of(aSICMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _aSICMarginReport -> _aSICMarginReport.getCollateralisationCategory()), MapperS.of(CollateralisationType3Code.OWP1), CardinalityOperator.Any)).orNullSafe(notEqual(MapperS.of(aSICMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _aSICMarginReport -> _aSICMarginReport.getCollateralisationCategory()), MapperS.of(CollateralisationType3Code.FLCL), CardinalityOperator.Any)).getOrDefault(false)) {
						return notExists(MapperS.of(aSICMarginReport).<BigDecimal>map("getInitialMarginCollectedByCounterparty1PreHaircut", _aSICMarginReport -> _aSICMarginReport.getInitialMarginCollectedByCounterparty1PreHaircut()));
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
	class NoOp implements ASICMarginReportDTCC_ASIC_BR_3015_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICMarginReport aSICMarginReport) {
			return Collections.emptyList();
		}
	}
}

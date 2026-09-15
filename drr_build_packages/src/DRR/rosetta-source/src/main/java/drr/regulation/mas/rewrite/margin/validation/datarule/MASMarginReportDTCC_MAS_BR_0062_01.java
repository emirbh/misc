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
@RosettaDataRule("MASMarginReportDTCC_MAS_BR_0062_01")
@ImplementedBy(MASMarginReportDTCC_MAS_BR_0062_01.Default.class)
public interface MASMarginReportDTCC_MAS_BR_0062_01 extends Validator<MASMarginReport> {
	
	String NAME = "MASMarginReportDTCC_MAS_BR_0062_01";
	String DEFINITION = "if [MarginActionEnum -> CORR, MarginActionEnum -> MARU] any = actionType then if [CollateralisationType3Code -> OWC2, CollateralisationType3Code -> OWP2, CollateralisationType3Code -> FLCL] any = collateralisationCategory then initialMarginCollectedByCounterparty1PreHaircut exists and initialMarginCollectedByCounterparty1PreHaircut >= 0 else if [CollateralisationType3Code -> OWC2, CollateralisationType3Code -> OWP2, CollateralisationType3Code -> FLCL] all <> collateralisationCategory then initialMarginCollectedByCounterparty1PreHaircut is absent";
	
	class Default implements MASMarginReportDTCC_MAS_BR_0062_01 {
	
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
					if (areEqual(MapperC.<CollateralisationType3Code>of(MapperS.of(CollateralisationType3Code.OWC2), MapperS.of(CollateralisationType3Code.OWP2), MapperS.of(CollateralisationType3Code.FLCL)), MapperS.of(mASMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _mASMarginReport -> _mASMarginReport.getCollateralisationCategory()), CardinalityOperator.Any).getOrDefault(false)) {
						return exists(MapperS.of(mASMarginReport).<BigDecimal>map("getInitialMarginCollectedByCounterparty1PreHaircut", _mASMarginReport -> _mASMarginReport.getInitialMarginCollectedByCounterparty1PreHaircut())).andNullSafe(greaterThanEquals(MapperS.of(mASMarginReport).<BigDecimal>map("getInitialMarginCollectedByCounterparty1PreHaircut", _mASMarginReport -> _mASMarginReport.getInitialMarginCollectedByCounterparty1PreHaircut()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All));
					}
					if (notEqual(MapperC.<CollateralisationType3Code>of(MapperS.of(CollateralisationType3Code.OWC2), MapperS.of(CollateralisationType3Code.OWP2), MapperS.of(CollateralisationType3Code.FLCL)), MapperS.of(mASMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _mASMarginReport -> _mASMarginReport.getCollateralisationCategory()), CardinalityOperator.All).getOrDefault(false)) {
						return notExists(MapperS.of(mASMarginReport).<BigDecimal>map("getInitialMarginCollectedByCounterparty1PreHaircut", _mASMarginReport -> _mASMarginReport.getInitialMarginCollectedByCounterparty1PreHaircut()));
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
	class NoOp implements MASMarginReportDTCC_MAS_BR_0062_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASMarginReport mASMarginReport) {
			return Collections.emptyList();
		}
	}
}

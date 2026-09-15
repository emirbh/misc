package drr.regulation.hkma.rewrite.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.hkma.rewrite.margin.HKMAMarginReport;
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
@RosettaDataRule("HKMAMarginReportDOC0133")
@ImplementedBy(HKMAMarginReportDOC0133.Default.class)
public interface HKMAMarginReportDOC0133 extends Validator<HKMAMarginReport> {
	
	String NAME = "HKMAMarginReportDOC0133";
	String DEFINITION = "if [MarginActionEnum -> MARU, MarginActionEnum -> CORR] any = actionType and [CollateralisationType3Code -> PRC1, CollateralisationType3Code -> PRCL, CollateralisationType3Code -> OWC1, CollateralisationType3Code -> OWP1, CollateralisationType3Code -> OWP2, CollateralisationType3Code -> FLCL] any = collateralisationCategory then variationMarginPostedByTheCounterparty1PostHaircut exists";
	
	class Default implements HKMAMarginReportDOC0133 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMAMarginReport hKMAMarginReport) {
			ComparisonResult result = executeDataRule(hKMAMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "HKMAMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "HKMAMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(HKMAMarginReport hKMAMarginReport) {
			try {
				if (areEqual(MapperC.<MarginActionEnum>of(MapperS.of(MarginActionEnum.MARU), MapperS.of(MarginActionEnum.CORR)), MapperS.of(hKMAMarginReport).<MarginActionEnum>map("getActionType", _hKMAMarginReport -> _hKMAMarginReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CollateralisationType3Code>of(MapperS.of(CollateralisationType3Code.PRC1), MapperS.of(CollateralisationType3Code.PRCL), MapperS.of(CollateralisationType3Code.OWC1), MapperS.of(CollateralisationType3Code.OWP1), MapperS.of(CollateralisationType3Code.OWP2), MapperS.of(CollateralisationType3Code.FLCL)), MapperS.of(hKMAMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _hKMAMarginReport -> _hKMAMarginReport.getCollateralisationCategory()), CardinalityOperator.Any)).getOrDefault(false)) {
					return exists(MapperS.of(hKMAMarginReport).<BigDecimal>map("getVariationMarginPostedByTheCounterparty1PostHaircut", _hKMAMarginReport -> _hKMAMarginReport.getVariationMarginPostedByTheCounterparty1PostHaircut()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements HKMAMarginReportDOC0133 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMAMarginReport hKMAMarginReport) {
			return Collections.emptyList();
		}
	}
}

package drr.regulation.jfsa.rewrite.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.jfsa.rewrite.functions.MarginAmount_Validation;
import drr.regulation.jfsa.rewrite.margin.JFSAMarginReport;
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.MarginActionEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("JFSAMarginReportDTCC_JFSA_BR_0046_01")
@ImplementedBy(JFSAMarginReportDTCC_JFSA_BR_0046_01.Default.class)
public interface JFSAMarginReportDTCC_JFSA_BR_0046_01 extends Validator<JFSAMarginReport> {
	
	String NAME = "JFSAMarginReportDTCC_JFSA_BR_0046_01";
	String DEFINITION = "MarginAmount_Validation( actionType, collateralisationCategory, initialMarginPostedByTheCounterparty1PostHaircut, [CollateralisationType3Code -> OWC1, CollateralisationType3Code -> OWP1, CollateralisationType3Code -> FLCL] )";
	
	class Default implements JFSAMarginReportDTCC_JFSA_BR_0046_01 {
	
		@Inject protected MarginAmount_Validation marginAmount_Validation;
		
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
				return ComparisonResult.ofNullSafe(MapperS.of(marginAmount_Validation.evaluate(MapperS.of(jFSAMarginReport).<MarginActionEnum>map("getActionType", _jFSAMarginReport -> _jFSAMarginReport.getActionType()).get(), MapperS.of(jFSAMarginReport).<CollateralisationType3Code>map("getCollateralisationCategory", _jFSAMarginReport -> _jFSAMarginReport.getCollateralisationCategory()).get(), MapperS.of(jFSAMarginReport).<BigDecimal>map("getInitialMarginPostedByTheCounterparty1PostHaircut", _jFSAMarginReport -> _jFSAMarginReport.getInitialMarginPostedByTheCounterparty1PostHaircut()).get(), MapperC.<CollateralisationType3Code>of(MapperS.of(CollateralisationType3Code.OWC1), MapperS.of(CollateralisationType3Code.OWP1), MapperS.of(CollateralisationType3Code.FLCL)).getMulti())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements JFSAMarginReportDTCC_JFSA_BR_0046_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSAMarginReport jFSAMarginReport) {
			return Collections.emptyList();
		}
	}
}

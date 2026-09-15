package drr.regulation.jfsa.rewrite.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.jfsa.rewrite.valuation.JFSAValuationReport;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("JFSAValuationReportDTCC_JFSA_VR_0004_01")
@ImplementedBy(JFSAValuationReportDTCC_JFSA_VR_0004_01.Default.class)
public interface JFSAValuationReportDTCC_JFSA_VR_0004_01 extends Validator<JFSAValuationReport> {
	
	String NAME = "JFSAValuationReportDTCC_JFSA_VR_0004_01";
	String DEFINITION = "reportingTimestamp >= valuationTimestamp";
	
	class Default implements JFSAValuationReportDTCC_JFSA_VR_0004_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSAValuationReport jFSAValuationReport) {
			ComparisonResult result = executeDataRule(jFSAValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSAValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSAValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(JFSAValuationReport jFSAValuationReport) {
			try {
				return greaterThanEquals(MapperS.of(jFSAValuationReport).<ZonedDateTime>map("getReportingTimestamp", _jFSAValuationReport -> _jFSAValuationReport.getReportingTimestamp()), MapperS.of(jFSAValuationReport).<ZonedDateTime>map("getValuationTimestamp", _jFSAValuationReport -> _jFSAValuationReport.getValuationTimestamp()), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements JFSAValuationReportDTCC_JFSA_VR_0004_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSAValuationReport jFSAValuationReport) {
			return Collections.emptyList();
		}
	}
}

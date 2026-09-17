package fpml.consolidated.doc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ClearingExceptionReason;
import fpml.consolidated.doc.EndUserExceptionDeclaration;
import fpml.consolidated.doc.ReportingRegime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ReportingRegimeChoice2")
@ImplementedBy(ReportingRegimeChoice2.Default.class)
public interface ReportingRegimeChoice2 extends Validator<ReportingRegime> {
	
	String NAME = "ReportingRegimeChoice2";
	String DEFINITION = "endUserExceptionDeclaration is absent or endUserException is absent and endUserExceptionReason is absent";
	
	class Default implements ReportingRegimeChoice2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingRegime reportingRegime) {
			ComparisonResult result = executeDataRule(reportingRegime);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportingRegime", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportingRegime", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReportingRegime reportingRegime) {
			try {
				return notExists(MapperS.of(reportingRegime).<EndUserExceptionDeclaration>map("getEndUserExceptionDeclaration", _reportingRegime -> _reportingRegime.getEndUserExceptionDeclaration())).orNullSafe(notExists(MapperS.of(reportingRegime).<Boolean>map("getEndUserException", _reportingRegime -> _reportingRegime.getEndUserException())).andNullSafe(notExists(MapperS.of(reportingRegime).<ClearingExceptionReason>mapC("getEndUserExceptionReason", _reportingRegime -> _reportingRegime.getEndUserExceptionReason()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReportingRegimeChoice2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingRegime reportingRegime) {
			return Collections.emptyList();
		}
	}
}

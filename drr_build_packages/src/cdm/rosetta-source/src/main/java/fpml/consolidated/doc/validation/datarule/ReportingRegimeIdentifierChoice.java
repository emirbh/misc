package fpml.consolidated.doc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ReportingRegimeIdentifier;
import fpml.consolidated.doc.SupervisorRegistration;
import fpml.consolidated.shared.ReportingRegimeName;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ReportingRegimeIdentifierChoice")
@ImplementedBy(ReportingRegimeIdentifierChoice.Default.class)
public interface ReportingRegimeIdentifierChoice extends Validator<ReportingRegimeIdentifier> {
	
	String NAME = "ReportingRegimeIdentifierChoice";
	String DEFINITION = "name exists or supervisorRegistration exists";
	
	class Default implements ReportingRegimeIdentifierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingRegimeIdentifier reportingRegimeIdentifier) {
			ComparisonResult result = executeDataRule(reportingRegimeIdentifier);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportingRegimeIdentifier", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportingRegimeIdentifier", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReportingRegimeIdentifier reportingRegimeIdentifier) {
			try {
				return exists(MapperS.of(reportingRegimeIdentifier).<ReportingRegimeName>map("getName", _reportingRegimeIdentifier -> _reportingRegimeIdentifier.getName())).orNullSafe(exists(MapperS.of(reportingRegimeIdentifier).<SupervisorRegistration>mapC("getSupervisorRegistration", _reportingRegimeIdentifier -> _reportingRegimeIdentifier.getSupervisorRegistration())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReportingRegimeIdentifierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingRegimeIdentifier reportingRegimeIdentifier) {
			return Collections.emptyList();
		}
	}
}

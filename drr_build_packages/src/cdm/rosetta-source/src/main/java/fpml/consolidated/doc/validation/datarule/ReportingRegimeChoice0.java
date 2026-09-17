package fpml.consolidated.doc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ReportingRegime;
import fpml.consolidated.doc.SupervisorRegistration;
import fpml.consolidated.shared.ReportingRegimeName;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ReportingRegimeChoice0")
@ImplementedBy(ReportingRegimeChoice0.Default.class)
public interface ReportingRegimeChoice0 extends Validator<ReportingRegime> {
	
	String NAME = "ReportingRegimeChoice0";
	String DEFINITION = "name exists or supervisorRegistration exists";
	
	class Default implements ReportingRegimeChoice0 {
	
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
				return exists(MapperS.of(reportingRegime).<ReportingRegimeName>map("getName", _reportingRegime -> _reportingRegime.getName())).orNullSafe(exists(MapperS.of(reportingRegime).<SupervisorRegistration>mapC("getSupervisorRegistration", _reportingRegime -> _reportingRegime.getSupervisorRegistration())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReportingRegimeChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingRegime reportingRegime) {
			return Collections.emptyList();
		}
	}
}

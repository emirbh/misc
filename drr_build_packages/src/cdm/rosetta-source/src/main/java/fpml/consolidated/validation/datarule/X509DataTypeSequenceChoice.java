package fpml.consolidated.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.X509DataTypeSequence;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("X509DataTypeSequenceChoice")
@ImplementedBy(X509DataTypeSequenceChoice.Default.class)
public interface X509DataTypeSequenceChoice extends Validator<X509DataTypeSequence> {
	
	String NAME = "X509DataTypeSequenceChoice";
	String DEFINITION = "one-of";
	
	class Default implements X509DataTypeSequenceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, X509DataTypeSequence x509DataTypeSequence) {
			ComparisonResult result = executeDataRule(x509DataTypeSequence);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "X509DataTypeSequence", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "X509DataTypeSequence", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(X509DataTypeSequence x509DataTypeSequence) {
			try {
				return choice(MapperS.of(x509DataTypeSequence), Arrays.asList("x509IssuerSerial", "x509SKI", "x509SubjectName", "x509Certificate", "x509CRL", "anyContents"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements X509DataTypeSequenceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, X509DataTypeSequence x509DataTypeSequence) {
			return Collections.emptyList();
		}
	}
}

package fpml.consolidated.msg.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.RequestRetransmission;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RequestRetransmissionChoice")
@ImplementedBy(RequestRetransmissionChoice.Default.class)
public interface RequestRetransmissionChoice extends Validator<RequestRetransmission> {
	
	String NAME = "RequestRetransmissionChoice";
	String DEFINITION = "optional choice portfolioReference, reportIdentification";
	
	class Default implements RequestRetransmissionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestRetransmission requestRetransmission) {
			ComparisonResult result = executeDataRule(requestRetransmission);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestRetransmission", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestRetransmission", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RequestRetransmission requestRetransmission) {
			try {
				return choice(MapperS.of(requestRetransmission), Arrays.asList("portfolioReference", "reportIdentification"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RequestRetransmissionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestRetransmission requestRetransmission) {
			return Collections.emptyList();
		}
	}
}

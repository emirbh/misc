package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.Routing;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RoutingChoice")
@ImplementedBy(RoutingChoice.Default.class)
public interface RoutingChoice extends Validator<Routing> {
	
	String NAME = "RoutingChoice";
	String DEFINITION = "one-of";
	
	class Default implements RoutingChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Routing routing) {
			ComparisonResult result = executeDataRule(routing);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Routing", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Routing", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Routing routing) {
			try {
				return choice(MapperS.of(routing), Arrays.asList("routingIds", "routingExplicitDetails", "routingIdsAndExplicitDetails"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RoutingChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Routing routing) {
			return Collections.emptyList();
		}
	}
}

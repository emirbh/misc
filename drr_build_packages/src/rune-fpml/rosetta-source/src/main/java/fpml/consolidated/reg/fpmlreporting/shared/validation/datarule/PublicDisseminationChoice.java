package fpml.consolidated.reg.fpmlreporting.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.shared.PublicDissemination;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PublicDisseminationChoice")
@ImplementedBy(PublicDisseminationChoice.Default.class)
public interface PublicDisseminationChoice extends Validator<PublicDissemination> {
	
	String NAME = "PublicDisseminationChoice";
	String DEFINITION = "optional choice publicationTime, projectedTime";
	
	class Default implements PublicDisseminationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PublicDissemination publicDissemination) {
			ComparisonResult result = executeDataRule(publicDissemination);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PublicDissemination", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PublicDissemination", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PublicDissemination publicDissemination) {
			try {
				return choice(MapperS.of(publicDissemination), Arrays.asList("publicationTime", "projectedTime"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PublicDisseminationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PublicDissemination publicDissemination) {
			return Collections.emptyList();
		}
	}
}

package fpml.consolidated.reg.fpmlreporting.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPosition;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CollateralPositionChoice")
@ImplementedBy(CollateralPositionChoice.Default.class)
public interface CollateralPositionChoice extends Validator<CollateralPosition> {
	
	String NAME = "CollateralPositionChoice";
	String DEFINITION = "optional choice marginRatio, haircut";
	
	class Default implements CollateralPositionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralPosition collateralPosition) {
			ComparisonResult result = executeDataRule(collateralPosition);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralPosition", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralPosition", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CollateralPosition collateralPosition) {
			try {
				return choice(MapperS.of(collateralPosition), Arrays.asList("marginRatio", "haircut"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralPositionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralPosition collateralPosition) {
			return Collections.emptyList();
		}
	}
}

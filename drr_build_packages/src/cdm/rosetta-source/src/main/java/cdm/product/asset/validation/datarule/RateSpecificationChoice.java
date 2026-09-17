package cdm.product.asset.validation.datarule;

import cdm.product.asset.RateSpecification;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("RateSpecificationChoice")
@ImplementedBy(RateSpecificationChoice.Default.class)
public interface RateSpecificationChoice extends Validator<RateSpecification> {
	
	String NAME = "RateSpecificationChoice";
	String DEFINITION = "";
	
	class Default implements RateSpecificationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RateSpecification rateSpecification) {
			ComparisonResult result = executeDataRule(rateSpecification);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RateSpecification", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RateSpecification", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RateSpecification rateSpecification) {
			try {
				return choice(MapperS.of(rateSpecification), Arrays.asList("FixedRateSpecification", "FloatingRateSpecification", "InflationRateSpecification"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RateSpecificationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RateSpecification rateSpecification) {
			return Collections.emptyList();
		}
	}
}

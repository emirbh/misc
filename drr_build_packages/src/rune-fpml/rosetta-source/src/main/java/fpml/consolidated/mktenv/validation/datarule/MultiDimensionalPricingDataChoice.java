package fpml.consolidated.mktenv.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.mktenv.MultiDimensionalPricingData;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("MultiDimensionalPricingDataChoice")
@ImplementedBy(MultiDimensionalPricingDataChoice.Default.class)
public interface MultiDimensionalPricingDataChoice extends Validator<MultiDimensionalPricingData> {
	
	String NAME = "MultiDimensionalPricingDataChoice";
	String DEFINITION = "optional choice businessCenter, exchangeId";
	
	class Default implements MultiDimensionalPricingDataChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultiDimensionalPricingData multiDimensionalPricingData) {
			ComparisonResult result = executeDataRule(multiDimensionalPricingData);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MultiDimensionalPricingData", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MultiDimensionalPricingData", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MultiDimensionalPricingData multiDimensionalPricingData) {
			try {
				return choice(MapperS.of(multiDimensionalPricingData), Arrays.asList("businessCenter", "exchangeId"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MultiDimensionalPricingDataChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultiDimensionalPricingData multiDimensionalPricingData) {
			return Collections.emptyList();
		}
	}
}

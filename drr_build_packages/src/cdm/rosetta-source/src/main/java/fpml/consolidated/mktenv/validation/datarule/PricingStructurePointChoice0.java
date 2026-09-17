package fpml.consolidated.mktenv.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.mktenv.PricingStructurePoint;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PricingStructurePointChoice0")
@ImplementedBy(PricingStructurePointChoice0.Default.class)
public interface PricingStructurePointChoice0 extends Validator<PricingStructurePoint> {
	
	String NAME = "PricingStructurePointChoice0";
	String DEFINITION = "optional choice underlyingAsset, underlyingAssetReference";
	
	class Default implements PricingStructurePointChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingStructurePoint pricingStructurePoint) {
			ComparisonResult result = executeDataRule(pricingStructurePoint);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PricingStructurePoint", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PricingStructurePoint", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PricingStructurePoint pricingStructurePoint) {
			try {
				return choice(MapperS.of(pricingStructurePoint), Arrays.asList("underlyingAsset", "underlyingAssetReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PricingStructurePointChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingStructurePoint pricingStructurePoint) {
			return Collections.emptyList();
		}
	}
}

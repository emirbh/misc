package cdm.product.template.validation.datarule;

import cdm.product.template.ConstituentWeight;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("ConstituentWeightBasketPercentage")
@ImplementedBy(ConstituentWeightBasketPercentage.Default.class)
public interface ConstituentWeightBasketPercentage extends Validator<ConstituentWeight> {
	
	String NAME = "ConstituentWeightBasketPercentage";
	String DEFINITION = "if basketPercentage exists then basketPercentage >= 0.0 and basketPercentage <= 1.0";
	
	class Default implements ConstituentWeightBasketPercentage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConstituentWeight constituentWeight) {
			ComparisonResult result = executeDataRule(constituentWeight);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ConstituentWeight", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ConstituentWeight", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ConstituentWeight constituentWeight) {
			try {
				if (exists(MapperS.of(constituentWeight).<BigDecimal>map("getBasketPercentage", _constituentWeight -> _constituentWeight.getBasketPercentage())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(constituentWeight).<BigDecimal>map("getBasketPercentage", _constituentWeight -> _constituentWeight.getBasketPercentage()), MapperS.of(new BigDecimal("0.0")), CardinalityOperator.All).andNullSafe(lessThanEquals(MapperS.of(constituentWeight).<BigDecimal>map("getBasketPercentage", _constituentWeight -> _constituentWeight.getBasketPercentage()), MapperS.of(new BigDecimal("1.0")), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ConstituentWeightBasketPercentage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConstituentWeight constituentWeight) {
			return Collections.emptyList();
		}
	}
}

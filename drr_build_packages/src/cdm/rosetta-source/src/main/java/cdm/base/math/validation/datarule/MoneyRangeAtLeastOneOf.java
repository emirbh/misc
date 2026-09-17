package cdm.base.math.validation.datarule;

import cdm.base.math.MoneyBound;
import cdm.base.math.MoneyRange;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("MoneyRangeAtLeastOneOf")
@ImplementedBy(MoneyRangeAtLeastOneOf.Default.class)
public interface MoneyRangeAtLeastOneOf extends Validator<MoneyRange> {
	
	String NAME = "MoneyRangeAtLeastOneOf";
	String DEFINITION = "lowerBound exists or upperBound exists";
	
	class Default implements MoneyRangeAtLeastOneOf {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MoneyRange moneyRange) {
			ComparisonResult result = executeDataRule(moneyRange);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MoneyRange", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MoneyRange", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MoneyRange moneyRange) {
			try {
				return exists(MapperS.of(moneyRange).<MoneyBound>map("getLowerBound", _moneyRange -> _moneyRange.getLowerBound())).orNullSafe(exists(MapperS.of(moneyRange).<MoneyBound>map("getUpperBound", _moneyRange -> _moneyRange.getUpperBound())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MoneyRangeAtLeastOneOf {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MoneyRange moneyRange) {
			return Collections.emptyList();
		}
	}
}

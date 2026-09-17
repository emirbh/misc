package cdm.product.asset.validation.datarule;

import cdm.product.asset.EquityUnderlierProvisions;
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
@RosettaDataRule("EquityUnderlierProvisionsComponentSecurityOrMultipleExchange")
@ImplementedBy(EquityUnderlierProvisionsComponentSecurityOrMultipleExchange.Default.class)
public interface EquityUnderlierProvisionsComponentSecurityOrMultipleExchange extends Validator<EquityUnderlierProvisions> {
	
	String NAME = "EquityUnderlierProvisionsComponentSecurityOrMultipleExchange";
	String DEFINITION = "optional choice multipleExchangeIndexAnnexFallback, componentSecurityIndexAnnexFallback";
	
	class Default implements EquityUnderlierProvisionsComponentSecurityOrMultipleExchange {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityUnderlierProvisions equityUnderlierProvisions) {
			ComparisonResult result = executeDataRule(equityUnderlierProvisions);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityUnderlierProvisions", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityUnderlierProvisions", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EquityUnderlierProvisions equityUnderlierProvisions) {
			try {
				return choice(MapperS.of(equityUnderlierProvisions), Arrays.asList("multipleExchangeIndexAnnexFallback", "componentSecurityIndexAnnexFallback"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityUnderlierProvisionsComponentSecurityOrMultipleExchange {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityUnderlierProvisions equityUnderlierProvisions) {
			return Collections.emptyList();
		}
	}
}

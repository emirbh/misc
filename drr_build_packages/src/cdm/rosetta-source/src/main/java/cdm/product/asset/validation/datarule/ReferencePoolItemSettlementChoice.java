package cdm.product.asset.validation.datarule;

import cdm.product.asset.ReferencePoolItem;
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
@RosettaDataRule("ReferencePoolItemSettlementChoice")
@ImplementedBy(ReferencePoolItemSettlementChoice.Default.class)
public interface ReferencePoolItemSettlementChoice extends Validator<ReferencePoolItem> {
	
	String NAME = "ReferencePoolItemSettlementChoice";
	String DEFINITION = "optional choice cashSettlementTermsReference, physicalSettlementTermsReference";
	
	class Default implements ReferencePoolItemSettlementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferencePoolItem referencePoolItem) {
			ComparisonResult result = executeDataRule(referencePoolItem);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferencePoolItem", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferencePoolItem", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReferencePoolItem referencePoolItem) {
			try {
				return choice(MapperS.of(referencePoolItem), Arrays.asList("cashSettlementTermsReference", "physicalSettlementTermsReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReferencePoolItemSettlementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferencePoolItem referencePoolItem) {
			return Collections.emptyList();
		}
	}
}

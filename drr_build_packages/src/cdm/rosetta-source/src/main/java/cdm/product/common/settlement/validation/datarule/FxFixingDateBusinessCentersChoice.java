package cdm.product.common.settlement.validation.datarule;

import cdm.product.common.settlement.FxFixingDate;
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
@RosettaDataRule("FxFixingDateBusinessCentersChoice")
@ImplementedBy(FxFixingDateBusinessCentersChoice.Default.class)
public interface FxFixingDateBusinessCentersChoice extends Validator<FxFixingDate> {
	
	String NAME = "FxFixingDateBusinessCentersChoice";
	String DEFINITION = "optional choice businessCenters, businessCentersReference";
	
	class Default implements FxFixingDateBusinessCentersChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixingDate fxFixingDate) {
			ComparisonResult result = executeDataRule(fxFixingDate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxFixingDate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxFixingDate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxFixingDate fxFixingDate) {
			try {
				return choice(MapperS.of(fxFixingDate), Arrays.asList("businessCenters", "businessCentersReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxFixingDateBusinessCentersChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixingDate fxFixingDate) {
			return Collections.emptyList();
		}
	}
}

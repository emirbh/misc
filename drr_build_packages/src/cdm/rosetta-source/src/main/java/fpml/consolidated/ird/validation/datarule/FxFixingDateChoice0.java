package fpml.consolidated.ird.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.FxFixingDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxFixingDateChoice0")
@ImplementedBy(FxFixingDateChoice0.Default.class)
public interface FxFixingDateChoice0 extends Validator<FxFixingDate> {
	
	String NAME = "FxFixingDateChoice0";
	String DEFINITION = "optional choice businessCentersReference, businessCenters";
	
	class Default implements FxFixingDateChoice0 {
	
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
				return choice(MapperS.of(fxFixingDate), Arrays.asList("businessCentersReference", "businessCenters"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxFixingDateChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixingDate fxFixingDate) {
			return Collections.emptyList();
		}
	}
}

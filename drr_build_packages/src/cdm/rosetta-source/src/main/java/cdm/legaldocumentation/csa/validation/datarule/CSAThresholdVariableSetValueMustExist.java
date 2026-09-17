package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.CSAThresholdVariableSet;
import cdm.observable.asset.CreditRatingAgencyEnum;
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
@RosettaDataRule("CSAThresholdVariableSetValueMustExist")
@ImplementedBy(CSAThresholdVariableSetValueMustExist.Default.class)
public interface CSAThresholdVariableSetValueMustExist extends Validator<CSAThresholdVariableSet> {
	
	String NAME = "CSAThresholdVariableSetValueMustExist";
	String DEFINITION = "if value exists then name exists";
	
	class Default implements CSAThresholdVariableSetValueMustExist {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAThresholdVariableSet cSAThresholdVariableSet) {
			ComparisonResult result = executeDataRule(cSAThresholdVariableSet);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSAThresholdVariableSet", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSAThresholdVariableSet", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSAThresholdVariableSet cSAThresholdVariableSet) {
			try {
				if (exists(MapperS.of(cSAThresholdVariableSet).<String>map("getValue", _cSAThresholdVariableSet -> _cSAThresholdVariableSet.getValue())).getOrDefault(false)) {
					return exists(MapperS.of(cSAThresholdVariableSet).<CreditRatingAgencyEnum>map("getName", _cSAThresholdVariableSet -> _cSAThresholdVariableSet.getName()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSAThresholdVariableSetValueMustExist {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAThresholdVariableSet cSAThresholdVariableSet) {
			return Collections.emptyList();
		}
	}
}

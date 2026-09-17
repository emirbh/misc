package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.CSAMTAVariableSet;
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
@RosettaDataRule("CSAMTAVariableSetValueMustExist")
@ImplementedBy(CSAMTAVariableSetValueMustExist.Default.class)
public interface CSAMTAVariableSetValueMustExist extends Validator<CSAMTAVariableSet> {
	
	String NAME = "CSAMTAVariableSetValueMustExist";
	String DEFINITION = "if value exists then name exists";
	
	class Default implements CSAMTAVariableSetValueMustExist {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAMTAVariableSet cSAMTAVariableSet) {
			ComparisonResult result = executeDataRule(cSAMTAVariableSet);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSAMTAVariableSet", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSAMTAVariableSet", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSAMTAVariableSet cSAMTAVariableSet) {
			try {
				if (exists(MapperS.of(cSAMTAVariableSet).<String>map("getValue", _cSAMTAVariableSet -> _cSAMTAVariableSet.getValue())).getOrDefault(false)) {
					return exists(MapperS.of(cSAMTAVariableSet).<CreditRatingAgencyEnum>map("getName", _cSAMTAVariableSet -> _cSAMTAVariableSet.getName()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSAMTAVariableSetValueMustExist {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAMTAVariableSet cSAMTAVariableSet) {
			return Collections.emptyList();
		}
	}
}

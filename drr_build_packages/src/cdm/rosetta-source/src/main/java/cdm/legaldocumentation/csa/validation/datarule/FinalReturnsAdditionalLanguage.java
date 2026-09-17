package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.FinalReturns;
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
@RosettaDataRule("FinalReturnsAdditionalLanguage")
@ImplementedBy(FinalReturnsAdditionalLanguage.Default.class)
public interface FinalReturnsAdditionalLanguage extends Validator<FinalReturns> {
	
	String NAME = "FinalReturnsAdditionalLanguage";
	String DEFINITION = "if applicable then additionalLanguage exists";
	
	class Default implements FinalReturnsAdditionalLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FinalReturns finalReturns) {
			ComparisonResult result = executeDataRule(finalReturns);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FinalReturns", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FinalReturns", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FinalReturns finalReturns) {
			try {
				if (MapperS.of(finalReturns).<Boolean>map("getApplicable", _finalReturns -> _finalReturns.getApplicable()).getOrDefault(false)) {
					return exists(MapperS.of(finalReturns).<String>map("getAdditionalLanguage", _finalReturns -> _finalReturns.getAdditionalLanguage()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FinalReturnsAdditionalLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FinalReturns finalReturns) {
			return Collections.emptyList();
		}
	}
}

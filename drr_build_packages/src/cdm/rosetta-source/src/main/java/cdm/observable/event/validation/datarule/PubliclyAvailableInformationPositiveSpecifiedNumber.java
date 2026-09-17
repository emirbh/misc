package cdm.observable.event.validation.datarule;

import cdm.observable.event.PubliclyAvailableInformation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("PubliclyAvailableInformationPositiveSpecifiedNumber")
@ImplementedBy(PubliclyAvailableInformationPositiveSpecifiedNumber.Default.class)
public interface PubliclyAvailableInformationPositiveSpecifiedNumber extends Validator<PubliclyAvailableInformation> {
	
	String NAME = "PubliclyAvailableInformationPositiveSpecifiedNumber";
	String DEFINITION = "if specifiedNumber exists then specifiedNumber >= 0";
	
	class Default implements PubliclyAvailableInformationPositiveSpecifiedNumber {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PubliclyAvailableInformation publiclyAvailableInformation) {
			ComparisonResult result = executeDataRule(publiclyAvailableInformation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PubliclyAvailableInformation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PubliclyAvailableInformation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PubliclyAvailableInformation publiclyAvailableInformation) {
			try {
				if (exists(MapperS.of(publiclyAvailableInformation).<Integer>map("getSpecifiedNumber", _publiclyAvailableInformation -> _publiclyAvailableInformation.getSpecifiedNumber())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(publiclyAvailableInformation).<Integer>map("getSpecifiedNumber", _publiclyAvailableInformation -> _publiclyAvailableInformation.getSpecifiedNumber()), MapperS.of(0), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PubliclyAvailableInformationPositiveSpecifiedNumber {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PubliclyAvailableInformation publiclyAvailableInformation) {
			return Collections.emptyList();
		}
	}
}

package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.AdditionalType;
import cdm.legaldocumentation.csa.AdditionalTypeEnum;
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
@RosettaDataRule("AdditionalTypeStandardValue")
@ImplementedBy(AdditionalTypeStandardValue.Default.class)
public interface AdditionalTypeStandardValue extends Validator<AdditionalType> {
	
	String NAME = "AdditionalTypeStandardValue";
	String DEFINITION = "if standardValue <> AdditionalTypeEnum -> Other then customValue is absent";
	
	class Default implements AdditionalTypeStandardValue {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalType additionalType) {
			ComparisonResult result = executeDataRule(additionalType);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdditionalType", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdditionalType", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AdditionalType additionalType) {
			try {
				if (notEqual(MapperS.of(additionalType).<AdditionalTypeEnum>map("getStandardValue", _additionalType -> _additionalType.getStandardValue()), MapperS.of(AdditionalTypeEnum.OTHER), CardinalityOperator.Any).getOrDefault(false)) {
					return notExists(MapperS.of(additionalType).<String>map("getCustomValue", _additionalType -> _additionalType.getCustomValue()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdditionalTypeStandardValue {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalType additionalType) {
			return Collections.emptyList();
		}
	}
}

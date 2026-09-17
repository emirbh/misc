package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.LegacyResolutionValue;
import cdm.legaldocumentation.csa.ValueCashEnum;
import cdm.legaldocumentation.csa.ValueSecuritiesEnum;
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
@RosettaDataRule("LegacyResolutionValueOtherValues")
@ImplementedBy(LegacyResolutionValueOtherValues.Default.class)
public interface LegacyResolutionValueOtherValues extends Validator<LegacyResolutionValue> {
	
	String NAME = "LegacyResolutionValueOtherValues";
	String DEFINITION = "if cash = ValueCashEnum -> Other or securities = ValueSecuritiesEnum -> Other then additionalLanguage exists";
	
	class Default implements LegacyResolutionValueOtherValues {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyResolutionValue legacyResolutionValue) {
			ComparisonResult result = executeDataRule(legacyResolutionValue);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegacyResolutionValue", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LegacyResolutionValue", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LegacyResolutionValue legacyResolutionValue) {
			try {
				if (areEqual(MapperS.of(legacyResolutionValue).<ValueCashEnum>map("getCash", _legacyResolutionValue -> _legacyResolutionValue.getCash()), MapperS.of(ValueCashEnum.OTHER), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(legacyResolutionValue).<ValueSecuritiesEnum>map("getSecurities", _legacyResolutionValue -> _legacyResolutionValue.getSecurities()), MapperS.of(ValueSecuritiesEnum.OTHER), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(legacyResolutionValue).<String>map("getAdditionalLanguage", _legacyResolutionValue -> _legacyResolutionValue.getAdditionalLanguage()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LegacyResolutionValueOtherValues {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyResolutionValue legacyResolutionValue) {
			return Collections.emptyList();
		}
	}
}

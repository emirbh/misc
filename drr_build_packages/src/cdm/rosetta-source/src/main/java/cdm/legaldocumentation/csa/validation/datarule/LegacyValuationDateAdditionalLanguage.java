package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.LegacyValuationDate;
import cdm.legaldocumentation.csa.ValuationDateDateEnum;
import cdm.legaldocumentation.csa.ValuationDateFrequencyEnum;
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
@RosettaDataRule("LegacyValuationDateAdditionalLanguage")
@ImplementedBy(LegacyValuationDateAdditionalLanguage.Default.class)
public interface LegacyValuationDateAdditionalLanguage extends Validator<LegacyValuationDate> {
	
	String NAME = "LegacyValuationDateAdditionalLanguage";
	String DEFINITION = "if date is absent or frequency is absent then additionalLanguage exists";
	
	class Default implements LegacyValuationDateAdditionalLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyValuationDate legacyValuationDate) {
			ComparisonResult result = executeDataRule(legacyValuationDate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegacyValuationDate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LegacyValuationDate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LegacyValuationDate legacyValuationDate) {
			try {
				if (notExists(MapperS.of(legacyValuationDate).<ValuationDateDateEnum>map("getDate", _legacyValuationDate -> _legacyValuationDate.getDate())).orNullSafe(notExists(MapperS.of(legacyValuationDate).<ValuationDateFrequencyEnum>map("getFrequency", _legacyValuationDate -> _legacyValuationDate.getFrequency()))).getOrDefault(false)) {
					return exists(MapperS.of(legacyValuationDate).<String>map("getAdditionalLanguage", _legacyValuationDate -> _legacyValuationDate.getAdditionalLanguage()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LegacyValuationDateAdditionalLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyValuationDate legacyValuationDate) {
			return Collections.emptyList();
		}
	}
}

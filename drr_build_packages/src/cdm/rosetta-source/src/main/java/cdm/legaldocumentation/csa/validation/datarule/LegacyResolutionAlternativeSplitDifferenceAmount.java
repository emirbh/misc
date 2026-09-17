package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.LegacyResolutionAlternative;
import cdm.legaldocumentation.csa.LegacyResolutionAlternativeEnum;
import cdm.observable.asset.Money;
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
@RosettaDataRule("LegacyResolutionAlternativeSplitDifferenceAmount")
@ImplementedBy(LegacyResolutionAlternativeSplitDifferenceAmount.Default.class)
public interface LegacyResolutionAlternativeSplitDifferenceAmount extends Validator<LegacyResolutionAlternative> {
	
	String NAME = "LegacyResolutionAlternativeSplitDifferenceAmount";
	String DEFINITION = "if resolutionAlternative = LegacyResolutionAlternativeEnum -> SplitDifference then amount exists";
	
	class Default implements LegacyResolutionAlternativeSplitDifferenceAmount {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyResolutionAlternative legacyResolutionAlternative) {
			ComparisonResult result = executeDataRule(legacyResolutionAlternative);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegacyResolutionAlternative", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LegacyResolutionAlternative", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LegacyResolutionAlternative legacyResolutionAlternative) {
			try {
				if (areEqual(MapperS.of(legacyResolutionAlternative).<LegacyResolutionAlternativeEnum>map("getResolutionAlternative", _legacyResolutionAlternative -> _legacyResolutionAlternative.getResolutionAlternative()), MapperS.of(LegacyResolutionAlternativeEnum.SPLIT_DIFFERENCE), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(legacyResolutionAlternative).<Money>map("getAmount", _legacyResolutionAlternative -> _legacyResolutionAlternative.getAmount()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LegacyResolutionAlternativeSplitDifferenceAmount {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyResolutionAlternative legacyResolutionAlternative) {
			return Collections.emptyList();
		}
	}
}

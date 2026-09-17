package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.FallbackReferencePrice;
import cdm.observable.asset.ValuationPostponement;
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
@RosettaDataRule("FallbackReferencePriceMaximumDaysOfPostponement")
@ImplementedBy(FallbackReferencePriceMaximumDaysOfPostponement.Default.class)
public interface FallbackReferencePriceMaximumDaysOfPostponement extends Validator<FallbackReferencePrice> {
	
	String NAME = "FallbackReferencePriceMaximumDaysOfPostponement";
	String DEFINITION = "if valuationPostponement exists then valuationPostponement -> maximumDaysOfPostponement > 0";
	
	class Default implements FallbackReferencePriceMaximumDaysOfPostponement {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FallbackReferencePrice fallbackReferencePrice) {
			ComparisonResult result = executeDataRule(fallbackReferencePrice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FallbackReferencePrice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FallbackReferencePrice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FallbackReferencePrice fallbackReferencePrice) {
			try {
				if (exists(MapperS.of(fallbackReferencePrice).<ValuationPostponement>map("getValuationPostponement", _fallbackReferencePrice -> _fallbackReferencePrice.getValuationPostponement())).getOrDefault(false)) {
					return greaterThan(MapperS.of(fallbackReferencePrice).<ValuationPostponement>map("getValuationPostponement", _fallbackReferencePrice -> _fallbackReferencePrice.getValuationPostponement()).<Integer>map("getMaximumDaysOfPostponement", valuationPostponement -> valuationPostponement.getMaximumDaysOfPostponement()), MapperS.of(0), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FallbackReferencePriceMaximumDaysOfPostponement {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FallbackReferencePrice fallbackReferencePrice) {
			return Collections.emptyList();
		}
	}
}

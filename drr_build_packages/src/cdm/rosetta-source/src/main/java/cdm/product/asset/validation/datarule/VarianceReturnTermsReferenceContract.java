package cdm.product.asset.validation.datarule;

import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.ValuationTerms;
import cdm.product.asset.VarianceReturnTerms;
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
@RosettaDataRule("VarianceReturnTermsReferenceContract")
@ImplementedBy(VarianceReturnTermsReferenceContract.Default.class)
public interface VarianceReturnTermsReferenceContract extends Validator<VarianceReturnTerms> {
	
	String NAME = "VarianceReturnTermsReferenceContract";
	String DEFINITION = "if valuationTerms -> futuresPriceValuation = True then exchangeTradedContractNearest exists";
	
	class Default implements VarianceReturnTermsReferenceContract {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceReturnTerms varianceReturnTerms) {
			ComparisonResult result = executeDataRule(varianceReturnTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "VarianceReturnTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "VarianceReturnTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(VarianceReturnTerms varianceReturnTerms) {
			try {
				if (areEqual(MapperS.of(varianceReturnTerms).<ValuationTerms>map("getValuationTerms", _varianceReturnTerms -> _varianceReturnTerms.getValuationTerms()).<Boolean>map("getFuturesPriceValuation", valuationTerms -> valuationTerms.getFuturesPriceValuation()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(varianceReturnTerms).<ReferenceWithMetaObservable>map("getExchangeTradedContractNearest", _varianceReturnTerms -> _varianceReturnTerms.getExchangeTradedContractNearest()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements VarianceReturnTermsReferenceContract {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceReturnTerms varianceReturnTerms) {
			return Collections.emptyList();
		}
	}
}

package cdm.product.asset.validation.datarule;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.ListedDerivative;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.VarianceReturnTerms;
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
@RosettaDataRule("VarianceReturnTermsUnderlierMustBeListedDerivative")
@ImplementedBy(VarianceReturnTermsUnderlierMustBeListedDerivative.Default.class)
public interface VarianceReturnTermsUnderlierMustBeListedDerivative extends Validator<VarianceReturnTerms> {
	
	String NAME = "VarianceReturnTermsUnderlierMustBeListedDerivative";
	String DEFINITION = "if exchangeTradedContractNearest exists then exchangeTradedContractNearest -> Asset -> Instrument -> ListedDerivative exists";
	
	class Default implements VarianceReturnTermsUnderlierMustBeListedDerivative {
	
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
				if (exists(MapperS.of(varianceReturnTerms).<ReferenceWithMetaObservable>map("getExchangeTradedContractNearest", _varianceReturnTerms -> _varianceReturnTerms.getExchangeTradedContractNearest())).getOrDefault(false)) {
					return exists(MapperS.of(varianceReturnTerms).<ReferenceWithMetaObservable>map("getExchangeTradedContractNearest", _varianceReturnTerms -> _varianceReturnTerms.getExchangeTradedContractNearest()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<ListedDerivative>map("getListedDerivative", instrument -> instrument.getListedDerivative()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements VarianceReturnTermsUnderlierMustBeListedDerivative {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceReturnTerms varianceReturnTerms) {
			return Collections.emptyList();
		}
	}
}

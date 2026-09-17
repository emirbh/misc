package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.legaldocumentation.transaction.additionalterms.FxDualExchangeRate;
import cdm.observable.asset.FallbackReferencePrice;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxDualExchangeRateValidator implements Validator<FxDualExchangeRate> {

	private List<ComparisonResult> getComparisonResults(FxDualExchangeRate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dualExchangeRateIsApplicable", (Boolean) o.getDualExchangeRateIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("fallbackReferencePrice", (FallbackReferencePrice) o.getFallbackReferencePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("escrowArrangement", (EscrowArrangement) o.getEscrowArrangement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDualExchangeRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxDualExchangeRate", ValidationResult.ValidationType.CARDINALITY, "FxDualExchangeRate", path, "", res.getError());
				}
				return success("FxDualExchangeRate", ValidationResult.ValidationType.CARDINALITY, "FxDualExchangeRate", path, "");
			})
			.collect(toList());
	}

}

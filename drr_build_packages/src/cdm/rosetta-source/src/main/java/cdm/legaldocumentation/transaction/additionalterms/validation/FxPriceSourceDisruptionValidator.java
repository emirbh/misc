package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.legaldocumentation.transaction.additionalterms.FxPriceSourceDisruption;
import cdm.observable.asset.SettlementRateOption;
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

public class FxPriceSourceDisruptionValidator implements Validator<FxPriceSourceDisruption> {

	private List<ComparisonResult> getComparisonResults(FxPriceSourceDisruption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("priceSourceDisruptionIsApplicable", (Boolean) o.getPriceSourceDisruptionIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("fallbackReferencePrice", (SettlementRateOption) o.getFallbackReferencePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("escrowArrangement", (EscrowArrangement) o.getEscrowArrangement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxPriceSourceDisruption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxPriceSourceDisruption", ValidationResult.ValidationType.CARDINALITY, "FxPriceSourceDisruption", path, "", res.getError());
				}
				return success("FxPriceSourceDisruption", ValidationResult.ValidationType.CARDINALITY, "FxPriceSourceDisruption", path, "");
			})
			.collect(toList());
	}

}

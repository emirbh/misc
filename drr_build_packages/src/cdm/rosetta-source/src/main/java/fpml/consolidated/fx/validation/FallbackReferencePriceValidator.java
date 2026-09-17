package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FallbackReferencePrice;
import fpml.consolidated.shared.SettlementRateOption;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FallbackReferencePriceValidator implements Validator<FallbackReferencePrice> {

	private List<ComparisonResult> getComparisonResults(FallbackReferencePrice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("primaryRateSource", (SettlementRateOption) o.getPrimaryRateSource() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FallbackReferencePrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FallbackReferencePrice", ValidationResult.ValidationType.CARDINALITY, "FallbackReferencePrice", path, "", res.getError());
				}
				return success("FallbackReferencePrice", ValidationResult.ValidationType.CARDINALITY, "FallbackReferencePrice", path, "");
			})
			.collect(toList());
	}

}

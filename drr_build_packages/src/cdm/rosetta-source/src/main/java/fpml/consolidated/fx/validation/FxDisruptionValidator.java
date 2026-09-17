package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxDisruption;
import fpml.consolidated.shared.Currency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxDisruptionValidator implements Validator<FxDisruption> {

	private List<ComparisonResult> getComparisonResults(FxDisruption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("baseCurrency", (Currency) o.getBaseCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("referenceCurrency", (Currency) o.getReferenceCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDisruption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxDisruption", ValidationResult.ValidationType.CARDINALITY, "FxDisruption", path, "", res.getError());
				}
				return success("FxDisruption", ValidationResult.ValidationType.CARDINALITY, "FxDisruption", path, "");
			})
			.collect(toList());
	}

}

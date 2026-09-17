package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.FxConversion;
import fpml.consolidated.shared.AmountReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxConversionValidator implements Validator<FxConversion> {

	private List<ComparisonResult> getComparisonResults(FxConversion o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amountRelativeTo", (AmountReference) o.getAmountRelativeTo() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxConversion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxConversion", ValidationResult.ValidationType.CARDINALITY, "FxConversion", path, "", res.getError());
				}
				return success("FxConversion", ValidationResult.ValidationType.CARDINALITY, "FxConversion", path, "");
			})
			.collect(toList());
	}

}

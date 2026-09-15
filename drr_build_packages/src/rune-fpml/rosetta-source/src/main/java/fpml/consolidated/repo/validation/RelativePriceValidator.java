package fpml.consolidated.repo.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.RelativePrice;
import fpml.consolidated.repo.RelativePriceChoice;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RelativePriceValidator implements Validator<RelativePrice> {

	private List<ComparisonResult> getComparisonResults(RelativePrice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("spread", (BigDecimal) o.getSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativePriceChoice", (List<? extends RelativePriceChoice>) o.getRelativePriceChoice() == null ? 0 : o.getRelativePriceChoice().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelativePrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RelativePrice", ValidationResult.ValidationType.CARDINALITY, "RelativePrice", path, "", res.getError());
				}
				return success("RelativePrice", ValidationResult.ValidationType.CARDINALITY, "RelativePrice", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.IndexChange;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class IndexChangeValidator implements Validator<IndexChange> {

	private List<ComparisonResult> getComparisonResults(IndexChange o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("indexFactor", (BigDecimal) o.getIndexFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("factoredCalculationAmount", (Money) o.getFactoredCalculationAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IndexChange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IndexChange", ValidationResult.ValidationType.CARDINALITY, "IndexChange", path, "", res.getError());
				}
				return success("IndexChange", ValidationResult.ValidationType.CARDINALITY, "IndexChange", path, "");
			})
			.collect(toList());
	}

}

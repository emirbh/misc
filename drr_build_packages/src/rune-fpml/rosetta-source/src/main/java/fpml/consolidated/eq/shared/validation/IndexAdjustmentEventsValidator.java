package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.IndexAdjustmentEvents;
import fpml.consolidated.fpmlenum.IndexEventConsequenceEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class IndexAdjustmentEventsValidator implements Validator<IndexAdjustmentEvents> {

	private List<ComparisonResult> getComparisonResults(IndexAdjustmentEvents o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("indexModification", (IndexEventConsequenceEnum) o.getIndexModification() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexCancellation", (IndexEventConsequenceEnum) o.getIndexCancellation() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexDisruption", (IndexEventConsequenceEnum) o.getIndexDisruption() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IndexAdjustmentEvents o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IndexAdjustmentEvents", ValidationResult.ValidationType.CARDINALITY, "IndexAdjustmentEvents", path, "", res.getError());
				}
				return success("IndexAdjustmentEvents", ValidationResult.ValidationType.CARDINALITY, "IndexAdjustmentEvents", path, "");
			})
			.collect(toList());
	}

}

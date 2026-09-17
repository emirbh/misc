package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.additionalterms.IndexAdjustmentEvents;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class IndexAdjustmentEventsTypeFormatValidator implements Validator<IndexAdjustmentEvents> {

	private List<ComparisonResult> getComparisonResults(IndexAdjustmentEvents o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IndexAdjustmentEvents o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IndexAdjustmentEvents", ValidationResult.ValidationType.TYPE_FORMAT, "IndexAdjustmentEvents", path, "", res.getError());
				}
				return success("IndexAdjustmentEvents", ValidationResult.ValidationType.TYPE_FORMAT, "IndexAdjustmentEvents", path, "");
			})
			.collect(toList());
	}

}

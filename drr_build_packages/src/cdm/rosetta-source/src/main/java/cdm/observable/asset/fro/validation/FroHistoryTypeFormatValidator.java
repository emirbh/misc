package cdm.observable.asset.fro.validation;

import cdm.observable.asset.fro.FroHistory;
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

public class FroHistoryTypeFormatValidator implements Validator<FroHistory> {

	private List<ComparisonResult> getComparisonResults(FroHistory o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FroHistory o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FroHistory", ValidationResult.ValidationType.TYPE_FORMAT, "FroHistory", path, "", res.getError());
				}
				return success("FroHistory", ValidationResult.ValidationType.TYPE_FORMAT, "FroHistory", path, "");
			})
			.collect(toList());
	}

}

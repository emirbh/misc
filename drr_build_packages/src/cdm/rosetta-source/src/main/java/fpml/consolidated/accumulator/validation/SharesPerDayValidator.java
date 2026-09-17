package fpml.consolidated.accumulator.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.accumulator.SharesPerDay;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SharesPerDayValidator implements Validator<SharesPerDay> {

	private List<ComparisonResult> getComparisonResults(SharesPerDay o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SharesPerDay o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SharesPerDay", ValidationResult.ValidationType.CARDINALITY, "SharesPerDay", path, "", res.getError());
				}
				return success("SharesPerDay", ValidationResult.ValidationType.CARDINALITY, "SharesPerDay", path, "");
			})
			.collect(toList());
	}

}

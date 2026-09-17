package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.MutuallyAgreedClearinghouse;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MutuallyAgreedClearinghouseTypeFormatValidator implements Validator<MutuallyAgreedClearinghouse> {

	private List<ComparisonResult> getComparisonResults(MutuallyAgreedClearinghouse o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MutuallyAgreedClearinghouse o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MutuallyAgreedClearinghouse", ValidationResult.ValidationType.TYPE_FORMAT, "MutuallyAgreedClearinghouse", path, "", res.getError());
				}
				return success("MutuallyAgreedClearinghouse", ValidationResult.ValidationType.TYPE_FORMAT, "MutuallyAgreedClearinghouse", path, "");
			})
			.collect(toList());
	}

}

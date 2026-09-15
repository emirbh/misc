package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LcAccrual;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LcAccrualTypeFormatValidator implements Validator<LcAccrual> {

	private List<ComparisonResult> getComparisonResults(LcAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LcAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LcAccrual", ValidationResult.ValidationType.TYPE_FORMAT, "LcAccrual", path, "", res.getError());
				}
				return success("LcAccrual", ValidationResult.ValidationType.TYPE_FORMAT, "LcAccrual", path, "");
			})
			.collect(toList());
	}

}

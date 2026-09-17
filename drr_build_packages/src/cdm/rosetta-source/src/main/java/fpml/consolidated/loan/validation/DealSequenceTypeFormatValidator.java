package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.DealSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DealSequenceTypeFormatValidator implements Validator<DealSequence> {

	private List<ComparisonResult> getComparisonResults(DealSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DealSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DealSequence", ValidationResult.ValidationType.TYPE_FORMAT, "DealSequence", path, "", res.getError());
				}
				return success("DealSequence", ValidationResult.ValidationType.TYPE_FORMAT, "DealSequence", path, "");
			})
			.collect(toList());
	}

}

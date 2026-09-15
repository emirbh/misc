package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.PartySelector;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartySelectorTypeFormatValidator implements Validator<PartySelector> {

	private List<ComparisonResult> getComparisonResults(PartySelector o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartySelector o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartySelector", ValidationResult.ValidationType.TYPE_FORMAT, "PartySelector", path, "", res.getError());
				}
				return success("PartySelector", ValidationResult.ValidationType.TYPE_FORMAT, "PartySelector", path, "");
			})
			.collect(toList());
	}

}

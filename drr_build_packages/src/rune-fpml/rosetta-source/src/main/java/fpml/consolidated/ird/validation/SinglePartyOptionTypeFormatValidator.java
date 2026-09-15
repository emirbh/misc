package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.SinglePartyOption;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SinglePartyOptionTypeFormatValidator implements Validator<SinglePartyOption> {

	private List<ComparisonResult> getComparisonResults(SinglePartyOption o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SinglePartyOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SinglePartyOption", ValidationResult.ValidationType.TYPE_FORMAT, "SinglePartyOption", path, "", res.getError());
				}
				return success("SinglePartyOption", ValidationResult.ValidationType.TYPE_FORMAT, "SinglePartyOption", path, "");
			})
			.collect(toList());
	}

}

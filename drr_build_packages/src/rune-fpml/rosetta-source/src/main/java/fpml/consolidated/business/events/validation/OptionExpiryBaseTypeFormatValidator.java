package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.OptionExpiryBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OptionExpiryBaseTypeFormatValidator implements Validator<OptionExpiryBase> {

	private List<ComparisonResult> getComparisonResults(OptionExpiryBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExpiryBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExpiryBase", ValidationResult.ValidationType.TYPE_FORMAT, "OptionExpiryBase", path, "", res.getError());
				}
				return success("OptionExpiryBase", ValidationResult.ValidationType.TYPE_FORMAT, "OptionExpiryBase", path, "");
			})
			.collect(toList());
	}

}

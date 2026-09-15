package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.NotifyingParty;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NotifyingPartyTypeFormatValidator implements Validator<NotifyingParty> {

	private List<ComparisonResult> getComparisonResults(NotifyingParty o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotifyingParty o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotifyingParty", ValidationResult.ValidationType.TYPE_FORMAT, "NotifyingParty", path, "", res.getError());
				}
				return success("NotifyingParty", ValidationResult.ValidationType.TYPE_FORMAT, "NotifyingParty", path, "");
			})
			.collect(toList());
	}

}

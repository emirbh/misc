package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.RelatedParty;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RelatedPartyTypeFormatValidator implements Validator<RelatedParty> {

	private List<ComparisonResult> getComparisonResults(RelatedParty o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelatedParty o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RelatedParty", ValidationResult.ValidationType.TYPE_FORMAT, "RelatedParty", path, "", res.getError());
				}
				return success("RelatedParty", ValidationResult.ValidationType.TYPE_FORMAT, "RelatedParty", path, "");
			})
			.collect(toList());
	}

}

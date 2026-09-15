package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.SECPartyInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SECPartyInformationTypeFormatValidator implements Validator<SECPartyInformation> {

	private List<ComparisonResult> getComparisonResults(SECPartyInformation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECPartyInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SECPartyInformation", ValidationResult.ValidationType.TYPE_FORMAT, "SECPartyInformation", path, "", res.getError());
				}
				return success("SECPartyInformation", ValidationResult.ValidationType.TYPE_FORMAT, "SECPartyInformation", path, "");
			})
			.collect(toList());
	}

}

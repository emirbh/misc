package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.ASICPartyInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ASICPartyInformationTypeFormatValidator implements Validator<ASICPartyInformation> {

	private List<ComparisonResult> getComparisonResults(ASICPartyInformation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICPartyInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ASICPartyInformation", ValidationResult.ValidationType.TYPE_FORMAT, "ASICPartyInformation", path, "", res.getError());
				}
				return success("ASICPartyInformation", ValidationResult.ValidationType.TYPE_FORMAT, "ASICPartyInformation", path, "");
			})
			.collect(toList());
	}

}

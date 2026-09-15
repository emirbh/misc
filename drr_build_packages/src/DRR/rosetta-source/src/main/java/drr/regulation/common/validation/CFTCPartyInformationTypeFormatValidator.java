package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.CFTCPartyInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CFTCPartyInformationTypeFormatValidator implements Validator<CFTCPartyInformation> {

	private List<ComparisonResult> getComparisonResults(CFTCPartyInformation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPartyInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CFTCPartyInformation", ValidationResult.ValidationType.TYPE_FORMAT, "CFTCPartyInformation", path, "", res.getError());
				}
				return success("CFTCPartyInformation", ValidationResult.ValidationType.TYPE_FORMAT, "CFTCPartyInformation", path, "");
			})
			.collect(toList());
	}

}

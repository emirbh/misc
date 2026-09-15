package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.CSAPartyInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CSAPartyInformationTypeFormatValidator implements Validator<CSAPartyInformation> {

	private List<ComparisonResult> getComparisonResults(CSAPartyInformation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAPartyInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CSAPartyInformation", ValidationResult.ValidationType.TYPE_FORMAT, "CSAPartyInformation", path, "", res.getError());
				}
				return success("CSAPartyInformation", ValidationResult.ValidationType.TYPE_FORMAT, "CSAPartyInformation", path, "");
			})
			.collect(toList());
	}

}

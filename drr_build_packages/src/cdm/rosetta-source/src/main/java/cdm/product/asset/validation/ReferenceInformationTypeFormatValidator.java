package cdm.product.asset.validation;

import cdm.product.asset.ReferenceInformation;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReferenceInformationTypeFormatValidator implements Validator<ReferenceInformation> {

	private List<ComparisonResult> getComparisonResults(ReferenceInformation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferenceInformation", ValidationResult.ValidationType.TYPE_FORMAT, "ReferenceInformation", path, "", res.getError());
				}
				return success("ReferenceInformation", ValidationResult.ValidationType.TYPE_FORMAT, "ReferenceInformation", path, "");
			})
			.collect(toList());
	}

}

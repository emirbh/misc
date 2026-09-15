package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BusinessCentersReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BusinessCentersReferenceTypeFormatValidator implements Validator<BusinessCentersReference> {

	private List<ComparisonResult> getComparisonResults(BusinessCentersReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessCentersReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BusinessCentersReference", ValidationResult.ValidationType.TYPE_FORMAT, "BusinessCentersReference", path, "", res.getError());
				}
				return success("BusinessCentersReference", ValidationResult.ValidationType.TYPE_FORMAT, "BusinessCentersReference", path, "");
			})
			.collect(toList());
	}

}

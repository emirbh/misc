package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BusinessUnitReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BusinessUnitReferenceTypeFormatValidator implements Validator<BusinessUnitReference> {

	private List<ComparisonResult> getComparisonResults(BusinessUnitReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessUnitReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BusinessUnitReference", ValidationResult.ValidationType.TYPE_FORMAT, "BusinessUnitReference", path, "", res.getError());
				}
				return success("BusinessUnitReference", ValidationResult.ValidationType.TYPE_FORMAT, "BusinessUnitReference", path, "");
			})
			.collect(toList());
	}

}

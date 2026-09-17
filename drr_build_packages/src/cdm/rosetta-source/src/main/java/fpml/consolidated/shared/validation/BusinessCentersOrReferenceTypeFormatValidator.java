package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BusinessCentersOrReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BusinessCentersOrReferenceTypeFormatValidator implements Validator<BusinessCentersOrReference> {

	private List<ComparisonResult> getComparisonResults(BusinessCentersOrReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessCentersOrReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BusinessCentersOrReference", ValidationResult.ValidationType.TYPE_FORMAT, "BusinessCentersOrReference", path, "", res.getError());
				}
				return success("BusinessCentersOrReference", ValidationResult.ValidationType.TYPE_FORMAT, "BusinessCentersOrReference", path, "");
			})
			.collect(toList());
	}

}

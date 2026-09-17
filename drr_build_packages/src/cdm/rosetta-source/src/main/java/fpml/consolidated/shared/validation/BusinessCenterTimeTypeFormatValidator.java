package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BusinessCenterTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BusinessCenterTimeTypeFormatValidator implements Validator<BusinessCenterTime> {

	private List<ComparisonResult> getComparisonResults(BusinessCenterTime o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessCenterTime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BusinessCenterTime", ValidationResult.ValidationType.TYPE_FORMAT, "BusinessCenterTime", path, "", res.getError());
				}
				return success("BusinessCenterTime", ValidationResult.ValidationType.TYPE_FORMAT, "BusinessCenterTime", path, "");
			})
			.collect(toList());
	}

}

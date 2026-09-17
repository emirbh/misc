package cdm.base.datetime.validation;

import cdm.base.datetime.BusinessDayAdjustments;
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

public class BusinessDayAdjustmentsTypeFormatValidator implements Validator<BusinessDayAdjustments> {

	private List<ComparisonResult> getComparisonResults(BusinessDayAdjustments o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessDayAdjustments o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BusinessDayAdjustments", ValidationResult.ValidationType.TYPE_FORMAT, "BusinessDayAdjustments", path, "", res.getError());
				}
				return success("BusinessDayAdjustments", ValidationResult.ValidationType.TYPE_FORMAT, "BusinessDayAdjustments", path, "");
			})
			.collect(toList());
	}

}

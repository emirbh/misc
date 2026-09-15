package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BusinessDayAdjustmentsReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BusinessDayAdjustmentsReferenceValidator implements Validator<BusinessDayAdjustmentsReference> {

	private List<ComparisonResult> getComparisonResults(BusinessDayAdjustmentsReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessDayAdjustmentsReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BusinessDayAdjustmentsReference", ValidationResult.ValidationType.CARDINALITY, "BusinessDayAdjustmentsReference", path, "", res.getError());
				}
				return success("BusinessDayAdjustmentsReference", ValidationResult.ValidationType.CARDINALITY, "BusinessDayAdjustmentsReference", path, "");
			})
			.collect(toList());
	}

}

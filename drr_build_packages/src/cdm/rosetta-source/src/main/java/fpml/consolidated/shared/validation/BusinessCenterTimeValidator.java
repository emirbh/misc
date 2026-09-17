package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.BusinessCenterTime;
import java.time.LocalTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BusinessCenterTimeValidator implements Validator<BusinessCenterTime> {

	private List<ComparisonResult> getComparisonResults(BusinessCenterTime o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("hourMinuteTime", (LocalTime) o.getHourMinuteTime() != null ? 1 : 0, 1, 1), 
				checkCardinality("businessCenter", (BusinessCenter) o.getBusinessCenter() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessCenterTime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BusinessCenterTime", ValidationResult.ValidationType.CARDINALITY, "BusinessCenterTime", path, "", res.getError());
				}
				return success("BusinessCenterTime", ValidationResult.ValidationType.CARDINALITY, "BusinessCenterTime", path, "");
			})
			.collect(toList());
	}

}

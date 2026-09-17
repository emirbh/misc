package cdm.observable.asset.fro.validation;

import cdm.observable.asset.fro.BusinessDayOffset;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class BusinessDayOffsetTypeFormatValidator implements Validator<BusinessDayOffset> {

	private List<ComparisonResult> getComparisonResults(BusinessDayOffset o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("periodMultiplier", o.getPeriodMultiplier(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessDayOffset o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BusinessDayOffset", ValidationResult.ValidationType.TYPE_FORMAT, "BusinessDayOffset", path, "", res.getError());
				}
				return success("BusinessDayOffset", ValidationResult.ValidationType.TYPE_FORMAT, "BusinessDayOffset", path, "");
			})
			.collect(toList());
	}

}

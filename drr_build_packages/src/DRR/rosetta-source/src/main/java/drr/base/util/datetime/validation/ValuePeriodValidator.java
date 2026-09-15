package drr.base.util.datetime.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.util.datetime.ValuePeriod;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ValuePeriodValidator implements Validator<ValuePeriod> {

	private List<ComparisonResult> getComparisonResults(ValuePeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("effectiveDate", (Date) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("endDate", (Date) o.getEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("value", (BigDecimal) o.getValue() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuePeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuePeriod", ValidationResult.ValidationType.CARDINALITY, "ValuePeriod", path, "", res.getError());
				}
				return success("ValuePeriod", ValidationResult.ValidationType.CARDINALITY, "ValuePeriod", path, "");
			})
			.collect(toList());
	}

}

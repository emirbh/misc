package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.DatePeriod1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DatePeriod1Validator implements Validator<DatePeriod1> {

	private List<ComparisonResult> getComparisonResults(DatePeriod1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("frDt", (Date) o.getFrDt() != null ? 1 : 0, 0, 1), 
				checkCardinality("toDt", (Date) o.getToDt() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DatePeriod1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DatePeriod1", ValidationResult.ValidationType.CARDINALITY, "DatePeriod1", path, "", res.getError());
				}
				return success("DatePeriod1", ValidationResult.ValidationType.CARDINALITY, "DatePeriod1", path, "");
			})
			.collect(toList());
	}

}

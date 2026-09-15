package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.Schedule1;
import iso20022.auth030.esma.SecuritiesTransactionPrice17Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class Schedule1Validator implements Validator<Schedule1> {

	private List<ComparisonResult> getComparisonResults(Schedule1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("uadjstdFctvDt", (Date) o.getUadjstdFctvDt() != null ? 1 : 0, 1, 1), 
				checkCardinality("uadjstdEndDt", (Date) o.getUadjstdEndDt() != null ? 1 : 0, 0, 1), 
				checkCardinality("pric", (SecuritiesTransactionPrice17Choice) o.getPric() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Schedule1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Schedule1", ValidationResult.ValidationType.CARDINALITY, "Schedule1", path, "", res.getError());
				}
				return success("Schedule1", ValidationResult.ValidationType.CARDINALITY, "Schedule1", path, "");
			})
			.collect(toList());
	}

}

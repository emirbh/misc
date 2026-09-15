package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.Schedule10__1;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class Schedule10__1Validator implements Validator<Schedule10__1> {

	private List<ComparisonResult> getComparisonResults(Schedule10__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("qty", (BigDecimal) o.getQty() != null ? 1 : 0, 1, 1), 
				checkCardinality("uadjstdFctvDt", (Date) o.getUadjstdFctvDt() != null ? 1 : 0, 1, 1), 
				checkCardinality("uadjstdEndDt", (Date) o.getUadjstdEndDt() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Schedule10__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Schedule10__1", ValidationResult.ValidationType.CARDINALITY, "Schedule10__1", path, "", res.getError());
				}
				return success("Schedule10__1", ValidationResult.ValidationType.CARDINALITY, "Schedule10__1", path, "");
			})
			.collect(toList());
	}

}

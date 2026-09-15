package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.Schedule10__1;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class Schedule10__1TypeFormatValidator implements Validator<Schedule10__1> {

	private List<ComparisonResult> getComparisonResults(Schedule10__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("qty", o.getQty(), of(25), of(5), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Schedule10__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Schedule10__1", ValidationResult.ValidationType.TYPE_FORMAT, "Schedule10__1", path, "", res.getError());
				}
				return success("Schedule10__1", ValidationResult.ValidationType.TYPE_FORMAT, "Schedule10__1", path, "");
			})
			.collect(toList());
	}

}

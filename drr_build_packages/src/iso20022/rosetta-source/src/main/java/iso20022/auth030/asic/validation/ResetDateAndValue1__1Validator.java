package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.ResetDateAndValue1__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ResetDateAndValue1__1Validator implements Validator<ResetDateAndValue1__1> {

	private List<ComparisonResult> getComparisonResults(ResetDateAndValue1__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dt", (Date) o.getDt() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ResetDateAndValue1__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ResetDateAndValue1__1", ValidationResult.ValidationType.CARDINALITY, "ResetDateAndValue1__1", path, "", res.getError());
				}
				return success("ResetDateAndValue1__1", ValidationResult.ValidationType.CARDINALITY, "ResetDateAndValue1__1", path, "");
			})
			.collect(toList());
	}

}

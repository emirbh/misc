package cdm.observable.asset.validation;

import cdm.observable.asset.SingleValuationDate;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SingleValuationDateValidator implements Validator<SingleValuationDate> {

	private List<ComparisonResult> getComparisonResults(SingleValuationDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("businessDays", (Integer) o.getBusinessDays() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SingleValuationDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SingleValuationDate", ValidationResult.ValidationType.CARDINALITY, "SingleValuationDate", path, "", res.getError());
				}
				return success("SingleValuationDate", ValidationResult.ValidationType.CARDINALITY, "SingleValuationDate", path, "");
			})
			.collect(toList());
	}

}

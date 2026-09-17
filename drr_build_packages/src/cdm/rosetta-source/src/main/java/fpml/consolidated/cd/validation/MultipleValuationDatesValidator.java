package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.MultipleValuationDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MultipleValuationDatesValidator implements Validator<MultipleValuationDates> {

	private List<ComparisonResult> getComparisonResults(MultipleValuationDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("businessDays", (Integer) o.getBusinessDays() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessDaysThereafter", (Integer) o.getBusinessDaysThereafter() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberValuationDates", (Integer) o.getNumberValuationDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultipleValuationDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MultipleValuationDates", ValidationResult.ValidationType.CARDINALITY, "MultipleValuationDates", path, "", res.getError());
				}
				return success("MultipleValuationDates", ValidationResult.ValidationType.CARDINALITY, "MultipleValuationDates", path, "");
			})
			.collect(toList());
	}

}

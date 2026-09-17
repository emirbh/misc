package cdm.base.datetime.validation;

import cdm.base.datetime.AdjustableDates;
import cdm.base.datetime.BusinessDayAdjustments;
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

public class AdjustableDatesValidator implements Validator<AdjustableDates> {

	private List<ComparisonResult> getComparisonResults(AdjustableDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateAdjustments", (BusinessDayAdjustments) o.getDateAdjustments() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustableDates", ValidationResult.ValidationType.CARDINALITY, "AdjustableDates", path, "", res.getError());
				}
				return success("AdjustableDates", ValidationResult.ValidationType.CARDINALITY, "AdjustableDates", path, "");
			})
			.collect(toList());
	}

}

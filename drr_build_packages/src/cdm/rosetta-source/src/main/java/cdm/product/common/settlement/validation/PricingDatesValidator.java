package cdm.product.common.settlement.validation;

import cdm.product.common.schedule.ParametricDates;
import cdm.product.common.settlement.PricingDates;
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

public class PricingDatesValidator implements Validator<PricingDates> {

	private List<ComparisonResult> getComparisonResults(PricingDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("parametricDates", (ParametricDates) o.getParametricDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingDates", ValidationResult.ValidationType.CARDINALITY, "PricingDates", path, "", res.getError());
				}
				return success("PricingDates", ValidationResult.ValidationType.CARDINALITY, "PricingDates", path, "");
			})
			.collect(toList());
	}

}

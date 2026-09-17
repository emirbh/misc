package cdm.observable.asset.validation;

import cdm.observable.asset.ValuationPostponement;
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

public class ValuationPostponementValidator implements Validator<ValuationPostponement> {

	private List<ComparisonResult> getComparisonResults(ValuationPostponement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("maximumDaysOfPostponement", (Integer) o.getMaximumDaysOfPostponement() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationPostponement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationPostponement", ValidationResult.ValidationType.CARDINALITY, "ValuationPostponement", path, "", res.getError());
				}
				return success("ValuationPostponement", ValidationResult.ValidationType.CARDINALITY, "ValuationPostponement", path, "");
			})
			.collect(toList());
	}

}

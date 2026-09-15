package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.SettlementPostponement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SettlementPostponementValidator implements Validator<SettlementPostponement> {

	private List<ComparisonResult> getComparisonResults(SettlementPostponement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("maximumNumberOfDays", (Integer) o.getMaximumNumberOfDays() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPostponement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPostponement", ValidationResult.ValidationType.CARDINALITY, "SettlementPostponement", path, "", res.getError());
				}
				return success("SettlementPostponement", ValidationResult.ValidationType.CARDINALITY, "SettlementPostponement", path, "");
			})
			.collect(toList());
	}

}

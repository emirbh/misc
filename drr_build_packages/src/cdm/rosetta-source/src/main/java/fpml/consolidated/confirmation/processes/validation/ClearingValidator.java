package fpml.consolidated.confirmation.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.confirmation.processes.Clearing;
import fpml.consolidated.confirmation.processes.TradeWrapper;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ClearingValidator implements Validator<Clearing> {

	private List<ComparisonResult> getComparisonResults(Clearing o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("submitted", (TradeWrapper) o.getSubmitted() != null ? 1 : 0, 1, 1), 
				checkCardinality("cleared", (List<? extends TradeWrapper>) o.getCleared() == null ? 0 : o.getCleared().size(), 2, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Clearing o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Clearing", ValidationResult.ValidationType.CARDINALITY, "Clearing", path, "", res.getError());
				}
				return success("Clearing", ValidationResult.ValidationType.CARDINALITY, "Clearing", path, "");
			})
			.collect(toList());
	}

}

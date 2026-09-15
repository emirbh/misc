package fpml.consolidated.credit.event.notification.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.credit.event.notification.ObligationDefault;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ObligationDefaultValidator implements Validator<ObligationDefault> {

	private List<ComparisonResult> getComparisonResults(ObligationDefault o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObligationDefault o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObligationDefault", ValidationResult.ValidationType.CARDINALITY, "ObligationDefault", path, "", res.getError());
				}
				return success("ObligationDefault", ValidationResult.ValidationType.CARDINALITY, "ObligationDefault", path, "");
			})
			.collect(toList());
	}

}

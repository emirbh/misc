package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.RoutingIds;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RoutingIdsValidator implements Validator<RoutingIds> {

	private List<ComparisonResult> getComparisonResults(RoutingIds o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RoutingIds o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RoutingIds", ValidationResult.ValidationType.CARDINALITY, "RoutingIds", path, "", res.getError());
				}
				return success("RoutingIds", ValidationResult.ValidationType.CARDINALITY, "RoutingIds", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.Address;
import fpml.consolidated.shared.RoutingExplicitDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RoutingExplicitDetailsValidator implements Validator<RoutingExplicitDetails> {

	private List<ComparisonResult> getComparisonResults(RoutingExplicitDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("routingName", (String) o.getRoutingName() != null ? 1 : 0, 0, 1), 
				checkCardinality("routingAddress", (Address) o.getRoutingAddress() != null ? 1 : 0, 0, 1), 
				checkCardinality("routingAccountNumber", (String) o.getRoutingAccountNumber() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RoutingExplicitDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RoutingExplicitDetails", ValidationResult.ValidationType.CARDINALITY, "RoutingExplicitDetails", path, "", res.getError());
				}
				return success("RoutingExplicitDetails", ValidationResult.ValidationType.CARDINALITY, "RoutingExplicitDetails", path, "");
			})
			.collect(toList());
	}

}

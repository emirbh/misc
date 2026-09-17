package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.RoutingIdsAndExplicitDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class RoutingIdsAndExplicitDetailsTypeFormatValidator implements Validator<RoutingIdsAndExplicitDetails> {

	private List<ComparisonResult> getComparisonResults(RoutingIdsAndExplicitDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("routingName", o.getRoutingName(), 0, of(255), empty()), 
				checkString("routingAccountNumber", o.getRoutingAccountNumber(), 1, empty(), empty()), 
				checkString("routingReferenceText", o.getRoutingReferenceText(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RoutingIdsAndExplicitDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RoutingIdsAndExplicitDetails", ValidationResult.ValidationType.TYPE_FORMAT, "RoutingIdsAndExplicitDetails", path, "", res.getError());
				}
				return success("RoutingIdsAndExplicitDetails", ValidationResult.ValidationType.TYPE_FORMAT, "RoutingIdsAndExplicitDetails", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.RoutingExplicitDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class RoutingExplicitDetailsTypeFormatValidator implements Validator<RoutingExplicitDetails> {

	private List<ComparisonResult> getComparisonResults(RoutingExplicitDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("routingName", o.getRoutingName(), 0, of(255), empty()), 
				checkString("routingAccountNumber", o.getRoutingAccountNumber(), 1, empty(), empty()), 
				checkString("routingReferenceText", o.getRoutingReferenceText(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RoutingExplicitDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RoutingExplicitDetails", ValidationResult.ValidationType.TYPE_FORMAT, "RoutingExplicitDetails", path, "", res.getError());
				}
				return success("RoutingExplicitDetails", ValidationResult.ValidationType.TYPE_FORMAT, "RoutingExplicitDetails", path, "");
			})
			.collect(toList());
	}

}

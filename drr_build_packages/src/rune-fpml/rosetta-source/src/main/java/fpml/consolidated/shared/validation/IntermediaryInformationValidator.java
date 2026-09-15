package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.IntermediaryInformation;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RoutingExplicitDetails;
import fpml.consolidated.shared.RoutingIds;
import fpml.consolidated.shared.RoutingIdsAndExplicitDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class IntermediaryInformationValidator implements Validator<IntermediaryInformation> {

	private List<ComparisonResult> getComparisonResults(IntermediaryInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("routingIds", (RoutingIds) o.getRoutingIds() != null ? 1 : 0, 0, 1), 
				checkCardinality("routingExplicitDetails", (RoutingExplicitDetails) o.getRoutingExplicitDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("routingIdsAndExplicitDetails", (RoutingIdsAndExplicitDetails) o.getRoutingIdsAndExplicitDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("intermediarySequenceNumber", (Integer) o.getIntermediarySequenceNumber() != null ? 1 : 0, 0, 1), 
				checkCardinality("intermediaryPartyReference", (PartyReference) o.getIntermediaryPartyReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IntermediaryInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IntermediaryInformation", ValidationResult.ValidationType.CARDINALITY, "IntermediaryInformation", path, "", res.getError());
				}
				return success("IntermediaryInformation", ValidationResult.ValidationType.CARDINALITY, "IntermediaryInformation", path, "");
			})
			.collect(toList());
	}

}

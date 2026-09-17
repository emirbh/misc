package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.CorrespondentInformation;
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

public class CorrespondentInformationValidator implements Validator<CorrespondentInformation> {

	private List<ComparisonResult> getComparisonResults(CorrespondentInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("routingIds", (RoutingIds) o.getRoutingIds() != null ? 1 : 0, 0, 1), 
				checkCardinality("routingExplicitDetails", (RoutingExplicitDetails) o.getRoutingExplicitDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("routingIdsAndExplicitDetails", (RoutingIdsAndExplicitDetails) o.getRoutingIdsAndExplicitDetails() != null ? 1 : 0, 0, 1), 
				checkCardinality("correspondentPartyReference", (PartyReference) o.getCorrespondentPartyReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrespondentInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CorrespondentInformation", ValidationResult.ValidationType.CARDINALITY, "CorrespondentInformation", path, "", res.getError());
				}
				return success("CorrespondentInformation", ValidationResult.ValidationType.CARDINALITY, "CorrespondentInformation", path, "");
			})
			.collect(toList());
	}

}

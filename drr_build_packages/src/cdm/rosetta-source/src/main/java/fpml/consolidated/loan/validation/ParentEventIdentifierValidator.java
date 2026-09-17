package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.business.events.EventId;
import fpml.consolidated.loan.ParentEventIdentifier;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ParentEventIdentifierValidator implements Validator<ParentEventIdentifier> {

	private List<ComparisonResult> getComparisonResults(ParentEventIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("accountReference", (AccountReference) o.getAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventId", (EventId) o.getEventId() != null ? 1 : 0, 1, 1), 
				checkCardinality("childEventIdentifier", (List<? extends BusinessEventIdentifier>) o.getChildEventIdentifier() == null ? 0 : o.getChildEventIdentifier().size(), 2, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ParentEventIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ParentEventIdentifier", ValidationResult.ValidationType.CARDINALITY, "ParentEventIdentifier", path, "", res.getError());
				}
				return success("ParentEventIdentifier", ValidationResult.ValidationType.CARDINALITY, "ParentEventIdentifier", path, "");
			})
			.collect(toList());
	}

}

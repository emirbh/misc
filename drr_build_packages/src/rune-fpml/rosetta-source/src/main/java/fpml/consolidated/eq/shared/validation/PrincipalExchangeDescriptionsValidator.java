package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.PrincipalExchangeAmount;
import fpml.consolidated.eq.shared.PrincipalExchangeDescriptions;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PrincipalExchangeDescriptionsValidator implements Validator<PrincipalExchangeDescriptions> {

	private List<ComparisonResult> getComparisonResults(PrincipalExchangeDescriptions o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("payerAccountReference", (AccountReference) o.getPayerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverPartyReference", (PartyReference) o.getReceiverPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("receiverAccountReference", (AccountReference) o.getReceiverAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("principalExchangeAmount", (PrincipalExchangeAmount) o.getPrincipalExchangeAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("principalExchangeDate", (AdjustableOrRelativeDate) o.getPrincipalExchangeDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalExchangeDescriptions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrincipalExchangeDescriptions", ValidationResult.ValidationType.CARDINALITY, "PrincipalExchangeDescriptions", path, "", res.getError());
				}
				return success("PrincipalExchangeDescriptions", ValidationResult.ValidationType.CARDINALITY, "PrincipalExchangeDescriptions", path, "");
			})
			.collect(toList());
	}

}

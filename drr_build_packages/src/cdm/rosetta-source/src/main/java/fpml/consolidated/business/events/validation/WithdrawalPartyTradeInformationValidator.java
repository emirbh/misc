package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.WithdrawalPartyTradeInformation;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class WithdrawalPartyTradeInformationValidator implements Validator<WithdrawalPartyTradeInformation> {

	private List<ComparisonResult> getComparisonResults(WithdrawalPartyTradeInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("accountReference", (AccountReference) o.getAccountReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WithdrawalPartyTradeInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WithdrawalPartyTradeInformation", ValidationResult.ValidationType.CARDINALITY, "WithdrawalPartyTradeInformation", path, "", res.getError());
				}
				return success("WithdrawalPartyTradeInformation", ValidationResult.ValidationType.CARDINALITY, "WithdrawalPartyTradeInformation", path, "");
			})
			.collect(toList());
	}

}

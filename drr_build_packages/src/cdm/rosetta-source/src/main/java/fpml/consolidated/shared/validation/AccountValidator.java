package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountName;
import fpml.consolidated.shared.AccountType;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AccountValidator implements Validator<Account> {

	private List<ComparisonResult> getComparisonResults(Account o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 1, 1), 
				checkCardinality("accountName", (AccountName) o.getAccountName() != null ? 1 : 0, 0, 1), 
				checkCardinality("accountType", (AccountType) o.getAccountType() != null ? 1 : 0, 0, 1), 
				checkCardinality("accountBeneficiary", (PartyReference) o.getAccountBeneficiary() != null ? 1 : 0, 0, 1), 
				checkCardinality("servicingParty", (PartyReference) o.getServicingParty() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Account o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Account", ValidationResult.ValidationType.CARDINALITY, "Account", path, "", res.getError());
				}
				return success("Account", ValidationResult.ValidationType.CARDINALITY, "Account", path, "");
			})
			.collect(toList());
	}

}

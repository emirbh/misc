package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.LegalEntity;
import cdm.legaldocumentation.csa.CustodianElection;
import cdm.legaldocumentation.csa.LegacyVMCustodianEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CustodianElectionValidator implements Validator<CustodianElection> {

	private List<ComparisonResult> getComparisonResults(CustodianElection o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (CounterpartyRoleEnum) o.getParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("custodian", (LegalEntity) o.getCustodian() != null ? 1 : 0, 0, 1), 
				checkCardinality("segregatedCashAccount", (Account) o.getSegregatedCashAccount() != null ? 1 : 0, 0, 1), 
				checkCardinality("segregatedSecurityAccount", (Account) o.getSegregatedSecurityAccount() != null ? 1 : 0, 0, 1), 
				checkCardinality("legacyVMCustodian", (LegacyVMCustodianEnum) o.getLegacyVMCustodian() != null ? 1 : 0, 0, 1), 
				checkCardinality("legacyNamedEntity", (LegalEntity) o.getLegacyNamedEntity() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalLanguage", (String) o.getAdditionalLanguage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustodianElection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CustodianElection", ValidationResult.ValidationType.CARDINALITY, "CustodianElection", path, "", res.getError());
				}
				return success("CustodianElection", ValidationResult.ValidationType.CARDINALITY, "CustodianElection", path, "");
			})
			.collect(toList());
	}

}

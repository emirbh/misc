package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.transaction.Clause;
import cdm.legaldocumentation.transaction.additionalterms.DeterminationRoleEnum;
import cdm.legaldocumentation.transaction.additionalterms.DeterminationRolesAndTerms;
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

public class DeterminationRolesAndTermsValidator implements Validator<DeterminationRolesAndTerms> {

	private List<ComparisonResult> getComparisonResults(DeterminationRolesAndTerms o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("determinationRole", (DeterminationRoleEnum) o.getDeterminationRole() != null ? 1 : 0, 1, 1), 
				checkCardinality("whoToDetermine", (List<CounterpartyRoleEnum>) o.getWhoToDetermine() == null ? 0 : o.getWhoToDetermine().size(), 1, 2), 
				checkCardinality("disputingParty", (CounterpartyRoleEnum) o.getDisputingParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("fallbackLanguageBespokeTerms", (Clause) o.getFallbackLanguageBespokeTerms() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeterminationRolesAndTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DeterminationRolesAndTerms", ValidationResult.ValidationType.CARDINALITY, "DeterminationRolesAndTerms", path, "", res.getError());
				}
				return success("DeterminationRolesAndTerms", ValidationResult.ValidationType.CARDINALITY, "DeterminationRolesAndTerms", path, "");
			})
			.collect(toList());
	}

}

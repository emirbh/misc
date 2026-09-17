package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.SecurityInterestForObligations;
import cdm.legaldocumentation.csa.SecurityInterestObligationsEnum;
import cdm.legaldocumentation.csa.SecurityInterestObligeeEnum;
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

public class SecurityInterestForObligationsValidator implements Validator<SecurityInterestForObligations> {

	private List<ComparisonResult> getComparisonResults(SecurityInterestForObligations o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (List<CounterpartyRoleEnum>) o.getParty() == null ? 0 : o.getParty().size(), 2, 2), 
				checkCardinality("obligations", (SecurityInterestObligationsEnum) o.getObligations() != null ? 1 : 0, 1, 1), 
				checkCardinality("obligee", (SecurityInterestObligeeEnum) o.getObligee() != null ? 1 : 0, 1, 1), 
				checkCardinality("other", (String) o.getOther() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityInterestForObligations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecurityInterestForObligations", ValidationResult.ValidationType.CARDINALITY, "SecurityInterestForObligations", path, "", res.getError());
				}
				return success("SecurityInterestForObligations", ValidationResult.ValidationType.CARDINALITY, "SecurityInterestForObligations", path, "");
			})
			.collect(toList());
	}

}

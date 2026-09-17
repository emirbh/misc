package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.SecuredPartyRightsEventElection;
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

public class SecuredPartyRightsEventElectionValidator implements Validator<SecuredPartyRightsEventElection> {

	private List<ComparisonResult> getComparisonResults(SecuredPartyRightsEventElection o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (CounterpartyRoleEnum) o.getParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("rightsEvent", (Boolean) o.getRightsEvent() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecuredPartyRightsEventElection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecuredPartyRightsEventElection", ValidationResult.ValidationType.CARDINALITY, "SecuredPartyRightsEventElection", path, "", res.getError());
				}
				return success("SecuredPartyRightsEventElection", ValidationResult.ValidationType.CARDINALITY, "SecuredPartyRightsEventElection", path, "");
			})
			.collect(toList());
	}

}

package cdm.product.collateral.validation;

import cdm.base.staticdata.party.PartyContactInformation;
import cdm.product.collateral.ContactElection;
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

public class ContactElectionValidator implements Validator<ContactElection> {

	private List<ComparisonResult> getComparisonResults(ContactElection o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyElection", (List<? extends PartyContactInformation>) o.getPartyElection() == null ? 0 : o.getPartyElection().size(), 2, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContactElection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContactElection", ValidationResult.ValidationType.CARDINALITY, "ContactElection", path, "", res.getError());
				}
				return success("ContactElection", ValidationResult.ValidationType.CARDINALITY, "ContactElection", path, "");
			})
			.collect(toList());
	}

}

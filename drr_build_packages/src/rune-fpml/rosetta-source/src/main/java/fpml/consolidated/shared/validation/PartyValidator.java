package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.ContactInformation;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyGroupType;
import fpml.consolidated.shared.PartyName;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyValidator implements Validator<Party> {

	private List<ComparisonResult> getComparisonResults(Party o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyName", (PartyName) o.getPartyName() != null ? 1 : 0, 0, 1), 
				checkCardinality("country", (CountryCode) o.getCountry() != null ? 1 : 0, 0, 1), 
				checkCardinality("contactInfo", (ContactInformation) o.getContactInfo() != null ? 1 : 0, 0, 1), 
				checkCardinality("groupType", (PartyGroupType) o.getGroupType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Party o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Party", ValidationResult.ValidationType.CARDINALITY, "Party", path, "", res.getError());
				}
				return success("Party", ValidationResult.ValidationType.CARDINALITY, "Party", path, "");
			})
			.collect(toList());
	}

}

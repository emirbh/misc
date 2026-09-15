package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.PartyProfile;
import fpml.consolidated.loan.PartyProfileChoice;
import fpml.consolidated.loan.PartyProfileDocumentation;
import fpml.consolidated.loan.PartyProfileIdentifier;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyProfileValidator implements Validator<PartyProfile> {

	private List<ComparisonResult> getComparisonResults(PartyProfile o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyProfileIdentifier", (List<? extends PartyProfileIdentifier>) o.getPartyProfileIdentifier() == null ? 0 : o.getPartyProfileIdentifier().size(), 1, 0), 
				checkCardinality("effectiveDate", (ZonedDateTime) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("documentation", (PartyProfileDocumentation) o.getDocumentation() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyProfileChoice", (List<? extends PartyProfileChoice>) o.getPartyProfileChoice() == null ? 0 : o.getPartyProfileChoice().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyProfile o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyProfile", ValidationResult.ValidationType.CARDINALITY, "PartyProfile", path, "", res.getError());
				}
				return success("PartyProfile", ValidationResult.ValidationType.CARDINALITY, "PartyProfile", path, "");
			})
			.collect(toList());
	}

}

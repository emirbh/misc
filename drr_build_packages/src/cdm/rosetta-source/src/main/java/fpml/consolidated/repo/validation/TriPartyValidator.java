package fpml.consolidated.repo.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.CollateralProfile;
import fpml.consolidated.repo.CollateralType;
import fpml.consolidated.repo.TriParty;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TriPartyValidator implements Validator<TriParty> {

	private List<ComparisonResult> getComparisonResults(TriParty o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("triPartyAgent", (PartyReference) o.getTriPartyAgent() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralProfile", (CollateralProfile) o.getCollateralProfile() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralType", (CollateralType) o.getCollateralType() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryByValue", (Boolean) o.getDeliveryByValue() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TriParty o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TriParty", ValidationResult.ValidationType.CARDINALITY, "TriParty", path, "", res.getError());
				}
				return success("TriParty", ValidationResult.ValidationType.CARDINALITY, "TriParty", path, "");
			})
			.collect(toList());
	}

}

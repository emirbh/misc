package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AssociationToAssetId;
import fpml.consolidated.loan.AssociationToAssetIdentifier;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssociationToAssetIdentifierValidator implements Validator<AssociationToAssetIdentifier> {

	private List<ComparisonResult> getComparisonResults(AssociationToAssetIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("associationId", (AssociationToAssetId) o.getAssociationId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssociationToAssetIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssociationToAssetIdentifier", ValidationResult.ValidationType.CARDINALITY, "AssociationToAssetIdentifier", path, "", res.getError());
				}
				return success("AssociationToAssetIdentifier", ValidationResult.ValidationType.CARDINALITY, "AssociationToAssetIdentifier", path, "");
			})
			.collect(toList());
	}

}

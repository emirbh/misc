package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.EntityClassification;
import fpml.consolidated.doc.PartyEntityClassification;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyEntityClassificationValidator implements Validator<PartyEntityClassification> {

	private List<ComparisonResult> getComparisonResults(PartyEntityClassification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("entityClassification", (EntityClassification) o.getEntityClassification() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyEntityClassification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyEntityClassification", ValidationResult.ValidationType.CARDINALITY, "PartyEntityClassification", path, "", res.getError());
				}
				return success("PartyEntityClassification", ValidationResult.ValidationType.CARDINALITY, "PartyEntityClassification", path, "");
			})
			.collect(toList());
	}

}

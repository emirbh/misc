package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.EntityType;
import fpml.consolidated.cd.ReferenceObligation;
import fpml.consolidated.cd.ReferencePair;
import fpml.consolidated.shared.LegalEntity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReferencePairValidator implements Validator<ReferencePair> {

	private List<ComparisonResult> getComparisonResults(ReferencePair o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceEntity", (LegalEntity) o.getReferenceEntity() != null ? 1 : 0, 0, 1), 
				checkCardinality("referenceObligation", (ReferenceObligation) o.getReferenceObligation() != null ? 1 : 0, 0, 1), 
				checkCardinality("noReferenceObligation", (Boolean) o.getNoReferenceObligation() != null ? 1 : 0, 0, 1), 
				checkCardinality("entityType", (EntityType) o.getEntityType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferencePair o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferencePair", ValidationResult.ValidationType.CARDINALITY, "ReferencePair", path, "", res.getError());
				}
				return success("ReferencePair", ValidationResult.ValidationType.CARDINALITY, "ReferencePair", path, "");
			})
			.collect(toList());
	}

}

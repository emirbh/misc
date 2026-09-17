package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.PersonReference;
import fpml.consolidated.shared.PersonRole;
import fpml.consolidated.shared.RelatedPerson;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RelatedPersonValidator implements Validator<RelatedPerson> {

	private List<ComparisonResult> getComparisonResults(RelatedPerson o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("personReference", (PersonReference) o.getPersonReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("role", (PersonRole) o.getRole() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelatedPerson o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RelatedPerson", ValidationResult.ValidationType.CARDINALITY, "RelatedPerson", path, "", res.getError());
				}
				return success("RelatedPerson", ValidationResult.ValidationType.CARDINALITY, "RelatedPerson", path, "");
			})
			.collect(toList());
	}

}

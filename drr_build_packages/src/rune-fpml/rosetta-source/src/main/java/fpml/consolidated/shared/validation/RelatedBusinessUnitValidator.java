package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.BusinessUnitReference;
import fpml.consolidated.shared.BusinessUnitRole;
import fpml.consolidated.shared.RelatedBusinessUnit;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RelatedBusinessUnitValidator implements Validator<RelatedBusinessUnit> {

	private List<ComparisonResult> getComparisonResults(RelatedBusinessUnit o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("businessUnitReference", (BusinessUnitReference) o.getBusinessUnitReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("role", (BusinessUnitRole) o.getRole() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelatedBusinessUnit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RelatedBusinessUnit", ValidationResult.ValidationType.CARDINALITY, "RelatedBusinessUnit", path, "", res.getError());
				}
				return success("RelatedBusinessUnit", ValidationResult.ValidationType.CARDINALITY, "RelatedBusinessUnit", path, "");
			})
			.collect(toList());
	}

}

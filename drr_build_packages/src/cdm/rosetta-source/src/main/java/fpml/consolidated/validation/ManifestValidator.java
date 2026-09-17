package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.Manifest;
import fpml.consolidated.ReferenceType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ManifestValidator implements Validator<Manifest> {

	private List<ComparisonResult> getComparisonResults(Manifest o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("reference", (List<? extends ReferenceType>) o.getReference() == null ? 0 : o.getReference().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Manifest o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Manifest", ValidationResult.ValidationType.CARDINALITY, "Manifest", path, "", res.getError());
				}
				return success("Manifest", ValidationResult.ValidationType.CARDINALITY, "Manifest", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ObjectType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ObjectTypeValidator implements Validator<ObjectType> {

	private List<ComparisonResult> getComparisonResults(ObjectType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("mimeType", (String) o.getMimeType() != null ? 1 : 0, 0, 1), 
				checkCardinality("encoding", (String) o.getEncoding() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObjectType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObjectType", ValidationResult.ValidationType.CARDINALITY, "ObjectType", path, "", res.getError());
				}
				return success("ObjectType", ValidationResult.ValidationType.CARDINALITY, "ObjectType", path, "");
			})
			.collect(toList());
	}

}

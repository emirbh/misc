package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.DigestMethodType;
import fpml.consolidated.ReferenceType;
import fpml.consolidated.TransformsType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReferenceTypeValidator implements Validator<ReferenceType> {

	private List<ComparisonResult> getComparisonResults(ReferenceType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("uri", (String) o.getUri() != null ? 1 : 0, 0, 1), 
				checkCardinality("type", (String) o._getType() != null ? 1 : 0, 0, 1), 
				checkCardinality("transforms", (TransformsType) o.getTransforms() != null ? 1 : 0, 0, 1), 
				checkCardinality("digestMethod", (DigestMethodType) o.getDigestMethod() != null ? 1 : 0, 1, 1), 
				checkCardinality("digestValue", (String) o.getDigestValue() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferenceType", ValidationResult.ValidationType.CARDINALITY, "ReferenceType", path, "", res.getError());
				}
				return success("ReferenceType", ValidationResult.ValidationType.CARDINALITY, "ReferenceType", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.DSAKeyValueType;
import fpml.consolidated.KeyValueType;
import fpml.consolidated.RSAKeyValueType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class KeyValueTypeValidator implements Validator<KeyValueType> {

	private List<ComparisonResult> getComparisonResults(KeyValueType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dsaKeyValue", (DSAKeyValueType) o.getDsaKeyValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("rsaKeyValue", (RSAKeyValueType) o.getRsaKeyValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("anyContents", (String) o.getAnyContents() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, KeyValueType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("KeyValueType", ValidationResult.ValidationType.CARDINALITY, "KeyValueType", path, "", res.getError());
				}
				return success("KeyValueType", ValidationResult.ValidationType.CARDINALITY, "KeyValueType", path, "");
			})
			.collect(toList());
	}

}

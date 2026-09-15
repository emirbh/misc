package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.DSAKeyValueType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DSAKeyValueTypeValidator implements Validator<DSAKeyValueType> {

	private List<ComparisonResult> getComparisonResults(DSAKeyValueType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("p", (String) o.getP() != null ? 1 : 0, 0, 1), 
				checkCardinality("q", (String) o.getQ() != null ? 1 : 0, 0, 1), 
				checkCardinality("g", (String) o.getG() != null ? 1 : 0, 0, 1), 
				checkCardinality("y", (String) o.getY() != null ? 1 : 0, 1, 1), 
				checkCardinality("j", (String) o.getJ() != null ? 1 : 0, 0, 1), 
				checkCardinality("seed", (String) o.getSeed() != null ? 1 : 0, 0, 1), 
				checkCardinality("pgenCounter", (String) o.getPgenCounter() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DSAKeyValueType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DSAKeyValueType", ValidationResult.ValidationType.CARDINALITY, "DSAKeyValueType", path, "", res.getError());
				}
				return success("DSAKeyValueType", ValidationResult.ValidationType.CARDINALITY, "DSAKeyValueType", path, "");
			})
			.collect(toList());
	}

}

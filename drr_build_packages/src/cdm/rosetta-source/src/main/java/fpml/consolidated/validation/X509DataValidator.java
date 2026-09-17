package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.X509Data;
import fpml.consolidated.X509DataTypeSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class X509DataValidator implements Validator<X509Data> {

	private List<ComparisonResult> getComparisonResults(X509Data o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("x509DataTypeSequence", (List<? extends X509DataTypeSequence>) o.getX509DataTypeSequence() == null ? 0 : o.getX509DataTypeSequence().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, X509Data o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("X509Data", ValidationResult.ValidationType.CARDINALITY, "X509Data", path, "", res.getError());
				}
				return success("X509Data", ValidationResult.ValidationType.CARDINALITY, "X509Data", path, "");
			})
			.collect(toList());
	}

}

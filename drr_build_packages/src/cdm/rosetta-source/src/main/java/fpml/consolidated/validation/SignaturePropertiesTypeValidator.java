package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.SignaturePropertiesType;
import fpml.consolidated.SignaturePropertyType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SignaturePropertiesTypeValidator implements Validator<SignaturePropertiesType> {

	private List<ComparisonResult> getComparisonResults(SignaturePropertiesType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("signatureProperty", (List<? extends SignaturePropertyType>) o.getSignatureProperty() == null ? 0 : o.getSignatureProperty().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SignaturePropertiesType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SignaturePropertiesType", ValidationResult.ValidationType.CARDINALITY, "SignaturePropertiesType", path, "", res.getError());
				}
				return success("SignaturePropertiesType", ValidationResult.ValidationType.CARDINALITY, "SignaturePropertiesType", path, "");
			})
			.collect(toList());
	}

}

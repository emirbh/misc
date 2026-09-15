package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.SignaturePropertyType;
import fpml.consolidated.SignaturePropertyTypeChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SignaturePropertyTypeValidator implements Validator<SignaturePropertyType> {

	private List<ComparisonResult> getComparisonResults(SignaturePropertyType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("target", (String) o.getTarget() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("signaturePropertyTypeChoice", (List<? extends SignaturePropertyTypeChoice>) o.getSignaturePropertyTypeChoice() == null ? 0 : o.getSignaturePropertyTypeChoice().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SignaturePropertyType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SignaturePropertyType", ValidationResult.ValidationType.CARDINALITY, "SignaturePropertyType", path, "", res.getError());
				}
				return success("SignaturePropertyType", ValidationResult.ValidationType.CARDINALITY, "SignaturePropertyType", path, "");
			})
			.collect(toList());
	}

}

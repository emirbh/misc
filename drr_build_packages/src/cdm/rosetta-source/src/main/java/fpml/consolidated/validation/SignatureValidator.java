package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.KeyInfoType;
import fpml.consolidated.Signature;
import fpml.consolidated.SignatureValueType;
import fpml.consolidated.SignedInfoType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SignatureValidator implements Validator<Signature> {

	private List<ComparisonResult> getComparisonResults(Signature o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("signedInfo", (SignedInfoType) o.getSignedInfo() != null ? 1 : 0, 1, 1), 
				checkCardinality("signatureValue", (SignatureValueType) o.getSignatureValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("keyInfo", (KeyInfoType) o.getKeyInfo() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Signature o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Signature", ValidationResult.ValidationType.CARDINALITY, "Signature", path, "", res.getError());
				}
				return success("Signature", ValidationResult.ValidationType.CARDINALITY, "Signature", path, "");
			})
			.collect(toList());
	}

}

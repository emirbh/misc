package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.CanonicalizationMethodType;
import fpml.consolidated.ReferenceType;
import fpml.consolidated.SignatureMethodType;
import fpml.consolidated.SignedInfo;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SignedInfoValidator implements Validator<SignedInfo> {

	private List<ComparisonResult> getComparisonResults(SignedInfo o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("canonicalizationMethod", (CanonicalizationMethodType) o.getCanonicalizationMethod() != null ? 1 : 0, 1, 1), 
				checkCardinality("signatureMethod", (SignatureMethodType) o.getSignatureMethod() != null ? 1 : 0, 1, 1), 
				checkCardinality("reference", (List<? extends ReferenceType>) o.getReference() == null ? 0 : o.getReference().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SignedInfo o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SignedInfo", ValidationResult.ValidationType.CARDINALITY, "SignedInfo", path, "", res.getError());
				}
				return success("SignedInfo", ValidationResult.ValidationType.CARDINALITY, "SignedInfo", path, "");
			})
			.collect(toList());
	}

}

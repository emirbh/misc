package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.ClearingPartyAndTime21Choice__2;
import iso20022.auth030.jfsa.ClearingPartyAndTime22__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ClearingPartyAndTime21Choice__2Validator implements Validator<ClearingPartyAndTime21Choice__2> {

	private List<ComparisonResult> getComparisonResults(ClearingPartyAndTime21Choice__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dtls", (ClearingPartyAndTime22__2) o.getDtls() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingPartyAndTime21Choice__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingPartyAndTime21Choice__2", ValidationResult.ValidationType.CARDINALITY, "ClearingPartyAndTime21Choice__2", path, "", res.getError());
				}
				return success("ClearingPartyAndTime21Choice__2", ValidationResult.ValidationType.CARDINALITY, "ClearingPartyAndTime21Choice__2", path, "");
			})
			.collect(toList());
	}

}

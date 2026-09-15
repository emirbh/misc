package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.ClearingPartyAndTime22Choice__1;
import iso20022.auth030.asic.ClearingPartyAndTime23__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ClearingPartyAndTime22Choice__1Validator implements Validator<ClearingPartyAndTime22Choice__1> {

	private List<ComparisonResult> getComparisonResults(ClearingPartyAndTime22Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dtls", (ClearingPartyAndTime23__1) o.getDtls() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingPartyAndTime22Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingPartyAndTime22Choice__1", ValidationResult.ValidationType.CARDINALITY, "ClearingPartyAndTime22Choice__1", path, "", res.getError());
				}
				return success("ClearingPartyAndTime22Choice__1", ValidationResult.ValidationType.CARDINALITY, "ClearingPartyAndTime22Choice__1", path, "");
			})
			.collect(toList());
	}

}

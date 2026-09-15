package iso20022.auth030.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.mas.SecurityIdentification46__3;
import iso20022.auth030.mas.UniqueProductIdentifier2Choice__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecurityIdentification46__3Validator implements Validator<SecurityIdentification46__3> {

	private List<ComparisonResult> getComparisonResults(SecurityIdentification46__3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("unqPdctIdr", (UniqueProductIdentifier2Choice__2) o.getUnqPdctIdr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityIdentification46__3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecurityIdentification46__3", ValidationResult.ValidationType.CARDINALITY, "SecurityIdentification46__3", path, "", res.getError());
				}
				return success("SecurityIdentification46__3", ValidationResult.ValidationType.CARDINALITY, "SecurityIdentification46__3", path, "");
			})
			.collect(toList());
	}

}

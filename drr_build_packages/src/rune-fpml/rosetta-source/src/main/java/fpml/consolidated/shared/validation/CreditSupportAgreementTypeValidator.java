package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.CreditSupportAgreementType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditSupportAgreementTypeValidator implements Validator<CreditSupportAgreementType> {

	private List<ComparisonResult> getComparisonResults(CreditSupportAgreementType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditSupportAgreementTypeScheme", (String) o.getCreditSupportAgreementTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportAgreementType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditSupportAgreementType", ValidationResult.ValidationType.CARDINALITY, "CreditSupportAgreementType", path, "", res.getError());
				}
				return success("CreditSupportAgreementType", ValidationResult.ValidationType.CARDINALITY, "CreditSupportAgreementType", path, "");
			})
			.collect(toList());
	}

}

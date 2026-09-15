package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.CreditSupportAgreement;
import fpml.consolidated.shared.CreditSupportAgreementIdentifier;
import fpml.consolidated.shared.CreditSupportAgreementType;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditSupportAgreementValidator implements Validator<CreditSupportAgreement> {

	private List<ComparisonResult> getComparisonResults(CreditSupportAgreement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("type", (CreditSupportAgreementType) o._getType() != null ? 1 : 0, 0, 1), 
				checkCardinality("date", (ZonedDateTime) o.getDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("identifier", (CreditSupportAgreementIdentifier) o.getIdentifier() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportAgreement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditSupportAgreement", ValidationResult.ValidationType.CARDINALITY, "CreditSupportAgreement", path, "", res.getError());
				}
				return success("CreditSupportAgreement", ValidationResult.ValidationType.CARDINALITY, "CreditSupportAgreement", path, "");
			})
			.collect(toList());
	}

}

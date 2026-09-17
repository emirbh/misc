package cdm.product.collateral.validation;

import cdm.base.staticdata.party.LegalEntity;
import cdm.product.collateral.IssuerName;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class IssuerNameValidator implements Validator<IssuerName> {

	private List<ComparisonResult> getComparisonResults(IssuerName o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuerName", (LegalEntity) o.getIssuerName() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IssuerName o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IssuerName", ValidationResult.ValidationType.CARDINALITY, "IssuerName", path, "", res.getError());
				}
				return success("IssuerName", ValidationResult.ValidationType.CARDINALITY, "IssuerName", path, "");
			})
			.collect(toList());
	}

}

package cdm.product.collateral.validation;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.product.collateral.IssuerCountryOfOrigin;
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

public class IssuerCountryOfOriginValidator implements Validator<IssuerCountryOfOrigin> {

	private List<ComparisonResult> getComparisonResults(IssuerCountryOfOrigin o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuerCountryOfOrigin", (ISOCountryCodeEnum) o.getIssuerCountryOfOrigin() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IssuerCountryOfOrigin o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IssuerCountryOfOrigin", ValidationResult.ValidationType.CARDINALITY, "IssuerCountryOfOrigin", path, "", res.getError());
				}
				return success("IssuerCountryOfOrigin", ValidationResult.ValidationType.CARDINALITY, "IssuerCountryOfOrigin", path, "");
			})
			.collect(toList());
	}

}

package cdm.product.asset.validation;

import cdm.product.asset.PriceReturnTerms;
import cdm.product.asset.ReturnTypeEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PriceReturnTermsValidator implements Validator<PriceReturnTerms> {

	private List<ComparisonResult> getComparisonResults(PriceReturnTerms o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("returnType", (ReturnTypeEnum) o.getReturnType() != null ? 1 : 0, 1, 1), 
				checkCardinality("conversionFactor", (BigDecimal) o.getConversionFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("performance", (String) o.getPerformance() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceReturnTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PriceReturnTerms", ValidationResult.ValidationType.CARDINALITY, "PriceReturnTerms", path, "", res.getError());
				}
				return success("PriceReturnTerms", ValidationResult.ValidationType.CARDINALITY, "PriceReturnTerms", path, "");
			})
			.collect(toList());
	}

}

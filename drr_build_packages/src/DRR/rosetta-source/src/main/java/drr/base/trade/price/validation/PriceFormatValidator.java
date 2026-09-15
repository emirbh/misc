package drr.base.trade.price.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PriceFormatValidator implements Validator<PriceFormat> {

	private List<ComparisonResult> getComparisonResults(PriceFormat o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("monetary", (BigDecimal) o.getMonetary() != null ? 1 : 0, 0, 1), 
				checkCardinality("decimal", (BigDecimal) o.getDecimal() != null ? 1 : 0, 0, 1), 
				checkCardinality("percentage", (BigDecimal) o.getPercentage() != null ? 1 : 0, 0, 1), 
				checkCardinality("basis", (BigDecimal) o.getBasis() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceFormat o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PriceFormat", ValidationResult.ValidationType.CARDINALITY, "PriceFormat", path, "", res.getError());
				}
				return success("PriceFormat", ValidationResult.ValidationType.CARDINALITY, "PriceFormat", path, "");
			})
			.collect(toList());
	}

}

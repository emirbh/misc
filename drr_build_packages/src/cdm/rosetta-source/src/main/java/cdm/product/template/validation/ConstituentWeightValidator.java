package cdm.product.template.validation;

import cdm.product.template.ConstituentWeight;
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

public class ConstituentWeightValidator implements Validator<ConstituentWeight> {

	private List<ComparisonResult> getComparisonResults(ConstituentWeight o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("openUnits", (BigDecimal) o.getOpenUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("basketPercentage", (BigDecimal) o.getBasketPercentage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConstituentWeight o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ConstituentWeight", ValidationResult.ValidationType.CARDINALITY, "ConstituentWeight", path, "", res.getError());
				}
				return success("ConstituentWeight", ValidationResult.ValidationType.CARDINALITY, "ConstituentWeight", path, "");
			})
			.collect(toList());
	}

}

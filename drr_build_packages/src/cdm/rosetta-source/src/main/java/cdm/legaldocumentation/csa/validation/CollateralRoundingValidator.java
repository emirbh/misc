package cdm.legaldocumentation.csa.validation;

import cdm.base.math.RoundingModeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.legaldocumentation.csa.CollateralRounding;
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

public class CollateralRoundingValidator implements Validator<CollateralRounding> {

	private List<ComparisonResult> getComparisonResults(CollateralRounding o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("deliveryAmount", (BigDecimal) o.getDeliveryAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryDirection", (RoundingModeEnum) o.getDeliveryDirection() != null ? 1 : 0, 1, 1), 
				checkCardinality("returnAmount", (BigDecimal) o.getReturnAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("returnDirection", (RoundingModeEnum) o.getReturnDirection() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (ISOCurrencyCodeEnum) o.getCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("other", (String) o.getOther() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralRounding o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralRounding", ValidationResult.ValidationType.CARDINALITY, "CollateralRounding", path, "", res.getError());
				}
				return success("CollateralRounding", ValidationResult.ValidationType.CARDINALITY, "CollateralRounding", path, "");
			})
			.collect(toList());
	}

}

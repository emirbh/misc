package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityTrigger;
import fpml.consolidated.fpmlenum.TriggerTypeEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityTriggerValidator implements Validator<CommodityTrigger> {

	private List<ComparisonResult> getComparisonResults(CommodityTrigger o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("levelQuantity", (BigDecimal) o.getLevelQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("levelUnit", (QuantityUnit) o.getLevelUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("levelPercentage", (BigDecimal) o.getLevelPercentage() != null ? 1 : 0, 0, 1), 
				checkCardinality("levelPrice", (CommodityFixedPrice) o.getLevelPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerType", (TriggerTypeEnum) o.getTriggerType() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityTrigger o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityTrigger", ValidationResult.ValidationType.CARDINALITY, "CommodityTrigger", path, "", res.getError());
				}
				return success("CommodityTrigger", ValidationResult.ValidationType.CARDINALITY, "CommodityTrigger", path, "");
			})
			.collect(toList());
	}

}

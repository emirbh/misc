package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityDigital;
import fpml.consolidated.com.CommodityTrigger;
import fpml.consolidated.shared.PositiveMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityDigitalValidator implements Validator<CommodityDigital> {

	private List<ComparisonResult> getComparisonResults(CommodityDigital o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("trigger", (CommodityTrigger) o.getTrigger() != null ? 1 : 0, 0, 1), 
				checkCardinality("featurePaymentAmount", (PositiveMoney) o.getFeaturePaymentAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDigital o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityDigital", ValidationResult.ValidationType.CARDINALITY, "CommodityDigital", path, "", res.getError());
				}
				return success("CommodityDigital", ValidationResult.ValidationType.CARDINALITY, "CommodityDigital", path, "");
			})
			.collect(toList());
	}

}

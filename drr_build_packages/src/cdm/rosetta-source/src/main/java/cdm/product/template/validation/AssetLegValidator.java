package cdm.product.template.validation;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.product.common.settlement.DeliveryMethodEnum;
import cdm.product.template.AssetLeg;
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

public class AssetLegValidator implements Validator<AssetLeg> {

	private List<ComparisonResult> getComparisonResults(AssetLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementDate", (AdjustableOrRelativeDate) o.getSettlementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryMethod", (DeliveryMethodEnum) o.getDeliveryMethod() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetLeg", ValidationResult.ValidationType.CARDINALITY, "AssetLeg", path, "", res.getError());
				}
				return success("AssetLeg", ValidationResult.ValidationType.CARDINALITY, "AssetLeg", path, "");
			})
			.collect(toList());
	}

}

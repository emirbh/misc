package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityBarrier;
import fpml.consolidated.com.CommodityTrigger;
import fpml.consolidated.fpmlenum.CommodityKnockEnum;
import fpml.consolidated.shared.PositiveMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityBarrierValidator implements Validator<CommodityBarrier> {

	private List<ComparisonResult> getComparisonResults(CommodityBarrier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("knock", (CommodityKnockEnum) o.getKnock() != null ? 1 : 0, 1, 1), 
				checkCardinality("featurePaymentAmount", (PositiveMoney) o.getFeaturePaymentAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("trigger", (CommodityTrigger) o.getTrigger() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBarrier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBarrier", ValidationResult.ValidationType.CARDINALITY, "CommodityBarrier", path, "", res.getError());
				}
				return success("CommodityBarrier", ValidationResult.ValidationType.CARDINALITY, "CommodityBarrier", path, "");
			})
			.collect(toList());
	}

}

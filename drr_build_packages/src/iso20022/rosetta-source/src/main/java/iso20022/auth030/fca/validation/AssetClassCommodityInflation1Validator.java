package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.AssetClassCommodityInflation1;
import iso20022.auth030.fca.AssetClassProductType12Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityInflation1Validator implements Validator<AssetClassCommodityInflation1> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityInflation1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType12Code) o.getBasePdct() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityInflation1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityInflation1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityInflation1", path, "", res.getError());
				}
				return success("AssetClassCommodityInflation1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityInflation1", path, "");
			})
			.collect(toList());
	}

}

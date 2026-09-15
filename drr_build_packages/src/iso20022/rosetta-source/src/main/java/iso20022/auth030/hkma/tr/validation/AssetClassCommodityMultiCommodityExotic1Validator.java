package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.AssetClassCommodityMultiCommodityExotic1;
import iso20022.auth030.hkma.tr.AssetClassProductType13Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityMultiCommodityExotic1Validator implements Validator<AssetClassCommodityMultiCommodityExotic1> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityMultiCommodityExotic1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType13Code) o.getBasePdct() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityMultiCommodityExotic1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityMultiCommodityExotic1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityMultiCommodityExotic1", path, "", res.getError());
				}
				return success("AssetClassCommodityMultiCommodityExotic1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityMultiCommodityExotic1", path, "");
			})
			.collect(toList());
	}

}

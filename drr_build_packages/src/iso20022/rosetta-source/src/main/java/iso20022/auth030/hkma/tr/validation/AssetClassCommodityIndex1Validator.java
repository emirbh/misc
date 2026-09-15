package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.AssetClassCommodityIndex1;
import iso20022.auth030.hkma.tr.AssetClassProductType16Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityIndex1Validator implements Validator<AssetClassCommodityIndex1> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityIndex1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType16Code) o.getBasePdct() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityIndex1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityIndex1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityIndex1", path, "", res.getError());
				}
				return success("AssetClassCommodityIndex1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityIndex1", path, "");
			})
			.collect(toList());
	}

}

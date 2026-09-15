package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityOther1;
import iso20022.auth030.hkma.dtcc.AssetClassProductType15Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityOther1Validator implements Validator<AssetClassCommodityOther1> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityOther1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType15Code) o.getBasePdct() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityOther1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityOther1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityOther1", path, "", res.getError());
				}
				return success("AssetClassCommodityOther1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityOther1", path, "");
			})
			.collect(toList());
	}

}

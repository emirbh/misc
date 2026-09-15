package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.AssetClassCommodityIndustrialProduct2Choice__1;
import iso20022.auth030.fca.IndustrialProductCommodityConstruction2__1;
import iso20022.auth030.fca.IndustrialProductCommodityManufacturing2__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityIndustrialProduct2Choice__1Validator implements Validator<AssetClassCommodityIndustrialProduct2Choice__1> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityIndustrialProduct2Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cnstrctn", (IndustrialProductCommodityConstruction2__1) o.getCnstrctn() != null ? 1 : 0, 0, 1), 
				checkCardinality("manfctg", (IndustrialProductCommodityManufacturing2__1) o.getManfctg() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityIndustrialProduct2Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityIndustrialProduct2Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityIndustrialProduct2Choice__1", path, "", res.getError());
				}
				return success("AssetClassCommodityIndustrialProduct2Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityIndustrialProduct2Choice__1", path, "");
			})
			.collect(toList());
	}

}

package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityIndustrialProduct2Choice;
import iso20022.auth030.hkma.dtcc.IndustrialProductCommodityConstruction2;
import iso20022.auth030.hkma.dtcc.IndustrialProductCommodityManufacturing2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityIndustrialProduct2ChoiceValidator implements Validator<AssetClassCommodityIndustrialProduct2Choice> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityIndustrialProduct2Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cnstrctn", (IndustrialProductCommodityConstruction2) o.getCnstrctn() != null ? 1 : 0, 0, 1), 
				checkCardinality("manfctg", (IndustrialProductCommodityManufacturing2) o.getManfctg() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityIndustrialProduct2Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityIndustrialProduct2Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityIndustrialProduct2Choice", path, "", res.getError());
				}
				return success("AssetClassCommodityIndustrialProduct2Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityIndustrialProduct2Choice", path, "");
			})
			.collect(toList());
	}

}

package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.AssetClassCommodityFreight4Choice__1;
import iso20022.auth030.fca.FreightCommodityContainerShip2__1;
import iso20022.auth030.fca.FreightCommodityDry3__1;
import iso20022.auth030.fca.FreightCommodityOther2__1;
import iso20022.auth030.fca.FreightCommodityWet3__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityFreight4Choice__1Validator implements Validator<AssetClassCommodityFreight4Choice__1> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityFreight4Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dry", (FreightCommodityDry3__1) o.getDry() != null ? 1 : 0, 0, 1), 
				checkCardinality("wet", (FreightCommodityWet3__1) o.getWet() != null ? 1 : 0, 0, 1), 
				checkCardinality("cntnrShip", (FreightCommodityContainerShip2__1) o.getCntnrShip() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (FreightCommodityOther2__1) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityFreight4Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityFreight4Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityFreight4Choice__1", path, "", res.getError());
				}
				return success("AssetClassCommodityFreight4Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityFreight4Choice__1", path, "");
			})
			.collect(toList());
	}

}

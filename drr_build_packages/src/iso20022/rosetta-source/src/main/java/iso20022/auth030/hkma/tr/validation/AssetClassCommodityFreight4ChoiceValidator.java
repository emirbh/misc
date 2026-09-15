package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.AssetClassCommodityFreight4Choice;
import iso20022.auth030.hkma.tr.FreightCommodityContainerShip2;
import iso20022.auth030.hkma.tr.FreightCommodityDry3;
import iso20022.auth030.hkma.tr.FreightCommodityOther2;
import iso20022.auth030.hkma.tr.FreightCommodityWet3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityFreight4ChoiceValidator implements Validator<AssetClassCommodityFreight4Choice> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityFreight4Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dry", (FreightCommodityDry3) o.getDry() != null ? 1 : 0, 0, 1), 
				checkCardinality("wet", (FreightCommodityWet3) o.getWet() != null ? 1 : 0, 0, 1), 
				checkCardinality("cntnrShip", (FreightCommodityContainerShip2) o.getCntnrShip() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (FreightCommodityOther2) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityFreight4Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityFreight4Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityFreight4Choice", path, "", res.getError());
				}
				return success("AssetClassCommodityFreight4Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityFreight4Choice", path, "");
			})
			.collect(toList());
	}

}

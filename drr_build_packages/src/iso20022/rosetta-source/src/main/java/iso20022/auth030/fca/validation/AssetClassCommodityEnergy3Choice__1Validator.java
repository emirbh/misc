package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.AssetClassCommodityEnergy3Choice__1;
import iso20022.auth030.fca.EnergyCommodityCoal2__1;
import iso20022.auth030.fca.EnergyCommodityDistillates2__1;
import iso20022.auth030.fca.EnergyCommodityElectricity2__1;
import iso20022.auth030.fca.EnergyCommodityInterEnergy2__1;
import iso20022.auth030.fca.EnergyCommodityLightEnd2__1;
import iso20022.auth030.fca.EnergyCommodityNaturalGas3__1;
import iso20022.auth030.fca.EnergyCommodityOil3__1;
import iso20022.auth030.fca.EnergyCommodityOther2__1;
import iso20022.auth030.fca.EnergyCommodityRenewableEnergy2__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityEnergy3Choice__1Validator implements Validator<AssetClassCommodityEnergy3Choice__1> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityEnergy3Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("elctrcty", (EnergyCommodityElectricity2__1) o.getElctrcty() != null ? 1 : 0, 0, 1), 
				checkCardinality("ntrlGas", (EnergyCommodityNaturalGas3__1) o.getNtrlGas() != null ? 1 : 0, 0, 1), 
				checkCardinality("oil", (EnergyCommodityOil3__1) o.getOil() != null ? 1 : 0, 0, 1), 
				checkCardinality("coal", (EnergyCommodityCoal2__1) o.getCoal() != null ? 1 : 0, 0, 1), 
				checkCardinality("intrNrgy", (EnergyCommodityInterEnergy2__1) o.getIntrNrgy() != null ? 1 : 0, 0, 1), 
				checkCardinality("rnwblNrgy", (EnergyCommodityRenewableEnergy2__1) o.getRnwblNrgy() != null ? 1 : 0, 0, 1), 
				checkCardinality("lghtEnd", (EnergyCommodityLightEnd2__1) o.getLghtEnd() != null ? 1 : 0, 0, 1), 
				checkCardinality("dstllts", (EnergyCommodityDistillates2__1) o.getDstllts() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (EnergyCommodityOther2__1) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityEnergy3Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityEnergy3Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityEnergy3Choice__1", path, "", res.getError());
				}
				return success("AssetClassCommodityEnergy3Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityEnergy3Choice__1", path, "");
			})
			.collect(toList());
	}

}

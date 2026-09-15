package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassCommodityEnergy3Choice;
import iso20022.auth030.esma.EnergyCommodityCoal2;
import iso20022.auth030.esma.EnergyCommodityDistillates2;
import iso20022.auth030.esma.EnergyCommodityElectricity2;
import iso20022.auth030.esma.EnergyCommodityInterEnergy2;
import iso20022.auth030.esma.EnergyCommodityLightEnd2;
import iso20022.auth030.esma.EnergyCommodityNaturalGas3;
import iso20022.auth030.esma.EnergyCommodityOil3;
import iso20022.auth030.esma.EnergyCommodityOther2;
import iso20022.auth030.esma.EnergyCommodityRenewableEnergy2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityEnergy3ChoiceValidator implements Validator<AssetClassCommodityEnergy3Choice> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityEnergy3Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("elctrcty", (EnergyCommodityElectricity2) o.getElctrcty() != null ? 1 : 0, 0, 1), 
				checkCardinality("ntrlGas", (EnergyCommodityNaturalGas3) o.getNtrlGas() != null ? 1 : 0, 0, 1), 
				checkCardinality("oil", (EnergyCommodityOil3) o.getOil() != null ? 1 : 0, 0, 1), 
				checkCardinality("coal", (EnergyCommodityCoal2) o.getCoal() != null ? 1 : 0, 0, 1), 
				checkCardinality("intrNrgy", (EnergyCommodityInterEnergy2) o.getIntrNrgy() != null ? 1 : 0, 0, 1), 
				checkCardinality("rnwblNrgy", (EnergyCommodityRenewableEnergy2) o.getRnwblNrgy() != null ? 1 : 0, 0, 1), 
				checkCardinality("lghtEnd", (EnergyCommodityLightEnd2) o.getLghtEnd() != null ? 1 : 0, 0, 1), 
				checkCardinality("dstllts", (EnergyCommodityDistillates2) o.getDstllts() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (EnergyCommodityOther2) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityEnergy3Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityEnergy3Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityEnergy3Choice", path, "", res.getError());
				}
				return success("AssetClassCommodityEnergy3Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityEnergy3Choice", path, "");
			})
			.collect(toList());
	}

}

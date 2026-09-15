package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.AgriculturalCommodityDairy2__1;
import iso20022.auth030.fca.AgriculturalCommodityForestry2__1;
import iso20022.auth030.fca.AgriculturalCommodityGrain3__1;
import iso20022.auth030.fca.AgriculturalCommodityLiveStock2__1;
import iso20022.auth030.fca.AgriculturalCommodityOilSeed2__1;
import iso20022.auth030.fca.AgriculturalCommodityOliveOil3__1;
import iso20022.auth030.fca.AgriculturalCommodityOther2__1;
import iso20022.auth030.fca.AgriculturalCommodityPotato2__1;
import iso20022.auth030.fca.AgriculturalCommoditySeafood2__1;
import iso20022.auth030.fca.AgriculturalCommoditySoft2__1;
import iso20022.auth030.fca.AssetClassCommodityAgricultural6Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityAgricultural6Choice__1Validator implements Validator<AssetClassCommodityAgricultural6Choice__1> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityAgricultural6Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("grnOilSeed", (AgriculturalCommodityOilSeed2__1) o.getGrnOilSeed() != null ? 1 : 0, 0, 1), 
				checkCardinality("soft", (AgriculturalCommoditySoft2__1) o.getSoft() != null ? 1 : 0, 0, 1), 
				checkCardinality("ptt", (AgriculturalCommodityPotato2__1) o.getPtt() != null ? 1 : 0, 0, 1), 
				checkCardinality("olvOil", (AgriculturalCommodityOliveOil3__1) o.getOlvOil() != null ? 1 : 0, 0, 1), 
				checkCardinality("dairy", (AgriculturalCommodityDairy2__1) o.getDairy() != null ? 1 : 0, 0, 1), 
				checkCardinality("frstry", (AgriculturalCommodityForestry2__1) o.getFrstry() != null ? 1 : 0, 0, 1), 
				checkCardinality("sfd", (AgriculturalCommoditySeafood2__1) o.getSfd() != null ? 1 : 0, 0, 1), 
				checkCardinality("liveStock", (AgriculturalCommodityLiveStock2__1) o.getLiveStock() != null ? 1 : 0, 0, 1), 
				checkCardinality("grn", (AgriculturalCommodityGrain3__1) o.getGrn() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (AgriculturalCommodityOther2__1) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityAgricultural6Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityAgricultural6Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityAgricultural6Choice__1", path, "", res.getError());
				}
				return success("AssetClassCommodityAgricultural6Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityAgricultural6Choice__1", path, "");
			})
			.collect(toList());
	}

}

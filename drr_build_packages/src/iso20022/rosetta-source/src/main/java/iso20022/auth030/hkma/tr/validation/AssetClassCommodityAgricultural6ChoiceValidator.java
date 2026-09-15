package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.AgriculturalCommodityDairy2;
import iso20022.auth030.hkma.tr.AgriculturalCommodityForestry2;
import iso20022.auth030.hkma.tr.AgriculturalCommodityGrain3;
import iso20022.auth030.hkma.tr.AgriculturalCommodityLiveStock2;
import iso20022.auth030.hkma.tr.AgriculturalCommodityOilSeed2;
import iso20022.auth030.hkma.tr.AgriculturalCommodityOliveOil3;
import iso20022.auth030.hkma.tr.AgriculturalCommodityOther2;
import iso20022.auth030.hkma.tr.AgriculturalCommodityPotato2;
import iso20022.auth030.hkma.tr.AgriculturalCommoditySeafood2;
import iso20022.auth030.hkma.tr.AgriculturalCommoditySoft2;
import iso20022.auth030.hkma.tr.AssetClassCommodityAgricultural6Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityAgricultural6ChoiceValidator implements Validator<AssetClassCommodityAgricultural6Choice> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityAgricultural6Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("grnOilSeed", (AgriculturalCommodityOilSeed2) o.getGrnOilSeed() != null ? 1 : 0, 0, 1), 
				checkCardinality("soft", (AgriculturalCommoditySoft2) o.getSoft() != null ? 1 : 0, 0, 1), 
				checkCardinality("ptt", (AgriculturalCommodityPotato2) o.getPtt() != null ? 1 : 0, 0, 1), 
				checkCardinality("olvOil", (AgriculturalCommodityOliveOil3) o.getOlvOil() != null ? 1 : 0, 0, 1), 
				checkCardinality("dairy", (AgriculturalCommodityDairy2) o.getDairy() != null ? 1 : 0, 0, 1), 
				checkCardinality("frstry", (AgriculturalCommodityForestry2) o.getFrstry() != null ? 1 : 0, 0, 1), 
				checkCardinality("sfd", (AgriculturalCommoditySeafood2) o.getSfd() != null ? 1 : 0, 0, 1), 
				checkCardinality("liveStock", (AgriculturalCommodityLiveStock2) o.getLiveStock() != null ? 1 : 0, 0, 1), 
				checkCardinality("grn", (AgriculturalCommodityGrain3) o.getGrn() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (AgriculturalCommodityOther2) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityAgricultural6Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityAgricultural6Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityAgricultural6Choice", path, "", res.getError());
				}
				return success("AssetClassCommodityAgricultural6Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityAgricultural6Choice", path, "");
			})
			.collect(toList());
	}

}

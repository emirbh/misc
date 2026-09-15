package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.AssetClassCommodityFertilizer4Choice__1;
import iso20022.auth030.fca.FertilizerCommodityAmmonia2__1;
import iso20022.auth030.fca.FertilizerCommodityDiammoniumPhosphate2__1;
import iso20022.auth030.fca.FertilizerCommodityOther2__1;
import iso20022.auth030.fca.FertilizerCommodityPotash2__1;
import iso20022.auth030.fca.FertilizerCommoditySulphur2__1;
import iso20022.auth030.fca.FertilizerCommodityUrea2__1;
import iso20022.auth030.fca.FertilizerCommodityUreaAndAmmoniumNitrate2__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityFertilizer4Choice__1Validator implements Validator<AssetClassCommodityFertilizer4Choice__1> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityFertilizer4Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ammn", (FertilizerCommodityAmmonia2__1) o.getAmmn() != null ? 1 : 0, 0, 1), 
				checkCardinality("dmmnmPhspht", (FertilizerCommodityDiammoniumPhosphate2__1) o.getDmmnmPhspht() != null ? 1 : 0, 0, 1), 
				checkCardinality("ptsh", (FertilizerCommodityPotash2__1) o.getPtsh() != null ? 1 : 0, 0, 1), 
				checkCardinality("slphr", (FertilizerCommoditySulphur2__1) o.getSlphr() != null ? 1 : 0, 0, 1), 
				checkCardinality("urea", (FertilizerCommodityUrea2__1) o.getUrea() != null ? 1 : 0, 0, 1), 
				checkCardinality("ureaAndAmmnmNtrt", (FertilizerCommodityUreaAndAmmoniumNitrate2__1) o.getUreaAndAmmnmNtrt() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (FertilizerCommodityOther2__1) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityFertilizer4Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityFertilizer4Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityFertilizer4Choice__1", path, "", res.getError());
				}
				return success("AssetClassCommodityFertilizer4Choice__1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityFertilizer4Choice__1", path, "");
			})
			.collect(toList());
	}

}

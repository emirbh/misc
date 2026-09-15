package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.AssetClassCommodityFertilizer4Choice;
import iso20022.auth030.hkma.tr.FertilizerCommodityAmmonia2;
import iso20022.auth030.hkma.tr.FertilizerCommodityDiammoniumPhosphate2;
import iso20022.auth030.hkma.tr.FertilizerCommodityOther2;
import iso20022.auth030.hkma.tr.FertilizerCommodityPotash2;
import iso20022.auth030.hkma.tr.FertilizerCommoditySulphur2;
import iso20022.auth030.hkma.tr.FertilizerCommodityUrea2;
import iso20022.auth030.hkma.tr.FertilizerCommodityUreaAndAmmoniumNitrate2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityFertilizer4ChoiceValidator implements Validator<AssetClassCommodityFertilizer4Choice> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityFertilizer4Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ammn", (FertilizerCommodityAmmonia2) o.getAmmn() != null ? 1 : 0, 0, 1), 
				checkCardinality("dmmnmPhspht", (FertilizerCommodityDiammoniumPhosphate2) o.getDmmnmPhspht() != null ? 1 : 0, 0, 1), 
				checkCardinality("ptsh", (FertilizerCommodityPotash2) o.getPtsh() != null ? 1 : 0, 0, 1), 
				checkCardinality("slphr", (FertilizerCommoditySulphur2) o.getSlphr() != null ? 1 : 0, 0, 1), 
				checkCardinality("urea", (FertilizerCommodityUrea2) o.getUrea() != null ? 1 : 0, 0, 1), 
				checkCardinality("ureaAndAmmnmNtrt", (FertilizerCommodityUreaAndAmmoniumNitrate2) o.getUreaAndAmmnmNtrt() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (FertilizerCommodityOther2) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityFertilizer4Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityFertilizer4Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityFertilizer4Choice", path, "", res.getError());
				}
				return success("AssetClassCommodityFertilizer4Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityFertilizer4Choice", path, "");
			})
			.collect(toList());
	}

}

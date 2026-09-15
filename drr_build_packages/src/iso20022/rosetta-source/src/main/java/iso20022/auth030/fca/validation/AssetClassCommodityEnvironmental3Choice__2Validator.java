package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.AssetClassCommodityEnvironmental3Choice__2;
import iso20022.auth030.fca.EnvironmentCommodityOther2;
import iso20022.auth030.fca.EnvironmentalCommodityCarbonRelated2__1;
import iso20022.auth030.fca.EnvironmentalCommodityEmission3__1;
import iso20022.auth030.fca.EnvironmentalCommodityWeather2__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityEnvironmental3Choice__2Validator implements Validator<AssetClassCommodityEnvironmental3Choice__2> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityEnvironmental3Choice__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("emssns", (EnvironmentalCommodityEmission3__1) o.getEmssns() != null ? 1 : 0, 0, 1), 
				checkCardinality("wthr", (EnvironmentalCommodityWeather2__1) o.getWthr() != null ? 1 : 0, 0, 1), 
				checkCardinality("crbnRltd", (EnvironmentalCommodityCarbonRelated2__1) o.getCrbnRltd() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (EnvironmentCommodityOther2) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityEnvironmental3Choice__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityEnvironmental3Choice__2", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityEnvironmental3Choice__2", path, "", res.getError());
				}
				return success("AssetClassCommodityEnvironmental3Choice__2", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityEnvironmental3Choice__2", path, "");
			})
			.collect(toList());
	}

}

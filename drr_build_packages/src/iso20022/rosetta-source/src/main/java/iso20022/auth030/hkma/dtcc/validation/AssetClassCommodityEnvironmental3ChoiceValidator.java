package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityEnvironmental3Choice;
import iso20022.auth030.hkma.dtcc.EnvironmentCommodityOther2;
import iso20022.auth030.hkma.dtcc.EnvironmentalCommodityCarbonRelated2;
import iso20022.auth030.hkma.dtcc.EnvironmentalCommodityEmission3;
import iso20022.auth030.hkma.dtcc.EnvironmentalCommodityWeather2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityEnvironmental3ChoiceValidator implements Validator<AssetClassCommodityEnvironmental3Choice> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityEnvironmental3Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("emssns", (EnvironmentalCommodityEmission3) o.getEmssns() != null ? 1 : 0, 0, 1), 
				checkCardinality("wthr", (EnvironmentalCommodityWeather2) o.getWthr() != null ? 1 : 0, 0, 1), 
				checkCardinality("crbnRltd", (EnvironmentalCommodityCarbonRelated2) o.getCrbnRltd() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (EnvironmentCommodityOther2) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityEnvironmental3Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityEnvironmental3Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityEnvironmental3Choice", path, "", res.getError());
				}
				return success("AssetClassCommodityEnvironmental3Choice", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityEnvironmental3Choice", path, "");
			})
			.collect(toList());
	}

}

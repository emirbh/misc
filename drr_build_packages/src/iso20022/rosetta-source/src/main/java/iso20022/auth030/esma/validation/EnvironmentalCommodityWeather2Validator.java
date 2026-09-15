package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassProductType3Code;
import iso20022.auth030.esma.AssetClassSubProductType30Code;
import iso20022.auth030.esma.EnvironmentalCommodityWeather2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnvironmentalCommodityWeather2Validator implements Validator<EnvironmentalCommodityWeather2> {

	private List<ComparisonResult> getComparisonResults(EnvironmentalCommodityWeather2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType3Code) o.getBasePdct() != null ? 1 : 0, 1, 1), 
				checkCardinality("subPdct", (AssetClassSubProductType30Code) o.getSubPdct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnvironmentalCommodityWeather2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnvironmentalCommodityWeather2", ValidationResult.ValidationType.CARDINALITY, "EnvironmentalCommodityWeather2", path, "", res.getError());
				}
				return success("EnvironmentalCommodityWeather2", ValidationResult.ValidationType.CARDINALITY, "EnvironmentalCommodityWeather2", path, "");
			})
			.collect(toList());
	}

}

package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassCommodityOfficialEconomicStatistics1;
import iso20022.auth030.esma.AssetClassProductType14Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityOfficialEconomicStatistics1Validator implements Validator<AssetClassCommodityOfficialEconomicStatistics1> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityOfficialEconomicStatistics1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basePdct", (AssetClassProductType14Code) o.getBasePdct() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityOfficialEconomicStatistics1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityOfficialEconomicStatistics1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityOfficialEconomicStatistics1", path, "", res.getError());
				}
				return success("AssetClassCommodityOfficialEconomicStatistics1", ValidationResult.ValidationType.CARDINALITY, "AssetClassCommodityOfficialEconomicStatistics1", path, "");
			})
			.collect(toList());
	}

}

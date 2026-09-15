package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassCommodityMetal2Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityMetal2ChoiceTypeFormatValidator implements Validator<AssetClassCommodityMetal2Choice> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityMetal2Choice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityMetal2Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityMetal2Choice", ValidationResult.ValidationType.TYPE_FORMAT, "AssetClassCommodityMetal2Choice", path, "", res.getError());
				}
				return success("AssetClassCommodityMetal2Choice", ValidationResult.ValidationType.TYPE_FORMAT, "AssetClassCommodityMetal2Choice", path, "");
			})
			.collect(toList());
	}

}

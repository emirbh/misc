package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityFertilizer4Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityFertilizer4ChoiceTypeFormatValidator implements Validator<AssetClassCommodityFertilizer4Choice> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityFertilizer4Choice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityFertilizer4Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityFertilizer4Choice", ValidationResult.ValidationType.TYPE_FORMAT, "AssetClassCommodityFertilizer4Choice", path, "", res.getError());
				}
				return success("AssetClassCommodityFertilizer4Choice", ValidationResult.ValidationType.TYPE_FORMAT, "AssetClassCommodityFertilizer4Choice", path, "");
			})
			.collect(toList());
	}

}

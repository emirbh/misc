package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityPaper5Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityPaper5ChoiceTypeFormatValidator implements Validator<AssetClassCommodityPaper5Choice> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityPaper5Choice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityPaper5Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityPaper5Choice", ValidationResult.ValidationType.TYPE_FORMAT, "AssetClassCommodityPaper5Choice", path, "", res.getError());
				}
				return success("AssetClassCommodityPaper5Choice", ValidationResult.ValidationType.TYPE_FORMAT, "AssetClassCommodityPaper5Choice", path, "");
			})
			.collect(toList());
	}

}

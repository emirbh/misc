package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassCommodityPaper4Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityPaper4ChoiceTypeFormatValidator implements Validator<AssetClassCommodityPaper4Choice> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityPaper4Choice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityPaper4Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityPaper4Choice", ValidationResult.ValidationType.TYPE_FORMAT, "AssetClassCommodityPaper4Choice", path, "", res.getError());
				}
				return success("AssetClassCommodityPaper4Choice", ValidationResult.ValidationType.TYPE_FORMAT, "AssetClassCommodityPaper4Choice", path, "");
			})
			.collect(toList());
	}

}

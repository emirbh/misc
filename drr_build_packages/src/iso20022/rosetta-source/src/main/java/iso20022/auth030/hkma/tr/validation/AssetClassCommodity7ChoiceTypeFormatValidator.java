package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.AssetClassCommodity7Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodity7ChoiceTypeFormatValidator implements Validator<AssetClassCommodity7Choice> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodity7Choice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodity7Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodity7Choice", ValidationResult.ValidationType.TYPE_FORMAT, "AssetClassCommodity7Choice", path, "", res.getError());
				}
				return success("AssetClassCommodity7Choice", ValidationResult.ValidationType.TYPE_FORMAT, "AssetClassCommodity7Choice", path, "");
			})
			.collect(toList());
	}

}

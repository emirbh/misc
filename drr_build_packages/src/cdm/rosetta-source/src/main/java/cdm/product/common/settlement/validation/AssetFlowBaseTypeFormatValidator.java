package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.AssetFlowBase;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetFlowBaseTypeFormatValidator implements Validator<AssetFlowBase> {

	private List<ComparisonResult> getComparisonResults(AssetFlowBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetFlowBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetFlowBase", ValidationResult.ValidationType.TYPE_FORMAT, "AssetFlowBase", path, "", res.getError());
				}
				return success("AssetFlowBase", ValidationResult.ValidationType.TYPE_FORMAT, "AssetFlowBase", path, "");
			})
			.collect(toList());
	}

}

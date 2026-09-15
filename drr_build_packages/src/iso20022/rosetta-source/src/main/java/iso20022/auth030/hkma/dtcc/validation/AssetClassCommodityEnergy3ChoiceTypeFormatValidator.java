package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityEnergy3Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetClassCommodityEnergy3ChoiceTypeFormatValidator implements Validator<AssetClassCommodityEnergy3Choice> {

	private List<ComparisonResult> getComparisonResults(AssetClassCommodityEnergy3Choice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityEnergy3Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetClassCommodityEnergy3Choice", ValidationResult.ValidationType.TYPE_FORMAT, "AssetClassCommodityEnergy3Choice", path, "", res.getError());
				}
				return success("AssetClassCommodityEnergy3Choice", ValidationResult.ValidationType.TYPE_FORMAT, "AssetClassCommodityEnergy3Choice", path, "");
			})
			.collect(toList());
	}

}

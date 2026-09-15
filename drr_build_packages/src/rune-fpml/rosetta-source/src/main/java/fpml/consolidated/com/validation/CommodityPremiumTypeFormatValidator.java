package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityPremium;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityPremiumTypeFormatValidator implements Validator<CommodityPremium> {

	private List<ComparisonResult> getComparisonResults(CommodityPremium o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPremium o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPremium", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityPremium", path, "", res.getError());
				}
				return success("CommodityPremium", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityPremium", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityPhysicalQuantityBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityPhysicalQuantityBaseTypeFormatValidator implements Validator<CommodityPhysicalQuantityBase> {

	private List<ComparisonResult> getComparisonResults(CommodityPhysicalQuantityBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalQuantityBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPhysicalQuantityBase", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityPhysicalQuantityBase", path, "", res.getError());
				}
				return success("CommodityPhysicalQuantityBase", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityPhysicalQuantityBase", path, "");
			})
			.collect(toList());
	}

}

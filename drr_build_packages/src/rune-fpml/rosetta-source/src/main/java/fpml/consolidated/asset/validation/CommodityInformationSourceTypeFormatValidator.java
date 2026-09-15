package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.CommodityInformationSource;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class CommodityInformationSourceTypeFormatValidator implements Validator<CommodityInformationSource> {

	private List<ComparisonResult> getComparisonResults(CommodityInformationSource o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("rateSourcePageHeading", o.getRateSourcePageHeading(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityInformationSource o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityInformationSource", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityInformationSource", path, "", res.getError());
				}
				return success("CommodityInformationSource", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityInformationSource", path, "");
			})
			.collect(toList());
	}

}

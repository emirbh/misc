package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.DerivativesTradeMarginDataReportV01;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DerivativesTradeMarginDataReportV01TypeFormatValidator implements Validator<DerivativesTradeMarginDataReportV01> {

	private List<ComparisonResult> getComparisonResults(DerivativesTradeMarginDataReportV01 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativesTradeMarginDataReportV01 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DerivativesTradeMarginDataReportV01", ValidationResult.ValidationType.TYPE_FORMAT, "DerivativesTradeMarginDataReportV01", path, "", res.getError());
				}
				return success("DerivativesTradeMarginDataReportV01", ValidationResult.ValidationType.TYPE_FORMAT, "DerivativesTradeMarginDataReportV01", path, "");
			})
			.collect(toList());
	}

}

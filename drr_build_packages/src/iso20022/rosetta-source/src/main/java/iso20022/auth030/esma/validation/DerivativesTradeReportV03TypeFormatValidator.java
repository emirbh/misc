package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.DerivativesTradeReportV03;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DerivativesTradeReportV03TypeFormatValidator implements Validator<DerivativesTradeReportV03> {

	private List<ComparisonResult> getComparisonResults(DerivativesTradeReportV03 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativesTradeReportV03 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DerivativesTradeReportV03", ValidationResult.ValidationType.TYPE_FORMAT, "DerivativesTradeReportV03", path, "", res.getError());
				}
				return success("DerivativesTradeReportV03", ValidationResult.ValidationType.TYPE_FORMAT, "DerivativesTradeReportV03", path, "");
			})
			.collect(toList());
	}

}

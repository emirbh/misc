package cdm.event.common.validation;

import cdm.event.common.TradePricingReport;
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

public class TradePricingReportTypeFormatValidator implements Validator<TradePricingReport> {

	private List<ComparisonResult> getComparisonResults(TradePricingReport o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradePricingReport o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradePricingReport", ValidationResult.ValidationType.TYPE_FORMAT, "TradePricingReport", path, "", res.getError());
				}
				return success("TradePricingReport", ValidationResult.ValidationType.TYPE_FORMAT, "TradePricingReport", path, "");
			})
			.collect(toList());
	}

}

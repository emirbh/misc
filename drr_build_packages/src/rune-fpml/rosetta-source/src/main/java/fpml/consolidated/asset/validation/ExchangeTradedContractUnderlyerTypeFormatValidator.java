package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.ExchangeTradedContractUnderlyer;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExchangeTradedContractUnderlyerTypeFormatValidator implements Validator<ExchangeTradedContractUnderlyer> {

	private List<ComparisonResult> getComparisonResults(ExchangeTradedContractUnderlyer o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExchangeTradedContractUnderlyer o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExchangeTradedContractUnderlyer", ValidationResult.ValidationType.TYPE_FORMAT, "ExchangeTradedContractUnderlyer", path, "", res.getError());
				}
				return success("ExchangeTradedContractUnderlyer", ValidationResult.ValidationType.TYPE_FORMAT, "ExchangeTradedContractUnderlyer", path, "");
			})
			.collect(toList());
	}

}

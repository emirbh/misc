package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.TradeCounterpartyReport20;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeCounterpartyReport20TypeFormatValidator implements Validator<TradeCounterpartyReport20> {

	private List<ComparisonResult> getComparisonResults(TradeCounterpartyReport20 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeCounterpartyReport20 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeCounterpartyReport20", ValidationResult.ValidationType.TYPE_FORMAT, "TradeCounterpartyReport20", path, "", res.getError());
				}
				return success("TradeCounterpartyReport20", ValidationResult.ValidationType.TYPE_FORMAT, "TradeCounterpartyReport20", path, "");
			})
			.collect(toList());
	}

}

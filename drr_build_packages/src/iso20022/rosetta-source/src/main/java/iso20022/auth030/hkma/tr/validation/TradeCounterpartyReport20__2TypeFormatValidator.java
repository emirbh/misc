package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.TradeCounterpartyReport20__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeCounterpartyReport20__2TypeFormatValidator implements Validator<TradeCounterpartyReport20__2> {

	private List<ComparisonResult> getComparisonResults(TradeCounterpartyReport20__2 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeCounterpartyReport20__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeCounterpartyReport20__2", ValidationResult.ValidationType.TYPE_FORMAT, "TradeCounterpartyReport20__2", path, "", res.getError());
				}
				return success("TradeCounterpartyReport20__2", ValidationResult.ValidationType.TYPE_FORMAT, "TradeCounterpartyReport20__2", path, "");
			})
			.collect(toList());
	}

}

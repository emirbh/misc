package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.InstrumentTradeQuantity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InstrumentTradeQuantityTypeFormatValidator implements Validator<InstrumentTradeQuantity> {

	private List<ComparisonResult> getComparisonResults(InstrumentTradeQuantity o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentTradeQuantity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InstrumentTradeQuantity", ValidationResult.ValidationType.TYPE_FORMAT, "InstrumentTradeQuantity", path, "", res.getError());
				}
				return success("InstrumentTradeQuantity", ValidationResult.ValidationType.TYPE_FORMAT, "InstrumentTradeQuantity", path, "");
			})
			.collect(toList());
	}

}

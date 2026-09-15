package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.TradeReport31Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeReport31ChoiceTypeFormatValidator implements Validator<TradeReport31Choice> {

	private List<ComparisonResult> getComparisonResults(TradeReport31Choice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeReport31Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeReport31Choice", ValidationResult.ValidationType.TYPE_FORMAT, "TradeReport31Choice", path, "", res.getError());
				}
				return success("TradeReport31Choice", ValidationResult.ValidationType.TYPE_FORMAT, "TradeReport31Choice", path, "");
			})
			.collect(toList());
	}

}

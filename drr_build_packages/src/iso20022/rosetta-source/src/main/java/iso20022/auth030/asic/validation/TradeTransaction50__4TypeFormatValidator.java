package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.TradeTransaction50__4;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class TradeTransaction50__4TypeFormatValidator implements Validator<TradeTransaction50__4> {

	private List<ComparisonResult> getComparisonResults(TradeTransaction50__4 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("scndryTxId", o.getScndryTxId(), 1, of(72), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeTransaction50__4 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeTransaction50__4", ValidationResult.ValidationType.TYPE_FORMAT, "TradeTransaction50__4", path, "", res.getError());
				}
				return success("TradeTransaction50__4", ValidationResult.ValidationType.TYPE_FORMAT, "TradeTransaction50__4", path, "");
			})
			.collect(toList());
	}

}

package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.TradeTransaction49__3;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class TradeTransaction49__3TypeFormatValidator implements Validator<TradeTransaction49__3> {

	private List<ComparisonResult> getComparisonResults(TradeTransaction49__3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("rptTrckgNb", o.getRptTrckgNb(), 1, of(52), empty()), 
				checkString("pltfmIdr", o.getPltfmIdr(), 0, empty(), of(Pattern.compile("[A-Z0-9]{4,4}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeTransaction49__3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeTransaction49__3", ValidationResult.ValidationType.TYPE_FORMAT, "TradeTransaction49__3", path, "", res.getError());
				}
				return success("TradeTransaction49__3", ValidationResult.ValidationType.TYPE_FORMAT, "TradeTransaction49__3", path, "");
			})
			.collect(toList());
	}

}

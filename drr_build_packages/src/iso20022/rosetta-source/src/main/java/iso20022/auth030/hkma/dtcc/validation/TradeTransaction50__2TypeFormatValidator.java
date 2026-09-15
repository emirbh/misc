package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.TradeTransaction50__2;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class TradeTransaction50__2TypeFormatValidator implements Validator<TradeTransaction50__2> {

	private List<ComparisonResult> getComparisonResults(TradeTransaction50__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("scndryTxId", o.getScndryTxId(), 1, of(72), empty()), 
				checkString("pltfmIdr", o.getPltfmIdr(), 0, empty(), of(Pattern.compile("[A-Z0-9]{4,4}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeTransaction50__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeTransaction50__2", ValidationResult.ValidationType.TYPE_FORMAT, "TradeTransaction50__2", path, "", res.getError());
				}
				return success("TradeTransaction50__2", ValidationResult.ValidationType.TYPE_FORMAT, "TradeTransaction50__2", path, "");
			})
			.collect(toList());
	}

}

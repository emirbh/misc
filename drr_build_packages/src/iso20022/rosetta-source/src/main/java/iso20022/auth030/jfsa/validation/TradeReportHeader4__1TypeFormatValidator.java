package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.TradeReportHeader4__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class TradeReportHeader4__1TypeFormatValidator implements Validator<TradeReportHeader4__1> {

	private List<ComparisonResult> getComparisonResults(TradeReportHeader4__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("nbRcrds", o.getNbRcrds(), of(18), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeReportHeader4__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeReportHeader4__1", ValidationResult.ValidationType.TYPE_FORMAT, "TradeReportHeader4__1", path, "", res.getError());
				}
				return success("TradeReportHeader4__1", ValidationResult.ValidationType.TYPE_FORMAT, "TradeReportHeader4__1", path, "");
			})
			.collect(toList());
	}

}

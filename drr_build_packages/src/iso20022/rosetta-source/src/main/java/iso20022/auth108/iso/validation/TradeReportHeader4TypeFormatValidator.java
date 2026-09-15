package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.TradeReportHeader4;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class TradeReportHeader4TypeFormatValidator implements Validator<TradeReportHeader4> {

	private List<ComparisonResult> getComparisonResults(TradeReportHeader4 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("nbRcrds", o.getNbRcrds(), of(18), of(0), empty(), empty()), 
				checkString("cmptntAuthrty", o.getCmptntAuthrty(), 1, of(100), empty()), 
				checkString("rptgPurp", o.getRptgPurp(), 1, of(100), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeReportHeader4 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeReportHeader4", ValidationResult.ValidationType.TYPE_FORMAT, "TradeReportHeader4", path, "", res.getError());
				}
				return success("TradeReportHeader4", ValidationResult.ValidationType.TYPE_FORMAT, "TradeReportHeader4", path, "");
			})
			.collect(toList());
	}

}

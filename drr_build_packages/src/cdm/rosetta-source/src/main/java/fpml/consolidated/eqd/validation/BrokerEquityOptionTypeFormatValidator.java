package fpml.consolidated.eqd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eqd.BrokerEquityOption;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class BrokerEquityOptionTypeFormatValidator implements Validator<BrokerEquityOption> {

	private List<ComparisonResult> getComparisonResults(BrokerEquityOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("spotPrice", o.getSpotPrice(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("numberOfOptions", o.getNumberOfOptions(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkString("brokerNotes", o.getBrokerNotes(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BrokerEquityOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BrokerEquityOption", ValidationResult.ValidationType.TYPE_FORMAT, "BrokerEquityOption", path, "", res.getError());
				}
				return success("BrokerEquityOption", ValidationResult.ValidationType.TYPE_FORMAT, "BrokerEquityOption", path, "");
			})
			.collect(toList());
	}

}

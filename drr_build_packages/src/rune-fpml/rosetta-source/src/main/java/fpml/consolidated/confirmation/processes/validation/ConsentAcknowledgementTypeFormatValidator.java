package fpml.consolidated.confirmation.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.confirmation.processes.ConsentAcknowledgement;
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

public class ConsentAcknowledgementTypeFormatValidator implements Validator<ConsentAcknowledgement> {

	private List<ComparisonResult> getComparisonResults(ConsentAcknowledgement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("fpmlVersion", o.getFpmlVersion(), 1, empty(), empty()), 
				checkNumber("expectedBuild", o.getExpectedBuild(), empty(), of(0), of(new BigDecimal("1")), empty()), 
				checkNumber("actualBuild", o.getActualBuild(), empty(), of(0), of(new BigDecimal("1")), empty()), 
				checkNumber("sequenceNumber", o.getSequenceNumber(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConsentAcknowledgement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ConsentAcknowledgement", ValidationResult.ValidationType.TYPE_FORMAT, "ConsentAcknowledgement", path, "", res.getError());
				}
				return success("ConsentAcknowledgement", ValidationResult.ValidationType.TYPE_FORMAT, "ConsentAcknowledgement", path, "");
			})
			.collect(toList());
	}

}

package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbCredit;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class AnnaDsbCreditTypeFormatValidator implements Validator<AnnaDsbCredit> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbCredit o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("UnderlyingCreditIndexVersion", o.getUnderlyingCreditIndexVersion(), empty(), of(0), empty(), empty()), 
				checkNumber("UnderlyingInstrumentIndexTermValue", o.getUnderlyingInstrumentIndexTermValue(), empty(), of(0), empty(), empty()), 
				checkNumber("UnderlyingCreditIndexSeries", o.getUnderlyingCreditIndexSeries(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbCredit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbCredit", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbCredit", path, "", res.getError());
				}
				return success("AnnaDsbCredit", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbCredit", path, "");
			})
			.collect(toList());
	}

}

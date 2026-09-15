package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbIndexTranche;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class AnnaDsbIndexTrancheTypeFormatValidator implements Validator<AnnaDsbIndexTranche> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbIndexTranche o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("UnderlyingInstrumentIndexTermValue", o.getUnderlyingInstrumentIndexTermValue(), empty(), of(0), empty(), empty()), 
				checkNumber("UnderlyingCreditIndexSeries", o.getUnderlyingCreditIndexSeries(), empty(), of(0), empty(), empty()), 
				checkNumber("UnderlyingCreditIndexVersion", o.getUnderlyingCreditIndexVersion(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbIndexTranche o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbIndexTranche", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbIndexTranche", path, "", res.getError());
				}
				return success("AnnaDsbIndexTranche", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbIndexTranche", path, "");
			})
			.collect(toList());
	}

}

package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbRates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class AnnaDsbRatesTypeFormatValidator implements Validator<AnnaDsbRates> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbRates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("OtherLegReferenceRateTermValue", o.getOtherLegReferenceRateTermValue(), empty(), of(0), empty(), empty()), 
				checkNumber("ReferenceRateTermValue", o.getReferenceRateTermValue(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbRates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbRates", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbRates", path, "", res.getError());
				}
				return success("AnnaDsbRates", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbRates", path, "");
			})
			.collect(toList());
	}

}

package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbAttributes;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class AnnaDsbAttributesTypeFormatValidator implements Validator<AnnaDsbAttributes> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbAttributes o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("UnderlyingInstrumentIndexTermValue", o.getUnderlyingInstrumentIndexTermValue(), empty(), of(0), empty(), empty()), 
				checkNumber("OtherLegReferenceRateTermValue", o.getOtherLegReferenceRateTermValue(), empty(), of(0), empty(), empty()), 
				checkNumber("ReferenceRateTermValue", o.getReferenceRateTermValue(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbAttributes o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbAttributes", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbAttributes", path, "", res.getError());
				}
				return success("AnnaDsbAttributes", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbAttributes", path, "");
			})
			.collect(toList());
	}

}

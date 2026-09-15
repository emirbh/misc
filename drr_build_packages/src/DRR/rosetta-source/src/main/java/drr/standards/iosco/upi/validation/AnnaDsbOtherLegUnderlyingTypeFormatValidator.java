package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlying;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class AnnaDsbOtherLegUnderlyingTypeFormatValidator implements Validator<AnnaDsbOtherLegUnderlying> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbOtherLegUnderlying o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("OtherLegReferenceRateTermValue", o.getOtherLegReferenceRateTermValue(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbOtherLegUnderlying o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbOtherLegUnderlying", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbOtherLegUnderlying", path, "", res.getError());
				}
				return success("AnnaDsbOtherLegUnderlying", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbOtherLegUnderlying", path, "");
			})
			.collect(toList());
	}

}

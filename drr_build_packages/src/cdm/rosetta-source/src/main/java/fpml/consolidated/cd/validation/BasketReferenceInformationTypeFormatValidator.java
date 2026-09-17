package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.BasketReferenceInformation;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class BasketReferenceInformationTypeFormatValidator implements Validator<BasketReferenceInformation> {

	private List<ComparisonResult> getComparisonResults(BasketReferenceInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("nthToDefault", o.getNthToDefault(), empty(), of(0), of(new BigDecimal("1")), empty()), 
				checkNumber("mthToDefault", o.getMthToDefault(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketReferenceInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BasketReferenceInformation", ValidationResult.ValidationType.TYPE_FORMAT, "BasketReferenceInformation", path, "", res.getError());
				}
				return success("BasketReferenceInformation", ValidationResult.ValidationType.TYPE_FORMAT, "BasketReferenceInformation", path, "");
			})
			.collect(toList());
	}

}

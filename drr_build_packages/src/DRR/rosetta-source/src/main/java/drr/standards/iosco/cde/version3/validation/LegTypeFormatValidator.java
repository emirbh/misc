package drr.standards.iosco.cde.version3.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.cde.version3.Leg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class LegTypeFormatValidator implements Validator<Leg> {

	private List<ComparisonResult> getComparisonResults(Leg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("notionalAmount", o.getNotionalAmount(), of(25), of(5), empty(), empty()), 
				checkNumber("totalNotionalQuantity", o.getTotalNotionalQuantity(), of(25), of(5), empty(), empty()), 
				checkNumber("fixedRate", o.getFixedRate(), of(11), of(10), empty(), empty()), 
				checkString("quantityUnitOfMeasure", o.getQuantityUnitOfMeasure(), 1, of(4), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Leg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Leg", ValidationResult.ValidationType.TYPE_FORMAT, "Leg", path, "", res.getError());
				}
				return success("Leg", ValidationResult.ValidationType.TYPE_FORMAT, "Leg", path, "");
			})
			.collect(toList());
	}

}

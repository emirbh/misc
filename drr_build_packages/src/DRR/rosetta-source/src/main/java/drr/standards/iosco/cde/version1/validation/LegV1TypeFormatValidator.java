package drr.standards.iosco.cde.version1.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.cde.version1.LegV1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class LegV1TypeFormatValidator implements Validator<LegV1> {

	private List<ComparisonResult> getComparisonResults(LegV1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("notionalAmount", o.getNotionalAmount(), of(25), of(5), empty(), empty()), 
				checkNumber("totalNotionalQuantity", o.getTotalNotionalQuantity(), of(25), of(5), empty(), empty()), 
				checkNumber("fixedRate", o.getFixedRate(), of(11), of(10), empty(), empty()), 
				checkString("quantityUnitOfMeasure", o.getQuantityUnitOfMeasure(), 1, of(4), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegV1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegV1", ValidationResult.ValidationType.TYPE_FORMAT, "LegV1", path, "", res.getError());
				}
				return success("LegV1", ValidationResult.ValidationType.TYPE_FORMAT, "LegV1", path, "");
			})
			.collect(toList());
	}

}

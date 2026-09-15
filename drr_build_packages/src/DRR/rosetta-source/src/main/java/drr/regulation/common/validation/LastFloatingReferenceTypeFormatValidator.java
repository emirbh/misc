package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.LastFloatingReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class LastFloatingReferenceTypeFormatValidator implements Validator<LastFloatingReference> {

	private List<ComparisonResult> getComparisonResults(LastFloatingReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("lastFloatingReferenceValueLeg1", o.getLastFloatingReferenceValueLeg1(), of(11), of(10), empty(), empty()), 
				checkNumber("lastFloatingReferenceValueLeg2", o.getLastFloatingReferenceValueLeg2(), of(11), of(10), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LastFloatingReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LastFloatingReference", ValidationResult.ValidationType.TYPE_FORMAT, "LastFloatingReference", path, "", res.getError());
				}
				return success("LastFloatingReference", ValidationResult.ValidationType.TYPE_FORMAT, "LastFloatingReference", path, "");
			})
			.collect(toList());
	}

}

package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CSAMTAVariableSet;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CSAMTAVariableSetTypeFormatValidator implements Validator<CSAMTAVariableSet> {

	private List<ComparisonResult> getComparisonResults(CSAMTAVariableSet o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("amount", o.getAmount(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSAMTAVariableSet o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CSAMTAVariableSet", ValidationResult.ValidationType.TYPE_FORMAT, "CSAMTAVariableSet", path, "", res.getError());
				}
				return success("CSAMTAVariableSet", ValidationResult.ValidationType.TYPE_FORMAT, "CSAMTAVariableSet", path, "");
			})
			.collect(toList());
	}

}

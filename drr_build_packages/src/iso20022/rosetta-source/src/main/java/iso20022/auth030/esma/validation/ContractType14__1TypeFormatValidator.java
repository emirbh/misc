package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.ContractType14__1;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class ContractType14__1TypeFormatValidator implements Validator<ContractType14__1> {

	private List<ComparisonResult> getComparisonResults(ContractType14__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("pdctClssfctn", o.getPdctClssfctn(), 0, empty(), of(Pattern.compile("[A-Z]{6,6}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractType14__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractType14__1", ValidationResult.ValidationType.TYPE_FORMAT, "ContractType14__1", path, "", res.getError());
				}
				return success("ContractType14__1", ValidationResult.ValidationType.TYPE_FORMAT, "ContractType14__1", path, "");
			})
			.collect(toList());
	}

}

package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.SupplementaryData1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class SupplementaryData1TypeFormatValidator implements Validator<SupplementaryData1> {

	private List<ComparisonResult> getComparisonResults(SupplementaryData1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("plcAndNm", o.getPlcAndNm(), 1, of(350), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SupplementaryData1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SupplementaryData1", ValidationResult.ValidationType.TYPE_FORMAT, "SupplementaryData1", path, "", res.getError());
				}
				return success("SupplementaryData1", ValidationResult.ValidationType.TYPE_FORMAT, "SupplementaryData1", path, "");
			})
			.collect(toList());
	}

}

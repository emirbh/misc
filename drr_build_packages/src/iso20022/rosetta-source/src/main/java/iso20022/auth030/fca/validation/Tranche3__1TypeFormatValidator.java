package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.Tranche3__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class Tranche3__1TypeFormatValidator implements Validator<Tranche3__1> {

	private List<ComparisonResult> getComparisonResults(Tranche3__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("attchmntPt", o.getAttchmntPt(), of(11), of(10), empty(), empty()), 
				checkNumber("dtchmntPt", o.getDtchmntPt(), of(11), of(10), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Tranche3__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Tranche3__1", ValidationResult.ValidationType.TYPE_FORMAT, "Tranche3__1", path, "", res.getError());
				}
				return success("Tranche3__1", ValidationResult.ValidationType.TYPE_FORMAT, "Tranche3__1", path, "");
			})
			.collect(toList());
	}

}

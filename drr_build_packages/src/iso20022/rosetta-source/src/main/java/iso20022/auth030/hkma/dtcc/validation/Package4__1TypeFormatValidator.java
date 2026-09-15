package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.Package4__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class Package4__1TypeFormatValidator implements Validator<Package4__1> {

	private List<ComparisonResult> getComparisonResults(Package4__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("cmplxTradId", o.getCmplxTradId(), 1, of(35), empty()), 
				checkString("fxSwpLkId", o.getFxSwpLkId(), 1, of(100), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Package4__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Package4__1", ValidationResult.ValidationType.TYPE_FORMAT, "Package4__1", path, "", res.getError());
				}
				return success("Package4__1", ValidationResult.ValidationType.TYPE_FORMAT, "Package4__1", path, "");
			})
			.collect(toList());
	}

}

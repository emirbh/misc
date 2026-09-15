package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.ClearingPartyAndTime23__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ClearingPartyAndTime23__1TypeFormatValidator implements Validator<ClearingPartyAndTime23__1> {

	private List<ComparisonResult> getComparisonResults(ClearingPartyAndTime23__1 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingPartyAndTime23__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingPartyAndTime23__1", ValidationResult.ValidationType.TYPE_FORMAT, "ClearingPartyAndTime23__1", path, "", res.getError());
				}
				return success("ClearingPartyAndTime23__1", ValidationResult.ValidationType.TYPE_FORMAT, "ClearingPartyAndTime23__1", path, "");
			})
			.collect(toList());
	}

}

package cdm.regulation.validation;

import cdm.regulation.FinInstrm;
import cdm.regulation.Othr;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FinInstrmValidator implements Validator<FinInstrm> {

	private List<ComparisonResult> getComparisonResults(FinInstrm o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("othr", (Othr) o.getOthr() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FinInstrm o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FinInstrm", ValidationResult.ValidationType.CARDINALITY, "FinInstrm", path, "", res.getError());
				}
				return success("FinInstrm", ValidationResult.ValidationType.CARDINALITY, "FinInstrm", path, "");
			})
			.collect(toList());
	}

}

package fpml.consolidated.reg.fpmlreporting.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.shared.ApplicableRegulations;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatorApplicability;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ApplicableRegulationsValidator implements Validator<ApplicableRegulations> {

	private List<ComparisonResult> getComparisonResults(ApplicableRegulations o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("regulatorApplicability", (List<? extends RegulatorApplicability>) o.getRegulatorApplicability() == null ? 0 : o.getRegulatorApplicability().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApplicableRegulations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApplicableRegulations", ValidationResult.ValidationType.CARDINALITY, "ApplicableRegulations", path, "", res.getError());
				}
				return success("ApplicableRegulations", ValidationResult.ValidationType.CARDINALITY, "ApplicableRegulations", path, "");
			})
			.collect(toList());
	}

}

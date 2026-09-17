package fpml.consolidated.reg.fpmlreporting.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatorApplicability;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatorApplicabilityValidator implements Validator<RegulatorApplicability> {

	private List<ComparisonResult> getComparisonResults(RegulatorApplicability o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("supervisoryBody", (String) o.getSupervisoryBody() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingPartyReference", (PartyReference) o.getReportingPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterPartyReference", (PartyReference) o.getCounterPartyReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatorApplicability o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatorApplicability", ValidationResult.ValidationType.CARDINALITY, "RegulatorApplicability", path, "", res.getError());
				}
				return success("RegulatorApplicability", ValidationResult.ValidationType.CARDINALITY, "RegulatorApplicability", path, "");
			})
			.collect(toList());
	}

}

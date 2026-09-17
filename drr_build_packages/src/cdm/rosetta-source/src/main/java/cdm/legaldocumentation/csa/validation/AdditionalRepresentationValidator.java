package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.AdditionalRepresentation;
import cdm.legaldocumentation.csa.AdditionalRepresentationElection;
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

public class AdditionalRepresentationValidator implements Validator<AdditionalRepresentation> {

	private List<ComparisonResult> getComparisonResults(AdditionalRepresentation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyElection", (List<? extends AdditionalRepresentationElection>) o.getPartyElection() == null ? 0 : o.getPartyElection().size(), 2, 2), 
				checkCardinality("customElection", (String) o.getCustomElection() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalRepresentation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdditionalRepresentation", ValidationResult.ValidationType.CARDINALITY, "AdditionalRepresentation", path, "", res.getError());
				}
				return success("AdditionalRepresentation", ValidationResult.ValidationType.CARDINALITY, "AdditionalRepresentation", path, "");
			})
			.collect(toList());
	}

}

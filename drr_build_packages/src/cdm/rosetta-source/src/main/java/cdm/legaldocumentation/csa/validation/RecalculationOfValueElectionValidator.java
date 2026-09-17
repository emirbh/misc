package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.RecalculationOfValueElection;
import cdm.legaldocumentation.csa.RecalculationOfValueElectionEnum;
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

public class RecalculationOfValueElectionValidator implements Validator<RecalculationOfValueElection> {

	private List<ComparisonResult> getComparisonResults(RecalculationOfValueElection o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (CounterpartyRoleEnum) o.getParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("recalculationOfValueElection", (RecalculationOfValueElectionEnum) o.getRecalculationOfValueElection() != null ? 1 : 0, 1, 1), 
				checkCardinality("recalculationOfValueTerms", (String) o.getRecalculationOfValueTerms() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RecalculationOfValueElection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RecalculationOfValueElection", ValidationResult.ValidationType.CARDINALITY, "RecalculationOfValueElection", path, "", res.getError());
				}
				return success("RecalculationOfValueElection", ValidationResult.ValidationType.CARDINALITY, "RecalculationOfValueElection", path, "");
			})
			.collect(toList());
	}

}

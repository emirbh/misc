package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.Custodian;
import cdm.legaldocumentation.csa.CustodianElection;
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

public class CustodianValidator implements Validator<Custodian> {

	private List<ComparisonResult> getComparisonResults(Custodian o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyElection", (List<? extends CustodianElection>) o.getPartyElection() == null ? 0 : o.getPartyElection().size(), 2, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Custodian o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Custodian", ValidationResult.ValidationType.CARDINALITY, "Custodian", path, "", res.getError());
				}
				return success("Custodian", ValidationResult.ValidationType.CARDINALITY, "Custodian", path, "");
			})
			.collect(toList());
	}

}

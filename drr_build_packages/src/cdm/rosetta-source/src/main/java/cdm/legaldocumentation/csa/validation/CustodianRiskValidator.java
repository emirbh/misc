package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CustodianRisk;
import cdm.legaldocumentation.csa.CustodianRiskElection;
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

public class CustodianRiskValidator implements Validator<CustodianRisk> {

	private List<ComparisonResult> getComparisonResults(CustodianRisk o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyElection", (List<? extends CustodianRiskElection>) o.getPartyElection() == null ? 0 : o.getPartyElection().size(), 1, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustodianRisk o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CustodianRisk", ValidationResult.ValidationType.CARDINALITY, "CustodianRisk", path, "", res.getError());
				}
				return success("CustodianRisk", ValidationResult.ValidationType.CARDINALITY, "CustodianRisk", path, "");
			})
			.collect(toList());
	}

}

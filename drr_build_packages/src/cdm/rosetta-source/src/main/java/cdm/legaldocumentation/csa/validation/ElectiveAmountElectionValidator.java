package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.ElectiveAmountElection;
import cdm.legaldocumentation.csa.ElectiveAmountEnum;
import cdm.observable.asset.Money;
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

public class ElectiveAmountElectionValidator implements Validator<ElectiveAmountElection> {

	private List<ComparisonResult> getComparisonResults(ElectiveAmountElection o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (CounterpartyRoleEnum) o.getParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("electiveAmount", (ElectiveAmountEnum) o.getElectiveAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("amount", (Money) o.getAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("customElection", (String) o.getCustomElection() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectiveAmountElection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectiveAmountElection", ValidationResult.ValidationType.CARDINALITY, "ElectiveAmountElection", path, "", res.getError());
				}
				return success("ElectiveAmountElection", ValidationResult.ValidationType.CARDINALITY, "ElectiveAmountElection", path, "");
			})
			.collect(toList());
	}

}

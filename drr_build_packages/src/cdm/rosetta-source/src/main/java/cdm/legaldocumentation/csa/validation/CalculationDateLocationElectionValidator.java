package cdm.legaldocumentation.csa.validation;

import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.CalculationDateLocationElection;
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

public class CalculationDateLocationElectionValidator implements Validator<CalculationDateLocationElection> {

	private List<ComparisonResult> getComparisonResults(CalculationDateLocationElection o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (CounterpartyRoleEnum) o.getParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("businessCenter", (FieldWithMetaBusinessCenterEnum) o.getBusinessCenter() != null ? 1 : 0, 0, 1), 
				checkCardinality("customLocation", (String) o.getCustomLocation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationDateLocationElection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationDateLocationElection", ValidationResult.ValidationType.CARDINALITY, "CalculationDateLocationElection", path, "", res.getError());
				}
				return success("CalculationDateLocationElection", ValidationResult.ValidationType.CARDINALITY, "CalculationDateLocationElection", path, "");
			})
			.collect(toList());
	}

}

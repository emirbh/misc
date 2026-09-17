package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.CalculationCurrencyElection;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CalculationCurrencyElectionValidator implements Validator<CalculationCurrencyElection> {

	private List<ComparisonResult> getComparisonResults(CalculationCurrencyElection o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (CounterpartyRoleEnum) o.getParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("isBaseCurrency", (Boolean) o.getIsBaseCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (FieldWithMetaString) o.getCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationCurrencyElection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationCurrencyElection", ValidationResult.ValidationType.CARDINALITY, "CalculationCurrencyElection", path, "", res.getError());
				}
				return success("CalculationCurrencyElection", ValidationResult.ValidationType.CARDINALITY, "CalculationCurrencyElection", path, "");
			})
			.collect(toList());
	}

}

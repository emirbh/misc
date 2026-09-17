package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.TerminationCurrencyElection;
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

public class TerminationCurrencyElectionValidator implements Validator<TerminationCurrencyElection> {

	private List<ComparisonResult> getComparisonResults(TerminationCurrencyElection o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (List<CounterpartyRoleEnum>) o.getParty() == null ? 0 : o.getParty().size(), 1, 2), 
				checkCardinality("isSpecified", (Boolean) o.getIsSpecified() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (FieldWithMetaString) o.getCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TerminationCurrencyElection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TerminationCurrencyElection", ValidationResult.ValidationType.CARDINALITY, "TerminationCurrencyElection", path, "", res.getError());
				}
				return success("TerminationCurrencyElection", ValidationResult.ValidationType.CARDINALITY, "TerminationCurrencyElection", path, "");
			})
			.collect(toList());
	}

}

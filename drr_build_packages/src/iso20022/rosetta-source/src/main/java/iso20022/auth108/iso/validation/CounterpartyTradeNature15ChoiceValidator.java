package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.CounterpartyTradeNature15Choice;
import iso20022.auth108.iso.FinancialInstitutionSector1;
import iso20022.auth108.iso.NoReasonCode;
import iso20022.auth108.iso.NonFinancialInstitutionSector10;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CounterpartyTradeNature15ChoiceValidator implements Validator<CounterpartyTradeNature15Choice> {

	private List<ComparisonResult> getComparisonResults(CounterpartyTradeNature15Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fi", (FinancialInstitutionSector1) o.getFi() != null ? 1 : 0, 0, 1), 
				checkCardinality("nfi", (NonFinancialInstitutionSector10) o.getNfi() != null ? 1 : 0, 0, 1), 
				checkCardinality("cntrlCntrPty", (NoReasonCode) o.getCntrlCntrPty() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (NoReasonCode) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CounterpartyTradeNature15Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CounterpartyTradeNature15Choice", ValidationResult.ValidationType.CARDINALITY, "CounterpartyTradeNature15Choice", path, "", res.getError());
				}
				return success("CounterpartyTradeNature15Choice", ValidationResult.ValidationType.CARDINALITY, "CounterpartyTradeNature15Choice", path, "");
			})
			.collect(toList());
	}

}

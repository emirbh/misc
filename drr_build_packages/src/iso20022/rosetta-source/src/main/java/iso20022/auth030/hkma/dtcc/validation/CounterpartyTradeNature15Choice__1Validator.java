package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.CounterpartyTradeNature15Choice__1;
import iso20022.auth030.hkma.dtcc.FinancialInstitutionSector1__1;
import iso20022.auth030.hkma.dtcc.NoReasonCode;
import iso20022.auth030.hkma.dtcc.NonFinancialInstitutionSector10__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CounterpartyTradeNature15Choice__1Validator implements Validator<CounterpartyTradeNature15Choice__1> {

	private List<ComparisonResult> getComparisonResults(CounterpartyTradeNature15Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fi", (FinancialInstitutionSector1__1) o.getFi() != null ? 1 : 0, 0, 1), 
				checkCardinality("nfi", (NonFinancialInstitutionSector10__1) o.getNfi() != null ? 1 : 0, 0, 1), 
				checkCardinality("cntrlCntrPty", (NoReasonCode) o.getCntrlCntrPty() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (NoReasonCode) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CounterpartyTradeNature15Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CounterpartyTradeNature15Choice__1", ValidationResult.ValidationType.CARDINALITY, "CounterpartyTradeNature15Choice__1", path, "", res.getError());
				}
				return success("CounterpartyTradeNature15Choice__1", ValidationResult.ValidationType.CARDINALITY, "CounterpartyTradeNature15Choice__1", path, "");
			})
			.collect(toList());
	}

}

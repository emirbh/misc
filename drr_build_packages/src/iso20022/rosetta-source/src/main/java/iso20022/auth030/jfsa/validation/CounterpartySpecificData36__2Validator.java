package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.ContractValuationData8__1;
import iso20022.auth030.jfsa.CounterpartySpecificData36__2;
import iso20022.auth030.jfsa.TradeCounterpartyReport20__2;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CounterpartySpecificData36__2Validator implements Validator<CounterpartySpecificData36__2> {

	private List<ComparisonResult> getComparisonResults(CounterpartySpecificData36__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ctrPty", (TradeCounterpartyReport20__2) o.getCtrPty() != null ? 1 : 0, 1, 1), 
				checkCardinality("valtn", (ContractValuationData8__1) o.getValtn() != null ? 1 : 0, 1, 1), 
				checkCardinality("rptgTmStmp", (ZonedDateTime) o.getRptgTmStmp() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CounterpartySpecificData36__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CounterpartySpecificData36__2", ValidationResult.ValidationType.CARDINALITY, "CounterpartySpecificData36__2", path, "", res.getError());
				}
				return success("CounterpartySpecificData36__2", ValidationResult.ValidationType.CARDINALITY, "CounterpartySpecificData36__2", path, "");
			})
			.collect(toList());
	}

}

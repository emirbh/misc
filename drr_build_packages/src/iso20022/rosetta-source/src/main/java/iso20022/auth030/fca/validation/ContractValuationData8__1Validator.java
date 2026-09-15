package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.AmountAndDirection109__1;
import iso20022.auth030.fca.ContractValuationData8__1;
import iso20022.auth030.fca.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ContractValuationData8__1Validator implements Validator<ContractValuationData8__1> {

	private List<ComparisonResult> getComparisonResults(ContractValuationData8__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ctrctVal", (AmountAndDirection109__1) o.getCtrctVal() != null ? 1 : 0, 0, 1), 
				checkCardinality("tmStmp", (ZonedDateTime) o.getTmStmp() != null ? 1 : 0, 0, 1), 
				checkCardinality("tp", (ValuationType1Code) o.getTp() != null ? 1 : 0, 0, 1), 
				checkCardinality("dlta", (BigDecimal) o.getDlta() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractValuationData8__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractValuationData8__1", ValidationResult.ValidationType.CARDINALITY, "ContractValuationData8__1", path, "", res.getError());
				}
				return success("ContractValuationData8__1", ValidationResult.ValidationType.CARDINALITY, "ContractValuationData8__1", path, "");
			})
			.collect(toList());
	}

}

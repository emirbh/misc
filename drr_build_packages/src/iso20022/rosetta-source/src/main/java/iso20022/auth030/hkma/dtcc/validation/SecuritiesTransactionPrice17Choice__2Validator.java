package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AmountAndDirection106__2;
import iso20022.auth030.hkma.dtcc.SecuritiesTransactionPrice17Choice__2;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecuritiesTransactionPrice17Choice__2Validator implements Validator<SecuritiesTransactionPrice17Choice__2> {

	private List<ComparisonResult> getComparisonResults(SecuritiesTransactionPrice17Choice__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("mntryVal", (AmountAndDirection106__2) o.getMntryVal() != null ? 1 : 0, 0, 1), 
				checkCardinality("dcml", (BigDecimal) o.getDcml() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecuritiesTransactionPrice17Choice__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecuritiesTransactionPrice17Choice__2", ValidationResult.ValidationType.CARDINALITY, "SecuritiesTransactionPrice17Choice__2", path, "", res.getError());
				}
				return success("SecuritiesTransactionPrice17Choice__2", ValidationResult.ValidationType.CARDINALITY, "SecuritiesTransactionPrice17Choice__2", path, "");
			})
			.collect(toList());
	}

}

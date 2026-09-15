package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.AmountAndDirection106__1;
import iso20022.auth030.hkma.tr.SecuritiesTransactionPrice23Choice__1;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecuritiesTransactionPrice23Choice__1Validator implements Validator<SecuritiesTransactionPrice23Choice__1> {

	private List<ComparisonResult> getComparisonResults(SecuritiesTransactionPrice23Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("mntryVal", (AmountAndDirection106__1) o.getMntryVal() != null ? 1 : 0, 0, 1), 
				checkCardinality("dcml", (BigDecimal) o.getDcml() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecuritiesTransactionPrice23Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecuritiesTransactionPrice23Choice__1", ValidationResult.ValidationType.CARDINALITY, "SecuritiesTransactionPrice23Choice__1", path, "", res.getError());
				}
				return success("SecuritiesTransactionPrice23Choice__1", ValidationResult.ValidationType.CARDINALITY, "SecuritiesTransactionPrice23Choice__1", path, "");
			})
			.collect(toList());
	}

}

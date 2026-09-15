package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AmountAndDirection106;
import iso20022.auth030.esma.PriceStatus1Code;
import iso20022.auth030.esma.SecuritiesTransactionPrice17Choice;
import iso20022.auth030.esma.SecuritiesTransactionPrice5;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecuritiesTransactionPrice17ChoiceValidator implements Validator<SecuritiesTransactionPrice17Choice> {

	private List<ComparisonResult> getComparisonResults(SecuritiesTransactionPrice17Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("mntryVal", (AmountAndDirection106) o.getMntryVal() != null ? 1 : 0, 0, 1), 
				checkCardinality("unit", (BigDecimal) o.getUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("pctg", (BigDecimal) o.getPctg() != null ? 1 : 0, 0, 1), 
				checkCardinality("yld", (BigDecimal) o.getYld() != null ? 1 : 0, 0, 1), 
				checkCardinality("dcml", (BigDecimal) o.getDcml() != null ? 1 : 0, 0, 1), 
				checkCardinality("pdgPric", (PriceStatus1Code) o.getPdgPric() != null ? 1 : 0, 0, 1), 
				checkCardinality("othr", (SecuritiesTransactionPrice5) o.getOthr() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecuritiesTransactionPrice17Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecuritiesTransactionPrice17Choice", ValidationResult.ValidationType.CARDINALITY, "SecuritiesTransactionPrice17Choice", path, "", res.getError());
				}
				return success("SecuritiesTransactionPrice17Choice", ValidationResult.ValidationType.CARDINALITY, "SecuritiesTransactionPrice17Choice", path, "");
			})
			.collect(toList());
	}

}

package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth030.hkma.dtcc.AmountAndDirection106__3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AmountAndDirection106__3Validator implements Validator<AmountAndDirection106__3> {

	private List<ComparisonResult> getComparisonResults(AmountAndDirection106__3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amt", (ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getAmt() != null ? 1 : 0, 1, 1), 
				checkCardinality("sgn", (Boolean) o.getSgn() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AmountAndDirection106__3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AmountAndDirection106__3", ValidationResult.ValidationType.CARDINALITY, "AmountAndDirection106__3", path, "", res.getError());
				}
				return success("AmountAndDirection106__3", ValidationResult.ValidationType.CARDINALITY, "AmountAndDirection106__3", path, "");
			})
			.collect(toList());
	}

}

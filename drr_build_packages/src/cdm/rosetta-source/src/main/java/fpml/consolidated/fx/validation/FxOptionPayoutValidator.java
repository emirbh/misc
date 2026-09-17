package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.PayoutEnum;
import fpml.consolidated.fx.FxOptionPayout;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.SettlementInformation;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxOptionPayoutValidator implements Validator<FxOptionPayout> {

	private List<ComparisonResult> getComparisonResults(FxOptionPayout o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (BigDecimal) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("payoutStyle", (PayoutEnum) o.getPayoutStyle() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementInformation", (SettlementInformation) o.getSettlementInformation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxOptionPayout o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxOptionPayout", ValidationResult.ValidationType.CARDINALITY, "FxOptionPayout", path, "", res.getError());
				}
				return success("FxOptionPayout", ValidationResult.ValidationType.CARDINALITY, "FxOptionPayout", path, "");
			})
			.collect(toList());
	}

}

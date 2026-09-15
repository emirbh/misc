package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.CommonTradeDataReport69__6;
import iso20022.auth030.esma.TradeTransaction49__6;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommonTradeDataReport69__6Validator implements Validator<CommonTradeDataReport69__6> {

	private List<ComparisonResult> getComparisonResults(CommonTradeDataReport69__6 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("txData", (TradeTransaction49__6) o.getTxData() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonTradeDataReport69__6 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonTradeDataReport69__6", ValidationResult.ValidationType.CARDINALITY, "CommonTradeDataReport69__6", path, "", res.getError());
				}
				return success("CommonTradeDataReport69__6", ValidationResult.ValidationType.CARDINALITY, "CommonTradeDataReport69__6", path, "");
			})
			.collect(toList());
	}

}

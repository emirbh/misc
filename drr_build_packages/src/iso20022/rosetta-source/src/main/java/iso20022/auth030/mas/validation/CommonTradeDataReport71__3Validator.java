package iso20022.auth030.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.mas.CommonTradeDataReport71__3;
import iso20022.auth030.mas.ContractType15__1;
import iso20022.auth030.mas.TradeTransaction50__3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommonTradeDataReport71__3Validator implements Validator<CommonTradeDataReport71__3> {

	private List<ComparisonResult> getComparisonResults(CommonTradeDataReport71__3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ctrctData", (ContractType15__1) o.getCtrctData() != null ? 1 : 0, 0, 1), 
				checkCardinality("txData", (TradeTransaction50__3) o.getTxData() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonTradeDataReport71__3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonTradeDataReport71__3", ValidationResult.ValidationType.CARDINALITY, "CommonTradeDataReport71__3", path, "", res.getError());
				}
				return success("CommonTradeDataReport71__3", ValidationResult.ValidationType.CARDINALITY, "CommonTradeDataReport71__3", path, "");
			})
			.collect(toList());
	}

}

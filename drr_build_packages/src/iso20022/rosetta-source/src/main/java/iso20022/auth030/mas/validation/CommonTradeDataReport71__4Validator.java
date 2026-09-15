package iso20022.auth030.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.mas.CommonTradeDataReport71__4;
import iso20022.auth030.mas.ContractType15__2;
import iso20022.auth030.mas.TradeTransaction50__4;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommonTradeDataReport71__4Validator implements Validator<CommonTradeDataReport71__4> {

	private List<ComparisonResult> getComparisonResults(CommonTradeDataReport71__4 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ctrctData", (ContractType15__2) o.getCtrctData() != null ? 1 : 0, 0, 1), 
				checkCardinality("txData", (TradeTransaction50__4) o.getTxData() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonTradeDataReport71__4 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonTradeDataReport71__4", ValidationResult.ValidationType.CARDINALITY, "CommonTradeDataReport71__4", path, "", res.getError());
				}
				return success("CommonTradeDataReport71__4", ValidationResult.ValidationType.CARDINALITY, "CommonTradeDataReport71__4", path, "");
			})
			.collect(toList());
	}

}

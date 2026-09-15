package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.CommonTradeDataReport69__5;
import iso20022.auth030.esma.ContractType14__1;
import iso20022.auth030.esma.TradeTransaction49__5;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommonTradeDataReport69__5Validator implements Validator<CommonTradeDataReport69__5> {

	private List<ComparisonResult> getComparisonResults(CommonTradeDataReport69__5 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ctrctData", (ContractType14__1) o.getCtrctData() != null ? 1 : 0, 0, 1), 
				checkCardinality("txData", (TradeTransaction49__5) o.getTxData() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonTradeDataReport69__5 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonTradeDataReport69__5", ValidationResult.ValidationType.CARDINALITY, "CommonTradeDataReport69__5", path, "", res.getError());
				}
				return success("CommonTradeDataReport69__5", ValidationResult.ValidationType.CARDINALITY, "CommonTradeDataReport69__5", path, "");
			})
			.collect(toList());
	}

}

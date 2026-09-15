package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.CommonTradeDataReport71__5;
import iso20022.auth030.hkma.dtcc.TradeTransaction50__5;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommonTradeDataReport71__5Validator implements Validator<CommonTradeDataReport71__5> {

	private List<ComparisonResult> getComparisonResults(CommonTradeDataReport71__5 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("txData", (TradeTransaction50__5) o.getTxData() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonTradeDataReport71__5 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonTradeDataReport71__5", ValidationResult.ValidationType.CARDINALITY, "CommonTradeDataReport71__5", path, "", res.getError());
				}
				return success("CommonTradeDataReport71__5", ValidationResult.ValidationType.CARDINALITY, "CommonTradeDataReport71__5", path, "");
			})
			.collect(toList());
	}

}

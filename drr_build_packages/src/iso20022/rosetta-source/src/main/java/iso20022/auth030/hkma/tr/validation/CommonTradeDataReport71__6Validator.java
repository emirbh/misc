package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.CommonTradeDataReport71__6;
import iso20022.auth030.hkma.tr.ContractType15__2;
import iso20022.auth030.hkma.tr.TradeTransaction50__6;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommonTradeDataReport71__6Validator implements Validator<CommonTradeDataReport71__6> {

	private List<ComparisonResult> getComparisonResults(CommonTradeDataReport71__6 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ctrctData", (ContractType15__2) o.getCtrctData() != null ? 1 : 0, 1, 1), 
				checkCardinality("txData", (TradeTransaction50__6) o.getTxData() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonTradeDataReport71__6 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonTradeDataReport71__6", ValidationResult.ValidationType.CARDINALITY, "CommonTradeDataReport71__6", path, "", res.getError());
				}
				return success("CommonTradeDataReport71__6", ValidationResult.ValidationType.CARDINALITY, "CommonTradeDataReport71__6", path, "");
			})
			.collect(toList());
	}

}

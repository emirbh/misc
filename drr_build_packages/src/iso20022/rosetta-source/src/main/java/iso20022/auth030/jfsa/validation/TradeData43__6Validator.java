package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.CommonTradeDataReport71__6;
import iso20022.auth030.jfsa.CounterpartySpecificData36__1;
import iso20022.auth030.jfsa.TechnicalAttributes5__1;
import iso20022.auth030.jfsa.TradeData43__6;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeData43__6Validator implements Validator<TradeData43__6> {

	private List<ComparisonResult> getComparisonResults(TradeData43__6 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ctrPtySpcfcData", (CounterpartySpecificData36__1) o.getCtrPtySpcfcData() != null ? 1 : 0, 1, 1), 
				checkCardinality("cmonTradData", (CommonTradeDataReport71__6) o.getCmonTradData() != null ? 1 : 0, 1, 1), 
				checkCardinality("techAttrbts", (TechnicalAttributes5__1) o.getTechAttrbts() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeData43__6 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeData43__6", ValidationResult.ValidationType.CARDINALITY, "TradeData43__6", path, "", res.getError());
				}
				return success("TradeData43__6", ValidationResult.ValidationType.CARDINALITY, "TradeData43__6", path, "");
			})
			.collect(toList());
	}

}

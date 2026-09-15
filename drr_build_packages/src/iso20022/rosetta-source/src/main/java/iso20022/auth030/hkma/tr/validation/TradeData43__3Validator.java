package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.CommonTradeDataReport71__3;
import iso20022.auth030.hkma.tr.CounterpartySpecificData36__1;
import iso20022.auth030.hkma.tr.SupplementaryData1;
import iso20022.auth030.hkma.tr.TechnicalAttributes5__1;
import iso20022.auth030.hkma.tr.TradeData43__3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeData43__3Validator implements Validator<TradeData43__3> {

	private List<ComparisonResult> getComparisonResults(TradeData43__3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ctrPtySpcfcData", (CounterpartySpecificData36__1) o.getCtrPtySpcfcData() != null ? 1 : 0, 1, 1), 
				checkCardinality("cmonTradData", (CommonTradeDataReport71__3) o.getCmonTradData() != null ? 1 : 0, 1, 1), 
				checkCardinality("techAttrbts", (TechnicalAttributes5__1) o.getTechAttrbts() != null ? 1 : 0, 1, 1), 
				checkCardinality("splmtryData", (SupplementaryData1) o.getSplmtryData() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeData43__3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeData43__3", ValidationResult.ValidationType.CARDINALITY, "TradeData43__3", path, "", res.getError());
				}
				return success("TradeData43__3", ValidationResult.ValidationType.CARDINALITY, "TradeData43__3", path, "");
			})
			.collect(toList());
	}

}

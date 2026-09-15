package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.CommonTradeDataReport71__7;
import iso20022.auth030.hkma.dtcc.CounterpartySpecificData36__2;
import iso20022.auth030.hkma.dtcc.SupplementaryData1;
import iso20022.auth030.hkma.dtcc.TechnicalAttributes5__1;
import iso20022.auth030.hkma.dtcc.TradeData43__7;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeData43__7Validator implements Validator<TradeData43__7> {

	private List<ComparisonResult> getComparisonResults(TradeData43__7 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ctrPtySpcfcData", (CounterpartySpecificData36__2) o.getCtrPtySpcfcData() != null ? 1 : 0, 1, 1), 
				checkCardinality("cmonTradData", (CommonTradeDataReport71__7) o.getCmonTradData() != null ? 1 : 0, 1, 1), 
				checkCardinality("techAttrbts", (TechnicalAttributes5__1) o.getTechAttrbts() != null ? 1 : 0, 1, 1), 
				checkCardinality("splmtryData", (SupplementaryData1) o.getSplmtryData() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeData43__7 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeData43__7", ValidationResult.ValidationType.CARDINALITY, "TradeData43__7", path, "", res.getError());
				}
				return success("TradeData43__7", ValidationResult.ValidationType.CARDINALITY, "TradeData43__7", path, "");
			})
			.collect(toList());
	}

}

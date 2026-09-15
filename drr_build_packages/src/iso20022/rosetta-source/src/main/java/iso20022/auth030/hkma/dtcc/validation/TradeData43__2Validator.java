package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.CommonTradeDataReport71__2;
import iso20022.auth030.hkma.dtcc.CounterpartySpecificData36__1;
import iso20022.auth030.hkma.dtcc.SupplementaryData1;
import iso20022.auth030.hkma.dtcc.TechnicalAttributes5__1;
import iso20022.auth030.hkma.dtcc.TradeData43__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeData43__2Validator implements Validator<TradeData43__2> {

	private List<ComparisonResult> getComparisonResults(TradeData43__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ctrPtySpcfcData", (CounterpartySpecificData36__1) o.getCtrPtySpcfcData() != null ? 1 : 0, 1, 1), 
				checkCardinality("cmonTradData", (CommonTradeDataReport71__2) o.getCmonTradData() != null ? 1 : 0, 1, 1), 
				checkCardinality("techAttrbts", (TechnicalAttributes5__1) o.getTechAttrbts() != null ? 1 : 0, 1, 1), 
				checkCardinality("splmtryData", (SupplementaryData1) o.getSplmtryData() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeData43__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeData43__2", ValidationResult.ValidationType.CARDINALITY, "TradeData43__2", path, "", res.getError());
				}
				return success("TradeData43__2", ValidationResult.ValidationType.CARDINALITY, "TradeData43__2", path, "");
			})
			.collect(toList());
	}

}

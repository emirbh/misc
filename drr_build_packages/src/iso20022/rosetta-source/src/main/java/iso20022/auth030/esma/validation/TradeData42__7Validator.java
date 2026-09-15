package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.CommonTradeDataReport69__6;
import iso20022.auth030.esma.CounterpartySpecificData36__3;
import iso20022.auth030.esma.ModificationLevel1Code;
import iso20022.auth030.esma.TradeData42__7;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeData42__7Validator implements Validator<TradeData42__7> {

	private List<ComparisonResult> getComparisonResults(TradeData42__7 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ctrPtySpcfcData", (CounterpartySpecificData36__3) o.getCtrPtySpcfcData() != null ? 1 : 0, 1, 1), 
				checkCardinality("cmonTradData", (CommonTradeDataReport69__6) o.getCmonTradData() != null ? 1 : 0, 1, 1), 
				checkCardinality("lvl", (ModificationLevel1Code) o.getLvl() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeData42__7 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeData42__7", ValidationResult.ValidationType.CARDINALITY, "TradeData42__7", path, "", res.getError());
				}
				return success("TradeData42__7", ValidationResult.ValidationType.CARDINALITY, "TradeData42__7", path, "");
			})
			.collect(toList());
	}

}

package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.CommonTradeDataReport69__7;
import iso20022.auth030.fca.CounterpartySpecificData36__1;
import iso20022.auth030.fca.ModificationLevel1Code;
import iso20022.auth030.fca.TradeData42__8;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeData42__8Validator implements Validator<TradeData42__8> {

	private List<ComparisonResult> getComparisonResults(TradeData42__8 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ctrPtySpcfcData", (CounterpartySpecificData36__1) o.getCtrPtySpcfcData() != null ? 1 : 0, 1, 1), 
				checkCardinality("cmonTradData", (CommonTradeDataReport69__7) o.getCmonTradData() != null ? 1 : 0, 1, 1), 
				checkCardinality("lvl", (ModificationLevel1Code) o.getLvl() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeData42__8 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeData42__8", ValidationResult.ValidationType.CARDINALITY, "TradeData42__8", path, "", res.getError());
				}
				return success("TradeData42__8", ValidationResult.ValidationType.CARDINALITY, "TradeData42__8", path, "");
			})
			.collect(toList());
	}

}

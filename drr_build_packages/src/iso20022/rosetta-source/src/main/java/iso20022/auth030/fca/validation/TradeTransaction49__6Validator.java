package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.CollateralPortfolioCode5Choice__1;
import iso20022.auth030.fca.DerivativeEvent6__5;
import iso20022.auth030.fca.PTRREvent2__1;
import iso20022.auth030.fca.TradeTransaction49__6;
import iso20022.auth030.fca.UniqueTransactionIdentifier2Choice__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeTransaction49__6Validator implements Validator<TradeTransaction49__6> {

	private List<ComparisonResult> getComparisonResults(TradeTransaction49__6 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("txId", (UniqueTransactionIdentifier2Choice__2) o.getTxId() != null ? 1 : 0, 1, 1), 
				checkCardinality("collPrtflCd", (CollateralPortfolioCode5Choice__1) o.getCollPrtflCd() != null ? 1 : 0, 0, 1), 
				checkCardinality("pstTradRskRdctnFlg", (Boolean) o.getPstTradRskRdctnFlg() != null ? 1 : 0, 0, 1), 
				checkCardinality("pstTradRskRdctnEvt", (PTRREvent2__1) o.getPstTradRskRdctnEvt() != null ? 1 : 0, 0, 1), 
				checkCardinality("derivEvt", (DerivativeEvent6__5) o.getDerivEvt() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeTransaction49__6 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeTransaction49__6", ValidationResult.ValidationType.CARDINALITY, "TradeTransaction49__6", path, "", res.getError());
				}
				return success("TradeTransaction49__6", ValidationResult.ValidationType.CARDINALITY, "TradeTransaction49__6", path, "");
			})
			.collect(toList());
	}

}

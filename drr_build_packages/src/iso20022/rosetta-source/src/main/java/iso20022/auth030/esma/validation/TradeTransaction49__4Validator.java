package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.CollateralPortfolioCode5Choice__1;
import iso20022.auth030.esma.DerivativeEvent6__4;
import iso20022.auth030.esma.PTRREvent2__1;
import iso20022.auth030.esma.TradeTransaction49__4;
import iso20022.auth030.esma.UniqueTransactionIdentifier2Choice__2;
import iso20022.auth030.esma.UniqueTransactionIdentifier3Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeTransaction49__4Validator implements Validator<TradeTransaction49__4> {

	private List<ComparisonResult> getComparisonResults(TradeTransaction49__4 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("txId", (UniqueTransactionIdentifier2Choice__2) o.getTxId() != null ? 1 : 0, 1, 1), 
				checkCardinality("sbsqntTxId", (UniqueTransactionIdentifier3Choice__1) o.getSbsqntTxId() != null ? 1 : 0, 0, 1), 
				checkCardinality("collPrtflCd", (CollateralPortfolioCode5Choice__1) o.getCollPrtflCd() != null ? 1 : 0, 0, 1), 
				checkCardinality("earlyTermntnDt", (Date) o.getEarlyTermntnDt() != null ? 1 : 0, 1, 1), 
				checkCardinality("pstTradRskRdctnFlg", (Boolean) o.getPstTradRskRdctnFlg() != null ? 1 : 0, 0, 1), 
				checkCardinality("pstTradRskRdctnEvt", (PTRREvent2__1) o.getPstTradRskRdctnEvt() != null ? 1 : 0, 0, 1), 
				checkCardinality("derivEvt", (DerivativeEvent6__4) o.getDerivEvt() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeTransaction49__4 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeTransaction49__4", ValidationResult.ValidationType.CARDINALITY, "TradeTransaction49__4", path, "", res.getError());
				}
				return success("TradeTransaction49__4", ValidationResult.ValidationType.CARDINALITY, "TradeTransaction49__4", path, "");
			})
			.collect(toList());
	}

}

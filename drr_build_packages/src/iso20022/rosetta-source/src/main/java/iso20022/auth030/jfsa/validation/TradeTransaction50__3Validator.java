package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.CollateralPortfolioCode6Choice__1;
import iso20022.auth030.jfsa.CreditDerivative4__1;
import iso20022.auth030.jfsa.CurrencyExchange22__1;
import iso20022.auth030.jfsa.DerivativeEvent6__2;
import iso20022.auth030.jfsa.InterestRateLegs14__2;
import iso20022.auth030.jfsa.NotionalAmountLegs5__1;
import iso20022.auth030.jfsa.NotionalQuantityLegs5__1;
import iso20022.auth030.jfsa.OptionOrSwaption11__1;
import iso20022.auth030.jfsa.Package4__1;
import iso20022.auth030.jfsa.PhysicalTransferType4Code;
import iso20022.auth030.jfsa.PriceData2__1;
import iso20022.auth030.jfsa.TradeClearing11__1;
import iso20022.auth030.jfsa.TradeConfirmation4Choice;
import iso20022.auth030.jfsa.TradeTransaction50__3;
import iso20022.auth030.jfsa.UniqueTransactionIdentifier2Choice__1;
import iso20022.auth030.jfsa.UniqueTransactionIdentifier3Choice__1;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeTransaction50__3Validator implements Validator<TradeTransaction50__3> {

	private List<ComparisonResult> getComparisonResults(TradeTransaction50__3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("txId", (UniqueTransactionIdentifier2Choice__1) o.getTxId() != null ? 1 : 0, 1, 1), 
				checkCardinality("scndryTxId", (String) o.getScndryTxId() != null ? 1 : 0, 0, 1), 
				checkCardinality("prrTxId", (UniqueTransactionIdentifier3Choice__1) o.getPrrTxId() != null ? 1 : 0, 0, 1), 
				checkCardinality("collPrtflCd", (CollateralPortfolioCode6Choice__1) o.getCollPrtflCd() != null ? 1 : 0, 1, 1), 
				checkCardinality("pltfmIdr", (String) o.getPltfmIdr() != null ? 1 : 0, 0, 1), 
				checkCardinality("txPric", (PriceData2__1) o.getTxPric() != null ? 1 : 0, 0, 1), 
				checkCardinality("ntnlAmt", (NotionalAmountLegs5__1) o.getNtnlAmt() != null ? 1 : 0, 1, 1), 
				checkCardinality("ntnlQty", (NotionalQuantityLegs5__1) o.getNtnlQty() != null ? 1 : 0, 0, 1), 
				checkCardinality("dlvryTp", (PhysicalTransferType4Code) o.getDlvryTp() != null ? 1 : 0, 1, 1), 
				checkCardinality("exctnTmStmp", (ZonedDateTime) o.getExctnTmStmp() != null ? 1 : 0, 1, 1), 
				checkCardinality("fctvDt", (Date) o.getFctvDt() != null ? 1 : 0, 1, 1), 
				checkCardinality("xprtnDt", (Date) o.getXprtnDt() != null ? 1 : 0, 1, 1), 
				checkCardinality("earlyTermntnDt", (Date) o.getEarlyTermntnDt() != null ? 1 : 0, 0, 1), 
				checkCardinality("sttlmDt", (Date) o.getSttlmDt() != null ? 1 : 0, 1, 1), 
				checkCardinality("derivEvt", (DerivativeEvent6__2) o.getDerivEvt() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradConf", (TradeConfirmation4Choice) o.getTradConf() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradClr", (TradeClearing11__1) o.getTradClr() != null ? 1 : 0, 1, 1), 
				checkCardinality("intrstRate", (InterestRateLegs14__2) o.getIntrstRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("ccy", (CurrencyExchange22__1) o.getCcy() != null ? 1 : 0, 0, 1), 
				checkCardinality("optn", (OptionOrSwaption11__1) o.getOptn() != null ? 1 : 0, 0, 1), 
				checkCardinality("cdt", (CreditDerivative4__1) o.getCdt() != null ? 1 : 0, 0, 1), 
				checkCardinality("packg", (Package4__1) o.getPackg() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeTransaction50__3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeTransaction50__3", ValidationResult.ValidationType.CARDINALITY, "TradeTransaction50__3", path, "", res.getError());
				}
				return success("TradeTransaction50__3", ValidationResult.ValidationType.CARDINALITY, "TradeTransaction50__3", path, "");
			})
			.collect(toList());
	}

}

package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassCommodity7Choice;
import iso20022.auth030.hkma.dtcc.CollateralPortfolioCode6Choice__1;
import iso20022.auth030.hkma.dtcc.CreditDerivative4__1;
import iso20022.auth030.hkma.dtcc.CurrencyExchange22__1;
import iso20022.auth030.hkma.dtcc.DerivativeEvent6__2;
import iso20022.auth030.hkma.dtcc.InterestRateLegs14__1;
import iso20022.auth030.hkma.dtcc.NotionalAmountLegs5__1;
import iso20022.auth030.hkma.dtcc.NotionalQuantityLegs5__1;
import iso20022.auth030.hkma.dtcc.OptionOrSwaption11__1;
import iso20022.auth030.hkma.dtcc.OtherPayment5__1;
import iso20022.auth030.hkma.dtcc.Package4__1;
import iso20022.auth030.hkma.dtcc.PhysicalTransferType4Code;
import iso20022.auth030.hkma.dtcc.PriceData2__1;
import iso20022.auth030.hkma.dtcc.TradeClearing11__1;
import iso20022.auth030.hkma.dtcc.TradeConfirmation4Choice__1;
import iso20022.auth030.hkma.dtcc.TradeTransaction50__2;
import iso20022.auth030.hkma.dtcc.UniqueTransactionIdentifier2Choice__1;
import iso20022.auth030.hkma.dtcc.UniqueTransactionIdentifier3Choice__1;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeTransaction50__2Validator implements Validator<TradeTransaction50__2> {

	private List<ComparisonResult> getComparisonResults(TradeTransaction50__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("txId", (UniqueTransactionIdentifier2Choice__1) o.getTxId() != null ? 1 : 0, 1, 1), 
				checkCardinality("scndryTxId", (String) o.getScndryTxId() != null ? 1 : 0, 0, 1), 
				checkCardinality("prrTxId", (UniqueTransactionIdentifier3Choice__1) o.getPrrTxId() != null ? 1 : 0, 0, 1), 
				checkCardinality("collPrtflCd", (CollateralPortfolioCode6Choice__1) o.getCollPrtflCd() != null ? 1 : 0, 1, 1), 
				checkCardinality("pltfmIdr", (String) o.getPltfmIdr() != null ? 1 : 0, 0, 1), 
				checkCardinality("txPric", (PriceData2__1) o.getTxPric() != null ? 1 : 0, 0, 1), 
				checkCardinality("ntnlAmt", (NotionalAmountLegs5__1) o.getNtnlAmt() != null ? 1 : 0, 1, 1), 
				checkCardinality("ntnlQty", (NotionalQuantityLegs5__1) o.getNtnlQty() != null ? 1 : 0, 0, 1), 
				checkCardinality("dlvryTp", (PhysicalTransferType4Code) o.getDlvryTp() != null ? 1 : 0, 0, 1), 
				checkCardinality("exctnTmStmp", (ZonedDateTime) o.getExctnTmStmp() != null ? 1 : 0, 1, 1), 
				checkCardinality("fctvDt", (Date) o.getFctvDt() != null ? 1 : 0, 0, 1), 
				checkCardinality("xprtnDt", (Date) o.getXprtnDt() != null ? 1 : 0, 1, 1), 
				checkCardinality("sttlmDt", (Date) o.getSttlmDt() != null ? 1 : 0, 0, 1), 
				checkCardinality("derivEvt", (DerivativeEvent6__2) o.getDerivEvt() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradConf", (TradeConfirmation4Choice__1) o.getTradConf() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonStdsdTerm", (Boolean) o.getNonStdsdTerm() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradClr", (TradeClearing11__1) o.getTradClr() != null ? 1 : 0, 1, 1), 
				checkCardinality("intrstRate", (InterestRateLegs14__1) o.getIntrstRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("ccy", (CurrencyExchange22__1) o.getCcy() != null ? 1 : 0, 0, 1), 
				checkCardinality("cmmdty", (AssetClassCommodity7Choice) o.getCmmdty() != null ? 1 : 0, 0, 1), 
				checkCardinality("optn", (OptionOrSwaption11__1) o.getOptn() != null ? 1 : 0, 0, 1), 
				checkCardinality("cdt", (CreditDerivative4__1) o.getCdt() != null ? 1 : 0, 0, 1), 
				checkCardinality("othrPmt", (List<? extends OtherPayment5__1>) o.getOthrPmt() == null ? 0 : o.getOthrPmt().size(), 0, 600), 
				checkCardinality("packg", (Package4__1) o.getPackg() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeTransaction50__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeTransaction50__2", ValidationResult.ValidationType.CARDINALITY, "TradeTransaction50__2", path, "", res.getError());
				}
				return success("TradeTransaction50__2", ValidationResult.ValidationType.CARDINALITY, "TradeTransaction50__2", path, "");
			})
			.collect(toList());
	}

}

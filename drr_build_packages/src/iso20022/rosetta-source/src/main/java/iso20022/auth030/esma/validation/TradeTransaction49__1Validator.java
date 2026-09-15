package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassCommodity6Choice__1;
import iso20022.auth030.esma.CollateralPortfolioCode5Choice__1;
import iso20022.auth030.esma.CreditDerivative4__1;
import iso20022.auth030.esma.CurrencyExchange22__1;
import iso20022.auth030.esma.DerivativeEvent6__1;
import iso20022.auth030.esma.EnergySpecificAttribute9__1;
import iso20022.auth030.esma.InterestRateLegs14__1;
import iso20022.auth030.esma.MasterAgreement8__1;
import iso20022.auth030.esma.NotionalAmountLegs5__1;
import iso20022.auth030.esma.NotionalQuantityLegs5__1;
import iso20022.auth030.esma.OptionOrSwaption10__1;
import iso20022.auth030.esma.PTRREvent2__1;
import iso20022.auth030.esma.Package4__1;
import iso20022.auth030.esma.PhysicalTransferType4Code;
import iso20022.auth030.esma.PriceData2__1;
import iso20022.auth030.esma.TradeClearing11__1;
import iso20022.auth030.esma.TradeConfirmation1Choice;
import iso20022.auth030.esma.TradeTransaction49__1;
import iso20022.auth030.esma.UniqueTransactionIdentifier2Choice__1;
import iso20022.auth030.esma.UniqueTransactionIdentifier3Choice__1;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeTransaction49__1Validator implements Validator<TradeTransaction49__1> {

	private List<ComparisonResult> getComparisonResults(TradeTransaction49__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("txId", (UniqueTransactionIdentifier2Choice__1) o.getTxId() != null ? 1 : 0, 1, 1), 
				checkCardinality("prrTxId", (UniqueTransactionIdentifier3Choice__1) o.getPrrTxId() != null ? 1 : 0, 0, 1), 
				checkCardinality("collPrtflCd", (CollateralPortfolioCode5Choice__1) o.getCollPrtflCd() != null ? 1 : 0, 1, 1), 
				checkCardinality("rptTrckgNb", (String) o.getRptTrckgNb() != null ? 1 : 0, 0, 1), 
				checkCardinality("pltfmIdr", (String) o.getPltfmIdr() != null ? 1 : 0, 0, 1), 
				checkCardinality("txPric", (PriceData2__1) o.getTxPric() != null ? 1 : 0, 0, 1), 
				checkCardinality("ntnlAmt", (NotionalAmountLegs5__1) o.getNtnlAmt() != null ? 1 : 0, 1, 1), 
				checkCardinality("ntnlQty", (NotionalQuantityLegs5__1) o.getNtnlQty() != null ? 1 : 0, 0, 1), 
				checkCardinality("dlvryTp", (PhysicalTransferType4Code) o.getDlvryTp() != null ? 1 : 0, 1, 1), 
				checkCardinality("exctnTmStmp", (ZonedDateTime) o.getExctnTmStmp() != null ? 1 : 0, 1, 1), 
				checkCardinality("fctvDt", (Date) o.getFctvDt() != null ? 1 : 0, 1, 1), 
				checkCardinality("xprtnDt", (Date) o.getXprtnDt() != null ? 1 : 0, 0, 1), 
				checkCardinality("sttlmDt", (Date) o.getSttlmDt() != null ? 1 : 0, 0, 1), 
				checkCardinality("mstrAgrmt", (MasterAgreement8__1) o.getMstrAgrmt() != null ? 1 : 0, 1, 1), 
				checkCardinality("pstTradRskRdctnFlg", (Boolean) o.getPstTradRskRdctnFlg() != null ? 1 : 0, 0, 1), 
				checkCardinality("pstTradRskRdctnEvt", (PTRREvent2__1) o.getPstTradRskRdctnEvt() != null ? 1 : 0, 0, 1), 
				checkCardinality("derivEvt", (DerivativeEvent6__1) o.getDerivEvt() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradConf", (TradeConfirmation1Choice) o.getTradConf() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradClr", (TradeClearing11__1) o.getTradClr() != null ? 1 : 0, 1, 1), 
				checkCardinality("intrstRate", (InterestRateLegs14__1) o.getIntrstRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("ccy", (CurrencyExchange22__1) o.getCcy() != null ? 1 : 0, 0, 1), 
				checkCardinality("cmmdty", (AssetClassCommodity6Choice__1) o.getCmmdty() != null ? 1 : 0, 0, 1), 
				checkCardinality("optn", (OptionOrSwaption10__1) o.getOptn() != null ? 1 : 0, 0, 1), 
				checkCardinality("nrgySpcfcAttrbts", (EnergySpecificAttribute9__1) o.getNrgySpcfcAttrbts() != null ? 1 : 0, 0, 1), 
				checkCardinality("cdt", (CreditDerivative4__1) o.getCdt() != null ? 1 : 0, 0, 1), 
				checkCardinality("packg", (Package4__1) o.getPackg() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeTransaction49__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeTransaction49__1", ValidationResult.ValidationType.CARDINALITY, "TradeTransaction49__1", path, "", res.getError());
				}
				return success("TradeTransaction49__1", ValidationResult.ValidationType.CARDINALITY, "TradeTransaction49__1", path, "");
			})
			.collect(toList());
	}

}

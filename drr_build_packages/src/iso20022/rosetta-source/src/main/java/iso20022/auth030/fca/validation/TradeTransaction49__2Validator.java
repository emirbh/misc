package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.AssetClassCommodity6Choice__1;
import iso20022.auth030.fca.CollateralPortfolioCode5Choice__1;
import iso20022.auth030.fca.CreditDerivative4__1;
import iso20022.auth030.fca.CurrencyExchange22__1;
import iso20022.auth030.fca.DerivativeEvent6__2;
import iso20022.auth030.fca.EnergySpecificAttribute9__1;
import iso20022.auth030.fca.InterestRateLegs14__1;
import iso20022.auth030.fca.MasterAgreement8__1;
import iso20022.auth030.fca.NotionalAmountLegs5__1;
import iso20022.auth030.fca.NotionalQuantityLegs5__1;
import iso20022.auth030.fca.OptionOrSwaption10__1;
import iso20022.auth030.fca.PTRREvent2__1;
import iso20022.auth030.fca.Package4__1;
import iso20022.auth030.fca.PhysicalTransferType4Code;
import iso20022.auth030.fca.PriceData2__1;
import iso20022.auth030.fca.TradeClearing11__1;
import iso20022.auth030.fca.TradeConfirmation1Choice;
import iso20022.auth030.fca.TradeTransaction49__2;
import iso20022.auth030.fca.UniqueTransactionIdentifier2Choice__2;
import iso20022.auth030.fca.UniqueTransactionIdentifier3Choice__1;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeTransaction49__2Validator implements Validator<TradeTransaction49__2> {

	private List<ComparisonResult> getComparisonResults(TradeTransaction49__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("txId", (UniqueTransactionIdentifier2Choice__2) o.getTxId() != null ? 1 : 0, 1, 1), 
				checkCardinality("prrTxId", (UniqueTransactionIdentifier3Choice__1) o.getPrrTxId() != null ? 1 : 0, 0, 1), 
				checkCardinality("sbsqntTxId", (UniqueTransactionIdentifier3Choice__1) o.getSbsqntTxId() != null ? 1 : 0, 0, 1), 
				checkCardinality("collPrtflCd", (CollateralPortfolioCode5Choice__1) o.getCollPrtflCd() != null ? 1 : 0, 1, 1), 
				checkCardinality("rptTrckgNb", (String) o.getRptTrckgNb() != null ? 1 : 0, 0, 1), 
				checkCardinality("pltfmIdr", (String) o.getPltfmIdr() != null ? 1 : 0, 1, 1), 
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
				checkCardinality("derivEvt", (DerivativeEvent6__2) o.getDerivEvt() != null ? 1 : 0, 1, 1), 
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
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeTransaction49__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeTransaction49__2", ValidationResult.ValidationType.CARDINALITY, "TradeTransaction49__2", path, "", res.getError());
				}
				return success("TradeTransaction49__2", ValidationResult.ValidationType.CARDINALITY, "TradeTransaction49__2", path, "");
			})
			.collect(toList());
	}

}

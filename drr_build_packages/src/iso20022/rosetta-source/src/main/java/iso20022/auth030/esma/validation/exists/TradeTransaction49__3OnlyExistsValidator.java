package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AssetClassCommodity6Choice__1;
import iso20022.auth030.esma.CollateralPortfolioCode5Choice__1;
import iso20022.auth030.esma.CreditDerivative4__1;
import iso20022.auth030.esma.CurrencyExchange22__1;
import iso20022.auth030.esma.DerivativeEvent6__3;
import iso20022.auth030.esma.EnergySpecificAttribute9__1;
import iso20022.auth030.esma.InterestRateLegs14__1;
import iso20022.auth030.esma.MasterAgreement8__1;
import iso20022.auth030.esma.NotionalAmountLegs5__1;
import iso20022.auth030.esma.NotionalQuantityLegs5__2;
import iso20022.auth030.esma.OptionOrSwaption10__1;
import iso20022.auth030.esma.OtherPayment5__1;
import iso20022.auth030.esma.PTRREvent2__1;
import iso20022.auth030.esma.Package4__1;
import iso20022.auth030.esma.PhysicalTransferType4Code;
import iso20022.auth030.esma.PriceData2__1;
import iso20022.auth030.esma.TradeClearing11__1;
import iso20022.auth030.esma.TradeConfirmation1Choice;
import iso20022.auth030.esma.TradeTransaction49__3;
import iso20022.auth030.esma.UniqueTransactionIdentifier2Choice__2;
import iso20022.auth030.esma.UniqueTransactionIdentifier3Choice__1;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeTransaction49__3OnlyExistsValidator implements ValidatorWithArg<TradeTransaction49__3, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeTransaction49__3> ValidationResult<TradeTransaction49__3> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("txId", ExistenceChecker.isSet((UniqueTransactionIdentifier2Choice__2) o.getTxId()))
				.put("prrTxId", ExistenceChecker.isSet((UniqueTransactionIdentifier3Choice__1) o.getPrrTxId()))
				.put("sbsqntTxId", ExistenceChecker.isSet((UniqueTransactionIdentifier3Choice__1) o.getSbsqntTxId()))
				.put("collPrtflCd", ExistenceChecker.isSet((CollateralPortfolioCode5Choice__1) o.getCollPrtflCd()))
				.put("rptTrckgNb", ExistenceChecker.isSet((String) o.getRptTrckgNb()))
				.put("pltfmIdr", ExistenceChecker.isSet((String) o.getPltfmIdr()))
				.put("txPric", ExistenceChecker.isSet((PriceData2__1) o.getTxPric()))
				.put("ntnlAmt", ExistenceChecker.isSet((NotionalAmountLegs5__1) o.getNtnlAmt()))
				.put("ntnlQty", ExistenceChecker.isSet((NotionalQuantityLegs5__2) o.getNtnlQty()))
				.put("dlvryTp", ExistenceChecker.isSet((PhysicalTransferType4Code) o.getDlvryTp()))
				.put("exctnTmStmp", ExistenceChecker.isSet((ZonedDateTime) o.getExctnTmStmp()))
				.put("fctvDt", ExistenceChecker.isSet((Date) o.getFctvDt()))
				.put("xprtnDt", ExistenceChecker.isSet((Date) o.getXprtnDt()))
				.put("earlyTermntnDt", ExistenceChecker.isSet((Date) o.getEarlyTermntnDt()))
				.put("sttlmDt", ExistenceChecker.isSet((Date) o.getSttlmDt()))
				.put("mstrAgrmt", ExistenceChecker.isSet((MasterAgreement8__1) o.getMstrAgrmt()))
				.put("pstTradRskRdctnFlg", ExistenceChecker.isSet((Boolean) o.getPstTradRskRdctnFlg()))
				.put("pstTradRskRdctnEvt", ExistenceChecker.isSet((PTRREvent2__1) o.getPstTradRskRdctnEvt()))
				.put("derivEvt", ExistenceChecker.isSet((DerivativeEvent6__3) o.getDerivEvt()))
				.put("tradConf", ExistenceChecker.isSet((TradeConfirmation1Choice) o.getTradConf()))
				.put("tradClr", ExistenceChecker.isSet((TradeClearing11__1) o.getTradClr()))
				.put("intrstRate", ExistenceChecker.isSet((InterestRateLegs14__1) o.getIntrstRate()))
				.put("ccy", ExistenceChecker.isSet((CurrencyExchange22__1) o.getCcy()))
				.put("cmmdty", ExistenceChecker.isSet((AssetClassCommodity6Choice__1) o.getCmmdty()))
				.put("optn", ExistenceChecker.isSet((OptionOrSwaption10__1) o.getOptn()))
				.put("nrgySpcfcAttrbts", ExistenceChecker.isSet((EnergySpecificAttribute9__1) o.getNrgySpcfcAttrbts()))
				.put("cdt", ExistenceChecker.isSet((CreditDerivative4__1) o.getCdt()))
				.put("othrPmt", ExistenceChecker.isSet((List<? extends OtherPayment5__1>) o.getOthrPmt()))
				.put("packg", ExistenceChecker.isSet((Package4__1) o.getPackg()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeTransaction49__3", ValidationResult.ValidationType.ONLY_EXISTS, "TradeTransaction49__3", path, "");
		}
		return failure("TradeTransaction49__3", ValidationResult.ValidationType.ONLY_EXISTS, "TradeTransaction49__3", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

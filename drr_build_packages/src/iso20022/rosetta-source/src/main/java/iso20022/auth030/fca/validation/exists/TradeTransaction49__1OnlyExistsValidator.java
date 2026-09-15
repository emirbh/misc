package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AssetClassCommodity6Choice__1;
import iso20022.auth030.fca.CollateralPortfolioCode5Choice__1;
import iso20022.auth030.fca.CreditDerivative4__1;
import iso20022.auth030.fca.CurrencyExchange22__1;
import iso20022.auth030.fca.DerivativeEvent6__1;
import iso20022.auth030.fca.EnergySpecificAttribute9__1;
import iso20022.auth030.fca.InterestRateLegs14__1;
import iso20022.auth030.fca.MasterAgreement8__1;
import iso20022.auth030.fca.NotionalAmountLegs5__1;
import iso20022.auth030.fca.NotionalQuantityLegs5__1;
import iso20022.auth030.fca.OptionOrSwaption10__1;
import iso20022.auth030.fca.OtherPayment5__1;
import iso20022.auth030.fca.PTRREvent2__1;
import iso20022.auth030.fca.Package4__1;
import iso20022.auth030.fca.PhysicalTransferType4Code;
import iso20022.auth030.fca.PriceData2__1;
import iso20022.auth030.fca.TradeClearing11__1;
import iso20022.auth030.fca.TradeConfirmation1Choice;
import iso20022.auth030.fca.TradeTransaction49__1;
import iso20022.auth030.fca.UniqueTransactionIdentifier2Choice__1;
import iso20022.auth030.fca.UniqueTransactionIdentifier3Choice__1;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeTransaction49__1OnlyExistsValidator implements ValidatorWithArg<TradeTransaction49__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeTransaction49__1> ValidationResult<TradeTransaction49__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("txId", ExistenceChecker.isSet((UniqueTransactionIdentifier2Choice__1) o.getTxId()))
				.put("prrTxId", ExistenceChecker.isSet((UniqueTransactionIdentifier3Choice__1) o.getPrrTxId()))
				.put("collPrtflCd", ExistenceChecker.isSet((CollateralPortfolioCode5Choice__1) o.getCollPrtflCd()))
				.put("rptTrckgNb", ExistenceChecker.isSet((String) o.getRptTrckgNb()))
				.put("pltfmIdr", ExistenceChecker.isSet((String) o.getPltfmIdr()))
				.put("txPric", ExistenceChecker.isSet((PriceData2__1) o.getTxPric()))
				.put("ntnlAmt", ExistenceChecker.isSet((NotionalAmountLegs5__1) o.getNtnlAmt()))
				.put("ntnlQty", ExistenceChecker.isSet((NotionalQuantityLegs5__1) o.getNtnlQty()))
				.put("dlvryTp", ExistenceChecker.isSet((PhysicalTransferType4Code) o.getDlvryTp()))
				.put("exctnTmStmp", ExistenceChecker.isSet((ZonedDateTime) o.getExctnTmStmp()))
				.put("fctvDt", ExistenceChecker.isSet((Date) o.getFctvDt()))
				.put("xprtnDt", ExistenceChecker.isSet((Date) o.getXprtnDt()))
				.put("sttlmDt", ExistenceChecker.isSet((Date) o.getSttlmDt()))
				.put("mstrAgrmt", ExistenceChecker.isSet((MasterAgreement8__1) o.getMstrAgrmt()))
				.put("pstTradRskRdctnFlg", ExistenceChecker.isSet((Boolean) o.getPstTradRskRdctnFlg()))
				.put("pstTradRskRdctnEvt", ExistenceChecker.isSet((PTRREvent2__1) o.getPstTradRskRdctnEvt()))
				.put("derivEvt", ExistenceChecker.isSet((DerivativeEvent6__1) o.getDerivEvt()))
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
			return success("TradeTransaction49__1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeTransaction49__1", path, "");
		}
		return failure("TradeTransaction49__1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeTransaction49__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

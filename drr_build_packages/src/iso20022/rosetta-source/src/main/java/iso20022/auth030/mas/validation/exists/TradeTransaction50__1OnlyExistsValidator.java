package iso20022.auth030.mas.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.CollateralPortfolioCode6Choice__1;
import iso20022.auth030.mas.CurrencyExchange22__1;
import iso20022.auth030.mas.DerivativeEvent6__1;
import iso20022.auth030.mas.InterestRateLegs14__1;
import iso20022.auth030.mas.NotionalAmountLegs5__1;
import iso20022.auth030.mas.NotionalQuantityLegs5__1;
import iso20022.auth030.mas.OptionOrSwaption11__1;
import iso20022.auth030.mas.OtherPayment5__1;
import iso20022.auth030.mas.Package4__1;
import iso20022.auth030.mas.PhysicalTransferType4Code;
import iso20022.auth030.mas.PriceData2__1;
import iso20022.auth030.mas.TradeClearing11__1;
import iso20022.auth030.mas.TradeConfirmation4Choice__1;
import iso20022.auth030.mas.TradeTransaction50__1;
import iso20022.auth030.mas.UniqueTransactionIdentifier2Choice__1;
import iso20022.auth030.mas.UniqueTransactionIdentifier3Choice__1;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeTransaction50__1OnlyExistsValidator implements ValidatorWithArg<TradeTransaction50__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeTransaction50__1> ValidationResult<TradeTransaction50__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("txId", ExistenceChecker.isSet((UniqueTransactionIdentifier2Choice__1) o.getTxId()))
				.put("prrTxId", ExistenceChecker.isSet((UniqueTransactionIdentifier3Choice__1) o.getPrrTxId()))
				.put("collPrtflCd", ExistenceChecker.isSet((CollateralPortfolioCode6Choice__1) o.getCollPrtflCd()))
				.put("pltfmIdr", ExistenceChecker.isSet((String) o.getPltfmIdr()))
				.put("txPric", ExistenceChecker.isSet((PriceData2__1) o.getTxPric()))
				.put("ntnlAmt", ExistenceChecker.isSet((NotionalAmountLegs5__1) o.getNtnlAmt()))
				.put("ntnlQty", ExistenceChecker.isSet((NotionalQuantityLegs5__1) o.getNtnlQty()))
				.put("dlvryTp", ExistenceChecker.isSet((PhysicalTransferType4Code) o.getDlvryTp()))
				.put("exctnTmStmp", ExistenceChecker.isSet((ZonedDateTime) o.getExctnTmStmp()))
				.put("fctvDt", ExistenceChecker.isSet((Date) o.getFctvDt()))
				.put("xprtnDt", ExistenceChecker.isSet((Date) o.getXprtnDt()))
				.put("sttlmDt", ExistenceChecker.isSet((Date) o.getSttlmDt()))
				.put("derivEvt", ExistenceChecker.isSet((DerivativeEvent6__1) o.getDerivEvt()))
				.put("tradConf", ExistenceChecker.isSet((TradeConfirmation4Choice__1) o.getTradConf()))
				.put("tradClr", ExistenceChecker.isSet((TradeClearing11__1) o.getTradClr()))
				.put("intrstRate", ExistenceChecker.isSet((InterestRateLegs14__1) o.getIntrstRate()))
				.put("ccy", ExistenceChecker.isSet((CurrencyExchange22__1) o.getCcy()))
				.put("optn", ExistenceChecker.isSet((OptionOrSwaption11__1) o.getOptn()))
				.put("othrPmt", ExistenceChecker.isSet((List<? extends OtherPayment5__1>) o.getOthrPmt()))
				.put("packg", ExistenceChecker.isSet((Package4__1) o.getPackg()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeTransaction50__1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeTransaction50__1", path, "");
		}
		return failure("TradeTransaction50__1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeTransaction50__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

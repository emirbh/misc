package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.CollateralPortfolioCode5Choice__1;
import iso20022.auth030.esma.DerivativeEvent6__4;
import iso20022.auth030.esma.OtherPayment5__1;
import iso20022.auth030.esma.PTRREvent2__1;
import iso20022.auth030.esma.TradeTransaction49__4;
import iso20022.auth030.esma.UniqueTransactionIdentifier2Choice__2;
import iso20022.auth030.esma.UniqueTransactionIdentifier3Choice__1;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeTransaction49__4OnlyExistsValidator implements ValidatorWithArg<TradeTransaction49__4, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeTransaction49__4> ValidationResult<TradeTransaction49__4> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("txId", ExistenceChecker.isSet((UniqueTransactionIdentifier2Choice__2) o.getTxId()))
				.put("sbsqntTxId", ExistenceChecker.isSet((UniqueTransactionIdentifier3Choice__1) o.getSbsqntTxId()))
				.put("collPrtflCd", ExistenceChecker.isSet((CollateralPortfolioCode5Choice__1) o.getCollPrtflCd()))
				.put("earlyTermntnDt", ExistenceChecker.isSet((Date) o.getEarlyTermntnDt()))
				.put("pstTradRskRdctnFlg", ExistenceChecker.isSet((Boolean) o.getPstTradRskRdctnFlg()))
				.put("pstTradRskRdctnEvt", ExistenceChecker.isSet((PTRREvent2__1) o.getPstTradRskRdctnEvt()))
				.put("derivEvt", ExistenceChecker.isSet((DerivativeEvent6__4) o.getDerivEvt()))
				.put("othrPmt", ExistenceChecker.isSet((List<? extends OtherPayment5__1>) o.getOthrPmt()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeTransaction49__4", ValidationResult.ValidationType.ONLY_EXISTS, "TradeTransaction49__4", path, "");
		}
		return failure("TradeTransaction49__4", ValidationResult.ValidationType.ONLY_EXISTS, "TradeTransaction49__4", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

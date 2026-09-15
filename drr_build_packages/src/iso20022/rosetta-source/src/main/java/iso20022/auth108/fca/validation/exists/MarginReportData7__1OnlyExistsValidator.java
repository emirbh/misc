package iso20022.auth108.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.fca.MarginCollateralReport4__1;
import iso20022.auth108.fca.MarginReportData7__1;
import iso20022.auth108.fca.PostedMarginOrCollateral6__1;
import iso20022.auth108.fca.ReceivedMarginOrCollateral6__1;
import iso20022.auth108.fca.TradeCounterpartyReport20__1;
import iso20022.auth108.fca.UniqueTransactionIdentifier2Choice__1;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MarginReportData7__1OnlyExistsValidator implements ValidatorWithArg<MarginReportData7__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MarginReportData7__1> ValidationResult<MarginReportData7__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("rptgTmStmp", ExistenceChecker.isSet((ZonedDateTime) o.getRptgTmStmp()))
				.put("ctrPtyId", ExistenceChecker.isSet((TradeCounterpartyReport20__1) o.getCtrPtyId()))
				.put("evtDt", ExistenceChecker.isSet((Date) o.getEvtDt()))
				.put("txId", ExistenceChecker.isSet((UniqueTransactionIdentifier2Choice__1) o.getTxId()))
				.put("coll", ExistenceChecker.isSet((MarginCollateralReport4__1) o.getColl()))
				.put("pstdMrgnOrColl", ExistenceChecker.isSet((PostedMarginOrCollateral6__1) o.getPstdMrgnOrColl()))
				.put("rcvdMrgnOrColl", ExistenceChecker.isSet((ReceivedMarginOrCollateral6__1) o.getRcvdMrgnOrColl()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MarginReportData7__1", ValidationResult.ValidationType.ONLY_EXISTS, "MarginReportData7__1", path, "");
		}
		return failure("MarginReportData7__1", ValidationResult.ValidationType.ONLY_EXISTS, "MarginReportData7__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

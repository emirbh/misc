package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.MarginCollateralReport4;
import iso20022.auth108.iso.MarginReportData7;
import iso20022.auth108.iso.PostedMarginOrCollateral6;
import iso20022.auth108.iso.ReceivedMarginOrCollateral6;
import iso20022.auth108.iso.SupplementaryData1;
import iso20022.auth108.iso.TechnicalAttributes6;
import iso20022.auth108.iso.TradeCounterpartyReport20;
import iso20022.auth108.iso.UniqueTransactionIdentifier2Choice;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MarginReportData7OnlyExistsValidator implements ValidatorWithArg<MarginReportData7, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MarginReportData7> ValidationResult<MarginReportData7> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("rptgTmStmp", ExistenceChecker.isSet((ZonedDateTime) o.getRptgTmStmp()))
				.put("ctrPtyId", ExistenceChecker.isSet((TradeCounterpartyReport20) o.getCtrPtyId()))
				.put("evtDt", ExistenceChecker.isSet((Date) o.getEvtDt()))
				.put("txId", ExistenceChecker.isSet((UniqueTransactionIdentifier2Choice) o.getTxId()))
				.put("coll", ExistenceChecker.isSet((MarginCollateralReport4) o.getColl()))
				.put("pstdMrgnOrColl", ExistenceChecker.isSet((PostedMarginOrCollateral6) o.getPstdMrgnOrColl()))
				.put("rcvdMrgnOrColl", ExistenceChecker.isSet((ReceivedMarginOrCollateral6) o.getRcvdMrgnOrColl()))
				.put("ctrPtyRatgTrggrInd", ExistenceChecker.isSet((Boolean) o.getCtrPtyRatgTrggrInd()))
				.put("ctrPtyRatgThrshldInd", ExistenceChecker.isSet((Boolean) o.getCtrPtyRatgThrshldInd()))
				.put("techAttrbts", ExistenceChecker.isSet((TechnicalAttributes6) o.getTechAttrbts()))
				.put("splmtryData", ExistenceChecker.isSet((List<? extends SupplementaryData1>) o.getSplmtryData()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MarginReportData7", ValidationResult.ValidationType.ONLY_EXISTS, "MarginReportData7", path, "");
		}
		return failure("MarginReportData7", ValidationResult.ValidationType.ONLY_EXISTS, "MarginReportData7", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

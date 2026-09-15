package iso20022.auth030.asic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth030.asic.OptionBarrierLevel1Choice__1;
import iso20022.auth030.asic.OptionOrSwaption11__1;
import iso20022.auth030.asic.SecuritiesTransactionPrice17Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionOrSwaption11__1OnlyExistsValidator implements ValidatorWithArg<OptionOrSwaption11__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionOrSwaption11__1> ValidationResult<OptionOrSwaption11__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("strkPric", ExistenceChecker.isSet((SecuritiesTransactionPrice17Choice__1) o.getStrkPric()))
				.put("callAmt", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getCallAmt()))
				.put("putAmt", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getPutAmt()))
				.put("prmAmt", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd5DecimalAmount) o.getPrmAmt()))
				.put("prmPmtDt", ExistenceChecker.isSet((Date) o.getPrmPmtDt()))
				.put("mtrtyDtOfUndrlyg", ExistenceChecker.isSet((Date) o.getMtrtyDtOfUndrlyg()))
				.put("brrrLvls", ExistenceChecker.isSet((OptionBarrierLevel1Choice__1) o.getBrrrLvls()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionOrSwaption11__1", ValidationResult.ValidationType.ONLY_EXISTS, "OptionOrSwaption11__1", path, "");
		}
		return failure("OptionOrSwaption11__1", ValidationResult.ValidationType.ONLY_EXISTS, "OptionOrSwaption11__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

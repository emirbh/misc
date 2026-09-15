package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.ActiveOrHistoricCurrencyAnd5DecimalAmount__1;
import iso20022.auth030.fca.OptionOrSwaption10__1;
import iso20022.auth030.fca.OptionStyle6Code__1;
import iso20022.auth030.fca.OptionType2Code;
import iso20022.auth030.fca.Schedule4__1;
import iso20022.auth030.fca.SecuritiesTransactionPrice17Choice__1;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionOrSwaption10__1OnlyExistsValidator implements ValidatorWithArg<OptionOrSwaption10__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionOrSwaption10__1> ValidationResult<OptionOrSwaption10__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tp", ExistenceChecker.isSet((OptionType2Code) o.getTp()))
				.put("exrcStyle", ExistenceChecker.isSet((OptionStyle6Code__1) o.getExrcStyle()))
				.put("strkPric", ExistenceChecker.isSet((SecuritiesTransactionPrice17Choice__1) o.getStrkPric()))
				.put("strkPricSchdl", ExistenceChecker.isSet((List<? extends Schedule4__1>) o.getStrkPricSchdl()))
				.put("prmAmt", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd5DecimalAmount__1) o.getPrmAmt()))
				.put("prmPmtDt", ExistenceChecker.isSet((Date) o.getPrmPmtDt()))
				.put("mtrtyDtOfUndrlyg", ExistenceChecker.isSet((Date) o.getMtrtyDtOfUndrlyg()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionOrSwaption10__1", ValidationResult.ValidationType.ONLY_EXISTS, "OptionOrSwaption10__1", path, "");
		}
		return failure("OptionOrSwaption10__1", ValidationResult.ValidationType.ONLY_EXISTS, "OptionOrSwaption10__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

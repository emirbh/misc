package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.RegulationDetails;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationASIC_2013;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationCSA_2016;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationEMIR_2015;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationMAS_2013;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationMifirRTS22_2015;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationMifirRTS23_2015;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationMifirRTS24_2015;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationMifirRTS6a_2015;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationMifirRTS6b_2015;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationOther;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart43_2012;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart43_2019;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart45_2012;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart45_2019;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationSFTR_2019;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulationDetailsOnlyExistsValidator implements ValidatorWithArg<RegulationDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulationDetails> ValidationResult<RegulationDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cftc_part43_2012", ExistenceChecker.isSet((RegulatoryClassificationPart43_2012) o.getCftc_part43_2012()))
				.put("cftc_part43_2019", ExistenceChecker.isSet((RegulatoryClassificationPart43_2019) o.getCftc_part43_2019()))
				.put("cftc_part45_2012", ExistenceChecker.isSet((RegulatoryClassificationPart45_2012) o.getCftc_part45_2012()))
				.put("cftc_part45_2019", ExistenceChecker.isSet((RegulatoryClassificationPart45_2019) o.getCftc_part45_2019()))
				.put("esma_emirRts_2015", ExistenceChecker.isSet((RegulatoryClassificationEMIR_2015) o.getEsma_emirRts_2015()))
				.put("esma_mifirRts6a_2015", ExistenceChecker.isSet((RegulatoryClassificationMifirRTS6a_2015) o.getEsma_mifirRts6a_2015()))
				.put("esma_mifirRts6b_2015", ExistenceChecker.isSet((RegulatoryClassificationMifirRTS6b_2015) o.getEsma_mifirRts6b_2015()))
				.put("esma_mifirRts22_2015", ExistenceChecker.isSet((RegulatoryClassificationMifirRTS22_2015) o.getEsma_mifirRts22_2015()))
				.put("esma_mifirRts23_2015", ExistenceChecker.isSet((RegulatoryClassificationMifirRTS23_2015) o.getEsma_mifirRts23_2015()))
				.put("esma_mifirRts24_2015", ExistenceChecker.isSet((RegulatoryClassificationMifirRTS24_2015) o.getEsma_mifirRts24_2015()))
				.put("csa_derivativesReporting_2016", ExistenceChecker.isSet((RegulatoryClassificationCSA_2016) o.getCsa_derivativesReporting_2016()))
				.put("mas_sfa_2013", ExistenceChecker.isSet((RegulatoryClassificationMAS_2013) o.getMas_sfa_2013()))
				.put("asic_derivativesTransactionRules_2013", ExistenceChecker.isSet((RegulatoryClassificationASIC_2013) o.getAsic_derivativesTransactionRules_2013()))
				.put("esma_sftrRts_2019", ExistenceChecker.isSet((RegulatoryClassificationSFTR_2019) o.getEsma_sftrRts_2019()))
				.put("other", ExistenceChecker.isSet((List<? extends RegulatoryClassificationOther>) o.getOther()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulationDetails", ValidationResult.ValidationType.ONLY_EXISTS, "RegulationDetails", path, "");
		}
		return failure("RegulationDetails", ValidationResult.ValidationType.ONLY_EXISTS, "RegulationDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

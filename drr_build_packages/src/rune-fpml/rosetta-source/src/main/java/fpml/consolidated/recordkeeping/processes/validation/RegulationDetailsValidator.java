package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
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
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart43_2012;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart43_2019;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart45_2012;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart45_2019;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationSFTR_2019;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulationDetailsValidator implements Validator<RegulationDetails> {

	private List<ComparisonResult> getComparisonResults(RegulationDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cftc_part43_2012", (RegulatoryClassificationPart43_2012) o.getCftc_part43_2012() != null ? 1 : 0, 0, 1), 
				checkCardinality("cftc_part43_2019", (RegulatoryClassificationPart43_2019) o.getCftc_part43_2019() != null ? 1 : 0, 0, 1), 
				checkCardinality("cftc_part45_2012", (RegulatoryClassificationPart45_2012) o.getCftc_part45_2012() != null ? 1 : 0, 0, 1), 
				checkCardinality("cftc_part45_2019", (RegulatoryClassificationPart45_2019) o.getCftc_part45_2019() != null ? 1 : 0, 0, 1), 
				checkCardinality("esma_emirRts_2015", (RegulatoryClassificationEMIR_2015) o.getEsma_emirRts_2015() != null ? 1 : 0, 0, 1), 
				checkCardinality("esma_mifirRts6a_2015", (RegulatoryClassificationMifirRTS6a_2015) o.getEsma_mifirRts6a_2015() != null ? 1 : 0, 0, 1), 
				checkCardinality("esma_mifirRts6b_2015", (RegulatoryClassificationMifirRTS6b_2015) o.getEsma_mifirRts6b_2015() != null ? 1 : 0, 0, 1), 
				checkCardinality("esma_mifirRts22_2015", (RegulatoryClassificationMifirRTS22_2015) o.getEsma_mifirRts22_2015() != null ? 1 : 0, 0, 1), 
				checkCardinality("esma_mifirRts23_2015", (RegulatoryClassificationMifirRTS23_2015) o.getEsma_mifirRts23_2015() != null ? 1 : 0, 0, 1), 
				checkCardinality("esma_mifirRts24_2015", (RegulatoryClassificationMifirRTS24_2015) o.getEsma_mifirRts24_2015() != null ? 1 : 0, 0, 1), 
				checkCardinality("csa_derivativesReporting_2016", (RegulatoryClassificationCSA_2016) o.getCsa_derivativesReporting_2016() != null ? 1 : 0, 0, 1), 
				checkCardinality("mas_sfa_2013", (RegulatoryClassificationMAS_2013) o.getMas_sfa_2013() != null ? 1 : 0, 0, 1), 
				checkCardinality("asic_derivativesTransactionRules_2013", (RegulatoryClassificationASIC_2013) o.getAsic_derivativesTransactionRules_2013() != null ? 1 : 0, 0, 1), 
				checkCardinality("esma_sftrRts_2019", (RegulatoryClassificationSFTR_2019) o.getEsma_sftrRts_2019() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulationDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulationDetails", ValidationResult.ValidationType.CARDINALITY, "RegulationDetails", path, "", res.getError());
				}
				return success("RegulationDetails", ValidationResult.ValidationType.CARDINALITY, "RegulationDetails", path, "");
			})
			.collect(toList());
	}

}

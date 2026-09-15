package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.ContractType15__1;
import iso20022.auth030.hkma.dtcc.CurrencyExchange23__1;
import iso20022.auth030.hkma.dtcc.FinancialInstrumentContractType2Code;
import iso20022.auth030.hkma.dtcc.ProductType4Code__1;
import iso20022.auth030.hkma.dtcc.SecurityIdentification41Choice__1;
import iso20022.auth030.hkma.dtcc.SecurityIdentification46__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ContractType15__1Validator implements Validator<ContractType15__1> {

	private List<ComparisonResult> getComparisonResults(ContractType15__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ctrctTp", (FinancialInstrumentContractType2Code) o.getCtrctTp() != null ? 1 : 0, 1, 1), 
				checkCardinality("asstClss", (ProductType4Code__1) o.getAsstClss() != null ? 1 : 0, 1, 1), 
				checkCardinality("pdctId", (SecurityIdentification46__1) o.getPdctId() != null ? 1 : 0, 0, 1), 
				checkCardinality("undrlygInstrm", (SecurityIdentification41Choice__1) o.getUndrlygInstrm() != null ? 1 : 0, 0, 1), 
				checkCardinality("undrlygAsstTradgPltfmIdr", (String) o.getUndrlygAsstTradgPltfmIdr() != null ? 1 : 0, 0, 1), 
				checkCardinality("undrlygAsstPricSrc", (String) o.getUndrlygAsstPricSrc() != null ? 1 : 0, 0, 1), 
				checkCardinality("sttlmCcy", (CurrencyExchange23__1) o.getSttlmCcy() != null ? 1 : 0, 0, 1), 
				checkCardinality("sttlmCcyScndLeg", (CurrencyExchange23__1) o.getSttlmCcyScndLeg() != null ? 1 : 0, 0, 1), 
				checkCardinality("plcOfSttlm", (String) o.getPlcOfSttlm() != null ? 1 : 0, 0, 1), 
				checkCardinality("derivBasedOnCrptAsst", (Boolean) o.getDerivBasedOnCrptAsst() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractType15__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractType15__1", ValidationResult.ValidationType.CARDINALITY, "ContractType15__1", path, "", res.getError());
				}
				return success("ContractType15__1", ValidationResult.ValidationType.CARDINALITY, "ContractType15__1", path, "");
			})
			.collect(toList());
	}

}

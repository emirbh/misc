package fpml.consolidated.reg.fpmlreporting.product.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductSettlementDetails;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductSettlementDetailsTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductSettlementDetailsValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.exists.RegulatoryReportingProductSettlementDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingProductSettlementDetails.class)
public class RegulatoryReportingProductSettlementDetailsMeta implements RosettaMetaData<RegulatoryReportingProductSettlementDetails> {

	@Override
	public List<Validator<? super RegulatoryReportingProductSettlementDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingProductSettlementDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingProductSettlementDetails> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductSettlementDetails>create(RegulatoryReportingProductSettlementDetailsValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingProductSettlementDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductSettlementDetails>create(RegulatoryReportingProductSettlementDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductSettlementDetails> validator() {
		return new RegulatoryReportingProductSettlementDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductSettlementDetails> typeFormatValidator() {
		return new RegulatoryReportingProductSettlementDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingProductSettlementDetails, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingProductSettlementDetailsOnlyExistsValidator();
	}
}

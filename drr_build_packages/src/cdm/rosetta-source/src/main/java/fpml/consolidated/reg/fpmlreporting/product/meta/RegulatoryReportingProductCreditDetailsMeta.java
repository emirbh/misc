package fpml.consolidated.reg.fpmlreporting.product.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductCreditDetails;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductCreditDetailsTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductCreditDetailsValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.exists.RegulatoryReportingProductCreditDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingProductCreditDetails.class)
public class RegulatoryReportingProductCreditDetailsMeta implements RosettaMetaData<RegulatoryReportingProductCreditDetails> {

	@Override
	public List<Validator<? super RegulatoryReportingProductCreditDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingProductCreditDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingProductCreditDetails> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductCreditDetails>create(RegulatoryReportingProductCreditDetailsValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingProductCreditDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductCreditDetails>create(RegulatoryReportingProductCreditDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductCreditDetails> validator() {
		return new RegulatoryReportingProductCreditDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductCreditDetails> typeFormatValidator() {
		return new RegulatoryReportingProductCreditDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingProductCreditDetails, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingProductCreditDetailsOnlyExistsValidator();
	}
}

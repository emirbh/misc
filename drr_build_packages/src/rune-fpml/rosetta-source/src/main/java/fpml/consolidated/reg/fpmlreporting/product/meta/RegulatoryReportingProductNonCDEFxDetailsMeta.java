package fpml.consolidated.reg.fpmlreporting.product.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductNonCDEFxDetails;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductNonCDEFxDetailsTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductNonCDEFxDetailsValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.exists.RegulatoryReportingProductNonCDEFxDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingProductNonCDEFxDetails.class)
public class RegulatoryReportingProductNonCDEFxDetailsMeta implements RosettaMetaData<RegulatoryReportingProductNonCDEFxDetails> {

	@Override
	public List<Validator<? super RegulatoryReportingProductNonCDEFxDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingProductNonCDEFxDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingProductNonCDEFxDetails> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductNonCDEFxDetails>create(RegulatoryReportingProductNonCDEFxDetailsValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingProductNonCDEFxDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductNonCDEFxDetails>create(RegulatoryReportingProductNonCDEFxDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductNonCDEFxDetails> validator() {
		return new RegulatoryReportingProductNonCDEFxDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductNonCDEFxDetails> typeFormatValidator() {
		return new RegulatoryReportingProductNonCDEFxDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingProductNonCDEFxDetails, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingProductNonCDEFxDetailsOnlyExistsValidator();
	}
}

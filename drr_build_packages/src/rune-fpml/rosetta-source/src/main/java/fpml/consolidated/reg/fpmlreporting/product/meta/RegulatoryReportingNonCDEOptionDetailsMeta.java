package fpml.consolidated.reg.fpmlreporting.product.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingNonCDEOptionDetails;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingNonCDEOptionDetailsTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingNonCDEOptionDetailsValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.exists.RegulatoryReportingNonCDEOptionDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingNonCDEOptionDetails.class)
public class RegulatoryReportingNonCDEOptionDetailsMeta implements RosettaMetaData<RegulatoryReportingNonCDEOptionDetails> {

	@Override
	public List<Validator<? super RegulatoryReportingNonCDEOptionDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingNonCDEOptionDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingNonCDEOptionDetails> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingNonCDEOptionDetails>create(RegulatoryReportingNonCDEOptionDetailsValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingNonCDEOptionDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingNonCDEOptionDetails>create(RegulatoryReportingNonCDEOptionDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingNonCDEOptionDetails> validator() {
		return new RegulatoryReportingNonCDEOptionDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingNonCDEOptionDetails> typeFormatValidator() {
		return new RegulatoryReportingNonCDEOptionDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingNonCDEOptionDetails, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingNonCDEOptionDetailsOnlyExistsValidator();
	}
}

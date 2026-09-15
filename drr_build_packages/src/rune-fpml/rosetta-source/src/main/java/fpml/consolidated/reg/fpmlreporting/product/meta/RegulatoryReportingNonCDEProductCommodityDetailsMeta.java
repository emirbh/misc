package fpml.consolidated.reg.fpmlreporting.product.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingNonCDEProductCommodityDetails;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingNonCDEProductCommodityDetailsTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingNonCDEProductCommodityDetailsValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.exists.RegulatoryReportingNonCDEProductCommodityDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingNonCDEProductCommodityDetails.class)
public class RegulatoryReportingNonCDEProductCommodityDetailsMeta implements RosettaMetaData<RegulatoryReportingNonCDEProductCommodityDetails> {

	@Override
	public List<Validator<? super RegulatoryReportingNonCDEProductCommodityDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingNonCDEProductCommodityDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingNonCDEProductCommodityDetails> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingNonCDEProductCommodityDetails>create(RegulatoryReportingNonCDEProductCommodityDetailsValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingNonCDEProductCommodityDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingNonCDEProductCommodityDetails>create(RegulatoryReportingNonCDEProductCommodityDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingNonCDEProductCommodityDetails> validator() {
		return new RegulatoryReportingNonCDEProductCommodityDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingNonCDEProductCommodityDetails> typeFormatValidator() {
		return new RegulatoryReportingNonCDEProductCommodityDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingNonCDEProductCommodityDetails, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingNonCDEProductCommodityDetailsOnlyExistsValidator();
	}
}

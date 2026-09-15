package fpml.consolidated.reg.fpmlreporting.product.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductPriceTerms;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductPriceTermsTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductPriceTermsValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.exists.RegulatoryReportingProductPriceTermsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingProductPriceTerms.class)
public class RegulatoryReportingProductPriceTermsMeta implements RosettaMetaData<RegulatoryReportingProductPriceTerms> {

	@Override
	public List<Validator<? super RegulatoryReportingProductPriceTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingProductPriceTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingProductPriceTerms> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductPriceTerms>create(RegulatoryReportingProductPriceTermsValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingProductPriceTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductPriceTerms>create(RegulatoryReportingProductPriceTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductPriceTerms> validator() {
		return new RegulatoryReportingProductPriceTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductPriceTerms> typeFormatValidator() {
		return new RegulatoryReportingProductPriceTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingProductPriceTerms, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingProductPriceTermsOnlyExistsValidator();
	}
}

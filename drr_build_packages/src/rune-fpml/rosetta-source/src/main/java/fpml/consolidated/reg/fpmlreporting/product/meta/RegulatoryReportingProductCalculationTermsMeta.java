package fpml.consolidated.reg.fpmlreporting.product.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductCalculationTerms;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductCalculationTermsTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductCalculationTermsValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.exists.RegulatoryReportingProductCalculationTermsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingProductCalculationTerms.class)
public class RegulatoryReportingProductCalculationTermsMeta implements RosettaMetaData<RegulatoryReportingProductCalculationTerms> {

	@Override
	public List<Validator<? super RegulatoryReportingProductCalculationTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingProductCalculationTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingProductCalculationTerms> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductCalculationTerms>create(RegulatoryReportingProductCalculationTermsValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingProductCalculationTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductCalculationTerms>create(RegulatoryReportingProductCalculationTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductCalculationTerms> validator() {
		return new RegulatoryReportingProductCalculationTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductCalculationTerms> typeFormatValidator() {
		return new RegulatoryReportingProductCalculationTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingProductCalculationTerms, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingProductCalculationTermsOnlyExistsValidator();
	}
}

package fpml.consolidated.reg.fpmlreporting.product.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductDates;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductDatesTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductDatesValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.exists.RegulatoryReportingProductDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingProductDates.class)
public class RegulatoryReportingProductDatesMeta implements RosettaMetaData<RegulatoryReportingProductDates> {

	@Override
	public List<Validator<? super RegulatoryReportingProductDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingProductDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingProductDates> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductDates>create(RegulatoryReportingProductDatesValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingProductDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductDates>create(RegulatoryReportingProductDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductDates> validator() {
		return new RegulatoryReportingProductDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductDates> typeFormatValidator() {
		return new RegulatoryReportingProductDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingProductDates, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingProductDatesOnlyExistsValidator();
	}
}

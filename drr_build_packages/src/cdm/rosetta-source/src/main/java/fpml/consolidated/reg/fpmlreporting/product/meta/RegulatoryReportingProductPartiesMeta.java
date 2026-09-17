package fpml.consolidated.reg.fpmlreporting.product.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductParties;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductPartiesTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductPartiesValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.exists.RegulatoryReportingProductPartiesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingProductParties.class)
public class RegulatoryReportingProductPartiesMeta implements RosettaMetaData<RegulatoryReportingProductParties> {

	@Override
	public List<Validator<? super RegulatoryReportingProductParties>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingProductParties, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingProductParties> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductParties>create(RegulatoryReportingProductPartiesValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingProductParties> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductParties>create(RegulatoryReportingProductPartiesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductParties> validator() {
		return new RegulatoryReportingProductPartiesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductParties> typeFormatValidator() {
		return new RegulatoryReportingProductPartiesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingProductParties, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingProductPartiesOnlyExistsValidator();
	}
}

package fpml.consolidated.reg.fpmlreporting.product.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductUnderlyers;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductUnderlyersTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductUnderlyersValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.exists.RegulatoryReportingProductUnderlyersOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingProductUnderlyers.class)
public class RegulatoryReportingProductUnderlyersMeta implements RosettaMetaData<RegulatoryReportingProductUnderlyers> {

	@Override
	public List<Validator<? super RegulatoryReportingProductUnderlyers>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingProductUnderlyers, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingProductUnderlyers> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductUnderlyers>create(RegulatoryReportingProductUnderlyersValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingProductUnderlyers> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductUnderlyers>create(RegulatoryReportingProductUnderlyersTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductUnderlyers> validator() {
		return new RegulatoryReportingProductUnderlyersValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductUnderlyers> typeFormatValidator() {
		return new RegulatoryReportingProductUnderlyersTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingProductUnderlyers, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingProductUnderlyersOnlyExistsValidator();
	}
}

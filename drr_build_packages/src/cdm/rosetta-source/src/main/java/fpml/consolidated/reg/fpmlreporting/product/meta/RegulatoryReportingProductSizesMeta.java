package fpml.consolidated.reg.fpmlreporting.product.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductSizes;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductSizesTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductSizesValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.exists.RegulatoryReportingProductSizesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingProductSizes.class)
public class RegulatoryReportingProductSizesMeta implements RosettaMetaData<RegulatoryReportingProductSizes> {

	@Override
	public List<Validator<? super RegulatoryReportingProductSizes>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingProductSizes, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingProductSizes> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductSizes>create(RegulatoryReportingProductSizesValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingProductSizes> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProductSizes>create(RegulatoryReportingProductSizesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductSizes> validator() {
		return new RegulatoryReportingProductSizesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProductSizes> typeFormatValidator() {
		return new RegulatoryReportingProductSizesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingProductSizes, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingProductSizesOnlyExistsValidator();
	}
}

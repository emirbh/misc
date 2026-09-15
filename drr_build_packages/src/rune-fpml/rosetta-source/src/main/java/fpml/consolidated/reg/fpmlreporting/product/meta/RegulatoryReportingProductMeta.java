package fpml.consolidated.reg.fpmlreporting.product.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProduct;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.RegulatoryReportingProductValidator;
import fpml.consolidated.reg.fpmlreporting.product.validation.exists.RegulatoryReportingProductOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingProduct.class)
public class RegulatoryReportingProductMeta implements RosettaMetaData<RegulatoryReportingProduct> {

	@Override
	public List<Validator<? super RegulatoryReportingProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingProduct> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProduct>create(RegulatoryReportingProductValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingProduct> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingProduct>create(RegulatoryReportingProductTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProduct> validator() {
		return new RegulatoryReportingProductValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingProduct> typeFormatValidator() {
		return new RegulatoryReportingProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingProduct, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingProductOnlyExistsValidator();
	}
}

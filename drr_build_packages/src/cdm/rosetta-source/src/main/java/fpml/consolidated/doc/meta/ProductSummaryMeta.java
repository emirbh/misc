package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ProductSummary;
import fpml.consolidated.doc.validation.ProductSummaryTypeFormatValidator;
import fpml.consolidated.doc.validation.ProductSummaryValidator;
import fpml.consolidated.doc.validation.exists.ProductSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ProductSummary.class)
public class ProductSummaryMeta implements RosettaMetaData<ProductSummary> {

	@Override
	public List<Validator<? super ProductSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProductSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ProductSummary> validator(ValidatorFactory factory) {
		return factory.<ProductSummary>create(ProductSummaryValidator.class);
	}

	@Override
	public Validator<? super ProductSummary> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ProductSummary>create(ProductSummaryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ProductSummary> validator() {
		return new ProductSummaryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ProductSummary> typeFormatValidator() {
		return new ProductSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProductSummary, Set<String>> onlyExistsValidator() {
		return new ProductSummaryOnlyExistsValidator();
	}
}

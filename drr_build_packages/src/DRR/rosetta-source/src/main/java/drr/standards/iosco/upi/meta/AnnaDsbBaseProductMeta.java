package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbBaseProduct;
import drr.standards.iosco.upi.validation.AnnaDsbBaseProductTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbBaseProductValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbBaseProductOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbBaseProduct.class)
public class AnnaDsbBaseProductMeta implements RosettaMetaData<AnnaDsbBaseProduct> {

	@Override
	public List<Validator<? super AnnaDsbBaseProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbBaseProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbBaseProduct> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbBaseProduct>create(AnnaDsbBaseProductValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbBaseProduct> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbBaseProduct>create(AnnaDsbBaseProductTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbBaseProduct> validator() {
		return new AnnaDsbBaseProductValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbBaseProduct> typeFormatValidator() {
		return new AnnaDsbBaseProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbBaseProduct, Set<String>> onlyExistsValidator() {
		return new AnnaDsbBaseProductOnlyExistsValidator();
	}
}

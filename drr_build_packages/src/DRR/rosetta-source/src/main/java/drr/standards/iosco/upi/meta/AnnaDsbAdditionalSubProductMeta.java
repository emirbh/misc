package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbAdditionalSubProduct;
import drr.standards.iosco.upi.validation.AnnaDsbAdditionalSubProductTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbAdditionalSubProductValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbAdditionalSubProductOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbAdditionalSubProduct.class)
public class AnnaDsbAdditionalSubProductMeta implements RosettaMetaData<AnnaDsbAdditionalSubProduct> {

	@Override
	public List<Validator<? super AnnaDsbAdditionalSubProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbAdditionalSubProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbAdditionalSubProduct> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbAdditionalSubProduct>create(AnnaDsbAdditionalSubProductValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbAdditionalSubProduct> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbAdditionalSubProduct>create(AnnaDsbAdditionalSubProductTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbAdditionalSubProduct> validator() {
		return new AnnaDsbAdditionalSubProductValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbAdditionalSubProduct> typeFormatValidator() {
		return new AnnaDsbAdditionalSubProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbAdditionalSubProduct, Set<String>> onlyExistsValidator() {
		return new AnnaDsbAdditionalSubProductOnlyExistsValidator();
	}
}

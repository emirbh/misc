package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbCategory;
import drr.standards.iosco.upi.validation.AnnaDsbCategoryTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbCategoryValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbCategoryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbCategory.class)
public class AnnaDsbCategoryMeta implements RosettaMetaData<AnnaDsbCategory> {

	@Override
	public List<Validator<? super AnnaDsbCategory>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbCategory, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbCategory> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbCategory>create(AnnaDsbCategoryValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbCategory> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbCategory>create(AnnaDsbCategoryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbCategory> validator() {
		return new AnnaDsbCategoryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbCategory> typeFormatValidator() {
		return new AnnaDsbCategoryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbCategory, Set<String>> onlyExistsValidator() {
		return new AnnaDsbCategoryOnlyExistsValidator();
	}
}

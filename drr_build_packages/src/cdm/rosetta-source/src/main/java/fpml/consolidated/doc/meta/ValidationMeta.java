package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.doc.validation.ValidationTypeFormatValidator;
import fpml.consolidated.doc.validation.ValidationValidator;
import fpml.consolidated.doc.validation.exists.ValidationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Validation.class)
public class ValidationMeta implements RosettaMetaData<Validation> {

	@Override
	public List<Validator<? super Validation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Validation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Validation> validator(ValidatorFactory factory) {
		return factory.<Validation>create(ValidationValidator.class);
	}

	@Override
	public Validator<? super Validation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Validation>create(ValidationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Validation> validator() {
		return new ValidationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Validation> typeFormatValidator() {
		return new ValidationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Validation, Set<String>> onlyExistsValidator() {
		return new ValidationOnlyExistsValidator();
	}
}

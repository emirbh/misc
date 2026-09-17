package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.MimeType;
import fpml.consolidated.shared.validation.MimeTypeTypeFormatValidator;
import fpml.consolidated.shared.validation.MimeTypeValidator;
import fpml.consolidated.shared.validation.exists.MimeTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MimeType.class)
public class MimeTypeMeta implements RosettaMetaData<MimeType> {

	@Override
	public List<Validator<? super MimeType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MimeType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MimeType> validator(ValidatorFactory factory) {
		return factory.<MimeType>create(MimeTypeValidator.class);
	}

	@Override
	public Validator<? super MimeType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MimeType>create(MimeTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MimeType> validator() {
		return new MimeTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MimeType> typeFormatValidator() {
		return new MimeTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MimeType, Set<String>> onlyExistsValidator() {
		return new MimeTypeOnlyExistsValidator();
	}
}

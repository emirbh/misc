package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.RetrievalMethodType;
import fpml.consolidated.validation.RetrievalMethodTypeTypeFormatValidator;
import fpml.consolidated.validation.RetrievalMethodTypeValidator;
import fpml.consolidated.validation.exists.RetrievalMethodTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RetrievalMethodType.class)
public class RetrievalMethodTypeMeta implements RosettaMetaData<RetrievalMethodType> {

	@Override
	public List<Validator<? super RetrievalMethodType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RetrievalMethodType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RetrievalMethodType> validator(ValidatorFactory factory) {
		return factory.<RetrievalMethodType>create(RetrievalMethodTypeValidator.class);
	}

	@Override
	public Validator<? super RetrievalMethodType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RetrievalMethodType>create(RetrievalMethodTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RetrievalMethodType> validator() {
		return new RetrievalMethodTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RetrievalMethodType> typeFormatValidator() {
		return new RetrievalMethodTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RetrievalMethodType, Set<String>> onlyExistsValidator() {
		return new RetrievalMethodTypeOnlyExistsValidator();
	}
}

package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Documentation;
import fpml.consolidated.shared.validation.DocumentationTypeFormatValidator;
import fpml.consolidated.shared.validation.DocumentationValidator;
import fpml.consolidated.shared.validation.datarule.DocumentationChoice;
import fpml.consolidated.shared.validation.exists.DocumentationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Documentation.class)
public class DocumentationMeta implements RosettaMetaData<Documentation> {

	@Override
	public List<Validator<? super Documentation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Documentation>create(DocumentationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Documentation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Documentation> validator(ValidatorFactory factory) {
		return factory.<Documentation>create(DocumentationValidator.class);
	}

	@Override
	public Validator<? super Documentation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Documentation>create(DocumentationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Documentation> validator() {
		return new DocumentationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Documentation> typeFormatValidator() {
		return new DocumentationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Documentation, Set<String>> onlyExistsValidator() {
		return new DocumentationOnlyExistsValidator();
	}
}

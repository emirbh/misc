package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.EndUserExceptionDeclaration;
import fpml.consolidated.doc.validation.EndUserExceptionDeclarationTypeFormatValidator;
import fpml.consolidated.doc.validation.EndUserExceptionDeclarationValidator;
import fpml.consolidated.doc.validation.exists.EndUserExceptionDeclarationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EndUserExceptionDeclaration.class)
public class EndUserExceptionDeclarationMeta implements RosettaMetaData<EndUserExceptionDeclaration> {

	@Override
	public List<Validator<? super EndUserExceptionDeclaration>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EndUserExceptionDeclaration, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EndUserExceptionDeclaration> validator(ValidatorFactory factory) {
		return factory.<EndUserExceptionDeclaration>create(EndUserExceptionDeclarationValidator.class);
	}

	@Override
	public Validator<? super EndUserExceptionDeclaration> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EndUserExceptionDeclaration>create(EndUserExceptionDeclarationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EndUserExceptionDeclaration> validator() {
		return new EndUserExceptionDeclarationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EndUserExceptionDeclaration> typeFormatValidator() {
		return new EndUserExceptionDeclarationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EndUserExceptionDeclaration, Set<String>> onlyExistsValidator() {
		return new EndUserExceptionDeclarationOnlyExistsValidator();
	}
}

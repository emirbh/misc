package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ClearingExceptionDeclaration;
import drr.regulation.common.validation.ClearingExceptionDeclarationTypeFormatValidator;
import drr.regulation.common.validation.ClearingExceptionDeclarationValidator;
import drr.regulation.common.validation.exists.ClearingExceptionDeclarationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ClearingExceptionDeclaration.class)
public class ClearingExceptionDeclarationMeta implements RosettaMetaData<ClearingExceptionDeclaration> {

	@Override
	public List<Validator<? super ClearingExceptionDeclaration>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingExceptionDeclaration, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClearingExceptionDeclaration> validator(ValidatorFactory factory) {
		return factory.<ClearingExceptionDeclaration>create(ClearingExceptionDeclarationValidator.class);
	}

	@Override
	public Validator<? super ClearingExceptionDeclaration> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ClearingExceptionDeclaration>create(ClearingExceptionDeclarationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ClearingExceptionDeclaration> validator() {
		return new ClearingExceptionDeclarationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ClearingExceptionDeclaration> typeFormatValidator() {
		return new ClearingExceptionDeclarationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingExceptionDeclaration, Set<String>> onlyExistsValidator() {
		return new ClearingExceptionDeclarationOnlyExistsValidator();
	}
}

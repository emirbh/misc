package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.PartyProfileDocumentation;
import fpml.consolidated.loan.validation.PartyProfileDocumentationTypeFormatValidator;
import fpml.consolidated.loan.validation.PartyProfileDocumentationValidator;
import fpml.consolidated.loan.validation.exists.PartyProfileDocumentationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyProfileDocumentation.class)
public class PartyProfileDocumentationMeta implements RosettaMetaData<PartyProfileDocumentation> {

	@Override
	public List<Validator<? super PartyProfileDocumentation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyProfileDocumentation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyProfileDocumentation> validator(ValidatorFactory factory) {
		return factory.<PartyProfileDocumentation>create(PartyProfileDocumentationValidator.class);
	}

	@Override
	public Validator<? super PartyProfileDocumentation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyProfileDocumentation>create(PartyProfileDocumentationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyProfileDocumentation> validator() {
		return new PartyProfileDocumentationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyProfileDocumentation> typeFormatValidator() {
		return new PartyProfileDocumentationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyProfileDocumentation, Set<String>> onlyExistsValidator() {
		return new PartyProfileDocumentationOnlyExistsValidator();
	}
}

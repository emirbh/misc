package cdm.legaldocumentation.transaction.meta;

import cdm.legaldocumentation.transaction.Clause;
import cdm.legaldocumentation.transaction.validation.ClauseTypeFormatValidator;
import cdm.legaldocumentation.transaction.validation.ClauseValidator;
import cdm.legaldocumentation.transaction.validation.datarule.ClauseChoice0;
import cdm.legaldocumentation.transaction.validation.exists.ClauseOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=Clause.class)
public class ClauseMeta implements RosettaMetaData<Clause> {

	@Override
	public List<Validator<? super Clause>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Clause>create(ClauseChoice0.class)
		);
	}
	
	@Override
	public List<Function<? super Clause, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Clause> validator(ValidatorFactory factory) {
		return factory.<Clause>create(ClauseValidator.class);
	}

	@Override
	public Validator<? super Clause> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Clause>create(ClauseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Clause> validator() {
		return new ClauseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Clause> typeFormatValidator() {
		return new ClauseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Clause, Set<String>> onlyExistsValidator() {
		return new ClauseOnlyExistsValidator();
	}
}

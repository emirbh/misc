package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.QueryParameterOperator;
import fpml.consolidated.doc.validation.QueryParameterOperatorTypeFormatValidator;
import fpml.consolidated.doc.validation.QueryParameterOperatorValidator;
import fpml.consolidated.doc.validation.exists.QueryParameterOperatorOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=QueryParameterOperator.class)
public class QueryParameterOperatorMeta implements RosettaMetaData<QueryParameterOperator> {

	@Override
	public List<Validator<? super QueryParameterOperator>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super QueryParameterOperator, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super QueryParameterOperator> validator(ValidatorFactory factory) {
		return factory.<QueryParameterOperator>create(QueryParameterOperatorValidator.class);
	}

	@Override
	public Validator<? super QueryParameterOperator> typeFormatValidator(ValidatorFactory factory) {
		return factory.<QueryParameterOperator>create(QueryParameterOperatorTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super QueryParameterOperator> validator() {
		return new QueryParameterOperatorValidator();
	}

	@Deprecated
	@Override
	public Validator<? super QueryParameterOperator> typeFormatValidator() {
		return new QueryParameterOperatorTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QueryParameterOperator, Set<String>> onlyExistsValidator() {
		return new QueryParameterOperatorOnlyExistsValidator();
	}
}

package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.QueryParameter;
import fpml.consolidated.doc.validation.QueryParameterTypeFormatValidator;
import fpml.consolidated.doc.validation.QueryParameterValidator;
import fpml.consolidated.doc.validation.exists.QueryParameterOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=QueryParameter.class)
public class QueryParameterMeta implements RosettaMetaData<QueryParameter> {

	@Override
	public List<Validator<? super QueryParameter>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super QueryParameter, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super QueryParameter> validator(ValidatorFactory factory) {
		return factory.<QueryParameter>create(QueryParameterValidator.class);
	}

	@Override
	public Validator<? super QueryParameter> typeFormatValidator(ValidatorFactory factory) {
		return factory.<QueryParameter>create(QueryParameterTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super QueryParameter> validator() {
		return new QueryParameterValidator();
	}

	@Deprecated
	@Override
	public Validator<? super QueryParameter> typeFormatValidator() {
		return new QueryParameterTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QueryParameter, Set<String>> onlyExistsValidator() {
		return new QueryParameterOnlyExistsValidator();
	}
}

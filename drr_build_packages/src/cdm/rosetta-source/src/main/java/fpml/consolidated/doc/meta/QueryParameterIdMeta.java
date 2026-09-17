package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.QueryParameterId;
import fpml.consolidated.doc.validation.QueryParameterIdTypeFormatValidator;
import fpml.consolidated.doc.validation.QueryParameterIdValidator;
import fpml.consolidated.doc.validation.exists.QueryParameterIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=QueryParameterId.class)
public class QueryParameterIdMeta implements RosettaMetaData<QueryParameterId> {

	@Override
	public List<Validator<? super QueryParameterId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super QueryParameterId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super QueryParameterId> validator(ValidatorFactory factory) {
		return factory.<QueryParameterId>create(QueryParameterIdValidator.class);
	}

	@Override
	public Validator<? super QueryParameterId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<QueryParameterId>create(QueryParameterIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super QueryParameterId> validator() {
		return new QueryParameterIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super QueryParameterId> typeFormatValidator() {
		return new QueryParameterIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QueryParameterId, Set<String>> onlyExistsValidator() {
		return new QueryParameterIdOnlyExistsValidator();
	}
}

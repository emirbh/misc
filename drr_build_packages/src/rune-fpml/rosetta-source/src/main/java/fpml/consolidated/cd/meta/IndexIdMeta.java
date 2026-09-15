package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.IndexId;
import fpml.consolidated.cd.validation.IndexIdTypeFormatValidator;
import fpml.consolidated.cd.validation.IndexIdValidator;
import fpml.consolidated.cd.validation.exists.IndexIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=IndexId.class)
public class IndexIdMeta implements RosettaMetaData<IndexId> {

	@Override
	public List<Validator<? super IndexId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndexId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IndexId> validator(ValidatorFactory factory) {
		return factory.<IndexId>create(IndexIdValidator.class);
	}

	@Override
	public Validator<? super IndexId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IndexId>create(IndexIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IndexId> validator() {
		return new IndexIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super IndexId> typeFormatValidator() {
		return new IndexIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndexId, Set<String>> onlyExistsValidator() {
		return new IndexIdOnlyExistsValidator();
	}
}

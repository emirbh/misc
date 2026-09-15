package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Index;
import fpml.consolidated.asset.validation.IndexTypeFormatValidator;
import fpml.consolidated.asset.validation.IndexValidator;
import fpml.consolidated.asset.validation.exists.IndexOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Index.class)
public class IndexMeta implements RosettaMetaData<Index> {

	@Override
	public List<Validator<? super Index>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Index, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Index> validator(ValidatorFactory factory) {
		return factory.<Index>create(IndexValidator.class);
	}

	@Override
	public Validator<? super Index> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Index>create(IndexTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Index> validator() {
		return new IndexValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Index> typeFormatValidator() {
		return new IndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Index, Set<String>> onlyExistsValidator() {
		return new IndexOnlyExistsValidator();
	}
}

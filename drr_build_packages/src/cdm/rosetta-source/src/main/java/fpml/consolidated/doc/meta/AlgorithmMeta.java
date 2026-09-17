package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Algorithm;
import fpml.consolidated.doc.validation.AlgorithmTypeFormatValidator;
import fpml.consolidated.doc.validation.AlgorithmValidator;
import fpml.consolidated.doc.validation.exists.AlgorithmOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Algorithm.class)
public class AlgorithmMeta implements RosettaMetaData<Algorithm> {

	@Override
	public List<Validator<? super Algorithm>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Algorithm, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Algorithm> validator(ValidatorFactory factory) {
		return factory.<Algorithm>create(AlgorithmValidator.class);
	}

	@Override
	public Validator<? super Algorithm> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Algorithm>create(AlgorithmTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Algorithm> validator() {
		return new AlgorithmValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Algorithm> typeFormatValidator() {
		return new AlgorithmTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Algorithm, Set<String>> onlyExistsValidator() {
		return new AlgorithmOnlyExistsValidator();
	}
}

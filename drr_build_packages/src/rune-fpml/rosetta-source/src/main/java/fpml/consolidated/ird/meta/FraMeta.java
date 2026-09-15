package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.Fra;
import fpml.consolidated.ird.validation.FraTypeFormatValidator;
import fpml.consolidated.ird.validation.FraValidator;
import fpml.consolidated.ird.validation.exists.FraOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Fra.class)
public class FraMeta implements RosettaMetaData<Fra> {

	@Override
	public List<Validator<? super Fra>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Fra, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Fra> validator(ValidatorFactory factory) {
		return factory.<Fra>create(FraValidator.class);
	}

	@Override
	public Validator<? super Fra> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Fra>create(FraTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Fra> validator() {
		return new FraValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Fra> typeFormatValidator() {
		return new FraTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Fra, Set<String>> onlyExistsValidator() {
		return new FraOnlyExistsValidator();
	}
}

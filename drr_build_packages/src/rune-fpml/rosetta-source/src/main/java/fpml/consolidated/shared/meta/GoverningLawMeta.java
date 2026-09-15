package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.GoverningLaw;
import fpml.consolidated.shared.validation.GoverningLawTypeFormatValidator;
import fpml.consolidated.shared.validation.GoverningLawValidator;
import fpml.consolidated.shared.validation.exists.GoverningLawOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GoverningLaw.class)
public class GoverningLawMeta implements RosettaMetaData<GoverningLaw> {

	@Override
	public List<Validator<? super GoverningLaw>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GoverningLaw, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GoverningLaw> validator(ValidatorFactory factory) {
		return factory.<GoverningLaw>create(GoverningLawValidator.class);
	}

	@Override
	public Validator<? super GoverningLaw> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GoverningLaw>create(GoverningLawTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GoverningLaw> validator() {
		return new GoverningLawValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GoverningLaw> typeFormatValidator() {
		return new GoverningLawTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GoverningLaw, Set<String>> onlyExistsValidator() {
		return new GoverningLawOnlyExistsValidator();
	}
}

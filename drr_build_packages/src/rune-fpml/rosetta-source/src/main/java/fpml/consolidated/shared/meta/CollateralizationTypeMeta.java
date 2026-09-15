package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.CollateralizationType;
import fpml.consolidated.shared.validation.CollateralizationTypeTypeFormatValidator;
import fpml.consolidated.shared.validation.CollateralizationTypeValidator;
import fpml.consolidated.shared.validation.exists.CollateralizationTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CollateralizationType.class)
public class CollateralizationTypeMeta implements RosettaMetaData<CollateralizationType> {

	@Override
	public List<Validator<? super CollateralizationType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralizationType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralizationType> validator(ValidatorFactory factory) {
		return factory.<CollateralizationType>create(CollateralizationTypeValidator.class);
	}

	@Override
	public Validator<? super CollateralizationType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralizationType>create(CollateralizationTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralizationType> validator() {
		return new CollateralizationTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralizationType> typeFormatValidator() {
		return new CollateralizationTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralizationType, Set<String>> onlyExistsValidator() {
		return new CollateralizationTypeOnlyExistsValidator();
	}
}

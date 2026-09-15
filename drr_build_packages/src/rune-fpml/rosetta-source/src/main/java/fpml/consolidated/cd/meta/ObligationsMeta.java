package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.Obligations;
import fpml.consolidated.cd.validation.ObligationsTypeFormatValidator;
import fpml.consolidated.cd.validation.ObligationsValidator;
import fpml.consolidated.cd.validation.datarule.ObligationsChoice;
import fpml.consolidated.cd.validation.exists.ObligationsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Obligations.class)
public class ObligationsMeta implements RosettaMetaData<Obligations> {

	@Override
	public List<Validator<? super Obligations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Obligations>create(ObligationsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Obligations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Obligations> validator(ValidatorFactory factory) {
		return factory.<Obligations>create(ObligationsValidator.class);
	}

	@Override
	public Validator<? super Obligations> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Obligations>create(ObligationsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Obligations> validator() {
		return new ObligationsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Obligations> typeFormatValidator() {
		return new ObligationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Obligations, Set<String>> onlyExistsValidator() {
		return new ObligationsOnlyExistsValidator();
	}
}

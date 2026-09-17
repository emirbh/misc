package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.AdditionalTerm;
import fpml.consolidated.cd.validation.AdditionalTermTypeFormatValidator;
import fpml.consolidated.cd.validation.AdditionalTermValidator;
import fpml.consolidated.cd.validation.exists.AdditionalTermOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdditionalTerm.class)
public class AdditionalTermMeta implements RosettaMetaData<AdditionalTerm> {

	@Override
	public List<Validator<? super AdditionalTerm>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdditionalTerm, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalTerm> validator(ValidatorFactory factory) {
		return factory.<AdditionalTerm>create(AdditionalTermValidator.class);
	}

	@Override
	public Validator<? super AdditionalTerm> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdditionalTerm>create(AdditionalTermTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalTerm> validator() {
		return new AdditionalTermValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalTerm> typeFormatValidator() {
		return new AdditionalTermTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalTerm, Set<String>> onlyExistsValidator() {
		return new AdditionalTermOnlyExistsValidator();
	}
}

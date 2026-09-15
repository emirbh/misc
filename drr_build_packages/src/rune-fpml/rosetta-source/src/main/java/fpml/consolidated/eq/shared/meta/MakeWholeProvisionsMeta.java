package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.MakeWholeProvisions;
import fpml.consolidated.eq.shared.validation.MakeWholeProvisionsTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.MakeWholeProvisionsValidator;
import fpml.consolidated.eq.shared.validation.exists.MakeWholeProvisionsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MakeWholeProvisions.class)
public class MakeWholeProvisionsMeta implements RosettaMetaData<MakeWholeProvisions> {

	@Override
	public List<Validator<? super MakeWholeProvisions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MakeWholeProvisions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MakeWholeProvisions> validator(ValidatorFactory factory) {
		return factory.<MakeWholeProvisions>create(MakeWholeProvisionsValidator.class);
	}

	@Override
	public Validator<? super MakeWholeProvisions> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MakeWholeProvisions>create(MakeWholeProvisionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MakeWholeProvisions> validator() {
		return new MakeWholeProvisionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MakeWholeProvisions> typeFormatValidator() {
		return new MakeWholeProvisionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MakeWholeProvisions, Set<String>> onlyExistsValidator() {
		return new MakeWholeProvisionsOnlyExistsValidator();
	}
}

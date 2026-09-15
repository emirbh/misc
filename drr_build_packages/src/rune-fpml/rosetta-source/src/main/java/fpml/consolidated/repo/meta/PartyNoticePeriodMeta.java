package fpml.consolidated.repo.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.PartyNoticePeriod;
import fpml.consolidated.repo.validation.PartyNoticePeriodTypeFormatValidator;
import fpml.consolidated.repo.validation.PartyNoticePeriodValidator;
import fpml.consolidated.repo.validation.exists.PartyNoticePeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyNoticePeriod.class)
public class PartyNoticePeriodMeta implements RosettaMetaData<PartyNoticePeriod> {

	@Override
	public List<Validator<? super PartyNoticePeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyNoticePeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyNoticePeriod> validator(ValidatorFactory factory) {
		return factory.<PartyNoticePeriod>create(PartyNoticePeriodValidator.class);
	}

	@Override
	public Validator<? super PartyNoticePeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyNoticePeriod>create(PartyNoticePeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyNoticePeriod> validator() {
		return new PartyNoticePeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyNoticePeriod> typeFormatValidator() {
		return new PartyNoticePeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyNoticePeriod, Set<String>> onlyExistsValidator() {
		return new PartyNoticePeriodOnlyExistsValidator();
	}
}

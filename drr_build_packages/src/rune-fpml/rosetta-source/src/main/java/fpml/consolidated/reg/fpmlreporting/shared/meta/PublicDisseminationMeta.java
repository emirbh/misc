package fpml.consolidated.reg.fpmlreporting.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.PublicDissemination;
import fpml.consolidated.reg.fpmlreporting.shared.validation.PublicDisseminationTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.PublicDisseminationValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.datarule.PublicDisseminationChoice;
import fpml.consolidated.reg.fpmlreporting.shared.validation.exists.PublicDisseminationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PublicDissemination.class)
public class PublicDisseminationMeta implements RosettaMetaData<PublicDissemination> {

	@Override
	public List<Validator<? super PublicDissemination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PublicDissemination>create(PublicDisseminationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PublicDissemination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PublicDissemination> validator(ValidatorFactory factory) {
		return factory.<PublicDissemination>create(PublicDisseminationValidator.class);
	}

	@Override
	public Validator<? super PublicDissemination> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PublicDissemination>create(PublicDisseminationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PublicDissemination> validator() {
		return new PublicDisseminationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PublicDissemination> typeFormatValidator() {
		return new PublicDisseminationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PublicDissemination, Set<String>> onlyExistsValidator() {
		return new PublicDisseminationOnlyExistsValidator();
	}
}

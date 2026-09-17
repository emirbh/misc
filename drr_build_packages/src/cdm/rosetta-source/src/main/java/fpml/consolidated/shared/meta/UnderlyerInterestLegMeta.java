package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.UnderlyerInterestLeg;
import fpml.consolidated.shared.validation.UnderlyerInterestLegTypeFormatValidator;
import fpml.consolidated.shared.validation.UnderlyerInterestLegValidator;
import fpml.consolidated.shared.validation.datarule.UnderlyerInterestLegChoice;
import fpml.consolidated.shared.validation.exists.UnderlyerInterestLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=UnderlyerInterestLeg.class)
public class UnderlyerInterestLegMeta implements RosettaMetaData<UnderlyerInterestLeg> {

	@Override
	public List<Validator<? super UnderlyerInterestLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<UnderlyerInterestLeg>create(UnderlyerInterestLegChoice.class)
		);
	}
	
	@Override
	public List<Function<? super UnderlyerInterestLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UnderlyerInterestLeg> validator(ValidatorFactory factory) {
		return factory.<UnderlyerInterestLeg>create(UnderlyerInterestLegValidator.class);
	}

	@Override
	public Validator<? super UnderlyerInterestLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<UnderlyerInterestLeg>create(UnderlyerInterestLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super UnderlyerInterestLeg> validator() {
		return new UnderlyerInterestLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super UnderlyerInterestLeg> typeFormatValidator() {
		return new UnderlyerInterestLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnderlyerInterestLeg, Set<String>> onlyExistsValidator() {
		return new UnderlyerInterestLegOnlyExistsValidator();
	}
}

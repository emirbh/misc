package fpml.consolidated.dividend.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.dividend.swaps.DividendLeg;
import fpml.consolidated.dividend.swaps.validation.DividendLegTypeFormatValidator;
import fpml.consolidated.dividend.swaps.validation.DividendLegValidator;
import fpml.consolidated.dividend.swaps.validation.exists.DividendLegOnlyExistsValidator;
import fpml.consolidated.eq.shared.DirectionalLegUnderlyer;
import fpml.consolidated.eq.shared.validation.datarule.DirectionalLegUnderlyerChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DividendLeg.class)
public class DividendLegMeta implements RosettaMetaData<DividendLeg> {

	@Override
	public List<Validator<? super DividendLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DirectionalLegUnderlyer>create(DirectionalLegUnderlyerChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DividendLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DividendLeg> validator(ValidatorFactory factory) {
		return factory.<DividendLeg>create(DividendLegValidator.class);
	}

	@Override
	public Validator<? super DividendLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DividendLeg>create(DividendLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DividendLeg> validator() {
		return new DividendLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DividendLeg> typeFormatValidator() {
		return new DividendLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendLeg, Set<String>> onlyExistsValidator() {
		return new DividendLegOnlyExistsValidator();
	}
}

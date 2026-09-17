package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.EquityValuation;
import fpml.consolidated.eq.shared.validation.EquityValuationTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.EquityValuationValidator;
import fpml.consolidated.eq.shared.validation.datarule.EquityValuationChoice0;
import fpml.consolidated.eq.shared.validation.datarule.EquityValuationChoice1;
import fpml.consolidated.eq.shared.validation.exists.EquityValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EquityValuation.class)
public class EquityValuationMeta implements RosettaMetaData<EquityValuation> {

	@Override
	public List<Validator<? super EquityValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<EquityValuation>create(EquityValuationChoice0.class),
			factory.<EquityValuation>create(EquityValuationChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super EquityValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityValuation> validator(ValidatorFactory factory) {
		return factory.<EquityValuation>create(EquityValuationValidator.class);
	}

	@Override
	public Validator<? super EquityValuation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquityValuation>create(EquityValuationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquityValuation> validator() {
		return new EquityValuationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquityValuation> typeFormatValidator() {
		return new EquityValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityValuation, Set<String>> onlyExistsValidator() {
		return new EquityValuationOnlyExistsValidator();
	}
}

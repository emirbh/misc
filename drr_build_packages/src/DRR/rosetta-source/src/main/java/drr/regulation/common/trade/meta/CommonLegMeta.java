package drr.regulation.common.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.validation.CommonLegTypeFormatValidator;
import drr.regulation.common.trade.validation.CommonLegValidator;
import drr.regulation.common.trade.validation.exists.CommonLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CommonLeg.class)
public class CommonLegMeta implements RosettaMetaData<CommonLeg> {

	@Override
	public List<Validator<? super CommonLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommonLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommonLeg> validator(ValidatorFactory factory) {
		return factory.<CommonLeg>create(CommonLegValidator.class);
	}

	@Override
	public Validator<? super CommonLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommonLeg>create(CommonLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommonLeg> validator() {
		return new CommonLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommonLeg> typeFormatValidator() {
		return new CommonLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommonLeg, Set<String>> onlyExistsValidator() {
		return new CommonLegOnlyExistsValidator();
	}
}

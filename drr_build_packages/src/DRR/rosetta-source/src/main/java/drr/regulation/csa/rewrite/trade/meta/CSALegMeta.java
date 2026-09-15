package drr.regulation.csa.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.csa.rewrite.trade.CSALeg;
import drr.regulation.csa.rewrite.trade.validation.CSALegTypeFormatValidator;
import drr.regulation.csa.rewrite.trade.validation.CSALegValidator;
import drr.regulation.csa.rewrite.trade.validation.exists.CSALegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CSALeg.class)
public class CSALegMeta implements RosettaMetaData<CSALeg> {

	@Override
	public List<Validator<? super CSALeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CSALeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CSALeg> validator(ValidatorFactory factory) {
		return factory.<CSALeg>create(CSALegValidator.class);
	}

	@Override
	public Validator<? super CSALeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CSALeg>create(CSALegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CSALeg> validator() {
		return new CSALegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CSALeg> typeFormatValidator() {
		return new CSALegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CSALeg, Set<String>> onlyExistsValidator() {
		return new CSALegOnlyExistsValidator();
	}
}

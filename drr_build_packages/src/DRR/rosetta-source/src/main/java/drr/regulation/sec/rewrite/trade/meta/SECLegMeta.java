package drr.regulation.sec.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.sec.rewrite.trade.SECLeg;
import drr.regulation.sec.rewrite.trade.validation.SECLegTypeFormatValidator;
import drr.regulation.sec.rewrite.trade.validation.SECLegValidator;
import drr.regulation.sec.rewrite.trade.validation.exists.SECLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=SECLeg.class)
public class SECLegMeta implements RosettaMetaData<SECLeg> {

	@Override
	public List<Validator<? super SECLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SECLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SECLeg> validator(ValidatorFactory factory) {
		return factory.<SECLeg>create(SECLegValidator.class);
	}

	@Override
	public Validator<? super SECLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SECLeg>create(SECLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SECLeg> validator() {
		return new SECLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SECLeg> typeFormatValidator() {
		return new SECLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SECLeg, Set<String>> onlyExistsValidator() {
		return new SECLegOnlyExistsValidator();
	}
}

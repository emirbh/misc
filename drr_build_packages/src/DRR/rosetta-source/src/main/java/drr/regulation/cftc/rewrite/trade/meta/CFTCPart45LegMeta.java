package drr.regulation.cftc.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.cftc.rewrite.trade.CFTCPart45Leg;
import drr.regulation.cftc.rewrite.trade.validation.CFTCPart45LegTypeFormatValidator;
import drr.regulation.cftc.rewrite.trade.validation.CFTCPart45LegValidator;
import drr.regulation.cftc.rewrite.trade.validation.exists.CFTCPart45LegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CFTCPart45Leg.class)
public class CFTCPart45LegMeta implements RosettaMetaData<CFTCPart45Leg> {

	@Override
	public List<Validator<? super CFTCPart45Leg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CFTCPart45Leg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CFTCPart45Leg> validator(ValidatorFactory factory) {
		return factory.<CFTCPart45Leg>create(CFTCPart45LegValidator.class);
	}

	@Override
	public Validator<? super CFTCPart45Leg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CFTCPart45Leg>create(CFTCPart45LegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CFTCPart45Leg> validator() {
		return new CFTCPart45LegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CFTCPart45Leg> typeFormatValidator() {
		return new CFTCPart45LegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CFTCPart45Leg, Set<String>> onlyExistsValidator() {
		return new CFTCPart45LegOnlyExistsValidator();
	}
}

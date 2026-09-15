package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.RegulatoryTradingObligation;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryTradingObligationTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryTradingObligationValidator;
import fpml.consolidated.recordkeeping.processes.validation.exists.RegulatoryTradingObligationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryTradingObligation.class)
public class RegulatoryTradingObligationMeta implements RosettaMetaData<RegulatoryTradingObligation> {

	@Override
	public List<Validator<? super RegulatoryTradingObligation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryTradingObligation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryTradingObligation> validator(ValidatorFactory factory) {
		return factory.<RegulatoryTradingObligation>create(RegulatoryTradingObligationValidator.class);
	}

	@Override
	public Validator<? super RegulatoryTradingObligation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryTradingObligation>create(RegulatoryTradingObligationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryTradingObligation> validator() {
		return new RegulatoryTradingObligationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryTradingObligation> typeFormatValidator() {
		return new RegulatoryTradingObligationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryTradingObligation, Set<String>> onlyExistsValidator() {
		return new RegulatoryTradingObligationOnlyExistsValidator();
	}
}

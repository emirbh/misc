package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.RegulatoryWithdrawal;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryWithdrawalTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryWithdrawalValidator;
import fpml.consolidated.recordkeeping.processes.validation.exists.RegulatoryWithdrawalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryWithdrawal.class)
public class RegulatoryWithdrawalMeta implements RosettaMetaData<RegulatoryWithdrawal> {

	@Override
	public List<Validator<? super RegulatoryWithdrawal>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryWithdrawal, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryWithdrawal> validator(ValidatorFactory factory) {
		return factory.<RegulatoryWithdrawal>create(RegulatoryWithdrawalValidator.class);
	}

	@Override
	public Validator<? super RegulatoryWithdrawal> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryWithdrawal>create(RegulatoryWithdrawalTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryWithdrawal> validator() {
		return new RegulatoryWithdrawalValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryWithdrawal> typeFormatValidator() {
		return new RegulatoryWithdrawalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryWithdrawal, Set<String>> onlyExistsValidator() {
		return new RegulatoryWithdrawalOnlyExistsValidator();
	}
}

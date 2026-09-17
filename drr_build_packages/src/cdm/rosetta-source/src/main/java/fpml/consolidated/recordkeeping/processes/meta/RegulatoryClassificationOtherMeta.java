package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationOther;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryClassificationOtherTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryClassificationOtherValidator;
import fpml.consolidated.recordkeeping.processes.validation.exists.RegulatoryClassificationOtherOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryClassificationOther.class)
public class RegulatoryClassificationOtherMeta implements RosettaMetaData<RegulatoryClassificationOther> {

	@Override
	public List<Validator<? super RegulatoryClassificationOther>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryClassificationOther, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryClassificationOther> validator(ValidatorFactory factory) {
		return factory.<RegulatoryClassificationOther>create(RegulatoryClassificationOtherValidator.class);
	}

	@Override
	public Validator<? super RegulatoryClassificationOther> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryClassificationOther>create(RegulatoryClassificationOtherTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryClassificationOther> validator() {
		return new RegulatoryClassificationOtherValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryClassificationOther> typeFormatValidator() {
		return new RegulatoryClassificationOtherTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryClassificationOther, Set<String>> onlyExistsValidator() {
		return new RegulatoryClassificationOtherOnlyExistsValidator();
	}
}

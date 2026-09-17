package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationASIC_2013;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryClassificationASIC_2013TypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryClassificationASIC_2013Validator;
import fpml.consolidated.recordkeeping.processes.validation.exists.RegulatoryClassificationASIC_2013OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryClassificationASIC_2013.class)
public class RegulatoryClassificationASIC_2013Meta implements RosettaMetaData<RegulatoryClassificationASIC_2013> {

	@Override
	public List<Validator<? super RegulatoryClassificationASIC_2013>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryClassificationASIC_2013, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryClassificationASIC_2013> validator(ValidatorFactory factory) {
		return factory.<RegulatoryClassificationASIC_2013>create(RegulatoryClassificationASIC_2013Validator.class);
	}

	@Override
	public Validator<? super RegulatoryClassificationASIC_2013> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryClassificationASIC_2013>create(RegulatoryClassificationASIC_2013TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryClassificationASIC_2013> validator() {
		return new RegulatoryClassificationASIC_2013Validator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryClassificationASIC_2013> typeFormatValidator() {
		return new RegulatoryClassificationASIC_2013TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryClassificationASIC_2013, Set<String>> onlyExistsValidator() {
		return new RegulatoryClassificationASIC_2013OnlyExistsValidator();
	}
}

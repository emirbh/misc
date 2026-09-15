package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationCSA_2016;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryClassificationCSA_2016TypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryClassificationCSA_2016Validator;
import fpml.consolidated.recordkeeping.processes.validation.exists.RegulatoryClassificationCSA_2016OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryClassificationCSA_2016.class)
public class RegulatoryClassificationCSA_2016Meta implements RosettaMetaData<RegulatoryClassificationCSA_2016> {

	@Override
	public List<Validator<? super RegulatoryClassificationCSA_2016>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryClassificationCSA_2016, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryClassificationCSA_2016> validator(ValidatorFactory factory) {
		return factory.<RegulatoryClassificationCSA_2016>create(RegulatoryClassificationCSA_2016Validator.class);
	}

	@Override
	public Validator<? super RegulatoryClassificationCSA_2016> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryClassificationCSA_2016>create(RegulatoryClassificationCSA_2016TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryClassificationCSA_2016> validator() {
		return new RegulatoryClassificationCSA_2016Validator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryClassificationCSA_2016> typeFormatValidator() {
		return new RegulatoryClassificationCSA_2016TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryClassificationCSA_2016, Set<String>> onlyExistsValidator() {
		return new RegulatoryClassificationCSA_2016OnlyExistsValidator();
	}
}

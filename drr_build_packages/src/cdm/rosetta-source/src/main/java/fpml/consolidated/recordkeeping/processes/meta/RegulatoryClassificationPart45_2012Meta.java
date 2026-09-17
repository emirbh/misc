package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart45_2012;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryClassificationPart45_2012TypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryClassificationPart45_2012Validator;
import fpml.consolidated.recordkeeping.processes.validation.datarule.RegulatoryClassificationPart45_2012Choice;
import fpml.consolidated.recordkeeping.processes.validation.exists.RegulatoryClassificationPart45_2012OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryClassificationPart45_2012.class)
public class RegulatoryClassificationPart45_2012Meta implements RosettaMetaData<RegulatoryClassificationPart45_2012> {

	@Override
	public List<Validator<? super RegulatoryClassificationPart45_2012>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RegulatoryClassificationPart45_2012>create(RegulatoryClassificationPart45_2012Choice.class)
		);
	}
	
	@Override
	public List<Function<? super RegulatoryClassificationPart45_2012, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryClassificationPart45_2012> validator(ValidatorFactory factory) {
		return factory.<RegulatoryClassificationPart45_2012>create(RegulatoryClassificationPart45_2012Validator.class);
	}

	@Override
	public Validator<? super RegulatoryClassificationPart45_2012> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryClassificationPart45_2012>create(RegulatoryClassificationPart45_2012TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryClassificationPart45_2012> validator() {
		return new RegulatoryClassificationPart45_2012Validator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryClassificationPart45_2012> typeFormatValidator() {
		return new RegulatoryClassificationPart45_2012TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryClassificationPart45_2012, Set<String>> onlyExistsValidator() {
		return new RegulatoryClassificationPart45_2012OnlyExistsValidator();
	}
}
